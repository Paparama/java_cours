package examination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomLinkedList<T> {
    private int size = 0;
    Node<T> first;
    Node<T> last;

    public void add(T elem){
        Node<T> newLast = new Node<>(last, elem, null);
        this.last = newLast;
    }




}

class Node<E> {
    E item;
    Node<E> next;
    Node<E> prev;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}