package GraphDataStructure.CreateGraph;

import GraphDataStructure.List.MyList;

public interface WeightAndGraph<T>{
    void appendWeightedGNode(NodesOfGraph newNode);

    void linkNodes(NodesOfGraph source, NodesOfGraph target, int weight);

    void BreadthSearch(NodesOfGraph source);

    void DepthSearch(NodesOfGraph source);

    MyList performDjistra(NodesOfGraph source);

    void revealPath(MyList<NearestVertex> ClosestV, NodesOfGraph data);

    NodesOfGraph nodesData(T data);
}
