package structures.list.array;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static structures.ArrayTestHelper.*;

public class RemoveIndexTest {
    @Test
    public void testRemoveFromEmpty() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArray = new CoolArray<>();
        CoolArray<Integer> cloneArray = coolArray.clone();
        assertFalse(coolArray.remove(5).isPresent());

        assertEquals(10 , getCoolArraySize(coolArray));
        assertEquals(-1 , getCoolArrayEnd(coolArray));
        assertTrue(compareCoolArrays(coolArray, cloneArray));
    }

    @Test
    public void testRemoveFromNonEmptyInRange() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArray = new CoolArray<>();
        for (int i = 0; i < 5; ++i) {
            coolArray.add(i);
        }

        Optional<Integer> value = coolArray.remove(1);

        assertTrue(value.isPresent());
        assertEquals(new Integer(1), value.get());

        assertEquals(10, getCoolArraySize(coolArray));
        assertEquals(3, getCoolArrayEnd(coolArray));
        assertEquals(4, coolArray.size());
        CoolArray<Integer> array =  new CoolArray<>();
        array.add(0);array.add(2);array.add(3);array.add(4);
        assertTrue(compareCoolArrays(array, coolArray));
    }

    @Test
    public void testRemoveFromNonEmptyOutOfRange(){
        CoolArray<Integer> coolArray = new CoolArray<>(10);
        Optional<Integer> value = coolArray.remove(15);

        assertFalse(value.isPresent());
    }

    @Test
    public void testRemoveNull() {
        CoolArray<Integer> coolArray = new CoolArray<>();
        coolArray.add(0,null);

        Optional<Integer> value = coolArray.remove(0);
        assertFalse(value.isPresent());
    }

}
