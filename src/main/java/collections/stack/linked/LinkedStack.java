package collections.stack.linked;

import collections.LinkedNode;
import collections.stack.Stack;

import java.util.Optional;

public class LinkedStack<T> implements Stack<T> {

    private LinkedNode<T> head;

    public LinkedStack() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(T element) {
        LinkedNode<T> node = new LinkedNode<>(element);
        if (head == null) {
            head = node;
        } else {
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
    }

    @Override
    public Optional<T> pop() {
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
    public Optional<T> peek() {
        T current = null;

        if (head != null) {
            current = head.getElement();
        }

        return Optional.ofNullable(current);
    }
}
