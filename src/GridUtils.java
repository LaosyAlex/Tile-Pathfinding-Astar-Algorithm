import java.util.Random;

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
    
}
