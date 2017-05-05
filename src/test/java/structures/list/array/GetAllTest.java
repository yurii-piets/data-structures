package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static structures.ArrayTestHelper.compareCoolArrayAndVector;
import static structures.ArrayTestHelper.createTestArray;

public class GetAllTest {
    @Test
    public void testGetAll() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray(11));
        CoolArray<Integer> getAll = coolArray.getAll(9, 11);

        assertTrue(compareCoolArrayAndVector(getAll, new Integer[]{2, 1}));
    }

    @Test
    public void testGetAllOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray(11));
        CoolArray<Integer> getAll = coolArray.getAll(22, 26);

        assertTrue(compareCoolArrayAndVector(getAll, new Integer[5]));
    }
}
