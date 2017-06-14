package collections.list.array;

import collections.list.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RemoveAllTest {

    @Test
    public void removeAll(){
        ArrayList<Double> list = new ArrayList<>();
        list.add(1.1);
        list.add(1.2);
        list.add(1.2);
        list.add(1.3);
        list.add(1.2);
        list.add(1.2);
        list.add(null);
        list.add(null);

        list.removeAll(1.1);
        list.removeAll(1.2);
        list.removeAll(null);

        assertEquals(1, list.size());
        assertTrue(list.get(0).isPresent());
        assertEquals((Double) 1.3, list.get(0).get());

    }
}
