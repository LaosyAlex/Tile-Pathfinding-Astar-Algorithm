import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int[] dim = GridUtils.sizeSpecificier(scanner);
        char[][] grid = GridUtils.generateGrid(dim[0], dim[1]);
        GridUtils.printGrid(grid);

        int[][] startEnd = GridUtils.setStartEnd(grid, scanner);
        int[] start = startEnd[0];
        int[] goal = startEnd[1];
        GridUtils.printGrid(grid);

        Branch currentBranch = new Branch(start);
        ArrayList<int[]> closedSet = new ArrayList<>();
        ArrayList<Branch> openSet = new ArrayList<>();

        while(currentBranch.front[0] != goal[0] || currentBranch.front[1] != goal[1]){
            currentBranch = AStarUtils.recheckBranches(openSet, currentBranch, goal, grid);

            EvaluationResults results = AStarUtils.evaluateNeighbours(goal, grid, currentBranch, closedSet);

            if (results.bestPath == null){
                GridUtils.printGrid(grid, currentBranch.path);
                System.out.println("Null pathed");
                return;
            }

            currentBranch = results.bestPath;
            openSet.addAll(results.otherPaths);
        }

        GridUtils.printGrid(grid, currentBranch.path);
    }
}
