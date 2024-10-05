package GraphDataStructure.CreateGraph;

public class Edge {
    int weight;
    NodesOfGraph target;
    public Edge(NodesOfGraph target, int weight){
        this.target = target;
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public NodesOfGraph getTarget() {
        return target;
    }

    public void setTarget(NodesOfGraph target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return weight+","+ target.toString();
    }

}
