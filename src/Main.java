public class Main {
    public static final String RESET = "\u001B[0m";

    public static final String RED = "\u001B[31m";
    public static void main(String[] args) throws Exception {
        int[] dim = GridUtils.sizeSpecificier();

        char[][] grid = GridUtils.generateGrid(dim[0], dim[1]);

        GridUtils.printGrid(grid);
    }
}
