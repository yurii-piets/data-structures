package collections.list.linked;

import collections.LinkedNode;
import collections.list.List;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void removeAll() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.1);
        list.add(1.1);
        list.add(1.1);
        list.add(1.3);
        list.add(1.4);
        list.add(1.5);
        list.add(null);
        list.add(null);
        list.add(null);

        list.removeAll(1.1);
        list.removeAll(1.3);
        list.removeAll(null);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double) 1.4, list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double) 1.5, list.get(1).get());

        assertEquals(2, list.size());
        assertFalse(list.contains(1.1));
        assertFalse(list.contains(1.3));
        assertFalse(list.contains(null));
        assertTrue(list.contains(1.4));
        assertTrue(list.contains(1.5));
    }

    @Test
    public void constructorZeroArgument() throws Exception {
        List<?> list = new LinkedList<>();
        LinkedNode<?> head = (LinkedNode<?>) getValueByName(list, "head");
        LinkedNode<?> tail = (LinkedNode<?>) getValueByName(list, "tail");
        int size = (int) getValueByName(list, "size");

        assertNull(head);
        assertNull(tail);
        assertEquals(0, size);
    }

    @Test
    public void constructorListArgument(){
        List<Double> list = new LinkedList<>();
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(4.4);

        List<?> listClone = new LinkedList<>(list);
        assertTrue(listClone.get(0).isPresent());
        assertEquals( 1.1, listClone.get(0).get());

        assertTrue(listClone.get(1).isPresent());
        assertEquals( 2.2, listClone.get(1).get());

        assertTrue(listClone.get(2).isPresent());
        assertEquals( 3.3, listClone.get(2).get());

        assertTrue(listClone.get(3).isPresent());
        assertEquals( 4.4, listClone.get(3).get());


        assertFalse(listClone.get(5).isPresent());
    }

    @Test
    public void add() throws Exception {
        List<Double> list = new LinkedList<>();

        LinkedNode<?> headNode = (LinkedNode) getValueByName(list, "head");
        LinkedNode<?> tailNode = (LinkedNode) getValueByName(list, "tail");

        assertNull(headNode);
        assertNull(tailNode);
        assertEquals(0, list.size());

        list.add(1.1);
        assertEquals(1, list.size());

        headNode = (LinkedNode) getValueByName(list, "head");
        tailNode = (LinkedNode) getValueByName(list, "tail");
        assertEquals(headNode, tailNode);
        assertEquals(headNode.getElement(), tailNode.getElement());

        list.add(77.7);
        headNode = (LinkedNode) getValueByName(list, "head");
        tailNode = (LinkedNode) getValueByName(list, "tail");
        assertEquals(2, list.size());
        assertNotEquals(headNode, tailNode);
        assertNotEquals(headNode.getElement(), tailNode.getElement());

        list.add(null);
        headNode = (LinkedNode) getValueByName(list, "head");
        tailNode = (LinkedNode) getValueByName(list, "tail");
        assertEquals(3, list.size());
        assertNotEquals(headNode, tailNode);
        assertNotEquals(headNode.getElement(), tailNode.getElement());

        assertEquals(1.1, headNode.getElement());
        assertEquals(77.7, headNode.getNext().getElement());
        assertNull(headNode.getNext().getNext().getElement());
        assertNull(headNode.getNext().getNext().getNext());

        assertNull(tailNode.getElement());
        assertEquals(77.7, tailNode.getPrevious().getElement());
        assertEquals(1.1, tailNode.getPrevious().getPrevious().getElement());
        assertNull(tailNode.getPrevious().getPrevious().getPrevious());

        assertEquals(headNode.getElement(), headNode.getNext().getPrevious().getElement());
        assertEquals(headNode.getElement(), headNode.getNext().getNext().getPrevious().getPrevious().getElement());

        assertEquals(tailNode.getElement(), tailNode.getPrevious().getNext().getElement());
        assertEquals(tailNode.getElement(), tailNode.getPrevious().getPrevious().getNext().getNext().getElement());

        list.clear();
        headNode = (LinkedNode) getValueByName(list, "head");
        tailNode = (LinkedNode) getValueByName(list, "tail");
        assertEquals(0, list.size());
        assertEquals(headNode, tailNode);
        assertNull(headNode);
        assertNull(tailNode);
    }

    @Test
    public void addAtIndex(){
        List<Double> list = new LinkedList<>();
        list.add(0.001);
        list.add(1.1);
        list.add(2.2);
        list.add(33.33);
        list.add(777.777);

        list.add(0, -0.001);

        assertTrue(list.get(0).isPresent());
        assertTrue(list.get(1).isPresent());
        assertTrue(list.get(2).isPresent());

        assertEquals((Double) (-0.001), list.get(0).get());
        assertEquals((Double) 0.001, list.get(1).get());
        assertEquals((Double) 1.1, list.get(2).get());

        list.add(3, -2.2);
        assertTrue(list.get(3).isPresent());
        assertEquals((Double)(-2.2), list.get(3).get());

        list.add(6, -777.777);
        assertTrue(list.get(6).isPresent());
        assertEquals((Double)(-777.777), list.get(6).get());

        assertTrue(list.get(7).isPresent());
        assertEquals((Double)(777.777), list.get(7).get());
    }

    @Test
    public void addAll() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(4.4);

        List<?> listClone = new LinkedList<>(list);
        assertTrue(listClone.get(0).isPresent());
        assertEquals( 1.1, listClone.get(0).get());

        assertTrue(listClone.get(1).isPresent());
        assertEquals( 2.2, listClone.get(1).get());

        assertTrue(listClone.get(2).isPresent());
        assertEquals( 3.3, listClone.get(2).get());

        assertTrue(listClone.get(3).isPresent());
        assertEquals( 4.4, listClone.get(3).get());


        assertFalse(listClone.get(5).isPresent());

    }

    @Test
    public void contains() throws Exception {
        List<Double> list = new LinkedList<>();

        assertFalse(list.contains(1.1));

        list.add(1.1);
        assertTrue(list.contains(1.1));

        list.add(2.2);
        list.add(3.3);
        list.add(4.4);
        assertTrue(list.contains(4.4));

        list.clear();
        assertFalse(list.contains(1.1));
        assertFalse(list.contains(2.2));
        assertFalse(list.contains(3.3));
        assertFalse(list.contains(4.4));
    }

    @Test
    public void clear() throws Exception {
        List<Double> list = new LinkedList<>();

        assertTrue(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());

        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(3.3);
        assertFalse(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void indexOf() throws Exception {
        List<Double> list = new LinkedList<>();
        assertEquals(-1, list.indexOf(22.2));
        list.add(22.2);
        assertEquals(0, list.indexOf(22.2));

        list.add(1.1);
        list.add(2.2);
        list.add(3.3);
        list.add(4.4);

        assertEquals(1, list.indexOf(1.1));
        assertEquals(2, list.indexOf(2.2));
        assertEquals(3, list.indexOf(3.3));
        assertEquals(4, list.indexOf(4.4));

        assertEquals(-1, list.indexOf(3425.1));

    }

    @Test
    public void isEmpty() throws Exception {
        List<Double> list = new LinkedList<>();
        assertTrue(list.isEmpty());
        list.clear();
        assertTrue(list.isEmpty());

        list.add(2.2);
        list.add(7.7);
        list.add(8.8);
        list.add(9.9);

        assertFalse(list.isEmpty());

        list.clear();

        assertTrue(list.isEmpty());
    }

    @Test
    public void get() throws Exception {
        List<Double> list = new LinkedList<>();

        assertFalse(list.get(0).isPresent());
        assertFalse(list.get(100).isPresent());

        list.add(1.1);
        list.add(2.2);
        list.add(3.3);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double)1.1, list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double)2.2, list.get(1).get());

        assertTrue(list.get(2).isPresent());
        assertEquals((Double)3.3, list.get(2).get());

    }

    @Test
    public void getAll() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.1);
        list.add(1.2);
        list.add(1.3);
        list.add(1.4);

        List<Double> listGet = list.getAll(1,3);
        assertTrue(listGet.get(0).isPresent());
        assertTrue(listGet.get(1).isPresent());
        assertEquals(list.get(1).get(), listGet.get(0).get());
        assertEquals(list.get(2).get(), listGet.get(1).get());
    }

    @Test
    public void removeIndex() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.2);
        list.add(1.3);
        list.add(1.4);
        list.add(1.5);
        list.add(1.6);

        Optional<Double> r1 = list.remove(0);
        Optional<Double> r2 = list.remove(3);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double) 1.3, list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double) 1.5, list.get(2).get());

        assertEquals(3, list.size());

        list.remove(10090);
        assertEquals(3, list.size());

        Optional<Double> r3 = list.remove(1);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double) 1.3, list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double) 1.5, list.get(1).get());

        assertEquals(2, list.size());

        assertTrue(r1.isPresent());
        assertEquals((Double) 1.2, r1.get());

        assertTrue(r2.isPresent());
        assertEquals((Double) 1.6, r2.get());

        assertTrue(r3.isPresent());
        assertEquals((Double) 1.4, r3.get());
    }

    @Test
    public void removeElement() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.2);
        list.add(1.3);
        list.add(1.4);
        list.add(1.5);
        list.add(1.6);

        list.remove(1.2);
        list.remove(1.6);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double) 1.3, list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double) 1.5, list.get(2).get());

        assertEquals(3, list.size());

        list.remove(10090);
        assertEquals(3, list.size());

        list.remove(1);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double) 1.3, list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double) 1.5, list.get(1).get());

        assertEquals(2, list.size());
    }

    @Test
    public void replaceIndex() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.2);
        list.add(1.3);
        list.add(1.4);
        list.add(1.5);

        Optional<Double> d1 = list.replace(0, -1.2);
        Optional<Double> d2 = list.replace(1, -1.3);
        Optional<Double> d3 = list.replace(2, -1.4);
        Optional<Double> d4 = list.replace(3, -1.5);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double) (-1.2), list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double) (-1.3), list.get(1).get());

        assertTrue(list.get(2).isPresent());
        assertEquals((Double) (-1.4), list.get(2).get());

        assertTrue(list.get(3).isPresent());
        assertEquals((Double) (-1.5), list.get(3).get());


        assertTrue(d1.isPresent());
        assertEquals((Double) 1.2, d1.get());

        assertTrue(d2.isPresent());
        assertEquals((Double) 1.3, d2.get());

        assertTrue(d3.isPresent());
        assertEquals((Double) 1.4, d3.get());

        assertTrue(d4.isPresent());
        assertEquals((Double) 1.5, d4.get());
    }

    @Test
    public void replaceElement() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.2);
        list.add(1.3);
        list.add(1.3);
        list.add(1.4);
        list.add(1.5);
        list.add(null);

        list.replace(1.2, -1.2);
        list.replace(1.3, -1.3);
        list.replace(1.4, -1.4);
        list.replace(1.5, -1.5);
        list.replace(null, (double) 777);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double) (-1.2), list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double) (-1.3), list.get(1).get());

        assertTrue(list.get(2).isPresent());
        assertEquals((Double) 1.3, list.get(2).get());

        assertTrue(list.get(3).isPresent());
        assertEquals((Double) (-1.4), list.get(3).get());

        assertTrue(list.get(4).isPresent());
        assertEquals((Double) (-1.5), list.get(4).get());

        assertTrue(list.get(5).isPresent());
        assertEquals(new Double(777), list.get(5).get());
    }

    @Test
    public void replaceAll() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.2);
        list.add(1.3);
        list.add(1.3);
        list.add(1.3);
        list.add(null);
        list.add(null);

        list.replaceAll(1.2, -1.2);
        list.replaceAll(1.3, -1.3);
        list.replaceAll(null, 7.77);

        assertTrue(list.get(0).isPresent());
        assertEquals( (Double) (-1.2), list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals( (Double) (-1.3), list.get(1).get());

        assertTrue(list.get(2).isPresent());
        assertEquals( (Double) (-1.3), list.get(2).get());

        assertTrue(list.get(3).isPresent());
        assertEquals( (Double) (-1.3), list.get(3).get());

        assertTrue(list.get(4).isPresent());
        assertEquals( (Double) 7.77, list.get(4).get());

        assertTrue(list.get(5).isPresent());
        assertEquals( (Double) 7.77, list.get(5).get());

        assertEquals(6, list.size());

    }

    @Test
    public void set() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(3.2);
        list.add(3.3);
        list.add(3.4);
        list.add(3.5);

        Optional<Double> old1 = list.set(0, -3.2);
        Optional<Double> old2 = list.set(1, -3.3);
        Optional<Double> old3 = list.set(2, -3.4);
        Optional<Double> old4 = list.set(3, -3.5);

        assertTrue(list.get(0).isPresent());
        assertEquals((Double)(-3.2), list.get(0).get());

        assertTrue(list.get(1).isPresent());
        assertEquals((Double)(-3.3), list.get(1).get());

        assertTrue(list.get(2).isPresent());
        assertEquals((Double)(-3.4), list.get(2).get());

        assertTrue(list.get(3).isPresent());
        assertEquals((Double)(-3.5), list.get(3).get());


        assertTrue(old1.isPresent());
        assertEquals((Double)(3.2), old1.get());

        assertTrue(old2.isPresent());
        assertEquals((Double)(3.3), old2.get());

        assertTrue(old3.isPresent());
        assertEquals((Double)(3.4), old3.get());

        assertTrue(old4.isPresent());
        assertEquals((Double)(3.5), old4.get());
    }

    @Test
    public void size() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(3.2);
        list.add(3.3);
        list.add(3.4);
        list.add(3.5);

        assertEquals(4, list.size());


        List<Double> list2 = new LinkedList<>(list);
        assertEquals(4, list2.size());

        list2.clear();
        assertEquals(0, list2.size());
    }

    @Test
    public void trimToSize() throws Exception {
        List<Double> list = new LinkedList<>();
        list.add(1.1);
        list.add(1.2);
        list.add(1.3);
        list.add(1.4);

        list.trimToSize(2);
        assertEquals(2, list.size());

        List<Double> list2 = new LinkedList<>();
        list.trimToSize(0);
        assertEquals(0, list.size());

        list.trimToSize(-1);
        assertEquals(0, list.size());
    }

    private Object getValueByName(List list, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = list.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Object object = field.get(list);

        return object;
    }

}