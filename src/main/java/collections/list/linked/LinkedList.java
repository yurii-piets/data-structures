package collections.list.linked;

import collections.Node;
import collections.list.List;

import java.util.Optional;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public LinkedList() {
    }

    public LinkedList(List<T> list) {
        for (int i = 0; i < list.size(); ++i) {
            this.add(list.get(i).get());
        }
    }

    @Override
    public void add(T element) {
        Node<T> node = new Node<T>(element);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
        }
        size = size + 1;
    }

    @Override
    public void add(int index, T element) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node<T> insertNode = new Node<>(element);

        int i = 0;
        Node<T> current = head;
        while (current != null) {
            if (i == index) {

                if (current == head && current == tail) {
                    head = tail = insertNode;
                } else if (current == head) {
                    head = insertNode;
                } else {
                    insertNode.setPrevious(current.getPrevious());
                    current.getPrevious().setNext(insertNode);
                }

                insertNode.setNext(current);
                current.setPrevious(insertNode);
                break;
            }
            i = i + 1;
            current = current.getNext();
        }
        size = size + 1;
    }

    @Override
    public void addAll(List<T> array) {
        for (int i = 0; i < array.size(); ++i) {
            this.add(array.get(i).get());
            size = size + 1;
        }
    }

    @Override
    public boolean contains(T element) {
        return getNodeByValue(element).isPresent();
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(T element) {
        int i = 0;
        int returnValue = -1;

        Node<T> current = head;
        if (element == null) {
            while (current != null) {
                if (current.getElement() == null) {
                    returnValue = i;
                    break;
                }
                i = i + 1;
                current = current.getNext();
            }
        } else {
            while (current != null) {
                if (element.equals(current.getElement())) {
                    returnValue = i;
                    break;
                }
                i = i + 1;
                current = current.getNext();
            }
        }

        return returnValue;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Optional<T> get(int index) {
        T returnValue = null;
        if (index >= 0) {
            Optional<Node<T>> node = getNodeByIndex(index);
            if (node.isPresent()) {
                returnValue = node.get().getElement();
            }
        }

        return Optional.ofNullable(returnValue);
    }

    @Override
    public List<T> getAll(int left, int right) {
        LinkedList<T> list = new LinkedList<>();
        Optional<Node<T>> current = getNodeByIndex(left);
        if (current.isPresent()) {
            Node<T> newCurrent = current.get();
            for (int i = left; i < right && current != null; ++i) {
                list.add(newCurrent.getElement());
                newCurrent = newCurrent.getNext();
            }
        }
        return list;
    }

    @Override
    public Optional<T> remove(int index) {
        T returnValue = null;

        if (index >= 0 && index < size) {
            Optional<Node<T>> currentNode = getNodeByIndex(index);
            if (currentNode.isPresent()) {
                Node<T> current = currentNode.get();
                returnValue = currentNode.get().getElement();

                if (current == head) {
                    head = current.getNext();

                    if (current.getNext() != null) {
                        current.getNext().setPrevious(null);
                    }

                    current.setNext(null);
                }

                if (current == tail) {
                    tail = current.getPrevious();

                    if (current.getPrevious() != null) {
                        current.getPrevious().setNext(null);
                    }
                    current.setPrevious(null);
                }

                if (current.getPrevious() != null) {
                    current.getPrevious().setNext(current.getNext());
                }

                if (current.getNext() != null) {
                    current.getNext().setPrevious(current.getPrevious());
                }

                size = size - 1;
            }
        }

        return Optional.ofNullable(returnValue);
    }

    @Override
    public void remove(T element) {
        Optional<Node<T>> currentNode = getNodeByValue(element);
        currentNode.ifPresent(this::removeNode);
    }

    @Override
    public void removeAll(T element) {
        Node<T> current = head;

        if (element == null) {
            while (current != null) {
                Node<T> currentNext = current.getNext();

                if (current.getElement() == null) {
                    removeNode(current);
                }
                current = currentNext;
            }
        } else {
            while (current != null) {
                Node<T> currentNext = current.getNext();
                if (element.equals(current.getElement())) {
                    removeNode(current);
                }
                current = currentNext;
            }
        }
    }

    @Override
    public Optional<T> replace(int index, T newElement) {
        Optional<Node<T>> node = getNodeByIndex(index);
        T returnValue = null;
        if (node.isPresent()) {
            returnValue = node.get().getElement();
            node.get().setElement(newElement);
        }
        return Optional.ofNullable(returnValue);
    }

    @Override
    public void replace(T oldElement, T newElement) {
        Optional<Node<T>> node = getNodeByValue(oldElement);
        if (node.isPresent()) {
            node.get().getElement();
            node.get().setElement(newElement);
        }
    }

    @Override
    public void replaceAll(T oldElement, T newElement) {
        Node<T> current = head;
        if (oldElement == null) {
            while (current != null) {
                if (current.getElement() == null) {
                    current.setElement(newElement);
                }
                current = current.getNext();
            }
        } else {
            while (current != null) {
                if (oldElement.equals(current.getElement())) {
                    current.setElement(newElement);
                }
                current = current.getNext();
            }
        }
    }

    @Override
    public Optional<T> set(int index, T element) {
        Optional<Node<T>> current = getNodeByIndex(index);
        T returnValue = null;
        if (current.isPresent()) {
            Node<T> newCurrent = current.get();
            returnValue = newCurrent.getElement();
            newCurrent.setElement(element);
        }
        return Optional.ofNullable(returnValue);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void trimToSize(int index) {
        if (index >= 0 && index < size) {
            Node<T> current = head;
            for (int i = 0; i < index; ++i) {
                current = current.getNext();
            }

            tail = current;
            size = index;
        }
    }

    private Optional<Node<T>> getNodeByIndex(int index) {
        Node<T> returnValue = null;
        if (index < size) {
            int i = 0;
            Node<T> current = head;

            while (current != null) {
                if (i == index) {
                    returnValue = current;
                    break;
                }
                i = i + 1;
                current = current.getNext();
            }
        }

        return Optional.ofNullable(returnValue);
    }

    private Optional<Node<T>> getNodeByValue(T element) {
        Node<T> returnValue = null;
        Node<T> current = head;

        if (element == null) {
            while (current != null) {
                if (current.getElement() == null) {
                    returnValue = current;
                    break;
                }
                current = current.getNext();
            }
        } else {
            while (current != null) {
                if (element.equals(current.getElement())) {
                    returnValue = current;
                    break;
                }
                current = current.getNext();
            }
        }
        return Optional.ofNullable(returnValue);
    }

    private void removeNode(Node<T> current) {
        if (current == head) {
            head = current.getNext();

            if (current.getNext() != null) {
                current.getNext().setPrevious(null);
            }

            current.setNext(null);
        }

        if (current == tail) {
            tail = current.getPrevious();

            if (current.getPrevious() != null) {
                current.getPrevious().setNext(null);
            }
            current.setPrevious(null);
        }

        if (current.getPrevious() != null) {
            current.getPrevious().setNext(current.getNext());
        }

        if (current.getNext() != null) {
            current.getNext().setPrevious(current.getPrevious());
        }

        size = size - 1;
    }
}
