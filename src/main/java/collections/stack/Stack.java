package collections.stack;

import java.util.Optional;

public interface Stack<T> {
    boolean isEmpty();
    void push(T element);
    Optional<T> pop();
    Optional<T> peek();
}
