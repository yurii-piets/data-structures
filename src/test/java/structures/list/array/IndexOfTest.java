package structures.list.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static structures.ArrayTestHelper.createTestArray;

public class IndexOfTest {

    @Test
    public void testIndexOfNullOfEmptyArray(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        assertEquals(-1, coolArray.indexOf(null));
    }

    @Test
    public void testIndexOfNullOfNonEmptyArray(){
        int SIZE = 20;
        CoolArray<Integer> coolArray = new CoolArray<>((Integer []) createTestArray(SIZE));
        assertEquals(-1, coolArray.indexOf(null));
    }

    @Test
    public void testIndexOfAddedElement(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        for(int i = 0; i < 30; ++i){
            coolArray.add(i);
        }

        assertEquals(29 , coolArray.indexOf(29));
    }

    @Test
    public void testIndexOfAddedElementFalse(){
        CoolArray<Integer> coolArray = new CoolArray<>();
        for(int i = 0; i < 30; ++i){
            coolArray.add(i);
        }

        assertEquals(-1 , coolArray.indexOf(-29));
    }

}
