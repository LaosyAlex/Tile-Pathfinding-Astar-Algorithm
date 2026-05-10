public class Main {
    public static void main(String[] args) throws Exception {
        int[] dim = GridUtils.sizeSpecificier();

        char[][] grid = GridUtils.generateGrid(dim[0], dim[1]);
        for (int i = 0; i < dim[0]; i++){
            for (int j = 0; j < dim[1]; j++){
                System.out.print(grid[i][j]);
            }
            System.out.print("\n");
        }
    }
}
