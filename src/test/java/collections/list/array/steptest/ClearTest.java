package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ClearTest {
    @Test
    public void testClearEmpty() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.clear();

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), 10);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), -1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(coolArray), new Object[10]);
    }

    @Test
    public void testClearCustomCapacity() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>(55);
        coolArray.clear();

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), 10);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), -1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(coolArray), new Object[10]);
    }

    @Test
    public void testClearCustomValues() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(testVector);
        coolArray.clear();

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(coolArray), 10);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(coolArray), -1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(coolArray), new Object[10]);
    }

    @Test
    public void testClearCopyValues() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(testVector);
        ArrayList<Integer> copyArray = new ArrayList<>(coolArray);

        copyArray.clear();

        Assert.assertEquals(ArrayTestHelper.getCoolArraySize(copyArray), 10);
        Assert.assertEquals(ArrayTestHelper.getCoolArrayEnd(copyArray), -1);
        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(copyArray), new Object[10]);
    }
}
