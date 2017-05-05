package structures.list.array;

import java.util.Optional;

public interface ICoolArray<T extends Comparable<T>> {
    void add(T element);
    void add(int index, T element);
    void addAll(ICoolArray<T> array);

    boolean contains(T element);
    void clear();

    int indexOf(T element);
    boolean isEmpty();

    Optional<T> get(int i);
    CoolArray<T> getAll(int left, int right);

    Optional<T> remove(int index);
    void remove(T element);
    Optional<T> replace(int index, T newElement);
    Optional<T> replace(T oldElement, T newElement);
    CoolArray<T> replaceAll(T oldElement, T newElement);

    Optional<T> set(int index, T element);
    int size();
    void trimToSize(int index);
}
