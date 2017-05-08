package collections.list.array;

import java.util.Optional;

public interface List<T extends Comparable<T>> {
    void add(T element);
    void add(int index, T element);
    void addAll(List<T> array);

    boolean contains(T element);
    void clear();

    int indexOf(T element);
    boolean isEmpty();

    Optional<T> get(int i);
    ArrayList<T> getAll(int left, int right);

    Optional<T> remove(int index);
    void remove(T element);
    Optional<T> replace(int index, T newElement);
    void replace(T oldElement, T newElement);
    void replaceAll(T oldElement, T newElement);

    Optional<T> set(int index, T element);
    int size();
    void trimToSize(int index);
}
