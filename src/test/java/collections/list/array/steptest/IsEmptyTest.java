package collections.list.array.steptest;

import collections.list.array.ArrayList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static collections.list.array.steptest.ArrayTestHelper.createTestArray;

public class IsEmptyTest {
    @Test
    public void testNewIsEmpty(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertTrue(coolArray.isEmpty());
    }

    @Test
    public void testFalseConstructed(){
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray());
        assertFalse(coolArray.isEmpty());
    }

    @Test
    public void testFalseEmptyAdd(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i=0; i < 100; ++i){
            coolArray.add(i);
        }
        assertFalse(coolArray.isEmpty());
    }

    @Test
    public void testIsEmptyConstructor(){
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) ArrayTestHelper.createTestArray());
        coolArray.clear();
        assertTrue(coolArray.isEmpty());
    }

    @Test
    public void testIsEmptyAdd(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i=0; i < 100; ++i){
            coolArray.add(i);
        }

        coolArray.clear();
        assertTrue(coolArray.isEmpty());
    }
}
