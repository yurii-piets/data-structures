package structures.list.array;

import java.util.Optional;

public interface ICoolArray<T extends Comparable<T>> {
    void add(T element);
    boolean contains(Object element);
    void clear();
    boolean isEmpty();
    Optional<T> get(int i);
    int size();
}
