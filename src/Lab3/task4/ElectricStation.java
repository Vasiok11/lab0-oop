package Lab3.task4;

public class ElectricStation implements Refuelable {
    private final CircularQueue<Car> carQueue = new CircularQueue<>(5); // Queue size limited to 5
    private final CircularQueue<Car> waitingCars = new CircularQueue<>(25); // Large enough to hold all waiting cars
    private int servedCount = 0;

    private final PeopleDinner peopleDinner = new PeopleDinner();
    private final RobotDinner robotDinner = new RobotDinner();

    public void addCarToQueue(Car car) {
        if (!carQueue.isFull()) {
            carQueue.enqueue(car);
            System.out.println("[ElectricStation] Car " + car.getCarId() + " added to queue.");
        } else {
            waitingCars.enqueue(car);
            System.out.println("[ElectricStation] Queue full. Adding Car " + car.getCarId() + " to waiting list.");
        }
    }

    public void processCars() {
        while (!carQueue.isEmpty() || !waitingCars.isEmpty()) {
            // Process cars in the main queue
            if (!carQueue.isEmpty()) {
                Car car = (Car) carQueue.dequeue();
                System.out.println("[ElectricStation] Refueling Car " + car.getCarId() + "...");
                refuel(car.getCarId());
                servedCount++;
                System.out.println("[ElectricStation] Total cars refueled: " + servedCount);

                // Handle dining
                if (car.isDining()) {
                    if ("PEOPLE".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("[ElectricStation] Directing Car " + car.getCarId() + " to PeopleDinner.");
                        peopleDinner.serveDinner(car.getCarId());
                    } else if ("ROBOTS".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("[ElectricStation] Directing Car " + car.getCarId() + " to RobotDinner.");
                        robotDinner.serveDinner(car.getCarId());
                    }
                } else {
                    System.out.println("[ElectricStation] Car " + car.getCarId() + " does not want to dine.\n");
                }
            }

            // Move cars from waiting list to main queue if space becomes available
            if (!carQueue.isFull() && !waitingCars.isEmpty()) {
                Car waitingCar = (Car) waitingCars.dequeue();
                carQueue.enqueue(waitingCar);
                System.out.println("[ElectricStation] Car " + waitingCar.getCarId() + " moved to queue from waiting list.");
            }
        }
    }

    @Override
    public void refuel(String carId) {
        System.out.println("[ElectricStation] Car " + carId + " has been refueled.");
    }
}
