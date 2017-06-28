package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;
import static collections.list.array.steptest.ArrayTestHelper.createTestArray;

public class SetTest {

    @Test
    public void testSetEmpty(){
        Integer element = 10;
        int index = 0;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.set(index, element);

        assertFalse(coolArray.get(index).isPresent());
    }

    @Test
    public void testSetNotEmpty(){
        Integer element = -12;
        int index = 15;
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray());
        coolArray.set(index, element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testSetInRange(){
        Integer element = -12;
        int index = 22;
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(32));
        coolArray.set(index, element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testSetOutOfRange(){
        Integer element = -12;
        int index = 22;
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(10));
        coolArray.set(index, element);

        assertFalse(coolArray.get(index).isPresent());
    }

}
