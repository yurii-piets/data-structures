package collections.tree.bstree;

import collections.tree.Tree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class BSTreeTest {
    private BSTree<Integer> tree;

    @Before
    public void init(){
        tree = new BSTree<>();
    }

    @After
    public void reset(){
        tree = null;
    }

    @Test
    public void add() throws Exception {
        tree.add(5);
        tree.add(4);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(9);

        for (int i = 1; i < 10; i++) {
            assertTrue(tree.contains(i));
        }
    }


    @Test
    public void clear() throws Exception {
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(9);

        tree.clear();
        assertEquals(0, tree.size());
        assertTrue(tree.isEmpty());

        for (int i = 0; i < 8; i++) {
            assertFalse(tree.contains(i));
        }
    }

    @Test
    public void contains() throws Exception {
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.add(4);

        for (int i = 1; i < 10; i++) {
            assertTrue(tree.contains(i));
        }

        tree.replace(9, -9);
        assertFalse(tree.contains(9));
        assertTrue(tree.contains(-9));

        tree.remove(-9);
        assertFalse(tree.contains(-9));
    }

    @Test
    public void depth() throws Exception {
        assertEquals(0, tree.depth());

        tree.add(5);
        assertEquals(1, tree.depth());

        tree.add(2);
        assertEquals(2, tree.depth());

        tree.add(7);
        assertEquals(2, tree.depth());

        tree.add(1);
        assertEquals(3, tree.depth());

        tree.add(3);
        assertEquals(3, tree.depth());

        tree.add(6);
        assertEquals(3, tree.depth());

        tree.add(8);
        assertEquals(3, tree.depth());

        tree.add(9);
        assertEquals(4, tree.depth());

        tree.add(10);
        assertEquals(5, tree.depth());

        tree.add(10);
        assertEquals(5, tree.depth());

        tree.clear();
        assertEquals(0, tree.depth());
    }

    @Test
    public void isEmpty() throws Exception {
        assertTrue(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());

        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(9);

        assertFalse(tree.isEmpty());
        tree.clear();
        assertTrue(tree.isEmpty());

        tree.add(6);
        tree.add(8);
        tree.add(9);
        tree.remove(6);
        tree.remove(9);
        tree.remove(8);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void removeOne() throws Exception {
        tree.add(5);
        tree.remove(5);
        assertFalse(tree.contains(5));
        assertEquals(0, tree.size());
    }

    @Test
    public void removeZeroChild() throws Exception {
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.remove(2);
        assertFalse(tree.contains(2));
        assertEquals(2, tree.size());
    }

    @Test
    public void removeRoot() throws Exception {
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.remove(5);

        assertFalse(tree.contains(5));
        assertTrue(tree.contains(2));
        assertTrue(tree.contains(7));

        assertEquals(2, tree.size());
    }

    @Test
    public void removeRoot2() throws Exception {
        tree.add(5);
        tree.add(3);
        tree.add(15);

        tree.add(7);
        tree.add(16);

        tree.add(6);
        tree.add(13);

        tree.add(11);
        tree.add(14);
        tree.add(12);

        tree.remove(5);
        assertFalse(tree.contains(5));

        assertTrue(tree.contains(7));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(15));
        assertTrue(tree.contains(16));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(13));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(14));
        assertTrue(tree.contains(12));
    }

    @Test
    public void removeWithOneLeftChild() throws Exception {
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(7);
        tree.remove(2);
        assertFalse(tree.contains(2));

        assertTrue(tree.contains(1));
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(7));

        assertEquals(3, tree.size());
    }

    @Test
    public void removeWithOneRightChild() throws Exception {
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(8);
        tree.remove(7);
        assertFalse(tree.contains(7));

        assertTrue(tree.contains(2));
        assertTrue(tree.contains(8));
        assertTrue(tree.contains(5));

        assertEquals(3, tree.size());
    }

    @Test
    public void removeWithTwoChildren() throws Exception {
        tree.add(5);

        tree.add(2);
        tree.add(1);
        tree.add(3);

        tree.add(8);
        tree.add(7);
        tree.add(9);

        tree.remove(8);
        assertFalse(tree.contains(8));

        assertTrue(tree.contains(5));

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(2));

        assertTrue(tree.contains(7));
        assertTrue(tree.contains(9));

        assertEquals(6, tree.size());
    }

    @Test
    public void removeWithTwoChildren2() throws Exception {
        tree.add(5);
        tree.add(3);
        tree.add(15);

        tree.add(7);
        tree.add(16);

        tree.add(6);
        tree.add(13);

        tree.add(11);
        tree.add(14);
        tree.add(12);

        tree.remove(7);
        assertFalse(tree.contains(7));

        assertTrue(tree.contains(5));
        assertTrue(tree.contains(3));
        assertTrue(tree.contains(15));
        assertTrue(tree.contains(16));
        assertTrue(tree.contains(6));
        assertTrue(tree.contains(13));
        assertTrue(tree.contains(11));
        assertTrue(tree.contains(14));
        assertTrue(tree.contains(12));
    }

    @Test
    public void replace() throws Exception {
        tree.add(5);
        tree.add(2);
        tree.add(7);

        tree.add(1);
        tree.add(3);
        tree.add(6);

        tree.add(8);
        tree.add(9);

        tree.replace(5,-5);
        assertTrue(tree.contains(-5));

        tree.replace(2,-2);
        assertTrue(tree.contains(-2));

        tree.replace(7,-7);
        assertTrue(tree.contains(-7));

        tree.replace(1,-1);
        assertTrue(tree.contains(-1));

        tree.replace(3,-3);
        assertTrue(tree.contains(-3));

        tree.replace(6,-6);
        assertTrue(tree.contains(-6));

        tree.replace(8,-8);
        assertTrue(tree.contains(-8));

        tree.replace(9,-9);
        assertTrue(tree.contains(-9));
    }

    @Test
    public void size() throws Exception {
        assertEquals(0, tree.size());

        tree.clear();
        assertEquals(0, tree.size());

        tree.add(5);
        assertEquals(1, tree.size());

        tree.add(2);
        assertEquals(2, tree.size());

        tree.add(7);
        assertEquals(3, tree.size());

        tree.add(1);
        assertEquals(4, tree.size());

        tree.add(3);
        assertEquals(5, tree.size());

        tree.add(6);
        assertEquals(6, tree.size());

        tree.add(8);
        assertEquals(7, tree.size());

        tree.replace(8,-8);
        tree.replace(2,-2);
        tree.replace(5,-5);

        assertEquals(7, tree.size());

        tree.remove(-5);
        assertEquals(6, tree.size());

        tree.remove(3);
        assertEquals(5, tree.size());

        tree.remove(6);
        assertEquals(4, tree.size());

        tree.remove(6);
        assertEquals(4, tree.size());

        tree.remove(1);
        assertEquals(3, tree.size());

        tree.remove(-2);
        assertEquals(2, tree.size());

        tree.remove(7);
        assertEquals(1, tree.size());

        tree.remove(7);
        assertEquals(1, tree.size());

        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(3);
        tree.add(6);
        tree.add(8);
        tree.add(9);

        tree.clear();
        assertEquals(0, tree.size());
    }

    @Test
    public void min() throws Exception {
        Random random = new Random();
        Integer min = Integer.MAX_VALUE;
        for(int i = 0; i <100; ++i){
            int val = random.nextInt();
            tree.add(val);
            min = min > val ? val : min;
        }

        assertEquals(min, tree.min());
    }

    @Test
    public void max() throws Exception {
        Random random = new Random();
        Integer max = Integer.MIN_VALUE;
        for(int i = 0; i <100; ++i){
            int val = random.nextInt();
            tree.add(val);
            max = max < val ? val : max;
        }

        assertEquals(max, tree.max());
    }

}