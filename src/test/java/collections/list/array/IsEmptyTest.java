package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static collections.list.array.ArrayTestHelper.createTestArray;

public class IsEmptyTest {
    @Test
    public void testNewIsEmpty(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertTrue(coolArray.isEmpty());
    }

    @Test
    public void testFalseConstructed(){
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray());
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
        ArrayList<Integer> coolArray = new ArrayList<>((Integer[]) createTestArray());
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
