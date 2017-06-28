package collections.list.array.steptest;

import collections.list.List;
import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CloneMethodTest {
    @Test
    public void testClone(){
        ArrayList<Integer> originalArray = new ArrayList<>();
        List<Integer> cloneArray = originalArray.clone();

        assertFalse(originalArray == cloneArray);
    }

    @Test
    public void testCloneArrays() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> originalArray = new ArrayList<>();
        List<Integer> cloneArray = originalArray.clone();

        assertFalse(ArrayTestHelper.getCoolArrayArray(originalArray) == ArrayTestHelper.getCoolArrayArray(cloneArray));
    }

    @Test
    public void testCloneSingleElement() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> originalArray = new ArrayList<>();
        for(int i = 0; i < 25; ++i){
            originalArray.add(i);
        }

        List<Integer> cloneArray = originalArray.clone();
        originalArray.add(1);

        assertFalse(ArrayTestHelper.compareCoolArrays(originalArray, cloneArray));
}

    @Test
    public void testClonedEmptySize() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> originalArray = new ArrayList<>();
        List<Integer> cloneArray = originalArray.clone();

        assertEquals(originalArray.size(), cloneArray.size());
        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(originalArray), ArrayTestHelper.getCoolArraySize(cloneArray));
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(originalArray), ArrayTestHelper.getCoolArrayEnd(cloneArray));
    }

    @Test
    public void testClonedEmptyArray() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> originalArray = new ArrayList<>();
        List<Integer> cloneArray = originalArray.clone();

        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(originalArray), ArrayTestHelper.getCoolArrayArray(cloneArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(originalArray, cloneArray));
    }

    @Test
    public void testClonedNotEmptySize() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> originalArray = new ArrayList<>();
        for(int i = 0; i < 25; ++i){
            originalArray.add(i);
        }

        List<Integer> cloneArray = originalArray.clone();

        assertEquals(originalArray.size(), cloneArray.size());
        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(originalArray), ArrayTestHelper.getCoolArraySize(cloneArray));
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(originalArray), ArrayTestHelper.getCoolArrayEnd(cloneArray));
    }

    @Test
    public void testClonedNotEmptyArray() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> originalArray = new ArrayList<>();
        for(int i = 0; i < 25; ++i){
            originalArray.add(i);
        }

        List<Integer> cloneArray = originalArray.clone();

        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(originalArray), ArrayTestHelper.getCoolArrayArray(cloneArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(originalArray, cloneArray));
    }
}
