package collections;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListNode<T> implements Node {
    private T element;
    private ListNode<T> next;
    private ListNode<T> previous;

    public ListNode(T element) {
        this.element = element;
    }
}
