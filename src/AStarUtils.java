public class AStarUtils {
    /*
    @ - 0.5
    # - 1
    % - 1.5
    & - 2
    $ - 5
    X - Start
    G - Goal
    */

    /*
    f(n) = g(n) + h(n)

    g(n) = cost from start to current node
    h(n) = guessed cost from current node to goal (distance or heuristic)
    f(n) = total estimated cost
    */
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
                return 0.5;
            case '#':
                return 1;
            case '%':
                return 1.5;
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

}
