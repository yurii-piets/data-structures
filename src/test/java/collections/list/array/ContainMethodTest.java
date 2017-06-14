package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static collections.list.array.ArrayTestHelper.createTestArray;

public class ContainMethodTest {

    @Test
    public void testContainsNull() {
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertFalse(coolArray.contains(null));
    }

    @Test
    public void testContainsNullFalse() {
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(null);
        assertTrue(coolArray.contains(null));
    }

    @Test
    public void testContainsElement() {
        int element = 7;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(element);
        assertTrue(coolArray.contains(element));
    }

    @Test
    public void testContainsElementFalse() {
        int element = 7;
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertFalse(coolArray.contains(element));
    }

    @Test
    public void testContainsElements() {
        ArrayList<Integer> coolArray = new ArrayList<>();
        for (int i = 0; i < 25; ++i) {
            coolArray.add(i);
        }

        assertTrue(coolArray.contains(0));
        assertTrue(coolArray.contains(1));
        assertTrue(coolArray.contains(2));
        assertTrue(coolArray.contains(3));
        assertTrue(coolArray.contains(24));
    }

    @Test
    public void testContainsElementsFalse() {
        ArrayList<Integer> coolArray = new ArrayList<>();
        for (int i = 25; i < 50; ++i) {
            coolArray.add(i);
        }

        assertFalse(coolArray.contains(0));
        assertFalse(coolArray.contains(1));
        assertFalse(coolArray.contains(2));
        assertFalse(coolArray.contains(3));
        assertFalse(coolArray.contains(24));
    }

    @Test
    public void testContainsElementClear() {
        int element = 7;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(element);
        coolArray.clear();
        assertFalse(coolArray.contains(element));
    }

    @Test
    public void testContainsElementArray() {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray(10));
        assertTrue(coolArray.contains(7));
    }

    @Test
    public void testContainsElementClearArrayFalse() {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray(10));
        coolArray.clear();
        assertFalse(coolArray.contains(7));
    }

}
