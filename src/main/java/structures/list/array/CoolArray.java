package structures.list.array;

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
        this.size = 2*array.length;
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
    public boolean contains(Object o) {
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
    public boolean isEmpty() {
        return this.end < 0;
    }

    @Override
    public int size() {
        return end + 1;
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
