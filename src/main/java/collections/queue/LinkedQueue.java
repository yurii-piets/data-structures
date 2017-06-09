package collections.queue;

import collections.Node;

import java.util.Optional;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> last;

    public LinkedQueue() {
        head = last = null;
    }

    public LinkedQueue(LinkedQueue<T> queue) {
        head = last = null;

        Node<T> current = queue.head;
        if(current != null) {
            while (current != null) {
                this.push(current.getElement());
                current = current.getNext();
            }
        }
    }

    @Override
    public Optional<T> poll() {
        T current = null;

        if (head != null) {
            current = head.getElement();
            head = head.getNext();
            if(head != null) {
                head.setPrevious(null);
            }
        }

        return Optional.ofNullable(current);
    }

    @Override
    public void push(T element) {
        Node<T> current = new Node<>(element);

        if (last == null) {
            head = current;
            last = current;
        } else {
            last.setNext(current);
            current.setPrevious(last);
            last = current;
        }
    }

    @Override
    public Optional peek() {
        T node = null;
        if (head != null){
            node = head.getElement();
        }
        return Optional.ofNullable(node);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
