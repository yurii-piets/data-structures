package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static collections.list.array.ArrayTestHelper.*;

public class TrimTest {

    @Test
    public void testTrimEmptyToSmaller() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 4;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.trimToSize(TRIMMED_SIZE);

        assertEquals(10, getCoolArraySize(coolArray));
        assertEquals(-1, getCoolArrayEnd(coolArray));
        assertArrayEquals(new Object[10], getCoolArrayArray(coolArray));
    }

    @Test
    public void testTrimEmptyToLarger() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 14;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.trimToSize(TRIMMED_SIZE);

        assertEquals(10, getCoolArraySize(coolArray));
        assertEquals(-1, getCoolArrayEnd(coolArray));
        assertArrayEquals(new Object[10], getCoolArrayArray(coolArray));
    }

    @Test
    public void testTrimNonEmptyToSmaller() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 14;
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0; i < 25; ++i){
            coolArray.add(i);
        }

        coolArray.trimToSize(TRIMMED_SIZE);

        assertEquals(TRIMMED_SIZE, getCoolArraySize(coolArray));
        assertEquals(TRIMMED_SIZE - 1, getCoolArrayEnd(coolArray));
    }

    @Test
    public void testTrimNonEmptyToLarger() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 34;
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0; i < 25; ++i){
            coolArray.add(i);
        }
        ArrayList<Integer> cloneArray = coolArray.clone();
        coolArray.trimToSize(TRIMMED_SIZE);

        assertEquals(40, getCoolArraySize(coolArray));
        assertEquals(24, getCoolArrayEnd(coolArray));
        assertTrue(compareCoolArrays(coolArray, cloneArray));
    }
}