package structures.list.array;

public interface ICoolArray<T extends Comparable<T>> {
    void add(T element);
    boolean contains(Object element);
    void clear();
    boolean isEmpty();
    int size();
}
