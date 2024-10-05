package GraphDataStructure.Queue;

import GraphDataStructure.SinglyLinkedNode;

public class Queue<T> implements myQueue<T> {
    public SinglyLinkedNode<T> Head;

    public Queue() {
        Head = new SinglyLinkedNode<>(null);
    }

    @Override
    public void enqueue(T data) {
        if (Head.getData() == null) {
            Head.setData(data);
        } else {
            SinglyLinkedNode newNode = new SinglyLinkedNode(data);
            SinglyLinkedNode checker = Head;
            while (checker.getNext() != null) {
                checker = checker.getNext();
            }
            checker.setNext(newNode);
        }
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T data = Head.getData();
        if (Head.getNext() == null) {
            Head.setData(null);
        } else {
            Head = Head.getNext();
        }
        return data;
    }


    @Override
    public boolean isEmpty() {
        return Head.getData() == null;
    }

    @Override
    public T peek() {
        if (Head.getData() == null) {
            System.out.println("The stack is empty");
            return null;
        } else {
            return Head.getData();
        }
    }

    @Override
    public int size() {
        int count = 0;
        if(isEmpty()){
            return count;
        }
        SinglyLinkedNode checker = Head;
        while (checker != null) {
            count++;
            checker = checker.getNext();
        }
        return count;
    }

    // Gets the node containing data
    @Override
    public SinglyLinkedNode getNode(T data) {
        SinglyLinkedNode checker = Head;
        while (checker != null) {
            if (data == checker.getData()) {
                return checker;
            } else {
                checker = checker.getNext();
            }
        }
        return null;
    }

    // Shows whether the data is in the queue or not
    @Override
    public boolean search(T data) {
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
    public void addQueue(Queue toCopy) {
        SinglyLinkedNode checker = toCopy.Head;
        while (checker!=null){
            this.enqueue((T) checker.getData());
            checker = checker.getNext();
        }
    }

    @Override
    public void displayQueueContent() {
        SinglyLinkedNode checker = Head;
        while(checker!=null){
            System.out.println(checker.getData());
            checker = checker.getNext();
        }
    }
}
