package examination;

public class CustomStack<T> extends CustomLinkedList{
    private int size = 0;
    Node<T> first = null;
    Node<T> last = null;

    public T pop(){
        if (size == 0) {
            throw new IndexOutOfBoundsException();
        }
        T result = this.last.getItem();
        this.last = this.last.prev;
        this.last.changeNext(null);
        size--;
        return result;
    }

}
