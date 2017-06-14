package collections.queue;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LinkedNode<T> {
    private T element;
    private LinkedNode<T> next;
    private LinkedNode<T> previous;

    public LinkedNode(T element) {
        this.element = element;
    }
}