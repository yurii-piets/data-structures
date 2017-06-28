package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddElementMethodTest {

    @Test
    public void testAddDefaultConstructorInRanger() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();

        int size = 10;
        Object[] testVector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), size);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), size - 1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(coolArray), testVector);
    }

    @Test
    public void testAddDefaultConstructorOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();

        int size = 25;
        int supposedSize = 40;

        Object[] testVector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), supposedSize);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), size - 1);
        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(coolArray, testVector));
    }

    @Test
    public void testAddSizeCustomSizeConstructorInRange() throws NoSuchFieldException, IllegalAccessException {
        int size = 49;
        ArrayList<Integer> coolArray = new ArrayList<>(size);

        Object[] testVector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), size);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), size - 1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(coolArray), testVector);
    }

    @Test
    public void testAddSizeCustomConstructorOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        int size = 37;
        ArrayList<Integer> coolArray = new ArrayList<>(size);

        Object[] testVector = new Integer[size * 2];
        for (int i = 0; i < size * 2; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), size * 2);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), size * 2 - 1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(coolArray), testVector);
    }

    @Test
    public void testAddSizeCopyConstructor() throws NoSuchFieldException, IllegalAccessException {
        int size = 100;
        Integer[] vector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            vector[i] = i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(vector);
        ArrayList<Integer> copyArray = new ArrayList<>(coolArray);

        for(int i=0; i < size; ++i){
            copyArray.add(size + i);
        }

        int sizeTest = size * 2;
        Integer[] testVector = new Integer[sizeTest];
        for (int i = 0; i < sizeTest; ++i) {
            testVector[i] = i;
        }

        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(copyArray, testVector));
    }

}
