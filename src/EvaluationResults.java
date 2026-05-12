import java.util.ArrayList;

public class EvaluationResults {
    Branch bestPath;
    ArrayList<Branch> otherPaths;

    public EvaluationResults(Branch bestPath, ArrayList<Branch> otherPaths){
        this.bestPath = bestPath;
        this.otherPaths = new ArrayList<>(otherPaths);
    }
}
