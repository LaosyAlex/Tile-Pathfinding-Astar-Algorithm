import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        char[][] grid = GridUtils.generateGrid(5, 5);
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
    }
}
