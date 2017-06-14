package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static collections.list.array.ArrayTestHelper.*;

public class ConstructorTest {

    @Test
    public void testZeroArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>();

        assertEquals(getCoolArraySize(array), 10);
        assertEquals(getCoolArrayEnd(array), -1);
        assertArrayEquals(getCoolArrayArray(array), new Object[10]);
    }

    @Test
    public void testSizeArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        int customSize = 1000;
        ArrayList<Integer> array = new ArrayList<>(customSize);

        assertEquals(getCoolArraySize(array), customSize);
        assertEquals(getCoolArrayEnd(array), -1);
        assertArrayEquals(getCoolArrayArray(array), new Object[customSize]);
    }

    @Test
    public void testArrayArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(testVector);

        assertTrue(compareCoolArrayAndVector(coolArray, testVector));
        assertEquals(getCoolArraySize(coolArray), testVector.length * 2);
        assertEquals(getCoolArrayEnd(coolArray), testVector.length - 1);
    }

    @Test
    public void testArrayLeftRightArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer testArray[] = new Integer[25];
        for (int i = 0; i < testArray.length; ++i) {
            testArray[i] = testArray.length - i;
        }

        int left = 10, right = 20;

        ArrayList<Integer> coolArray = new ArrayList<>(testArray, left, right);

        boolean arraysEqual = true;
        Object mainArray[] = getCoolArrayArray(coolArray);
        for (int i = left, j = 0; i < right && j < mainArray.length; ++i, ++j) {
            if (testArray[i] != mainArray[j]) {
                arraysEqual = false;
                break;
            }
        }

        assertTrue(arraysEqual);
        assertEquals(getCoolArraySize(coolArray), testArray.length * 2);
        assertEquals(getCoolArrayEnd(coolArray), right);
    }

    @Test
    public void testArrayLeftGreaterRightArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        int left = 20, right = 10;

        ArrayList<Integer> coolArray = new ArrayList<>(testVector, left, right);

        assertFalse(compareCoolArrayAndVector(coolArray, testVector));
        assertEquals(getCoolArraySize(coolArray), testVector.length * 2);
        assertEquals(getCoolArrayEnd(coolArray), right);
    }

    @Test
    public void testArrayLeftMinusRightGreaterArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        int left = -10, right = 30;

        ArrayList<Integer> coolArray = new ArrayList<>(testVector, left, right);

        assertTrue(compareCoolArrayAndVector(coolArray, testVector));
        assertEquals(getCoolArraySize(coolArray), testVector.length * 2);
        assertEquals(getCoolArrayEnd(coolArray), right);
    }

    @Test
    public void testCopyConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer[] array = new Integer[15];
        for (int i = 0; i < array.length; ++i) {
            array[i] = array.length - i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(array);
        ArrayList<Integer> copyArray = new ArrayList<>(coolArray);

        assertEquals(getCoolArraySize(coolArray), getCoolArraySize(copyArray));
        assertEquals(getCoolArrayEnd(coolArray), getCoolArrayEnd(copyArray));
        assertTrue(compareCoolArrays(coolArray, copyArray));
    }

}