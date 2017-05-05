package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static structures.ArrayTestHelper.createTestArray;

public class SizeTest {
    @Test
    public void testEmptySize(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        assertEquals(coolArray.size(), 0);
    }

    @Test
    public void testSizeConstructor(){
        int SIZE = 25;
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[])createTestArray(SIZE));
        assertEquals(coolArray.size(), SIZE);
    }

    @Test
    public void testSizeAddedElement(){
        int SIZE = 25;
        CoolArray<Integer> coolArray = new CoolArray<>();

        for(int i =0; i < SIZE; ++i){
            coolArray.add(i);
        }

        assertEquals(coolArray.size(), SIZE);
    }

    @Test
    public void testSizeClearedElement(){
        CoolArray<Integer> coolArray = new CoolArray<>((Integer[]) createTestArray());
        coolArray.clear();
        assertEquals(coolArray.size(), 0);
    }
}
