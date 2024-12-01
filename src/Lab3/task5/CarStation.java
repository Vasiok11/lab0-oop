package Lab3.task5;

import java.util.Objects;

public class CarStation {
    private Queue<Car> queue;

    public CarStation(Queue<Car> queue) {
        this.queue = queue;
    }

    public void addCar(Car car) {
        if (!queue.isFull()) {
            queue.enqueue(car);
        } else {
            System.out.println("Queue is full.");
        }
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = (Car) queue.dequeue();

            Dineable diningService;
            if ("Human".equalsIgnoreCase(car.getPerson())) {
                diningService = new PeopleDinner();
                System.out.println("Car ID: " + car.getCarId() + " -> Directing Human to PeopleDinner.");
            } else if ("Robot".equalsIgnoreCase(car.getPerson())) {
                diningService = new RobotDinner();
                System.out.println("Car ID: " + car.getCarId() + " -> Directing Robot to RobotDinner.");
            } else {
                System.out.println("Car ID: " + car.getCarId() + " -> Unknown person type!");
                continue;
            }

            if (car.isDining()) {
                diningService.serveDinner(car.getCarId());
            } else {
                System.out.println("Car ID: " + car.getCarId() + " -> Does not want to dine.");
            }
        }
    }
}
