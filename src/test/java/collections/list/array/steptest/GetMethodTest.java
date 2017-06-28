package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static collections.list.array.steptest.ArrayTestHelper.createTestArray;

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
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(33));

        assertTrue(coolArray.get(32).isPresent());
        Assert.assertEquals(coolArray.get(32).get(), ArrayTestHelper.getCoolArrayArray(coolArray)[32]);
        assertEquals(coolArray.get(32).get(), (Integer) 1);
    }

    @Test
    public void testGetAddedElements() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0 ; i < 25; ++i ){
            coolArray.add(i);
        }

        assertTrue(coolArray.get(10).isPresent());
        Assert.assertEquals(coolArray.get(10).get(), ArrayTestHelper.getCoolArrayArray(coolArray)[10]);
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
