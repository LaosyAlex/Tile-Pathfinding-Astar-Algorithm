public class AStarUtils {
    public static int manhattanDistance(int[] p1, int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
    public static int[][] getNeighbours(int[] p){
        int[] up = {p[0],p[1]+1};
        int[] down = {p[0],p[1]-1};
        int[] left = {p[0]+1,p[1]};
        int[] right = {p[0]-1,p[1]};
        int[][] neighbours = {up,down,left,right};
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
        int[][] neighbours = getNeighbours(p);
        int[] best = neighbours[0];
        
        for (int i = 1; i < neighbours.length; i++){
            if (evaluateTile(goal, grid, best) < evaluateTile(goal, grid, neighbours[i])){
                best = neighbours[0];
            }
        }

        return best;
    }
}
