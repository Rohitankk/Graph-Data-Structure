package GraphDataStructure.CreateGraph;

import GraphDataStructure.List.MyList;

public class NodesOfGraph<T> {
    MyList<Edge> adjacent;
    T data;

    public NodesOfGraph(T data){
        this.data = data;
        this.adjacent = new MyList<>();
    }

    public MyList<Edge> getAdjacent() {
        return adjacent;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}