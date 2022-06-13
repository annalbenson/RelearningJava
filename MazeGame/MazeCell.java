package MazeGame;

public class MazeCell {
    
    final int id;
    final int row;
    final int column;

    private boolean breadCrumb = false;

    private MazeWall up;
    private MazeWall down;
    private MazeWall left;
    private MazeWall right;

    public MazeCell(int cellId, int cellRow, int cellColumn){
       
        id = cellId;
        row = cellRow;
        column = cellColumn;
       
        // default cell has all walls up    
        up = new MazeWall(WallType.UP, cellId);
        down = new MazeWall(WallType.DOWN, cellId);
        left = new MazeWall(WallType.LEFT, cellId);
        right = new MazeWall(WallType.RIGHT, cellId);
    }

    public MazeWall GetMazeWall(WallType wallType){
        switch (wallType)
        {
            case UP:
                return up;
            case DOWN:
                return down;
            case LEFT:
                return left;
            case RIGHT:
                return right;
            default:
                return null;
        }
    }

    public void AddWallToCell(MazeWall wall){
        switch (wall.GetWallType())
        {
            case UP:
                up = wall;
                break;
            case DOWN:
                down = wall;
                break;
            case LEFT:
                left = wall;
                break;
            case RIGHT:
                right = wall;
                break;
        }
    }

    public void UpdateWallForCell(WallType wallType, boolean value){
        switch (wallType)
        {
            case UP:
                up.SetWallValue(value);
                break;
            case DOWN:
                down.SetWallValue(value);
                break;
            case LEFT:
                left.SetWallValue(value);
                break;
            case RIGHT:
                right.SetWallValue(value);
                break;
        }
    }

    public void LeaveBreadCrumb(){
        breadCrumb = true;
    }

    public boolean CheckBreadCrumb(){
        return breadCrumb;
    }
}
