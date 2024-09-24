import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //read in your file
        File in = new File("maze.dat");


        try (Scanner scan = new Scanner(in))
        {

            //get the dimensions of the array
          int numRows = scan.nextInt();
          int numCols = scan.nextInt(); //cursor ready to start where maze starts
          scan.nextLine();
        
          //create a char array with those dimensions
            char[][] myMaze = new char[numRows][numCols];



            for(int i = 0; i < numRows; i++)
            {
                //scan each line of the file, convert it to a char array
                //then assign the corresponding row in maze[][] to that value
                    myMaze[i] = scan.nextLine().toCharArray();

                    //to char array
            }
            

            boolean start = false; 
            int currRow = 0;
            int currCol = 0;

           
            for(int i = 0; i < numRows; i++)
            {
                for(int j = 0; j < numCols; j++)
                {
                    if(myMaze[i][j] == '+') {
                         start = true;
                        currRow = i;
                        currCol = j;
                    }
                }
            }
           
            while(start)
            {
                if(mazeMover(currRow, currCol, myMaze, numRows, numCols))
                {
                    System.out.println("Maze is solved."); 
                }
                else {
                    System.out.println("Maze cannot be solved."); 
                }

                for(int i = 0; i < numRows; i++)
                {
                    System.out.println();
                    for(int j = 0; j < numCols; j++)
                    {
                        System.out.print(myMaze[i][j]); 
                    }
                }
                start = false; 
            }
                
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    } 

        public static boolean mazeMover(int rowIndex, int colIndex, char[][] maze, int rowDim, int colDim)
        {
            //check if we can move to the right
            //conditions: if it is within the maze bounds, not a wall (X),
            //not already went through (+), not a dead end (.), and not the end of the maze(-)

            if(colIndex != colDim-1 && maze[rowIndex][colIndex+1] != 'X'  && 
            maze[rowIndex][colIndex+1] != '+' && maze[rowIndex][colIndex+1] != '.')
            {
                if (maze[rowIndex][colIndex+1] == '-')
                {
                    return true;           
                }
                else
                {
                    maze[rowIndex][colIndex+1] = '+'; 
                     
                    if(mazeMover(rowIndex, colIndex+1, maze, rowDim, colDim))
                      {
                         return true; 
                      }
                    else
                    {
                        maze[rowIndex][colIndex+1] = '.'; 
                    }
                }
                
            }

            //check if we can move up 
            //conditions: if it is within the maze bounds, not a wall (X),
            //not already went through (+), not a dead end (.), and not the end of the maze(-)

            if(rowIndex != 0 && maze[rowIndex-1][colIndex] != 'X'  && 
            maze[rowIndex-1][colIndex] != '+' && maze[rowIndex-1][colIndex] != '.')
            {
                if (maze[rowIndex-1][colIndex] == '-')
                {
                    return true;           
                }
                else
                {
                    maze[rowIndex-1][colIndex] = '+'; 
                     
                    if(mazeMover(rowIndex-1, colIndex, maze, rowDim, colDim))
                      {
                         return true; 
                      }
                    else
                    {
                        maze[rowIndex-1][colIndex] = '.'; 
                    }
                }
                
            }

            //check if we can move to the left
            //conditions: if it is within the maze bounds, not a wall (X),
            //not already went through (+), not a dead end (.), and not the end of the maze(-)

            if(colIndex != 0 && maze[rowIndex][colIndex-1] != 'X'  && 
            maze[rowIndex][colIndex-1] != '+' && maze[rowIndex][colIndex-1] != '.')
            {
                if (maze[rowIndex][colIndex-1] == '-')
                {
                    return true;           
                }
                else
                {
                    maze[rowIndex][colIndex-1] = '+'; 
                     
                    if(mazeMover(rowIndex, colIndex-1, maze, rowDim, colDim))
                      {
                         return true; 
                      }
                    else
                    {
                        maze[rowIndex][colIndex-1] = '.'; 
                    }
                }
                
            }

            //check if we can move down
            //conditions: if it is within the maze bounds, not a wall (X),
            //not already went through (+), not a dead end (.), and not the end of the maze(-)

            if(rowIndex != rowDim-1 && maze[rowIndex+1][colIndex] != 'X'  && 
            maze[rowIndex+1][colIndex] != '+' && maze[rowIndex+1][colIndex] != '.')
            {
                if (maze[rowIndex+1][colIndex] == '-')
                {
                    return true;           
                }
                else
                {
                    maze[rowIndex+1][colIndex] = '+'; 
                     
                    if(mazeMover(rowIndex+1, colIndex, maze, rowDim, colDim))
                      {
                         return true; 
                      }
                    else
                    {
                        maze[rowIndex+1][colIndex] = '.'; 
                    }
                }
                
            }

           
            return false; 
    }


}
