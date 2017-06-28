package collections.list.array;

import collections.list.List;

import java.util.Optional;

public class ArrayList<T> implements List<T>, Cloneable {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;
    private int end = -1;

    public ArrayList() {
        this.size = DEFAULT_CAPACITY;
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int size) {
        if (size < 0) {
            this.size = DEFAULT_CAPACITY;
            this.elements = new Object[DEFAULT_CAPACITY];
        } else {
            this.size = size;
            this.elements = new Object[size];
        }
    }

    public ArrayList(T[] array) {
        this.size = 2 * array.length;
        this.elements = new Object[size];
        copyArray(array, 0, array.length);
        this.end = array.length - 1;
    }

    public ArrayList(T[] array, int left, int right) {
        this.size = 2 * array.length;
        this.elements = new Object[size];
        copyArray(array, left, right);
        this.end = right;
    }

    public ArrayList(ArrayList<T> coolArray) {
        this.elements = new Object[coolArray.size];
        this.size = coolArray.size;
        copyArray(coolArray.elements, 0, coolArray.end + 1);
    }

    @Override
    public void add(T element) {
        if (end >= elements.length - 1) {
            resizeAndCopyArray();
        }
        this.elements[++end] = element;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0) {
            return;
        }

        if (index >= end) {
            Object[] newArray = new Object[index + DEFAULT_CAPACITY];

            System.arraycopy(this.elements, 0, newArray, 0, this.end + 1);

            this.elements = newArray;
            this.end = index;
        }

        this.elements[index] = element;
    }

    @Override
    public void addAll(List<T> array) {
        if (array == null) {
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
        if (o == null) {
            for (int i = 0; i <= this.end; ++i) {
                if (this.elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i <= this.end; ++i) {
                if (o.equals(this.elements[i])) {
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
        if (o == null) {
            for (int i = 0; i <= end; ++i) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i <= end; ++i) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public ArrayList<T> clone() {
        ArrayList<T> cloneArray = new ArrayList<>(this);
        return cloneArray;
    }

    @Override
    public boolean isEmpty() {
        return this.end < 0;
    }

    @Override
    public Optional<T> get(int i) {
        if (i > end || i < 0) {
            return Optional.empty();
        }

        return Optional.ofNullable((T) elements[i]);
    }

    @Override
    public ArrayList<T> getAll(int left, int right) {
        ArrayList<T> coolArray = new ArrayList<>();

        for (int i = left; i <= this.end && i < right; ++i) {
            coolArray.add((T) this.elements[i]);
        }

        return coolArray;
    }

    @Override
    public Optional<T> remove(int index) {
        if (index > end) {
            return Optional.empty();
        }

        T tmpElement = (T) elements[index];

        System.arraycopy(elements, index + 1, elements, index, this.elements.length - 1 - index);
        end = end - 1;

        return Optional.ofNullable(tmpElement);
    }

    @Override
    public void remove(T element) {
        int indexOfOcuurance = -1;
        if (element == null) {
            for (int i = 0; i <= end; ++i) {
                if (this.elements[i] == null) {
                    indexOfOcuurance = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i <= end; ++i) {
                if (this.elements[i].equals(element)) {
                    indexOfOcuurance = i;
                    break;
                }
            }
        }

        if (indexOfOcuurance != -1) {
            System.arraycopy(this.elements, indexOfOcuurance + 1, this.elements, indexOfOcuurance, end + 1 - indexOfOcuurance);
            end = end - 1;
        }
    }

    @Override
    public void removeAll(T element) {
        if (element == null) {
            for (int i = 0; i <= end; ++i) {
                if (!get(i).isPresent()) {
                    remove(i--);
                }
            }
        } else {
            for (int i = 0; i <= end; ++i) {
                Optional<T> tmp = get(i);
                if (tmp.isPresent() && element.equals(tmp.get())) {
                    remove(i--);
                }
            }
        }
    }

    @Override
    public Optional<T> replace(int index, T newElement) {
        T returnValue = null;

        if (index < end) {
            returnValue = (T) this.elements[index];
            this.elements[index] = newElement;
        }
        return Optional.ofNullable(returnValue);
    }

    @Override
    public void replace(T oldElement, T newElement) {
        if (oldElement == null) {
            for (int i = 0; i <= end; ++i) {
                if (this.elements[i] == null) {
                    this.elements[i] = newElement;
                    break;
                }
            }
        } else {
            for (int i = 0; i <= end; ++i) {
                if (oldElement.equals(this.elements[i])) {
                    this.elements[i] = newElement;
                    break;
                }
            }
        }
    }

    @Override
    public void replaceAll(T oldElement, T newElement) {
        if (oldElement == null) {
            for (int i = 0; i <= end; ++i) {
                if (this.elements[i] == null) {
                    this.elements[i] = newElement;
                }
            }
        } else {
            for (int i = 0; i <= end; ++i) {
                if (oldElement.equals(this.elements[i])) {
                    this.elements[i] = newElement;
                }
            }
        }
    }

    @Override
    public Optional<T> set(int index, T element) {
        if (index > end) {
            return Optional.empty();
        }

        Optional<T> tmpElement = Optional.ofNullable((T) this.elements[index]);

        this.elements[index] = element;

        return tmpElement;
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

        System.arraycopy(this.elements, 0, newArray, 0, index);
        this.elements = newArray;
        this.end = index - 1;
        this.size = index;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i <= this.end; ++i) {
            builder.append(this.elements[i]).append(" ");
        }

        return builder.toString().trim();
    }

    private void copyArray(Object[] array, int left, int right) {
        if (left > right) {
            return;
        }

        if (left < 0) {
            left = 0;
        }

        if (right > array.length) {
            right = array.length;
        }

        if (this.elements.length < array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(this.elements, 0, newArray, 0, this.elements.length);
            this.elements = newArray;
            this.end = newArray.length;
        }

        for (int i = left; i < right; ++i) {
            this.elements[++end] = array[i];
        }
    }

    private void resizeAndCopyArray() {
        this.size *= 2;
        Object[] newArray = new Object[this.size];

        System.arraycopy(this.elements, 0, newArray, 0, this.end + 1);

        this.elements = newArray;
    }

}
