package collections.list.array.steptest;

import collections.list.List;
import collections.list.array.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class RemoveIndexTest {
    @Test
    public void testRemoveFromEmpty() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();
        List<Integer> cloneArray = coolArray.clone();
        assertFalse(coolArray.remove(5).isPresent());

        Assert.assertEquals(10 , ArrayTestHelper.getCoolArraySize(coolArray));
        Assert.assertEquals(-1 , ArrayTestHelper.getCoolArrayEnd(coolArray));
        assertTrue(ArrayTestHelper.compareCoolArrays(coolArray, cloneArray));
    }

    @Test
    public void testRemoveFromNonEmptyInRange() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>();
        for (int i = 0; i < 5; ++i) {
            coolArray.add(i);
        }

        Optional<Integer> value = coolArray.remove(1);

        assertTrue(value.isPresent());
        assertEquals(new Integer(1), value.get());

        Assert.assertEquals(10, ArrayTestHelper.getCoolArraySize(coolArray));
        Assert.assertEquals(3, ArrayTestHelper.getCoolArrayEnd(coolArray));
        assertEquals(4, coolArray.size());
        ArrayList<Integer> array =  new ArrayList<>();
        array.add(0);array.add(2);array.add(3);array.add(4);
        assertTrue(ArrayTestHelper.compareCoolArrays(array, coolArray));
    }

    @Test
    public void testRemoveFromNonEmptyOutOfRange(){
        ArrayList<Integer> coolArray = new ArrayList<>(10);
        Optional<Integer> value = coolArray.remove(15);

        assertFalse(value.isPresent());
    }

    @Test
    public void testRemoveNull() {
        ArrayList<Integer> coolArray = new ArrayList<>();
        coolArray.add(0,null);

        Optional<Integer> value = coolArray.remove(0);
        assertFalse(value.isPresent());
    }

}
