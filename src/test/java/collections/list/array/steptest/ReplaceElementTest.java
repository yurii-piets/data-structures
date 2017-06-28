package collections.list.array.steptest;

import collections.list.List;
import collections.list.array.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ReplaceElementTest {

    @Test
    public void testReplaceElement() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = 10;
        Integer newElement = -10;
        ArrayList<Integer> defaultArray = new ArrayList<>(new Integer[]{10, 1, 2, 3, 4, 5});
        List<Integer> coolArray = defaultArray.clone();
        coolArray.replace(oldElement, newElement);

        assertFalse(ArrayTestHelper.compareCoolArrays(defaultArray, coolArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(new ArrayList<>(new Integer[]{-10, 1, 2, 3, 4, 5}), coolArray));
    }

    @Test
    public void testReplaceElementWithNull() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = 10;
        Integer newElement = null;
        ArrayList<Integer> defaultArray = new ArrayList<>(new Integer[]{10, 1, 2, 3, 4, 5});
        List<Integer> coolArray = defaultArray.clone();
        coolArray.replace(oldElement, newElement);

        assertFalse(ArrayTestHelper.compareCoolArrays(defaultArray, coolArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(new ArrayList<>(new Integer[]{null, 1, 2, 3, 4, 5}), coolArray));
    }

    @Test
    public void testReplaceNull() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = null;
        Integer newElement = -1;
        ArrayList<Integer> defaultArray = new ArrayList<>(new Integer[]{0, 1, 2, null, 4, 5});
        List<Integer> coolArray = defaultArray.clone();
        coolArray.replace(oldElement, newElement);

        assertFalse(ArrayTestHelper.compareCoolArrays(defaultArray, coolArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(new ArrayList<>(new Integer[]{0, 1, 2, -1, 4, 5}), coolArray));
    }

}
