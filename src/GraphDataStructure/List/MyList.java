package GraphDataStructure.List;

import GraphDataStructure.CreateGraph.NearestVertex;
import GraphDataStructure.CreateGraph.NodesOfGraph;
import GraphDataStructure.SinglyLinkedNode;

public class MyList<T> implements SinglyLinkedList<T>{
    public SinglyLinkedNode<T> Head = new SinglyLinkedNode<>();
    @Override
    public void addData(T data){
        if(isEmpty()){
            Head.setData(data);
        } else {
            SinglyLinkedNode checker = Head;
            while (checker.getNext() != null){
                checker = checker.getNext();
            }
            checker.setNext(new SinglyLinkedNode<>(data));
        }
    }
    @Override
    public void delete(T data){
        if(search(data)){
            if (Head.getData() == data){
                Head = Head.getNext();
            }else {
                SinglyLinkedNode<T> checker = Head;
                while (checker.getNext() != null && checker.getNext().getData() != data) {
                    checker = checker.getNext();
                }
                checker.setNext(checker.getNext().getNext());
            }
        } else {
            System.out.println("The item does not exist on the list");
        }
    }
    @Override
    public boolean search(T data){
        SinglyLinkedNode checker = Head;
        while (checker != null) {
            if (data == checker.getData()) {
                return true;
            } else {
                checker = checker.getNext();
            }
        }
        return false;
    }
    @Override
    public boolean isEmpty(){
        return Head.getData() == null;
    }
    @Override
    public void showListContent(){
        SinglyLinkedNode checker = Head;
        System.out.println("-----------------------------------------");
        System.out.println("|                TABLE                  |");
        System.out.println("-----------------------------------------");
        while(checker!=null){
            String element = String.valueOf(checker.getData());

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
            element = element.replace(",", "");


            System.out.printf("|%19s %-18s|\n", element, "");
            checker = checker.getNext();
        }
        System.out.println(" ");
    }

    public NearestVertex getCVWithGNode(NodesOfGraph a){
        SinglyLinkedNode<NearestVertex> checker = (SinglyLinkedNode<NearestVertex>) Head;
        while(checker != null && a != checker.getData().getFirstNode()){
            checker = checker.getNext();
        }
        return checker.getData();
    }
}
