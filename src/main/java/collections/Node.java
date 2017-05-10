package collections;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {
    private T element;
    private Node<T> next;
    private Node<T> previous;

    public Node(T element) {
        this.element = element;
    }
}
