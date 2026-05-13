import java.util.ArrayList;

public class AStarUtils {
    public static int manhattanDistance(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
    public static ArrayList<int[]> getNeighbours(char[][] grid, int[] p){
        int rows = grid.length;
        int columns = grid[0].length;

        int[] down = new int[2];
        int[] up = new int[2];
        int[] right = new int[2];
        int[] left = new int[2];

        ArrayList<int[]> neighbours = new ArrayList<>();

        if (p[1] + 1 < rows){
            down[0] = p[0];
            down[1] = p[1]+1;
            neighbours.add(down);
        }
        if (p[1] - 1 >= 0){
            up[0] = p[0];
            up[1] = p[1]-1;
            neighbours.add(up);
        }
        if (p[0] + 1 < columns){
            right[0] = p[0]+1;
            right[1] = p[1];
            neighbours.add(right);
        }
        if (p[0] - 1 >= 0){
            left[0] = p[0]-1;
            left[1] = p[1];
            neighbours.add(left);
        }

        return neighbours;
    }
    public static double evaluateSymbol(char symbol){
        switch (symbol) {
            case '@':
                return 0.25;
            case '#':
                return 0.5;
            case '%':
                return 1;
            case '&':
                return 2;
            case '$':
                return 5;
            default:
                return 0;
        }
    }
    public static double evaluateBranch(int[] goal, char[][] grid, Branch path){
            int[] p = path.front;
            int mD = manhattanDistance(goal, p);
            char symbol = grid[p[1]][p[0]];
            double value = evaluateSymbol(symbol);
            double total = value + mD + path.cost;
            return total;
    }
    public static Branch evaluateNeighboursOpenSet(int[] goal, char[][] grid, Branch path, ArrayList<int[]> closedSet, ArrayList<Branch> openSet){
        /*
        Needs to return:
            paths
            fronties
            path totals
        */
        int[] p = path.front;
        closedSet.add(p);
        ArrayList<int[]> newPath = new ArrayList<>(path.path);
        newPath.add(p);

        ArrayList<int[]> neighbours = getNeighbours(grid, p);

        ArrayList<Branch> tempBranches = new ArrayList<>();
        for (int i = 0; i < neighbours.size(); i++){
            if (GridUtils.isIntArrinArrList(closedSet, neighbours.get(i)) == true){
                continue;
            }
            Branch tempBranch = new Branch(neighbours.get(i), newPath, path.cost + evaluateSymbol(grid[neighbours.get(i)[1]][neighbours.get(i)[0]]));

            tempBranches.add(tempBranch);
        }

        openSet.addAll(tempBranches);
        Branch best = nextBestBranch(goal, grid, openSet);

        return best;
    }
    public static Branch recheckBranches(ArrayList<Branch> openSet, Branch currentBranch, int[] goal, char[][] grid){
        Branch best = currentBranch;

        if (openSet != null){
            for (int i = 0; i < openSet.size(); i++){
                if (evaluateBranch(goal, grid, best) > evaluateBranch(goal, grid, openSet.get(i))){
                    Branch temp = openSet.get(i);
                    openSet.remove(i);
                    openSet.add(best);
                    best = temp;
                }
            }
        }

        return best;
    }
    public static Branch nextBestBranch(int[] goal, char[][]grid, ArrayList<Branch> openSet){
        Branch best = null;
        for (int i = 0; i < openSet.size(); i++){
            if (best == null){
                Branch temp = openSet.get(i);
                openSet.remove(i);
                best = temp;
            }else if (evaluateBranch(goal, grid, best) > evaluateBranch(goal, grid, openSet.get(i))){
                Branch temp = openSet.get(i);
                openSet.remove(i);
                openSet.add(best);
                best = temp;
            }
        }
        return best;
    }
}
