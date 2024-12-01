package Lab3.task5;

public interface Queue<T> {
    public boolean isFull();
    public void enqueue(T car);

    public Object dequeue();

    public boolean isEmpty();

    public void printQueue();

}
