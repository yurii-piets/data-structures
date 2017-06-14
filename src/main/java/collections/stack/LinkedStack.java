package collections.stack;

import collections.list.ListNode;

import java.util.Optional;
import java.util.Stack;

public class LinkedStack<T> implements Stack<T> {

    private ListNode<T> head;

    public LinkedStack() {
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void push(T element) {
        ListNode<T> node = new ListNode<>(element);
        if(head == null){
            head = node;
        }else{
            node.setNext(head);
            head.setPrevious(node);
            head = node;
        }
    }

    @Override
    public Optional<T> pop() {
        T current = null;

        if(head != null){
            current = head.getElement();
            head = head.getNext();
            if(head != null){
                head.setPrevious(null);
            }
        }

        return Optional.ofNullable(current);
    }

    @Override
    public Optional<T> peek() {
        T current = null;

        if(head != null){
            current = head.getElement();
        }

        return Optional.ofNullable(current);
    }
}
