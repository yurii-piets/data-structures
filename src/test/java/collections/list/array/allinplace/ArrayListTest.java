package collections.list.array.allinplace;

import collections.list.List;
import collections.list.array.ArrayList;
import org.junit.Before;
import org.junit.Test;

import static collections.list.array.allinplace.ArrayListTestHelper.randomInt;
import static collections.list.array.allinplace.ArrayListTestHelper.randomString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {
    private List<Entity> list;

    @Before
    public void initList() {
        list = new ArrayList<>();
    }

    @Test
    public void addOneElem() {
        Entity entity1 = new Entity(randomInt(), randomString());
        Entity entity2 = new Entity(randomInt(), randomString());
        Entity entity3 = new Entity(randomInt(), randomString());
        Entity entity4 = new Entity(randomInt(), randomString());
        Entity entity5 = new Entity(randomInt(), randomString());

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);

        assertTrue(list.contains(entity1));
        assertTrue(list.contains(entity2));
        assertTrue(list.contains(entity3));
        assertTrue(list.contains(entity4));
        assertTrue(list.contains(entity5));

        assertEquals(entity1, list.get(0).get());
        assertEquals(entity2, list.get(1).get());
        assertEquals(entity3, list.get(2).get());
        assertEquals(entity4, list.get(3).get());
        assertEquals(entity5, list.get(4).get());

        assertEquals(5, list.size());
    }

    @Test
    public void addAll() {
        List<Entity> listOriginal = new ArrayList<>();
        Entity entity1 = new Entity(randomInt(), randomString());
        Entity entity2 = new Entity(randomInt(), randomString());
        Entity entity3 = new Entity(randomInt(), randomString());
        Entity entity4 = new Entity(randomInt(), randomString());
        Entity entity5 = new Entity(randomInt(), randomString());

        listOriginal.add(entity1);
        listOriginal.add(entity2);
        listOriginal.add(entity3);
        listOriginal.add(entity4);
        listOriginal.add(entity5);

        List<Entity> list = new ArrayList<>();
        list.addAll(listOriginal);

        assertTrue(list.contains(entity1));
        assertTrue(list.contains(entity2));
        assertTrue(list.contains(entity3));
        assertTrue(list.contains(entity4));
        assertTrue(list.contains(entity5));

        assertEquals(entity1, list.get(0).get());
        assertEquals(entity2, list.get(1).get());
        assertEquals(entity3, list.get(2).get());
        assertEquals(entity4, list.get(3).get());
        assertEquals(entity5, list.get(4).get());

        assertEquals(5, listOriginal.size());
    }

    @Test
    public void contains() {
        Entity entity1 = new Entity(randomInt(), randomString());
        Entity entity2 = new Entity(randomInt(), randomString());
        Entity entity3 = new Entity(randomInt(), randomString());
        Entity entity4 = new Entity(randomInt(), randomString());
        Entity entity5 = new Entity(randomInt(), randomString());

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);

        list.remove(entity5);

        assertTrue(list.contains(entity1));
        assertTrue(list.contains(entity2));
        assertTrue(list.contains(entity3));
        assertTrue(list.contains(entity4));
        assertFalse(list.contains(entity5));
    }

    @Test
    public void clear() {
        Entity entity1 = new Entity(randomInt(), randomString());
        Entity entity2 = new Entity(randomInt(), randomString());
        Entity entity3 = new Entity(randomInt(), randomString());
        Entity entity4 = new Entity(randomInt(), randomString());
        Entity entity5 = new Entity(randomInt(), randomString());

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);

        list.remove(entity5);

        list.clear();

        assertFalse(list.contains(entity1));
        assertFalse(list.contains(entity2));
        assertFalse(list.contains(entity3));
        assertFalse(list.contains(entity4));
        assertFalse(list.contains(entity5));

        assertEquals(0, list.size());
    }

    @Test
    public void indexOf() {
        Entity entity1 = new Entity(randomInt(), randomString());
        Entity entity2 = new Entity(randomInt(), randomString());
        Entity entity3 = new Entity(randomInt(), randomString());
        Entity entity4 = new Entity(randomInt(), randomString());
        Entity entity5 = new Entity(randomInt(), randomString());
        Entity entity6 = new Entity(randomInt(), randomString());

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.remove(entity5);
        list.add(entity6);

        assertEquals(0, list.indexOf(entity1));
        assertEquals(1, list.indexOf(entity2));
        assertEquals(2, list.indexOf(entity3));
        assertEquals(3, list.indexOf(entity4));
        assertEquals(4, list.indexOf(entity6));
    }

    @Test
    public void testClone() {
        Entity entity1 = new Entity(randomInt(), randomString());
        Entity entity2 = new Entity(randomInt(), randomString());
        Entity entity3 = new Entity(randomInt(), randomString());
        Entity entity4 = new Entity(randomInt(), randomString());
        Entity entity5 = new Entity(randomInt(), randomString());
        Entity entity6 = new Entity(randomInt(), randomString());

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        list.remove(entity5);
        list.add(entity6);

        List<Entity> listClone = list.clone();
        assertEquals(list.size(), listClone.size());

        assertTrue(listClone.contains(entity1));
        assertTrue(listClone.contains(entity2));
        assertTrue(listClone.contains(entity3));
        assertTrue(listClone.contains(entity4));
        assertTrue(listClone.contains(entity6));
    }

    @Test
    public void isEmpty(){
        assertTrue(list.isEmpty());

        Entity entity1 = new Entity(randomInt(), randomString());
        Entity entity2 = new Entity(randomInt(), randomString());
        Entity entity3 = new Entity(randomInt(), randomString());
        Entity entity4 = new Entity(randomInt(), randomString());
        Entity entity5 = new Entity(randomInt(), randomString());

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);
        assertFalse(list.isEmpty());

        list.clear();
        assertTrue(list.isEmpty());

        list.add(entity1);
        list.add(entity2);
        list.add(entity3);
        list.add(entity4);
        list.add(entity5);

        list.remove(entity1);
        list.remove(entity2);
        list.remove(entity3);
        list.remove(entity4);
        list.remove(entity5);

        assertTrue(list.isEmpty());
    }
}
