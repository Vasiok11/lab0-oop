package Lab3.task1;
public class BasicQueue<T> implements Queue<T> {
    private int size = 5;
    Object cars[] = new Object[size];
    private int front;
    private int rear;

    public BasicQueue() {
        front = -1;
        rear = -1;
    }
    @Override
   public boolean isFull() {
        if (rear == size - 1) {
            return rear == size - 1;
        }
        return false;
    }
    @Override
    public boolean isEmpty() {
        if (front == -1) {
            return true;
        } else return false;
    }

    public void enqueue(T car){
        if (isFull()){
            System.out.println("Queue is full");
        }
        else{
            if (front == -1) front = 0;
            rear++;
            cars[rear] = car;
            System.out.println("Inserted:" + car);
        }
    }


    @Override
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println(cars[front] + " left the queue");

            for (int i = front; i < rear; i++) {
                cars[i] = cars[i + 1];
            }
            rear--;
            if (rear < front) {
                front = -1;
                rear = -1;
            }
        }
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Cars currently in the queue:");
        for (int i = front; i <= rear; i++) {
            System.out.println(cars[i]);
        }
    }
}


