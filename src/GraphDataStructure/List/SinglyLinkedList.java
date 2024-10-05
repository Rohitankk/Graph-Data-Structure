package GraphDataStructure.List;

public interface SinglyLinkedList<T> {
    void addData(T data);

    void delete(T data);

    boolean search(T data);

    void showListContent();

    boolean isEmpty();

}
