package GraphDataStructure.CreateGraph;

import GraphDataStructure.List.MyList;
import GraphDataStructure.SinglyLinkedNode;
import GraphDataStructure.Queue.Queue;
import GraphDataStructure.Stack.Stack;

public class Graph<T> implements WeightAndGraph<T> {
    MyList<NodesOfGraph> adjacent = new MyList<>();

    @Override
    public void appendWeightedGNode(NodesOfGraph newNode){
        if (adjacent.search(newNode)){
            System.out.println("The node is already in the graph");
            return;
        }
        adjacent.addData(newNode);
    }

    @Override
    public MyList performDjistra(NodesOfGraph source){
        Queue<NodesOfGraph> isVisited = new Queue<>();
        Queue<NodesOfGraph> willVisit = new Queue<>();
        MyList<NearestVertex> smallestP = new MyList<>();

        willVisit.enqueue(source);

        while (!(willVisit.isEmpty())){
            NodesOfGraph current = willVisit.dequeue();
            if (isVisited.search(current)) {
            } else {
                smallestP.addData(new NearestVertex(current));
                if(current.getAdjacent().isEmpty()){

                }else{
                    SinglyLinkedNode<Edge> checker = current.getAdjacent().Head;
                    while (checker != null){
                        willVisit.enqueue(checker.getData().getTarget());
                        checker = checker.getNext();
                    }
                }
                isVisited.enqueue(current);
            }
        }

        willVisit = isVisited;
        smallestP.Head.getData().getLastNode().setTarget(source);
        smallestP.Head.getData().getLastNode().setWeight(0);
        NodesOfGraph current = willVisit.dequeue();

        if(willVisit.isEmpty()){
            return smallestP;
        }

        while(current!=null){
            SinglyLinkedNode<Edge> checker = current.getAdjacent().Head;
            while(checker != null){
                    int toCompare = smallestP.getCVWithGNode(current).getLastNode().getWeight() +
                            checker.getData().getWeight();
                    NearestVertex sameNode = smallestP.getCVWithGNode(checker.getData().getTarget());
                    if (toCompare < sameNode.getLastNode().getWeight()) {
                        sameNode.getLastNode().setWeight(toCompare);
                        sameNode.getLastNode().setTarget(current);
                    }
                checker = checker.getNext();
            }
            current = willVisit.dequeue();
        }

        return smallestP;
    }

    @Override
    public void DepthSearch(NodesOfGraph source){
        MyList<NodesOfGraph> isVisited = new MyList<>();
        Stack<NodesOfGraph> willVisit = new Stack<>();
        willVisit.push(source);
        while (!(willVisit.isEmpty())){
            NodesOfGraph current = willVisit.pop();
            if (isVisited.search(current)){
            } else if (source.getAdjacent().isEmpty()){
                isVisited.addData(current);
            } else {
                SinglyLinkedNode<Edge> checker = current.getAdjacent().Head;
                while (checker != null){
                    willVisit.push(checker.getData().getTarget());
                    checker = checker.getNext();
                }
                isVisited.addData(current);
            }
        }
        isVisited.showListContent();
    }

    @Override
    public void BreadthSearch(NodesOfGraph source){
        MyList<NodesOfGraph> isVisited = new MyList<>();
        Queue<NodesOfGraph> willVisit = new Queue<>();
        willVisit.enqueue(source);
        while (!(willVisit.isEmpty())){
            NodesOfGraph current = willVisit.dequeue();
            if (isVisited.search(current)){
            } else if (source.getAdjacent().isEmpty()){
                isVisited.addData(current);
            } else {
                SinglyLinkedNode<Edge> checker = current.getAdjacent().Head;
                while (checker != null){
                    willVisit.enqueue(checker.getData().getTarget());
                    checker = checker.getNext();
                }
                isVisited.addData(current);
            }
        }
        isVisited.showListContent();
    }


    @Override
    public void revealPath(MyList<NearestVertex> closestVert, NodesOfGraph data){
        int computedWeight = 0;
        NearestVertex current = closestVert.getCVWithGNode(data);
        Stack stack = new Stack<>();

        while(current.getFirstNode()!=current.getLastNode().getTarget()){
            stack.push(current.getFirstNode());
            int weight = current.getLastNode().getWeight() -
                    closestVert.getCVWithGNode(current.getLastNode().getTarget()).getLastNode().getWeight();
            stack.push(weight);
            computedWeight = computedWeight +weight;
            current = closestVert.getCVWithGNode(current.getLastNode().getTarget());
        }

        stack.push(current.getFirstNode());
        while (!(stack.isEmpty())){
            String element = String.valueOf(stack.pop());
            element = element.replace("node", "");
            element = element.replace("0", "");
            element = element.replace("1", "");
            element = element.replace("2", "");
            element = element.replace("3", "");
            element = element.replace("4", "");
            element = element.replace("5", "");
            element = element.replace("6", "");
            element = element.replace("7", "");
            element = element.replace("8", "");
            element = element.replace("9", "");

            if(!stack.isEmpty()) {
                System.out.print(element + "--");
            }
            else{
                System.out.print(element);
            }
        }

        //System.out.print("The targeted node has been reached."+"\n");
        System.out.println("");
        System.out.print("Total Weight:");
        System.out.print(computedWeight);
        System.out.println(" ");
    }

    @Override
    public void linkNodes(NodesOfGraph source, NodesOfGraph target, int weight){
        if (source == target){
            System.out.println("A node's adjacent node can not be set to itself");
            return;
        }

        SinglyLinkedNode<Edge> c = source.getAdjacent().Head;
        if ((!source.getAdjacent().isEmpty())) {
            while (c != null) {
                if (c.getData().getTarget() == target) {
                    System.out.println("The source and target nodes are already linked");
                    return;
                }
                c = c.getNext();
            }
        }
        source.getAdjacent().addData(new Edge(target,weight));
        target.getAdjacent().addData(new Edge(source,weight));
    }

    @Override
    public NodesOfGraph nodesData(T data){
        SinglyLinkedNode<NodesOfGraph> c = adjacent.Head;
        while(c != null){
            if (c.getData().getData()!=data){
                c = c.getNext();
            } else {
                return c.getData();
            }
        }
        System.out.println("A node for the specified data does not exist");
        return null;
    }
}