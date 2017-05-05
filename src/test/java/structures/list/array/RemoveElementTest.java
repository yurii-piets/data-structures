package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static structures.ArrayTestHelper.compareCoolArrayAndVector;
import static structures.ArrayTestHelper.compareCoolArrays;

public class RemoveElementTest {

    @Test
    public void testRemoveElement() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArray = new CoolArray<>();
        coolArray.add(0);coolArray.add(1);coolArray.add(2);
        coolArray.add(3);coolArray.add(4);coolArray.add(5);
        coolArray.remove(new Integer(2));

        assertTrue(compareCoolArrayAndVector(coolArray, new Integer[]{0,1,3,4,5}));
    }

    @Test
    public void testRemoveNotExistingElement() throws NoSuchFieldException, IllegalAccessException {
        Integer[] defaultVector = new Integer[]{0,1,2,3,4,5};
        CoolArray<Integer> coolArray = new CoolArray<>(defaultVector);
        coolArray.remove(new Integer(-7));

        assertTrue(compareCoolArrayAndVector(coolArray, defaultVector));
    }

    @Test
    public void testRemoveNull() throws NoSuchFieldException, IllegalAccessException {
        Integer[] defaultVector = new Integer[]{0,1,2,3,4,5};
        CoolArray<Integer> defaultCoolArray = new CoolArray<>(defaultVector);
        CoolArray<Integer> coolArray = new CoolArray<>(defaultVector);
        coolArray.remove(null);
        assertTrue(compareCoolArrays(coolArray, defaultCoolArray));

        coolArray.add(null);
        assertFalse(compareCoolArrays(coolArray, defaultCoolArray));

        coolArray.remove(null);
        assertTrue(compareCoolArrays(coolArray, defaultCoolArray));
    }

}
