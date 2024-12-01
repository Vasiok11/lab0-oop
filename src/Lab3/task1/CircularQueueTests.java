package Lab3.task1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CircularQueueTests{
    private CircularQueue<String> queue;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        queue = new CircularQueue<>();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testInitialState() {
        assertTrue(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testEnqueueUntilFull() {
        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.enqueue("Car3");
        queue.enqueue("Car4");
        queue.enqueue("Car5");
        assertTrue(queue.isFull());
        queue.enqueue("Car6");
        assertTrue(outContent.toString().contains("Queue is full"));
    }

    @Test
    public void testCircularBehavior() {
        queue.enqueue("Car1");
        queue.enqueue("Car2");
        queue.enqueue("Car3");
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("Car4");
        queue.enqueue("Car5");
        assertFalse(queue.isEmpty());
        assertFalse(queue.isFull());
    }

    @Test
    public void testDequeueEmpty() {
        queue.dequeue();
        assertTrue(outContent.toString().contains("Queue is empty"));
    }

    @Test
    public void testPrintEmpty() {
        queue.printQueue();
        assertTrue(outContent.toString().contains("Queue is empty"));
    }

    @org.junit.After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}