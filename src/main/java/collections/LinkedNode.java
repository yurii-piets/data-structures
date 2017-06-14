package collections;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedNode<T> implements Node<T> {
    private T element;
    private LinkedNode<T> next;
    private LinkedNode<T> previous;

    public LinkedNode(T element) {
        this.element = element;
    }
}
