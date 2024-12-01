package Lab3.task4;

public class GasStation implements Refuelable {
    private final CircularQueue<Car> carQueue = new CircularQueue<>(5);
    private final CircularQueue<Car> waitingCars = new CircularQueue<>(25);
    private int servedCount = 0;

    private final PeopleDinner peopleDinner = new PeopleDinner();
    private final RobotDinner robotDinner = new RobotDinner();

    public void addCarToQueue(Car car) {
        if (!carQueue.isFull()) {
            carQueue.enqueue(car);
            System.out.println("[GasStation] Car " + car.getCarId() + " added to queue.");
        } else {
            waitingCars.enqueue(car);
            System.out.println("[GasStation] Queue full. Adding Car " + car.getCarId() + " to waiting list.");
        }
    }

    public void processCars() {
        while (!carQueue.isEmpty() || !waitingCars.isEmpty()) {
            if (!carQueue.isEmpty()) {
                Car car = (Car) carQueue.dequeue();
                System.out.println("[GasStation] Refueling Car " + car.getCarId() + "...");
                refuel(car.getCarId());
                servedCount++;
                System.out.println("[GasStation] Total cars refueled: " + servedCount);

                if (car.isDining()) {
                    if ("PEOPLE".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("[GasStation] Directing Car " + car.getCarId() + " to PeopleDinner.");
                        peopleDinner.serveDinner(car.getCarId());
                    } else if ("ROBOTS".equalsIgnoreCase(car.getPerson())) {
                        System.out.println("[GasStation] Directing Car " + car.getCarId() + " to RobotDinner.");
                        robotDinner.serveDinner(car.getCarId());
                    }
                } else {
                    System.out.println("[GasStation] Car " + car.getCarId() + " does not want to dine.\n");
                }
            }

            if (!carQueue.isFull() && !waitingCars.isEmpty()) {
                Car waitingCar = (Car) waitingCars.dequeue();
                carQueue.enqueue(waitingCar);
                System.out.println("[GasStation] Car " + waitingCar.getCarId() + " moved to queue from waiting list.");
            }
        }
    }

    @Override
    public void refuel(String carId) {
        System.out.println("[GasStation] Car " + carId + " has been refueled.");
    }
}
