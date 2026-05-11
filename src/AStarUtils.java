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
    public static double evaluateTile(int[] goal, char[][] grid, int[] p){
            int mD = manhattanDistance(goal, p);
            char symbol = grid[p[1]][p[0]];
            double value = evaluateSymbol(symbol);
            double total = value + mD;
            return total;
    }
    public static int[] evaluateNeighbours(int[] goal, char[][] grid, int[] p){
        ArrayList<int[]> neighbours = getNeighbours(grid, p);
        int[] best = neighbours.get(0);
        
        for (int i = 1; i < neighbours.size(); i++){
            if (evaluateTile(goal, grid, best) > evaluateTile(goal, grid, neighbours.get(i))){
                best = neighbours.get(i);
            }
        }

        return best;
    }
}
