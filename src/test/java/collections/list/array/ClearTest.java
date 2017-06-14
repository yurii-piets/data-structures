package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static collections.list.array.ArrayTestHelper.getCoolArrayArray;
import static collections.list.array.ArrayTestHelper.getCoolArrayEnd;
import static collections.list.array.ArrayTestHelper.getCoolArraySize;

public class ClearTest {
    @Test
    public void testClearEmpty() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.clear();

        assertEquals(getCoolArraySize(coolArray), 10);
        assertEquals(getCoolArrayEnd(coolArray), -1);
        assertArrayEquals(getCoolArrayArray(coolArray), new Object[10]);
    }

    @Test
    public void testClearCustomCapacity() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>(55);
        coolArray.clear();

        assertEquals(getCoolArraySize(coolArray), 10);
        assertEquals(getCoolArrayEnd(coolArray), -1);
        assertArrayEquals(getCoolArrayArray(coolArray), new Object[10]);
    }

    @Test
    public void testClearCustomValues() throws NoSuchFieldException, IllegalAccessException {
        Integer testVector[] = new Integer[25];
        for (int i = 0; i < testVector.length; ++i) {
            testVector[i] = testVector.length - i;
        }

        ArrayList<Integer> coolArray = new ArrayList<>(testVector);
        coolArray.clear();

        assertEquals(getCoolArraySize(coolArray), 10);
        assertEquals(getCoolArrayEnd(coolArray), -1);
        assertArrayEquals(getCoolArrayArray(coolArray), new Object[10]);
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

        assertEquals(getCoolArraySize(copyArray), 10);
        assertEquals(getCoolArrayEnd(copyArray), -1);
        assertArrayEquals(getCoolArrayArray(copyArray), new Object[10]);
    }
}
