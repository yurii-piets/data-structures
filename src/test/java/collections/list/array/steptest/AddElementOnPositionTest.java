package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;
import static collections.list.array.steptest.ArrayTestHelper.createTestArray;

public class AddElementOnPositionTest {

    @Test
    public void testAddToEmptyListInRange(){
        Integer element = 777;
        int index = 5;

        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testAddToEmptyListOutOfRange(){
        Integer element = 777;
        int index = 15;

        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testAddToNotEmptyListInRange(){
        Integer element = 777;
        int index = 5;

        ArrayList<Integer> coolArray = new ArrayList<>((Integer []) ArrayTestHelper.createTestArray());
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testAddToNotEmptyListOutOfRange(){
        Integer element = 777;
        int index = 15;

        ArrayList<Integer> coolArray = new ArrayList<>((Integer []) ArrayTestHelper.createTestArray());
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

}
