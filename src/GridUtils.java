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
    public static int[] sizeSpecificier(){
        int[] dim = new int[2];
        Scanner scanner = new Scanner(System.in);

        System.out.print("# Rows: ");
        dim[0] = scanner.nextInt();


        System.out.print("# Columns: ");
        dim[1] = scanner.nextInt();

        scanner.close();

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
                System.out.print(grid[i][j]);
                System.out.print(" ".repeat(slotSize - 1)); //Math.abs() turns the $,% etc into ASCII code (usually 2 digits despite 1 symbol) 
            }
            System.out.print("\n");
        }
    }
}

/*
+  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
1  a  b  c  d  e  f  g  h  i  j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z
2  z  y  x  w  v  u  t  s  r  q  p  o  n  m  l  k  j  i  h  g  f  e  d  c  b  a
*/
