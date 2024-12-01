package Lab3.task5;

public class CircularQueue<T> implements Queue<T> {
    Object cars[];
    private int front;
    private int rear;
    private final int size;

    public CircularQueue(int size) {
        this.size = size;
        cars = new Object[size];
        front = -1;
        rear = -1;
    }

    @Override
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    @Override
    public boolean isEmpty() {
        return front == -1;
    }

    @Override
    public void enqueue(T element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        cars[rear] = element;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Object car = cars[front];
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return car;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int i = front;
        do {
            System.out.println(cars[i]);
            i = (i + 1) % size;
        } while (i != (rear + 1) % size);
    }
}
