package Lab3.task1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasicQueueTests {
    private BasicQueue<String> queue;

    @Before
    public void setUp() {
        queue = new BasicQueue<>();
    }

    @Test
    public void testInitialState() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testEnqueue() {
        queue.enqueue("Car1");
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testEnqueueUntilFull() {
        for (int i = 0; i < 5; i++) {
            queue.enqueue("Car" + i);
        }
        assertTrue(queue.isFull());
    }

    @Test
    public void testDequeueFromEmpty() {
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testEnqueueDequeue() {
        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.dequeue();
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testCompleteQueueCycle() {
        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.dequeue();
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testQueueOrder() {
        String[] cars = {"Car1", "Car2", "Car3"};
        for (String car : cars) {
            queue.enqueue(car);
        }
        assertEquals(cars[0], queue.cars[0]);
        assertEquals(cars[2], queue.cars[2]);
    }
}