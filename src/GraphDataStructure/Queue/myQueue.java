package GraphDataStructure.Queue;

import GraphDataStructure.SinglyLinkedNode;

public interface myQueue<T> {
    public void enqueue(T data);

    public T dequeue();

    public boolean isEmpty();

    public T peek();

    public int size();

    public boolean search(T data);

    public void addQueue(Queue toCopy);

    void displayQueueContent();

    public SinglyLinkedNode getNode(T data);

}