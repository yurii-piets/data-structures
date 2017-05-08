package collections.list.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static collections.list.array.ArrayTestHelper.createTestArray;

public class IndexOfTest {

    @Test
    public void testIndexOfNullOfEmptyArray(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        assertEquals(-1, coolArray.indexOf(null));
    }

    @Test
    public void testIndexOfNullOfNonEmptyArray(){
        int SIZE = 20;
        ArrayList<Integer> coolArray = new ArrayList<>((Integer []) createTestArray(SIZE));
        assertEquals(-1, coolArray.indexOf(null));
    }

    @Test
    public void testIndexOfAddedElement(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0; i < 30; ++i){
            coolArray.add(i);
        }

        assertEquals(29 , coolArray.indexOf(29));
    }

    @Test
    public void testIndexOfAddedElementFalse(){
        ArrayList<Integer> coolArray = new ArrayList<>();
        for(int i = 0; i < 30; ++i){
            coolArray.add(i);
        }

        assertEquals(-1 , coolArray.indexOf(-29));
    }

}
