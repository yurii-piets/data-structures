package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static structures.ArrayTestHelper.*;

public class CloneMethodTest {
    @Test
    public void testClone(){
        CoolArray<Integer> originalArray = new CoolArray<>();
        CoolArray<Integer> cloneArray = originalArray.clone();

        assertFalse(originalArray == cloneArray);
    }

    @Test
    public void testCloneArrays() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> originalArray = new CoolArray<>();
        CoolArray<Integer> cloneArray = originalArray.clone();

        assertFalse(getCoolArrayArray(originalArray) == getCoolArrayArray(cloneArray));
    }

    @Test
    public void testCloneSingleElement() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> originalArray = new CoolArray<>();
        for(int i = 0; i < 25; ++i){
            originalArray.add(i);
        }

        CoolArray<Integer> cloneArray = originalArray.clone();
        originalArray.add(1);

        assertFalse(compareCoolArrays(originalArray, cloneArray));
}

    @Test
    public void testClonedEmptySize() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> originalArray = new CoolArray<>();
        CoolArray<Integer> cloneArray = originalArray.clone();

        assertEquals(originalArray.size(), cloneArray.size());
        assertEquals(getCoolArraySize(originalArray), getCoolArraySize(cloneArray));
        assertEquals(getCoolArrayEnd(originalArray), getCoolArrayEnd(cloneArray));
    }

    @Test
    public void testClonedEmptyArray() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> originalArray = new CoolArray<>();
        CoolArray<Integer> cloneArray = originalArray.clone();

        assertArrayEquals(getCoolArrayArray(originalArray), getCoolArrayArray(cloneArray));
        assertTrue(compareCoolArrays(originalArray, cloneArray));
    }

    @Test
    public void testClonedNotEmptySize() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> originalArray = new CoolArray<>();
        for(int i = 0; i < 25; ++i){
            originalArray.add(i);
        }

        CoolArray<Integer> cloneArray = originalArray.clone();

        assertEquals(originalArray.size(), cloneArray.size());
        assertEquals(getCoolArraySize(originalArray), getCoolArraySize(cloneArray));
        assertEquals(getCoolArrayEnd(originalArray), getCoolArrayEnd(cloneArray));
    }

    @Test
    public void testClonedNotEmptyArray() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> originalArray = new CoolArray<>();
        for(int i = 0; i < 25; ++i){
            originalArray.add(i);
        }

        CoolArray<Integer> cloneArray = originalArray.clone();

        assertArrayEquals(getCoolArrayArray(originalArray), getCoolArrayArray(cloneArray));
        assertTrue(compareCoolArrays(originalArray, cloneArray));
    }
}
