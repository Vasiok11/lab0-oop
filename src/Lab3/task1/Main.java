package Lab3.task1;

public class Main {
    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue();
        q.enqueue("Skoda", 3);
        q.enqueue("Audi", 6);
        q.enqueue("Audi A4", 1);
        q.enqueue("Audi A7", 8);
        q.dequeue();
        q.enqueue("Supra", 3);
        q.enqueue("Peel", 5);
        q.enqueue("Skoda",4 );
        q.dequeue();
        q.enqueue("Ferrari", 2);
    }
}