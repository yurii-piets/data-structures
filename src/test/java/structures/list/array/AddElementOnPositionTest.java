package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static structures.ArrayTestHelper.createTestArray;

public class AddElementOnPositionTest {

    @Test
    public void testAddToEmptyListInRange(){
        Integer element = 777;
        int index = 5;

        CoolArray<Integer> coolArray = new CoolArray<>();
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testAddToEmptyListOutOfRange(){
        Integer element = 777;
        int index = 15;

        CoolArray<Integer> coolArray = new CoolArray<>();
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testAddToNotEmptyListInRange(){
        Integer element = 777;
        int index = 5;

        CoolArray<Integer> coolArray = new CoolArray<>((Integer []) createTestArray());
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testAddToNotEmptyListOutOfRange(){
        Integer element = 777;
        int index = 15;

        CoolArray<Integer> coolArray = new CoolArray<>((Integer []) createTestArray());
        coolArray.add(index,element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

}
