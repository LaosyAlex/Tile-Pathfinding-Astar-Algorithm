#import java.util.ArrayList;

public class Branch {
    int[] front;
    ArrayList<int[]> path;
    double cost;

    public Branch(int[] front, ArrayList<int[]> path, double cost){
        this.front = front;
        this.path = path;
        this.cost = cost;
    }
}
