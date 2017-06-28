package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static collections.list.array.steptest.ArrayTestHelper.createTestArray;

public class GetAllTest {
    @Test
    public void testGetAll() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(11));
        ArrayList<Integer> getAll = coolArray.getAll(9, 11);

        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(getAll, new Integer[]{2, 1}));
    }

    @Test
    public void testGetAllOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(11));
        ArrayList<Integer> getAll = coolArray.getAll(22, 26);

        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(getAll, new Integer[5]));
    }
}
