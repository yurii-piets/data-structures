package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static structures.ArrayTestHelper.createTestArray;

public class SetTest {

    @Test
    public void testSetEmpty(){
        Integer element = 10;
        int index = 0;
        CoolArray<Integer> coolArray = new CoolArray<>();
        coolArray.set(index, element);

        assertFalse(coolArray.get(index).isPresent());
    }

    @Test
    public void testSetNotEmpty(){
        Integer element = -12;
        int index = 15;
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray());
        coolArray.set(index, element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testSetInRange(){
        Integer element = -12;
        int index = 22;
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray(32));
        coolArray.set(index, element);

        assertTrue(coolArray.get(index).isPresent());
        assertEquals(element, coolArray.get(index).get());
    }

    @Test
    public void testSetOutOfRange(){
        Integer element = -12;
        int index = 22;
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray(10));
        coolArray.set(index, element);

        assertFalse(coolArray.get(index).isPresent());
    }

}
