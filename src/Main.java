import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] dim = GridUtils.sizeSpecificier(scanner);
        char[][] grid = GridUtils.generateGrid(dim[0], dim[1]);
        GridUtils.printGrid(grid);
        int[][] startEnd = GridUtils.setStartEnd(grid, scanner);
        GridUtils.printGrid(grid);
    }
}
