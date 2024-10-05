package GraphDataStructure.Stack;

import GraphDataStructure.SinglyLinkedNode;

public class Stack<T> implements myStack<T>{
    SinglyLinkedNode<T> head;

    public Stack(){
        head = new SinglyLinkedNode(null);
    }

    @Override
    public void push(T data) {
        if (head.getData() == null){
            head.setData(data);
        } else {
            SinglyLinkedNode newNode = new SinglyLinkedNode(data);
            newNode.setNext(head);
            head = newNode;
        }
    }

    @Override
    public int size() {
        int count = 0;
        SinglyLinkedNode checker = head;
        while(checker != null){
            count ++;
            checker = checker.getNext();
        }
        return count;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            System.out.println("The stack is empty");
            return null;
        }
        T data = head.getData();
        if(head.getNext() == null){
            head.setData(null);
        } else {
            head = head.getNext();
        }
        return data;
    }

    @Override
    public T peek() {
        if (head.getData() == null) {
            System.out.println("The stack is empty");
            return null;
        } else {
            return head.getData();
        }
    }

    @Override
    public boolean isEmpty() {
        return head.getData() == null;
    }

}
