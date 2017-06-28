package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RemoveElementTest {

    @Test
    public void testRemoveElement() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(0);coolArray.add(1);coolArray.add(2);
        coolArray.add(3);coolArray.add(4);coolArray.add(5);
        coolArray.remove(new Integer(2));

        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(coolArray, new Integer[]{0,1,3,4,5}));
    }

    @Test
    public void testRemoveNotExistingElement() throws NoSuchFieldException, IllegalAccessException {
        Integer[] defaultVector = new Integer[]{0,1,2,3,4,5};
        ArrayList<Integer> coolArray = new ArrayList<>(defaultVector);
        coolArray.remove(new Integer(-7));

        assertTrue(ArrayTestHelper.compareCoolArrayAndVector(coolArray, defaultVector));
    }

    @Test
    public void testRemoveNull() throws NoSuchFieldException, IllegalAccessException {
        Integer[] defaultVector = new Integer[]{0,1,2,3,4,5};
        ArrayList<Integer> defaultCoolArray = new ArrayList<>(defaultVector);
        ArrayList<Integer> coolArray = new ArrayList<>(defaultVector);
        coolArray.remove(null);
        assertTrue(ArrayTestHelper.compareCoolArrays(coolArray, defaultCoolArray));

        coolArray.add(null);
        assertFalse(ArrayTestHelper.compareCoolArrays(coolArray, defaultCoolArray));

        coolArray.remove(null);
        assertTrue(ArrayTestHelper.compareCoolArrays(coolArray, defaultCoolArray));
    }

}
