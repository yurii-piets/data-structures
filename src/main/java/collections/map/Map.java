package collections.map;

public interface Map<K,V> {
    void clear();
    boolean empty();
    V get(K key);
    boolean containsKey(K key);
    boolean containsValue(V value);
    void put(K key, V value);
    void remove(K key);
    int size();
}
