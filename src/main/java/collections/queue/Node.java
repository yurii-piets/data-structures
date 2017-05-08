package collections.queue;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Node<T> {
    private T element;
    private Node<T> next;
    private Node<T> previous;

    Node(T element) {
        this.element = element;
    }
}
