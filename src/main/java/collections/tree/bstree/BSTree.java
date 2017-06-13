package collections.tree.bstree;

import collections.tree.Tree;
import collections.tree.TreeNode;

public class BSTree<T extends Comparable<T>> implements Tree<T> {

    private TreeNode<T> head;
    private int size = 0;

    @Override
    public void add(T value) {
        if (value == null) {
            return;
        }

        TreeNode<T> node = new TreeNode<>(value);
        if (head == null) {
            head = node;
            size += 1;
        } else {
            TreeNode<T> current = head;

            while (current != null) {
                if (value.compareTo(current.getValue()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(node);
                        size += 1;
                        return;
                    } else {
                        current = current.getLeft();
                    }
                } else if (value.compareTo(current.getValue()) > 0) {
                    if (current.getRight() == null) {
                        current.setRight(node);
                        size += 1;
                        return;
                    } else {
                        current = current.getRight();
                    }
                } else {
                    current.setValue(value);
                    return;
                }
            }
        }
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean contains(T value) {
        if (head == null || value == null) {
            return false;
        }

        TreeNode<T> current = head;

        while (current != null) {
            if (value.compareTo(current.getValue()) == 0) {
                return true;
            } else if (value.compareTo(current.getValue()) < 0) {
                if (current.getLeft() == null) {
                    return false;
                } else {
                    current = current.getLeft();
                }
            } else if (value.compareTo(current.getValue()) > 0) {
                if (current.getRight() == null) {
                    return false;
                } else {
                    current = current.getRight();
                }
            }
        }

        return false;
    }

    @Override
    public int depth() {
        return depth(head);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void remove(T value) {
        if (value == null || head == null) {
            return;
        }

        TreeNode<T> parrent = head;
        TreeNode<T> current = head;

        //searching for element
        while (current != null) {
            if (value.compareTo(current.getValue()) == 0) {
                break;
            } else if (value.compareTo(current.getValue()) < 0) {
                parrent = current;
                current = current.getLeft();
            } else if (value.compareTo(current.getValue()) > 0) {
                parrent = current;
                current = current.getRight();
            }
        }

        //no such elem
        if (current == null) {
            return;
        }

        //deleteing
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == parrent.getLeft()) {
                parrent.setLeft(null);
            } else if (current == parrent.getRight()) {
                parrent.setRight(null);
            } else if (current == parrent) {
                this.head = null;
            }
            size -= 1;
        } else if (current.getLeft() == null && current.getRight() != null) {
            if (current == parrent.getLeft()) {
                parrent.setLeft(current.getRight());
            } else if (current == parrent.getRight()) {
                parrent.setRight(current.getRight());
            } else if (current == parrent) {
                this.head = current.getRight();
            }
            size -= 1;
        } else if (current.getLeft() != null && current.getRight() == null) {
            if (current == parrent.getLeft()) {
                parrent.setLeft(current.getLeft());
            } else if (current == parrent.getRight()) {
                parrent.setRight(current.getLeft());
            } else if (current == parrent) {
                this.head = current.getLeft();
            }
            size -= 1;
        } else if (current.getLeft() != null && current.getRight() != null) {
            TreeNode<T> min = minNode(current.getRight());
            T minValue = min.getValue();
            remove(minValue);
            current.setValue(minValue);
        }
    }

    @Override
    public void replace(T oldValue, T newValue) {
        remove(oldValue);
        add(newValue);
    }

    @Override
    public int size() {
        return size;
    }

    public T min() {
        if (head == null) {
            return null;
        }
        return minNode(head).getValue();
    }

    public T max() {
        if (head == null) {
            return null;
        }

        return maxNode(head).getValue();
    }

    private int depth(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.getLeft()), depth(node.getRight()));
    }

    private TreeNode<T> minNode(TreeNode<T> current) {
        if (current == null) {
            return null;
        }

        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    private TreeNode<T> maxNode(TreeNode<T> current) {
        if (current == null) {
            return null;
        }

        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current;
    }
}
