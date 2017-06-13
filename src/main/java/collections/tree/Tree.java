package collections.tree;

public interface Tree<T> {
    void add(T value);
    void clear();
    boolean contains(T value);
    int depth();
    boolean isEmpty();
    void remove(T value);
    void replace(T oldValue, T newValue);
    int size();
}
