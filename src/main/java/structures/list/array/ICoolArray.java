package structures.list.array;

import java.util.Optional;

public interface ICoolArray<T extends Comparable<T>> {
    void add(T element);
    void add(int index, T element);
    boolean contains(T element);
    void clear();
    int indexOf(T element);
    boolean isEmpty();
    Optional<T> get(int i);
    int size();
    void trimToSize(int index);
}
