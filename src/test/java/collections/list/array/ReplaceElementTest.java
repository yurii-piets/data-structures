package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static collections.list.array.ArrayTestHelper.compareCoolArrays;

public class ReplaceElementTest {

    @Test
    public void testReplaceElement() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = 10;
        Integer newElement = -10;
        ArrayList<Integer> defaultArray = new ArrayList<>(new Integer[]{10, 1, 2, 3, 4, 5});
        ArrayList<Integer> coolArray = defaultArray.clone();
        coolArray.replace(oldElement, newElement);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new ArrayList<>(new Integer[]{-10, 1, 2, 3, 4, 5}), coolArray));
    }

    @Test
    public void testReplaceElementWithNull() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = 10;
        Integer newElement = null;
        ArrayList<Integer> defaultArray = new ArrayList<>(new Integer[]{10, 1, 2, 3, 4, 5});
        ArrayList<Integer> coolArray = defaultArray.clone();
        coolArray.replace(oldElement, newElement);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new ArrayList<>(new Integer[]{null, 1, 2, 3, 4, 5}), coolArray));
    }

    @Test
    public void testReplaceNull() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = null;
        Integer newElement = -1;
        ArrayList<Integer> defaultArray = new ArrayList<>(new Integer[]{0, 1, 2, null, 4, 5});
        ArrayList<Integer> coolArray = defaultArray.clone();
        coolArray.replace(oldElement, newElement);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new ArrayList<>(new Integer[]{0, 1, 2, -1, 4, 5}), coolArray));
    }

}
