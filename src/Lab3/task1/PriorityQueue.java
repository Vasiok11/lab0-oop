package Lab3.task1;

public class PriorityQueue implements Queue<String> {
    private int size = 5;
    private Object[] cars = new Object[size];
    private int[] priorities = new int[size];
    private int front;
    private int rear;

    public PriorityQueue() {
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isFull() {
        return rear == size - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(String car, int priority) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if (front == -1) {
            front = 0;
            rear = 0;
            cars[rear] = car;
            priorities[rear] = priority;
            System.out.println("\nInserted: " + car + " (Priority: " + priority + ")\n");
        } else {
            int i;
            for (i = rear; i >= front; i--) {
                if (priorities[i] < priority) {
                    cars[i + 1] = cars[i];
                    priorities[i + 1] = priorities[i];
                } else {
                    break;
                }
            }
            cars[i + 1] = car;
            priorities[i + 1] = priority;
            rear++;
            System.out.println("\nInserted: " + car + " (Priority: " + priority + ")\n");
            System.out.println("Current queue order (by priority):");
            for (int j = front; j <= rear; j++) {
                System.out.println(cars[j] + " (Priority: " + priorities[j] + ")");
            }
        }
    }

    @Override
    public void enqueue(String car) {
        enqueue(car, car.compareTo(""));  // Default priority based on string comparison
    }

    @Override
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println(cars[front] + " (Priority: " + priorities[front] + ") left the queue");

        for (int i = front; i < rear; i++) {
            cars[i] = cars[i + 1];
            priorities[i] = priorities[i + 1];
        }
        rear--;

        if (rear < front) {
            front = -1;
            rear = -1;
        }
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Cars currently in the queue (with priorities):");
        for (int i = front; i <= rear; i++) {
            System.out.println(cars[i] + " (Priority: " + priorities[i] + ")");
        }
    }
}