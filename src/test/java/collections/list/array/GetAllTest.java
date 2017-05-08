package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static collections.list.array.ArrayTestHelper.compareCoolArrayAndVector;
import static collections.list.array.ArrayTestHelper.createTestArray;

public class GetAllTest {
    @Test
    public void testGetAll() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray(11));
        ArrayList<Integer> getAll = coolArray.getAll(9, 11);

        assertTrue(compareCoolArrayAndVector(getAll, new Integer[]{2, 1}));
    }

    @Test
    public void testGetAllOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray(11));
        ArrayList<Integer> getAll = coolArray.getAll(22, 26);

        assertTrue(compareCoolArrayAndVector(getAll, new Integer[5]));
    }
}
