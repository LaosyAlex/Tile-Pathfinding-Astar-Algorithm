public class Main {
    public static void main(String[] args) throws Exception {
        int[] dim = GridUtils.sizeSpecificier();
        char[][] grid = GridUtils.generateGrid(dim[0], dim[1]);
        GridUtils.printGrid(grid);
        GridUtils.setStartEnd(grid);
        GridUtils.printGrid(grid);
    }
}
