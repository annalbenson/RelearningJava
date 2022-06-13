package MazeGame;

public class MazeWall {
    
    private boolean on;
    private WallType type;
    private int[] adjacentCells = new int[2];

    public MazeWall(WallType wallType, int cellId){
         // default wall is on/present
        on = true;
        type = wallType;
    }

    public MazeWall(boolean value, WallType wallType){
       on = value;
       type = wallType;
    }

    public boolean GetWallValue(){
        return on;
    }

    public void SetWallValue(boolean value){
        on = value;
    }

    public WallType GetWallType(){
        return type;
    }
}