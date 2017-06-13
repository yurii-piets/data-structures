package collections.tree;

import collections.Node;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode<T> implements Node {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }
}
