package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static structures.ArrayTestHelper.createTestArray;

public class ToStringTest {
    @Test
    public void testToStringEmpty(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        assertEquals(coolArray.toString(), "");
    }

    @Test
    public void testToString(){
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray(5));
        assertEquals(coolArray.toString(), "5 4 3 2 1");
    }

    @Test
    public void testToStringCleared(){
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray(5));
        coolArray.clear();
        assertEquals(coolArray.toString(), "");
    }
}
