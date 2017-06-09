package collections.map.hashmap;

import collections.list.List;
import collections.list.array.ArrayList;
import collections.list.linked.LinkedList;
import collections.map.Map;
import lombok.AllArgsConstructor;

import java.util.Optional;

public class HashMap<K, V> implements Map<K, V> {
    private final int CAPACITY = 8192;
    private ArrayList<LinkedList<Entry<K, V>>> array = new ArrayList<>(CAPACITY);
    private int size = 0;

    @AllArgsConstructor
    private static final class Entry<K, V> {
        private K key;
        private V value;
    }

    @Override
    public void clear() {
        this.array = new ArrayList<>(CAPACITY);
        this.size = 0;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public V get(K key) {
        int index = keyToIndex(key);

        Optional<LinkedList<Entry<K, V>>> optionalList = array.get(index);
        if (optionalList.isPresent()) {
            List<Entry<K, V>> innerList = optionalList.get();

            if (key == null) {
                for (int i = 0; i < innerList.size(); ++i) {
                    Optional<Entry<K, V>> optionEntry = innerList.get(i);
                    if (optionEntry.isPresent()) {
                        Entry<K, V> entry = optionEntry.get();

                        if (entry.key == null) {
                            return entry.value;
                        }

                    }
                }
            } else {
                for (int i = 0; i < innerList.size(); ++i) {
                    Optional<Entry<K, V>> optionEntry = innerList.get(i);
                    if (optionEntry.isPresent()) {
                        Entry<K, V> entry = optionEntry.get();

                        if (key.equals(entry.key)) {
                            return entry.value;
                        }

                    }
                }
            }

        }


        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int index = keyToIndex(key);

        Optional<LinkedList<Entry<K, V>>> optionalList = array.get(index);

        if (optionalList.isPresent()) {
            List<Entry<K, V>> list = optionalList.get();
            if (key == null) {
                for (int i = 0; i < list.size(); ++i) {
                    Optional<Entry<K, V>> entryOptional = list.get(i);
                    Entry<K, V> entry = entryOptional.get();
                    if (entry.key == null) {
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < list.size(); ++i) {
                    Optional<Entry<K, V>> entryOptional = list.get(i);
                    Entry<K, V> entry = entryOptional.get();
                    if (key.equals(entry.key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        if (value == null) {
            for (int i = 0; i < array.size(); ++i) {
                Optional<LinkedList<Entry<K, V>>> optionalList = array.get(i);
                if (optionalList.isPresent()) {
                    LinkedList<Entry<K, V>> innerList = optionalList.get();
                    for (int j = 0; j < innerList.size(); ++j) {
                        Optional<Entry<K, V>> optionalEntry = innerList.get(j);
                        if (optionalEntry.isPresent()) {
                            Entry<K, V> entry = optionalEntry.get();
                            if (entry.value == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < array.size(); ++i) {
                Optional<LinkedList<Entry<K, V>>> optionalList = array.get(i);
                if (optionalList.isPresent()) {
                    LinkedList<Entry<K, V>> innerList = optionalList.get();
                    for (int j = 0; j < innerList.size(); ++j) {
                        Optional<Entry<K, V>> optionalEntry = innerList.get(j);
                        if (optionalEntry.isPresent()) {
                            Entry<K, V> entry = optionalEntry.get();
                            if (value.equals(entry.value)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    @Override
    public void put(K key, V value) {
        if (containsKey(key)) {
            update(key, value);
        } else {
            insert(key, value);
        }
    }

    @Override
    public void remove(K key) {
        if(!containsKey(key)){
            return;
        }

        int index = keyToIndex(key);

        Optional<LinkedList<Entry<K,V>>> optionalList = array.get(index);

        if(key == null){
            if(optionalList.isPresent()){
                LinkedList<Entry<K,V>> list = optionalList.get();
                for(int i = 0; i < list.size(); ++i){
                    Optional<Entry<K,V>> optionalEntry = list.get(i);
                    if(optionalEntry.isPresent()){
                        Entry<K,V> entry = optionalEntry.get();
                        if(key == entry.key){
                            list.remove(entry);
                            size -=1;
                            return;
                        }
                    }
                }
            }
        } else {
            if(optionalList.isPresent()){
                LinkedList<Entry<K,V>> list = optionalList.get();
                for(int i = 0; i < list.size(); ++i){
                    Optional<Entry<K,V>> optionalEntry = list.get(i);
                    if(optionalEntry.isPresent()){
                        Entry<K,V> entry = optionalEntry.get();
                        if(key.equals(entry.key)){
                            list.remove(entry);
                            size -=1;
                            return;
                        }
                    }
                }
            }
        }

    }

    @Override
    public int size() {
        return size;
    }

    private int keyToIndex(K key) {
        if (key != null) {
            int index = key.hashCode() % CAPACITY;
            index = index < 0 ? Math.abs(index) : index;
            return index;
        } else {
            return 0;
        }
    }

    private void update(K key, V value) {
        int index = keyToIndex(key);

        Optional<LinkedList<Entry<K,V>>> optionalList = array.get(index);

        if(key == null){
            if(optionalList.isPresent()){
                LinkedList<Entry<K,V>> list = optionalList.get();
                for(int i = 0; i < list.size(); ++i){
                    Optional<Entry<K,V>> optionalEntry = list.get(i);
                    if(optionalEntry.isPresent()){
                        Entry<K,V> entry = optionalEntry.get();
                        if(key == entry.key){
                            list.replace(entry, new Entry<>(key,value));
                            return;
                        }
                    }
                }
            }
        } else {
            if(optionalList.isPresent()){
                LinkedList<Entry<K,V>> list = optionalList.get();
                for(int i = 0; i < list.size(); ++i){
                    Optional<Entry<K,V>> optionalEntry = list.get(i);
                    if(optionalEntry.isPresent()){
                        Entry<K,V> entry = optionalEntry.get();
                        if(key.equals(entry.key)){
                            list.replace(entry, new Entry<>(key,value));
                            return;
                        }
                    }
                }
            }
        }
    }

    private void insert(K key, V value) {
        int index = keyToIndex(key);

        Entry<K, V> entry = new Entry<>(key, value);

        Optional<LinkedList<Entry<K, V>>> optionalList = array.get(index);
        LinkedList<Entry<K, V>> list;

        if (optionalList.isPresent()) {
            list = optionalList.get();
        } else {
            list = new LinkedList<>();
            array.add(index, list);
        }

        list.add(entry);
        size += 1;
    }
}
