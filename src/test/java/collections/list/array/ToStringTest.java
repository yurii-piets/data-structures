package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static collections.list.array.ArrayTestHelper.createTestArray;

public class ToStringTest {
    @Test
    public void testToStringEmpty(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertEquals(coolArray.toString(), "");
    }

    @Test
    public void testToString(){
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray(5));
        assertEquals(coolArray.toString(), "5 4 3 2 1");
    }

    @Test
    public void testToStringCleared(){
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray(5));
        coolArray.clear();
        assertEquals(coolArray.toString(), "");
    }
}
