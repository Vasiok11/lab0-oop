package Lab3.task5;

import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        String queueFolderPath = "D:\\OOP\\lab0-oop\\src\\Lab3\\queue";

        ElectricStation electricStation = new ElectricStation();
        GasStation gasStation = new GasStation();

        Semaphore semaphore = new Semaphore(electricStation, gasStation);

        HashSet<String> processedFiles = new HashSet<>();

        Timer semaphoreTimer = new Timer();
        semaphoreTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                File queueFolder = new File(queueFolderPath);

                if (!queueFolder.exists() || !queueFolder.isDirectory()) {
                    System.err.println("[Main] Queue folder does not exist or is not a directory: " + queueFolderPath);
                    return;
                }

                File[] files = queueFolder.listFiles((dir, name) -> name.endsWith(".json"));
                if (files != null && files.length > 0) {
                    List<Car> cars = new ArrayList<>();

                    for (File jsonFile : files) {
                        if (!processedFiles.contains(jsonFile.getName())) {
                            try {
                                String jsonContent = new String(Files.readAllBytes(jsonFile.toPath()));
                                System.out.println("[Main] Processing file: " + jsonFile.getName());
                                System.out.println("[Main] JSON Content: " + jsonContent);

                                Car car = parseCarFromJsonString(jsonContent);
                                cars.add(car);

                                processedFiles.add(jsonFile.getName());
                            } catch (Exception e) {
                                System.err.println("[Main] Error processing file: " + jsonFile.getName() + " - " + e.getMessage());
                            }
                        }
                    }

                    if (!cars.isEmpty()) {
                        semaphore.guideCars(cars);
                    }
                } else {
                    System.out.println("[Main] No new files to process.");
                }
            }
        }, 0, 5000);

        Timer servingTimer = new Timer();
        servingTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    //small buffer after semaphore before serving starts
                    Thread.sleep(2000);
                    System.out.println("\n[Scheduler] Serving cars...");
                    electricStation.processCars();
                    gasStation.processCars();
                } catch (InterruptedException e) {
                    System.err.println("[Scheduler] Error during serving delay: " + e.getMessage());
                }
            }
        }, 2000, 7000); // car serving starts 2 seconds after semaphore and it runs every 7 seconds

        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            System.out.println("[Main] Press 'q' and Enter to stop the program...");
            while (true) {
                String input = scanner.nextLine();
                if ("q".equalsIgnoreCase(input)) {
                    System.out.println("\n[Main] Shutting down...");
                    semaphoreTimer.cancel();
                    servingTimer.cancel();
                    System.exit(0);
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();
    }

    private static Car parseCarFromJsonString(String jsonString) {
        try {
            org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
            JSONObject jsonCar = (JSONObject) parser.parse(jsonString);

            int id = Integer.parseInt(jsonCar.get("id").toString());
            String type = jsonCar.get("type").toString();
            String passengers = jsonCar.get("passengers").toString();
            boolean isDining = Boolean.parseBoolean(jsonCar.get("isDining").toString());

            return new Car("CAR" + id, type, passengers, isDining);
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string: " + jsonString, e);
        }
    }

}
