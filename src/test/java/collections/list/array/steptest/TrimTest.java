package collections.list.array.steptest;

import collections.list.List;
import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrimTest {

    @Test
    public void testTrimEmptyToSmaller() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 4;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.trimToSize(TRIMMED_SIZE);

        Assert.assertEquals(10, ArrayTestHelper.getCoolArraySize(coolArray));
        Assert.assertEquals(-1, ArrayTestHelper.getCoolArrayEnd(coolArray));
        Assert.assertArrayEquals(new Object[10], ArrayTestHelper.getCoolArrayArray(coolArray));
    }

    @Test
    public void testTrimEmptyToLarger() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 14;
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.trimToSize(TRIMMED_SIZE);

        Assert.assertEquals(10, ArrayTestHelper.getCoolArraySize(coolArray));
        Assert.assertEquals(-1, ArrayTestHelper.getCoolArrayEnd(coolArray));
        Assert.assertArrayEquals(new Object[10], ArrayTestHelper.getCoolArrayArray(coolArray));
    }

    @Test
    public void testTrimNonEmptyToSmaller() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 14;
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0; i < 25; ++i){
            coolArray.add(i);
        }

        coolArray.trimToSize(TRIMMED_SIZE);

        Assert.assertEquals(TRIMMED_SIZE, ArrayTestHelper.getCoolArraySize(coolArray));
        Assert.assertEquals(TRIMMED_SIZE - 1, ArrayTestHelper.getCoolArrayEnd(coolArray));
    }

    @Test
    public void testTrimNonEmptyToLarger() throws NoSuchFieldException, IllegalAccessException {
        final int TRIMMED_SIZE = 34;
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0; i < 25; ++i){
            coolArray.add(i);
        }
        List<Integer> cloneArray = coolArray.clone();
        coolArray.trimToSize(TRIMMED_SIZE);

        Assert.assertEquals(40, ArrayTestHelper.getCoolArraySize(coolArray));
        Assert.assertEquals(24, ArrayTestHelper.getCoolArrayEnd(coolArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(coolArray, cloneArray));
    }
}
