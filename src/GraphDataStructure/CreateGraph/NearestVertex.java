package GraphDataStructure.CreateGraph;

public class NearestVertex {
    NodesOfGraph firstNode;
    Edge lastNode;

    public NearestVertex(NodesOfGraph first){
        this.firstNode = first;
        this.lastNode = new Edge(null,Integer.MAX_VALUE);
    }

    public NodesOfGraph getFirstNode() {
        return firstNode;
    }

    public Edge getLastNode() {
        return lastNode;
    }

    @Override
    public String toString() {
        return firstNode +","+ lastNode.getWeight()+","+ lastNode.getTarget();
    }
}
