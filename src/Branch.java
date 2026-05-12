import java.util.ArrayList;

public class Branch {
    int[] front = new int[2];
    ArrayList<int[]> path;
    double cost;

    public Branch(int[] front){
        this(front, new ArrayList<>(), 0);
    }

    public Branch(int[] front, ArrayList<int[]> path){
        this(front, path, 0);
    }

    public Branch(int[] front, ArrayList<int[]> path, double cost){
        this.front = front;
        this.path = new ArrayList<>(path);
        this.cost = cost;
    }
}
