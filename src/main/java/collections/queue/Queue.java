package collections.queue;

import java.util.Optional;

public interface Queue<T> {
    
    Optional<T> poll();
    void push(T element);
    Optional<T> peek();
    boolean isEmpty();
}
