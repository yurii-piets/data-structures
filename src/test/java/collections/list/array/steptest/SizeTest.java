package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static collections.list.array.steptest.ArrayTestHelper.createTestArray;

public class SizeTest {
    @Test
    public void testEmptySize(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertEquals(coolArray.size(), 0);
    }

    @Test
    public void testSizeConstructor(){
        int SIZE = 25;
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray(SIZE));
        assertEquals(coolArray.size(), SIZE);
    }

    @Test
    public void testSizeAddedElement(){
        int SIZE = 25;
        ArrayList<Integer> coolArray = new ArrayList<>();

        for(int i =0; i < SIZE; ++i){
            coolArray.add(i);
        }

        assertEquals(coolArray.size(), SIZE);
    }

    @Test
    public void testSizeClearedElement(){
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray());
        coolArray.clear();
        assertEquals(coolArray.size(), 0);
    }

    @Test
    public void testSizeFor() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray());
        Object []vector = ArrayTestHelper.getCoolArrayArray(coolArray);

        for(int i = 0 ; i < coolArray.size(); ++i){
            assertEquals(vector[i], coolArray.size() - i);
        }
    }
}
