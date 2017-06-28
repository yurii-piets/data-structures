package collections.queue.linked;

import collections.LinkedNode;
import collections.queue.Queue;

import java.util.Optional;

public class LinkedQueue<T> implements Queue<T> {

    private LinkedNode<T> head;
    private LinkedNode<T> last;

    public LinkedQueue() {
        head = last = null;
    }

    public LinkedQueue(LinkedQueue<T> queue) {
        head = last = null;

        LinkedNode<T> current = queue.head;
        if (current != null) {
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
            if (head != null) {
                head.setPrevious(null);
            }
        }

        return Optional.ofNullable(current);
    }

    @Override
    public void push(T element) {
        LinkedNode<T> current = new LinkedNode<>(element);

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
        if (head != null) {
            node = head.getElement();
        }
        return Optional.ofNullable(node);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
