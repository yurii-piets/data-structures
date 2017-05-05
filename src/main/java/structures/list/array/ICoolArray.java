package structures.list.array;

import java.util.Optional;

public interface ICoolArray<T extends Comparable<T>> {
    void add(T element);
    boolean contains(Object element);
    void clear();
    int indexOf(Object o);
    boolean isEmpty();
    Optional<T> get(int i);
    int size();
}
