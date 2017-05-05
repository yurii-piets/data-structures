package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static structures.ArrayTestHelper.compareCoolArrays;

public class ReplaceAllElementsTest {
    @Test
    public void testReplaceElement() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = 10;
        Integer newElement = -10;
        CoolArray<Integer> defaultArray = new CoolArray<>(new Integer[]{10, 1, 10, 3, 4, 10});
        CoolArray<Integer> coolArray = defaultArray.clone();
        coolArray.replaceAll(oldElement, newElement);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new CoolArray<>(new Integer[]{-10, 1, -10, 3, 4, -10}), coolArray));
    }

    @Test
    public void testReplaceElementWithNull() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = 10;
        Integer newElement = null;
        CoolArray<Integer> defaultArray = new CoolArray<>(new Integer[]{10, 10, 10, 10, 4, 5});
        CoolArray<Integer> coolArray = defaultArray.clone();
        coolArray.replaceAll(oldElement, newElement);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new CoolArray<>(new Integer[]{null, null, null, null, 4, 5}), coolArray));
    }

    @Test
    public void testReplaceNull() throws NoSuchFieldException, IllegalAccessException {
        Integer oldElement = null;
        Integer newElement = -1;
        CoolArray<Integer> defaultArray = new CoolArray<>(new Integer[]{0, null, 2, null, 4, null});
        CoolArray<Integer> coolArray = defaultArray.clone();
        coolArray.replaceAll(oldElement, newElement);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new CoolArray<>(new Integer[]{0, -1, 2, -1, 4, -1}), coolArray));
    }
}
