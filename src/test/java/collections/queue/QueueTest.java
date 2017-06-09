package collections.queue;

import collections.Node;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void testZeroArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Queue<?> queue = new LinkedQueue<>();

        Field headField = queue.getClass().getDeclaredField("head");
        headField.setAccessible(true);
        Node<?> head = (Node<?>) headField.get(queue);

        Field lastField = queue.getClass().getDeclaredField("last");
        lastField.setAccessible(true);
        Node<?> last = (Node<?>) lastField.get(queue);

        assertNull(head);
        assertNull(last);
    }

    @Test
    public void testQueueArgumentConstructor() throws NoSuchFieldException, IllegalAccessException {
        Queue<Double> queueOriginal = new LinkedQueue<>();
        queueOriginal.push(0.3);
        queueOriginal.push(1.3);
        queueOriginal.push(2.3);
        queueOriginal.push(100.3);

        Queue<Double> queueClone = new LinkedQueue<>((LinkedQueue<Double>) queueOriginal);

        Field headField = queueClone.getClass().getDeclaredField("head");
        headField.setAccessible(true);
        Node<Double> head = (Node<Double>) headField.get(queueClone);

        Field lastField = queueClone.getClass().getDeclaredField("last");
        lastField.setAccessible(true);
        Node<?> last = (Node<?>) lastField.get(queueClone);

        assertNotNull(head);
        assertNotNull(last);

        assertTrue(queueClone.peek().isPresent());

        assertEquals((Double)0.3, queueClone.peek().get());

        Double d1 = queueClone.poll().get();
        Double d2 = queueClone.poll().get();
        Double d3 = queueClone.poll().get();
        Double d4 = queueClone.poll().get();

        assertEquals((Double)0.3, d1);
        assertEquals((Double)1.3, d2);
        assertEquals((Double)2.3, d3);
        assertEquals((Double)100.3, d4);
    }

    @Test
    public void testEmptyFunction() {
        Queue<Double> queue = new LinkedQueue<>();

        assertTrue(queue.isEmpty());

        queue.push(2.0);
        queue.push(2.1);
        queue.push(2.2);
        queue.push(2.2);

        assertFalse(queue.isEmpty());

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testPushPop() {
        Queue<Double> queue = new LinkedQueue<>();
        queue.push(2.0);
        queue.push(2.1);
        queue.push(2.2);
        queue.push(2.2);

        Double poll1 = queue.poll().get();
        Double poll2 = queue.poll().get();
        Double poll3 = queue.poll().get();
        Double poll4 = queue.poll().get();

        assertEquals(new Double(2.0), poll1);
        assertEquals((Double) 2.1, poll2);
        assertEquals((Double) 2.2, poll3);
        assertEquals((Double) 2.2, poll4);
    }

    @Test
    public void testPushPeek() {
        Queue<Double> queue = new LinkedQueue<>();
        queue.push(2.0);
        queue.push(2.1);
        queue.push(2.2);
        queue.push(2.2);

        assertTrue(queue.peek().isPresent());

        assertEquals(new Double(2.0), queue.peek().get());
        assertNotEquals(2.1, queue.peek().get());
    }

    @Test
    public void testPeekFromEmpty() {
        Queue<?> queue = new LinkedQueue<>();
        assertFalse(queue.peek().isPresent());
    }

    @Test
    public void testPollFromEmpty() {
        Queue<?> queue = new LinkedQueue<>();
        assertFalse(queue.poll().isPresent());
    }
}
