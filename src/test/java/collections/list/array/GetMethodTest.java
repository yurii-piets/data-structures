package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static collections.list.array.ArrayTestHelper.createTestArray;
import static collections.list.array.ArrayTestHelper.getCoolArrayArray;

public class GetMethodTest {
    @Test
    public void testGetEmpty(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertFalse(coolArray.get(0).isPresent());
    }

    @Test
    public void testGetOutOfBound(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertFalse(coolArray.get(-777).isPresent());
        assertFalse(coolArray.get(777).isPresent());
    }

    @Test
    public void testGetAdded(){
        Integer element = 7;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(element);

        assertTrue(coolArray.get(0).isPresent());
        assertEquals(coolArray.get(0).get(), element);
    }

    @Test
    public void testGetArray() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray(33));

        assertTrue(coolArray.get(32).isPresent());
        assertEquals(coolArray.get(32).get(), getCoolArrayArray(coolArray)[32]);
        assertEquals(coolArray.get(32).get(), (Integer) 1);
    }

    @Test
    public void testGetAddedElements() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0 ; i < 25; ++i ){
            coolArray.add(i);
        }

        assertTrue(coolArray.get(10).isPresent());
        assertEquals(coolArray.get(10).get(), getCoolArrayArray(coolArray)[10]);
        assertEquals(coolArray.get(10).get(), (Integer) 10);

    }

    @Test
    public void testGetCleared(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0 ; i < 25; ++i ){
            coolArray.add(i);
        }

        coolArray.clear();
        assertFalse(coolArray.get(0).isPresent());
        assertFalse(coolArray.get(10).isPresent());
        assertFalse(coolArray.get(50).isPresent());
    }

}
