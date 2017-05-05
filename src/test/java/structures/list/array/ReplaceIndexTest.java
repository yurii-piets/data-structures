package structures.list.array;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static structures.ArrayTestHelper.compareCoolArrays;

public class ReplaceIndexTest {
    @Test
    public void testReplaceIndex() throws NoSuchFieldException, IllegalAccessException {
        int index = 2;
        Integer element = -2;
        CoolArray<Integer> defaultArray = new CoolArray<>(new Integer[]{0, 1, 2, 3, 4, 5});
        CoolArray<Integer> coolArray = defaultArray.clone();
        coolArray.replace(index, element);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new CoolArray<>(new Integer[]{0, 1, -2, 3, 4, 5}), coolArray));
    }

    @Test
    public void testReplaceIndexNull() throws NoSuchFieldException, IllegalAccessException {
        int index = 2;
        Integer element = null;
        CoolArray<Integer> defaultArray = new CoolArray<>(new Integer[]{0, 1, 2, 3, 4, 5});
        CoolArray<Integer> coolArray = defaultArray.clone();
        coolArray.replace(index, element);

        assertFalse(compareCoolArrays(defaultArray, coolArray));
        assertTrue(compareCoolArrays(new CoolArray<>(new Integer[]{0, 1, null, 3, 4, 5}), coolArray));
    }

    @Test
    public void testReturnValueInRange() {
        int index = 2;
        Integer element = -2;
        CoolArray<Integer> defaultArray = new CoolArray<>(new Integer[]{0, 1, 2, 3, 4, 5});
        CoolArray<Integer> coolArray = defaultArray.clone();
        Optional<Integer> value = coolArray.replace(index, element);

        assertTrue(value.isPresent());
        assertEquals((Integer) 2, value.get());
    }

    @Test
    public void testReturnValueOutOfRange() {
        int index = 10;
        Integer element = -2;
        CoolArray<Integer> defaultArray = new CoolArray<>(new Integer[]{0, 1, 2, 3, 4, 5});
        CoolArray<Integer> coolArray = defaultArray.clone();
        Optional<Integer> value = coolArray.replace(index, element);

        assertFalse(value.isPresent());
    }
}
