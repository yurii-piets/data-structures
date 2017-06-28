package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConstructorTest {

    @Test
    public void testZeroArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>();

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(array), 10);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(array), -1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(array), new Object[10]);
    }

    @Test
    public void testSizeArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        int customSize = 1000;
        ArrayList<Integer> array = new ArrayList<>(customSize);

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(array), customSize);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(array), -1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(array), new Object[customSize]);
    }

    @Test
    public void testArrayArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(testVector);

        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(coolArray, testVector));
        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), testVector.length * 2);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), testVector.length - 1);
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
        Object mainArray[] = ArrayTestHelper.getCoolArrayArray(coolArray);
        for (int i = left, j = 0; i < right && j < mainArray.length; ++i, ++j) {
            if (testArray[i] != mainArray[j]) {
                arraysEqual = false;
                break;
            }
        }

        assertTrue(arraysEqual);
        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), testArray.length * 2);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), right);
    }

    @Test
    public void testArrayLeftGreaterRightArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        int left = 20, right = 10;

        ArrayList<Integer> coolArray = new ArrayList<>(testVector, left, right);

        assertFalse(ArrayTestHelper.compareCoolArrayAndVector(coolArray, testVector));
        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), testVector.length * 2);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), right);
    }

    @Test
    public void testArrayLeftMinusRightGreaterArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        int left = -10, right = 30;

        ArrayList<Integer> coolArray = new ArrayList<>(testVector, left, right);

        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(coolArray, testVector));
        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), testVector.length * 2);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), right);
    }

    @Test
    public void testCopyConstructor() throws NoSuchFieldException, IllegalAccessException {
        Integer[] array = new Integer[15];
        for (int i = 0; i < array.length; ++i) {
            array[i] = array.length - i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(array);
        ArrayList<Integer> copyArray = new ArrayList<>(coolArray);

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), ArrayTestHelper.getCoolArraySize(copyArray));
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), ArrayTestHelper.getCoolArrayEnd(copyArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(coolArray, copyArray));
    }

}