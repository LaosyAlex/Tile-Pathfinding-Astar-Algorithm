public class AStarUtils {
    /*
    @ - 0.5
    # - 1
    % - 1.5
    & - 2
    $ - 2.5
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
}
