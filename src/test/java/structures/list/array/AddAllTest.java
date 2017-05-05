package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static structures.ArrayTestHelper.compareCoolArrays;
import static structures.ArrayTestHelper.createTestArray;
import static structures.ArrayTestHelper.getCoolArrayArray;

public class AddAllTest {

    @Test
    public void testAddAll() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArrayPart1 = new CoolArray<>();

        coolArrayPart1.add(null);coolArrayPart1.add(1);coolArrayPart1.add(2);
        coolArrayPart1.add(null);coolArrayPart1.add(4);coolArrayPart1.add(6);

        CoolArray<Integer> coolArrayPart2 = new CoolArray<>();
        coolArrayPart2.add(7); coolArrayPart2.add(null); coolArrayPart2.add(8);

        coolArrayPart1.addAll(coolArrayPart2);

        CoolArray<Integer> coolArrayParts = new CoolArray<>();
        coolArrayParts.add(null);coolArrayParts.add(1);coolArrayParts.add(2);
        coolArrayParts.add(null);coolArrayParts.add(4);coolArrayParts.add(6);
        coolArrayParts.add(7); coolArrayParts.add(null); coolArrayParts.add(8);

        assertArrayEquals(getCoolArrayArray(coolArrayParts), getCoolArrayArray(coolArrayPart1));
    }

    @Test
    public void testAddAllToEmpty() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArrayPart1 = new CoolArray<>();
        CoolArray<Integer> coolArrayPart2 = new CoolArray<>();
        coolArrayPart2.add(1);coolArrayPart2.add(2);coolArrayPart2.add(null);
        coolArrayPart2.add(4);coolArrayPart2.add(5);coolArrayPart2.add(null);
        coolArrayPart1.addAll(coolArrayPart2);

        CoolArray<Integer> coolArrayParts = new CoolArray<>();
        coolArrayParts.add(1);coolArrayParts.add(2);coolArrayParts.add(null);
        coolArrayParts.add(4);coolArrayParts.add(5);coolArrayParts.add(null);

        assertTrue(compareCoolArrays(coolArrayPart1, coolArrayParts));

    }

    @Test
    public void testAddAllEmpty() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArrayPart1 = new CoolArray<>();
        coolArrayPart1.add(1);coolArrayPart1.add(2);coolArrayPart1.add(null);
        coolArrayPart1.add(4);coolArrayPart1.add(5);coolArrayPart1.add(null);

        CoolArray<Integer> coolArrayPart2 = new CoolArray<>();
        coolArrayPart1.addAll(coolArrayPart2);

        CoolArray<Integer> coolArrayParts = new CoolArray<>();
        coolArrayParts.add(1);coolArrayParts.add(2);coolArrayParts.add(null);
        coolArrayParts.add(4);coolArrayParts.add(5);coolArrayParts.add(null);

        assertTrue(compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

    @Test
    public void testAddAllEmptyToEmpty() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArrayPart1 = new CoolArray<>();
        CoolArray<Integer> coolArrayPart2 = new CoolArray<>();
        CoolArray<Integer> coolArrayParts = new CoolArray<>();

        coolArrayPart1.addAll(coolArrayPart2);

        assertTrue(compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

    @Test
    public void testAddAllNull() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArrayPart1 = new CoolArray<>();
        CoolArray<Integer> coolArrayParts = new CoolArray<>();

        coolArrayPart1.addAll(null);

        assertTrue(compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

    @Test
    public void testAddAllFilled() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArrayPart1 = new CoolArray<>((Integer[]) createTestArray(5));
        CoolArray<Integer> coolArrayPart2 = new CoolArray<>((Integer[]) createTestArray(5));
        CoolArray<Integer> coolArrayParts = new CoolArray<>();
        coolArrayParts.add(5);coolArrayParts.add(4);coolArrayParts.add(3);coolArrayParts.add(2);coolArrayParts.add(1);
        coolArrayParts.add(5);coolArrayParts.add(4);coolArrayParts.add(3);coolArrayParts.add(2);coolArrayParts.add(1);
        coolArrayPart1.addAll(coolArrayPart2);

        assertTrue(compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

}
