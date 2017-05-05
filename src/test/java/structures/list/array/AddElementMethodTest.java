package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.*;
import static structures.ArrayTestHelper.*;

public class AddElementMethodTest {

    @Test
    public void testAddDefaultConstructorInRanger() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArray = new CoolArray<>();

        int size = 10;
        Object[] testVector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        assertEquals(getCoolArraySize(coolArray), size);
        assertEquals(getCoolArrayEnd(coolArray), size - 1);
        assertArrayEquals(getCoolArrayArray(coolArray), testVector);
    }

    @Test
    public void testAddDefaultConstructorOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        CoolArray<Integer> coolArray = new CoolArray<>();

        int size = 25;
        int supposedSize = 40;

        Object[] testVector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        assertEquals(getCoolArraySize(coolArray), supposedSize);
        assertEquals(getCoolArrayEnd(coolArray), size - 1);
        assertTrue(compareCoolArrayAndVector(coolArray, testVector));
    }

    @Test
    public void testAddSizeCustomSizeConstructorInRange() throws NoSuchFieldException, IllegalAccessException {
        int size = 49;
        CoolArray<Integer> coolArray = new CoolArray<>(size);

        Object[] testVector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        assertEquals(getCoolArraySize(coolArray), size);
        assertEquals(getCoolArrayEnd(coolArray), size - 1);
        assertArrayEquals(getCoolArrayArray(coolArray), testVector);
    }

    @Test
    public void testAddSizeCustomConstructorOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        int size = 37;
        CoolArray<Integer> coolArray = new CoolArray<>(size);

        Object[] testVector = new Integer[size * 2];
        for (int i = 0; i < size * 2; ++i) {
            coolArray.add(i);
            testVector[i] = i;
        }

        assertEquals(getCoolArraySize(coolArray), size * 2);
        assertEquals(getCoolArrayEnd(coolArray), size * 2 - 1);
        assertArrayEquals(getCoolArrayArray(coolArray), testVector);
    }

    @Test
    public void testAddSizeCopyConstructor() throws NoSuchFieldException, IllegalAccessException {
        int size = 100;
        Integer[] vector = new Integer[size];
        for (int i = 0; i < size; ++i) {
            vector[i] = i;
        }

        CoolArray<Integer> coolArray = new CoolArray<>(vector);
        CoolArray<Integer> copyArray = new CoolArray<>(coolArray);

        for(int i=0; i < size; ++i){
            copyArray.add(size + i);
        }

        int sizeTest = size * 2;
        Integer[] testVector = new Integer[sizeTest];
        for (int i = 0; i < sizeTest; ++i) {
            testVector[i] = i;
        }

        assertTrue(compareCoolArrayAndVector(copyArray, testVector));
    }

}