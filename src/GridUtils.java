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
}
