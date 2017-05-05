package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static structures.list.array.ArrayTestHelper.*;

public class ConstructorTest {

    @Test
    public void testZeroArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> array = new CoolArray<>();

        assertEquals(getCoolArraySize(array), 10);
        assertEquals(getCoolArrayEnd(array), -1);
        assertArrayEquals(getCoolArrayArray(array), new Object[10]);
    }

    @Test
    public void testSizeArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        int customSize = 1000;
        CoolArray<Integer> array = new CoolArray<>(customSize);

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

        CoolArray<Integer> coolArray = new CoolArray<>(testVector);

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

        CoolArray<Integer> coolArray = new CoolArray<>(testArray, left, right);

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

        CoolArray<Integer> coolArray = new CoolArray<>(testVector, left, right);

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

        CoolArray<Integer> coolArray = new CoolArray<>(testVector, left, right);

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

        CoolArray<Integer> coolArray = new CoolArray<>(array);
        CoolArray<Integer> copyArray = new CoolArray<>(coolArray);

        assertEquals(getCoolArraySize(coolArray), getCoolArraySize(copyArray));
        assertEquals(getCoolArrayEnd(coolArray), getCoolArrayEnd(copyArray));
        assertTrue(compareCoolArrays(coolArray, copyArray));
    }

}