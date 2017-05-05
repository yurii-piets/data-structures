package structures.list.array;

public class CoolArray<T extends Comparable<T>> implements ICoolArray<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;
    private int size;
    private int end = -1;


    public CoolArray() {
        this.size = DEFAULT_CAPACITY;
        this.array = new Object[DEFAULT_CAPACITY];
    }

    public CoolArray(int size) {
        this.size = size;
        this.array = new Object[size];
    }

    public CoolArray(T[] array) {
        this.size = 2*array.length;
        this.array = new Object[size];
        copyArray(array, 0, array.length);
        this.end = array.length-1;
    }

    public CoolArray(T[] array, int left, int right) {
        this.size = 2*array.length;
        this.array = new Object[size];
        copyArray(array, left, right);
        this.end = right;
    }

    public CoolArray(CoolArray<T> coolArray){
        this.array = new Object[coolArray.size];
        this.size = coolArray.size;
        copyArray(coolArray.array, 0, coolArray.end + 1);
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

        if(this.array.length < array.length){
            Object[] newArray = new Object[array.length * 2];
            for (int i = 0; i < this.array.length; ++i) {
                newArray[i] = this.array[i];
            }
            this.array = newArray;
            this.end = newArray.length;
        }

        for(int i=left; i<right; ++i){
            this.array[++end] = array[i];
        }
    }
}
