package examination;

public class CustomQueue<T> extends CustomLinkedList {
    private int size = 0;
    Node<T> first = null;
    Node<T> last = null;

    public T pop(){
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        T result = this.first.getItem();
        this.first = this.first.next;
        this.first.changePrev(null);
        size--;
        return result;
    }
}
