package structures.list.array;

import java.util.Optional;

public class CoolArray<T extends Comparable<T>> implements ICoolArray<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int end = -1;

    public CoolArray() {
        this.size = DEFAULT_CAPACITY;
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public CoolArray(int size) {
        if (size < 0) {
            this.size = DEFAULT_CAPACITY;
            this.elements = new Object[DEFAULT_CAPACITY];
        } else {
            this.size = size;
            this.elements = new Object[size];
        }
    }

    public CoolArray(T[] array) {
        this.size = 2 * array.length;
        this.elements = new Object[size];
        copyArray(array, 0, array.length);
        this.end = array.length-1;
    }

    public CoolArray(T[] array, int left, int right) {
        this.size = 2*array.length;
        this.elements = new Object[size];
        copyArray(array, left, right);
        this.end = right;
    }

    public CoolArray(CoolArray<T> coolArray){
        this.elements = new Object[coolArray.size];
        this.size = coolArray.size;
        copyArray(coolArray.elements, 0, coolArray.end + 1);
    }

    @Override
    public void add(T element){
        if(end >= elements.length - 1){
            resizeAndCopyArray();
        }
        this.elements[++end] = element;
    }

    @Override
    public void add(int index, T element) {
        if(index < 0){
            return;
        }

        if (index >= end) {
            Object[] newArray = new Object[index + DEFAULT_CAPACITY];

            for (int i = 0; i <= this.end; ++i) {
                newArray[i] = this.elements[i];
            }

            this.elements = newArray;
            this.end = index;
        }

        this.elements[index] = element;
    }

    @Override
    public void addAll(ICoolArray<T> array) {
        if(array == null ){
            return;
        }

        for (int i = 0; i < array.size(); ++i) {
            Optional<T> element = array.get(i);
            if (element.isPresent()) {
                this.add(element.get());
            } else {
                this.add(null);
            }
        }
    }

    @Override
    public boolean contains(T o) {
        if(o == null){
            for(int i = 0; i <= this.end; ++i){
                if (this.elements[i] == null){
                    return true;
                }
            }
        }else{
            for(int i = 0; i <= this.end; ++i){
                if (o.equals(this.elements[i])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = DEFAULT_CAPACITY;
        this.end = -1;
    }

    @Override
    public int indexOf(T o) {
        if(o == null){
            for(int i=0; i <= end; ++i){
                if(elements[i] == null){
                    return i;
                }
            }
        }else{
            for(int i=0; i <= end; ++i){
                if(o.equals(elements[i])){
                    return i;
                }
            }
        }

        return -1;
    }

    public CoolArray<T> clone(){
        CoolArray<T> cloneArray = new CoolArray<>(this);
        return cloneArray;
    }

    @Override
    public boolean isEmpty() {
        return this.end < 0;
    }

    @Override
    public Optional<T> get(int i) {
        if(i > end || i < 0){
            return Optional.ofNullable(null);
        }

        return Optional.ofNullable((T) elements[i]);
    }

    @Override
    public CoolArray<T> getAll(int left, int right) {
        CoolArray<T> coolArray = new CoolArray<>();

        for(int i = left; i <= this.end && i < right; ++i){
            coolArray.add((T) this.elements[i]);
        }

        return coolArray;
    }

    @Override
    public Optional<T> remove(int index) {
        if (index > end) {
            return Optional.ofNullable(null);
        }

        T tmpElement = (T) elements[index];

        for (int i = index; i < this.elements.length - 1; ++i) {
            elements[i] = elements[i + 1];
        }
        --end;

        return Optional.ofNullable(tmpElement);
    }

    @Override
    public Optional<T> remove(T element) {
        //TODO
        return null;
    }

    @Override
    public Optional<T> replace(int index, T newElement) {
        if (index >= end) {
            return Optional.ofNullable(null);
        }

        Optional<T> tmpValue = Optional.ofNullable((T) this.elements[index]);
        this.elements[index] = newElement;

        return tmpValue;
    }

    @Override
    public Optional<T> replace(T oldElement, T newElement) {
        //TODO
        return null;
    }

    @Override
    public CoolArray<T> replaceAll(T oldElement, T newElement) {
        //TODO
        return null;
    }

    @Override
    public Optional<T> set(int index, T element) {
        //TODO
        return null;
    }

    @Override
    public int size() {
        return end + 1;
    }

    @Override
    public void trimToSize(int index) {
        if (index > end) {
            return;
        }

        Object[] newArray = new Object[index];

        for (int i = 0; i < index; ++i) {
            newArray[i] = this.elements[i];
        }
        this.elements = newArray;
        this.end = index - 1;
        this.size = index;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i <= this.end; ++i){
            builder.append(this.elements[i]).append(" ");
        }

        return builder.toString().trim();
    }

    private void copyArray(Object[] array, int left, int right) {
        if(left > right){
            return;
        }

        if(left < 0){
            left = 0;
        }

        if(right > array.length){
            right = array.length;
        }

        if(this.elements.length < array.length){
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < this.elements.length; ++i) {
                newArray[i] = this.elements[i];
            }
            this.elements = newArray;
            this.end = newArray.length;
        }

        for(int i=left; i<right; ++i){
            this.elements[++end] = array[i];
        }
    }

    private void resizeAndCopyArray(){
        this.size *=  2;
        Object[] newArray = new Object[this.size];

        for(int i=0; i<=this.end; ++i){
            newArray[i] = this.elements[i];
        }

        this.elements = newArray;
    }

}
