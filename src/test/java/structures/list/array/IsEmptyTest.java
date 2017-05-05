package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static structures.ArrayTestHelper.createTestArray;

public class IsEmptyTest {
    @Test
    public void testNewIsEmpty(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        assertTrue(coolArray.isEmpty());
    }

    @Test
    public void testFalseConstructed(){
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray());
        assertFalse(coolArray.isEmpty());
    }

    @Test
    public void testFalseEmptyAdd(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        for(int i=0; i < 100; ++i){
            coolArray.add(i);
        }
        assertFalse(coolArray.isEmpty());
    }

    @Test
    public void testIsEmptyConstructor(){
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray());
        coolArray.clear();
        assertTrue(coolArray.isEmpty());
    }

    @Test
    public void testIsEmptyAdd(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        for(int i=0; i < 100; ++i){
            coolArray.add(i);
        }

        coolArray.clear();
        assertTrue(coolArray.isEmpty());
    }
}
