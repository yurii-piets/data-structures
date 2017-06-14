package collections.stack;

import collections.LinkedNode;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void testZeroArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Stack<Double> stack = new LinkedStack<>();

        Field headField = stack.getClass().getDeclaredField("head");
        headField.setAccessible(true);
        LinkedNode<?> head = (LinkedNode<?>) headField.get(stack);

        assertNull(head);
    }

    @Test
    public void testPushPop(){
        Stack<Double> stack = new LinkedStack<>();
        stack.push(0.007);
        stack.push(1.007);
        stack.push(2.007);
        stack.push(100.007);

        Optional<Double> d1 = stack.pop();
        Optional<Double> d2 = stack.pop();
        Optional<Double> d3 = stack.pop();
        Optional<Double> d4 = stack.pop();

        assertTrue(d1.isPresent());
        assertTrue(d2.isPresent());
        assertTrue(d3.isPresent());
        assertTrue(d4.isPresent());

        assertEquals((Double) 100.007, d1.get());
        assertEquals((Double) 2.007, d2.get());
        assertEquals((Double) 1.007, d3.get());
        assertEquals((Double) 0.007, d4.get());
    }

    @Test
    public void testPushPeek(){
        Stack<Double> stack = new LinkedStack<>();
        stack.push(2.007);
        stack.push(100.007);

        Optional<Double> d1 = stack.peek();
        Optional<Double> d2 = stack.peek();

        assertTrue(d1.isPresent());
        assertTrue(d2.isPresent());

        assertEquals((Double) 100.007, d1.get());
        assertNotEquals( 2.007, d2.get());
        assertEquals(d1, d2);

    }

    @Test
    public void testEmptyFunction() {
        Stack<Double> stack = new LinkedStack<>();
        assertTrue(stack.isEmpty());

        stack.push(36.6);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopFromEmpty(){
        Stack<Double> stack = new LinkedStack<>();
        Optional<?> d = stack.pop();

        assertFalse(d.isPresent());
        d = stack.pop();
        assertFalse(d.isPresent());

        stack.push(77.7);
        d = stack.pop();

        d = stack.pop();
        assertFalse(d.isPresent());
    }

    @Test
    public void testPeekFromEmpty(){
        Stack<Double> stack = new LinkedStack<>();
        Optional<?> d = stack.peek();
        assertFalse(d.isPresent());
    }

    @Test
    public void testPushPopNull(){
        Stack<Double> stack = new LinkedStack<>();
        stack.push(null);
        stack.push(null);
        stack.push(null);
        Optional<Double> d = stack.pop();

        assertFalse(d.isPresent());

    }
}
