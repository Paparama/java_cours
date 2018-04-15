package examination;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomLinkedList<T> {
    private int size = 0;
    Node<T> first = null;
    Node<T> last = null;

    public void add(T elem){
        Node<T> newLast = new Node<>(last, elem, null);
        this.last = newLast;
        if (this.first == null) {
            this.first = this.last;
        }
        size++;
    }

    public boolean contains(T elem){
        for (Node<T> node = last; node != null; node = node.prev) {
            if (node.getItem() == elem) {
                return true;
            }
        }
        return false;

    }

    public int indexOf(T elem){
        int index = size;
        for (Node<T> node = last; node != null; node = node.prev) {
            index--;
            if (node.getItem() == elem) {
                return index;
            }
        }
        return -1;
    }

    public void set(int index, T elem){
        if (index>=size || index<0) {
            throw new IndexOutOfBoundsException();
        }
        int ind = size;
        for (Node<T> node = last; node != null; node = node.prev) {
            ind--;
            if (index == ind) {
                Node<T> newNode = new Node<>(node.prev, elem, node.next);
                node.prev.changeNext(newNode);
                node.next.changePrev(newNode);
            }
        }
    }




}

class Node<E> {
    E item;
    Node<E> next = null;
    Node<E> prev = null;

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }

    public void changePrev(Node prev) {
        this.prev = prev;
    }

    public void changeNext(Node next) {
        this.next = next;
    }

    public E getItem(){
        return this.item;
    }
}