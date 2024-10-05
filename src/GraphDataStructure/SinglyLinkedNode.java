package GraphDataStructure;

public class SinglyLinkedNode<T> {
    T data;
    private SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T data){
        this.next = null;
        this.data = data;
    }

    public SinglyLinkedNode(){
        this.next = null;
        this.data = null;
    }


    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(SinglyLinkedNode next) {
        this.next = next;
    }

    public SinglyLinkedNode<T> getNext() {
        return next;
    }
}
