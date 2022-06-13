package MazeGame;

import java.util.List;
import java.util.Set;

public class Maze {
    // this class will represent the maze itself and its configuration

    private int width;
    private int heigth;

    private MazeCell[][] cellGrid;

    public Maze(){

        width = 10;
        heigth = 10;
        cellGrid = new MazeCell[heigth][width];
        GenerateMaze();
    }

    public Maze(int dimensionA, int dimensionB)
    {
        width = dimensionA;
        heigth = dimensionB;
        cellGrid = new MazeCell[heigth][width];
        GenerateMaze();
    }

    public void GenerateMaze(){
        
        // using https://en.wikipedia.org/wiki/Maze_generation_algorithm#Randomized_Kruskal's_algorithm as reference

        // generate all cells and walls and their relationships to each other
        List<MazeWall> walls = new List<MazeWall>();
        List<Set<MazeCell>> listOfCellSets = new List<Set<MazeCell>>(); 

        int cellCount = 1;

        // first cell
        //MazeCell previous = new MazeCell(cellCount++, 0, 0); 
        for(int j = 0; j < heigth; j++){
            for(int i = 0; i < width; i++){
                // create cell which by default has all walls on
                MazeCell current = new MazeCell(cellCount++, j, i); 
                
                // hook up walls to adjacent walls

                // if not in top row, hook up UP
                if(j != 0)
                {
                    current.AddWallToCell(cellGrid[j-1][i].GetMazeWall(WallType.DOWN));
                }

                // if not in left most column, hook up LEFT
                if(i != 0){
                    current.AddWallToCell(cellGrid[j][i-1].GetMazeWall(WallType.RIGHT));
                }

                //}
                // add the cell to a set of its own, and the walls to a list of walls

                Set<MazeCell> setOfCells = new Set<MazeCell>();
                setOfCells.add(current);
                listOfCellSets.add(setOfCells);

                walls.add(current.GetMazeWall(WallType.UP));
                walls.add(current.GetMazeWall(WallType.DOWN));
                walls.add(current.GetMazeWall(WallType.LEFT));
                walls.add(current.GetMazeWall(WallType.RIGHT));

                // put cell into grid
                cellGrid[j][i] = current;
            }
        }

        // default wall is on = true so maze generated with all walls

        // Create a list of all walls, and 
        //List<MazeWall> walls = new List<MazeWall>();
        
        /* for(int j = 0; j < heigth*2; j++){
            for(int i = 0; i < heigth*2; i++){
                walls.add(wallGrid[j][i]);
            }
        } */

        // Create a set for each cell, each containing just that one cell.
        //List<Set<MazeCell>> listOfCellSets = new List<<Set<MazeCell>>(); 
        /* for(int j = 0; j < heigth; j++){
            for(int i = 0; i < heigth; i++){
                Set<MazeCell> setOfCells = new Set<MazeCell>();
                setOfCells.add(cellGrid[j][i]);
                listOfCellSets.add(setOfCells);
            }
        } */
        
        // For each wall, in some random order:
            // If the cells divided by this wall belong to distinct sets:
                // Remove the current wall.
                // Join the sets of the formerly divided cells

        while(walls.size() != 0)
        {
            // get random wall:
            int numberOfWalls = walls.size();
            int randomNumber = (int) Math.round((Math.random() * (numberOfWalls - 1)));
            MazeWall randomWall = walls.get(randomNumber);

            int cellId = randomWall.Get            
            
            // a cell object should contain its coordinates
            // a wall object should contain its coordinates
            // a cell's walls can be found as follows:

            // cell     (0,0)
            // walls        [0,1] 
            //          [1,0]   [1,1]
            //              [2,1]

            // cell     (0,1)
            // walls        [0,3] 
            //          [1,2]   [1,4]
            //              [2,3]

            // cell     (0,n)
            // walls        [0,2n+1]
            //          [1,2n]  [1,2n+2]
            //              [2,2n+1]


            // cell     (0,0)
            // walls        [0,1] 
            //          [1,0]   [1,1]
            //              [2,1]

            // cell     (1,0)
            // walls        [2,1] 
            //          [3,0]   [3,2]
            //              [4,1]

            // cell     (n,0)
            // walls        [,]
            //          [,]  [,]
            //              [,]

        }
        
    }
}
