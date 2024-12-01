package Lab3.task4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        Semaphore semaphore = new Semaphore(electricStation, gasStation);

        String resourcesFolderPath = "D:\\OOP\\lab0-oop\\src\\Lab3\\resources";
        List<Car> cars = semaphore.parseCarsFromJson(resourcesFolderPath);

        semaphore.guideCars(cars);

        System.out.println("\n=== Processing Electric Station ===");
        electricStation.processCars();

        System.out.println("\n=== Processing Gas Station ===");
        gasStation.processCars();

        System.out.println("\n=== All Cars Processed ===");
    }
}
