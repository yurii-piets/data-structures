package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static collections.list.array.steptest.ArrayTestHelper.createTestArray;

public class AddAllTest {

    @Test
    public void testAddAll() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArrayPart1 = new ArrayList<>();

        coolArrayPart1.add(null);coolArrayPart1.add(1);coolArrayPart1.add(2);
        coolArrayPart1.add(null);coolArrayPart1.add(4);coolArrayPart1.add(6);

        ArrayList<Integer> coolArrayPart2 = new ArrayList<>();
        coolArrayPart2.add(7); coolArrayPart2.add(null); coolArrayPart2.add(8);

        coolArrayPart1.addAll(coolArrayPart2);

        ArrayList<Integer> coolArrayParts = new ArrayList<>();
        coolArrayParts.add(null);coolArrayParts.add(1);coolArrayParts.add(2);
        coolArrayParts.add(null);coolArrayParts.add(4);coolArrayParts.add(6);
        coolArrayParts.add(7); coolArrayParts.add(null); coolArrayParts.add(8);

        Assert.assertArrayEquals(ArrayTestHelper.getCoolArrayArray(coolArrayParts), ArrayTestHelper.getCoolArrayArray(coolArrayPart1));
    }

    @Test
    public void testAddAllToEmpty() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArrayPart1 = new ArrayList<>();
        ArrayList<Integer> coolArrayPart2 = new ArrayList<>();
        coolArrayPart2.add(1);coolArrayPart2.add(2);coolArrayPart2.add(null);
        coolArrayPart2.add(4);coolArrayPart2.add(5);coolArrayPart2.add(null);
        coolArrayPart1.addAll(coolArrayPart2);

        ArrayList<Integer> coolArrayParts = new ArrayList<>();
        coolArrayParts.add(1);coolArrayParts.add(2);coolArrayParts.add(null);
        coolArrayParts.add(4);coolArrayParts.add(5);coolArrayParts.add(null);

        assertTrue(ArrayTestHelper.compareCoolArrays(coolArrayPart1, coolArrayParts));

    }

    @Test
    public void testAddAllEmpty() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArrayPart1 = new ArrayList<>();
        coolArrayPart1.add(1);coolArrayPart1.add(2);coolArrayPart1.add(null);
        coolArrayPart1.add(4);coolArrayPart1.add(5);coolArrayPart1.add(null);

        ArrayList<Integer> coolArrayPart2 = new ArrayList<>();
        coolArrayPart1.addAll(coolArrayPart2);

        ArrayList<Integer> coolArrayParts = new ArrayList<>();
        coolArrayParts.add(1);coolArrayParts.add(2);coolArrayParts.add(null);
        coolArrayParts.add(4);coolArrayParts.add(5);coolArrayParts.add(null);

        assertTrue(ArrayTestHelper.compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

    @Test
    public void testAddAllEmptyToEmpty() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArrayPart1 = new ArrayList<>();
        ArrayList<Integer> coolArrayPart2 = new ArrayList<>();
        ArrayList<Integer> coolArrayParts = new ArrayList<>();

        coolArrayPart1.addAll(coolArrayPart2);

        assertTrue(ArrayTestHelper.compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

    @Test
    public void testAddAllNull() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArrayPart1 = new ArrayList<>();
        ArrayList<Integer> coolArrayParts = new ArrayList<>();

        coolArrayPart1.addAll(null);

        assertTrue(ArrayTestHelper.compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

    @Test
    public void testAddAllFilled() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArrayPart1 = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(5));
        ArrayList<Integer> coolArrayPart2 = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(5));
        ArrayList<Integer> coolArrayParts = new ArrayList<>();
        coolArrayParts.add(5);coolArrayParts.add(4);coolArrayParts.add(3);coolArrayParts.add(2);coolArrayParts.add(1);
        coolArrayParts.add(5);coolArrayParts.add(4);coolArrayParts.add(3);coolArrayParts.add(2);coolArrayParts.add(1);
        coolArrayPart1.addAll(coolArrayPart2);

        assertTrue(ArrayTestHelper.compareCoolArrays(coolArrayPart1, coolArrayParts));
    }

}
