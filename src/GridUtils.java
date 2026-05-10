import java.util.Random;
import java.util.Scanner;

public class GridUtils {
    public static char[][] generateGrid(int n, int m){
        /*
        @ - 0.5
        # - 1
        % - 1.5
        & - 2
        $ - 2.5
        X - Start
        G - Goal
        */
        char[] tiles = {'@', '#', '%', '&', '$'};
        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                Random rand = new Random();
                int ranNum = rand.nextInt(5); //random integer from 0-4

                grid[i][j] = tiles[ranNum];
            }
        }
        return grid;
    }
    public static int[] sizeSpecificier(Scanner scanner){
        int[] dim = new int[2];

        System.out.print("# Rows: ");
        dim[0] = scanner.nextInt();


        System.out.print("# Columns: ");
        dim[1] = scanner.nextInt();

        return dim; 
    }
    public static void printGrid(char[][] grid){
        int slotSize = String.valueOf(Math.abs(grid[0].length - 1)).length() + 1;

        System.out.print("+");
        System.out.print(" ".repeat(slotSize - 1));

        for (int i = 0; i < grid.length; i++){
            System.out.print(i);
            System.out.print(" ".repeat(slotSize - String.valueOf(Math.abs(i)).length()));
        }

        System.out.print("\n");

        for (int i = 0; i < grid.length; i++){
            System.out.print(i);
            System.out.print(" ".repeat(slotSize - String.valueOf(Math.abs(i)).length()));
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 'X' || grid[i][j] == 'G'){
                    System.out.print("\\u001B[33m" + grid[i][j] + "\u001B[30m");
                } else {
                    System.out.print(grid[i][j]);
                }
                System.out.print(" ".repeat(slotSize - 1)); //Math.abs() turns the $,% etc into ASCII code (usually 2 digits despite 1 symbol) 
            }
            System.out.print("\n");
        }
    }
    public static void setStartEnd(char[][] grid, Scanner scanner){
        int sx;
        int sy;
        int ex;
        int ey;

        System.out.print("Starting x coordinate: ");
        sx = scanner.nextInt();
        System.out.print("Starting y coordinate: ");
        sy = scanner.nextInt();
        grid[sy][sx] = 'X';

        System.out.print("Ending x coordinate: ");
        ex = scanner.nextInt();
        System.out.print("Ending y coordinate: ");
        ey = scanner.nextInt();
        grid[ey][ex] = 'G';
    }
}