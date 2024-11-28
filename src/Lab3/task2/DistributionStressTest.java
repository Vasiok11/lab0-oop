package Lab3.task2;

import org.junit.Test;
import java.util.Random;

public class DistributionStressTest {
    private static final String[] CAR_TYPES = {"Gas", "Electric"};
    private static final String[] PERSON_TYPES = {"Human", "Robot"};
    private static final int NUM_ITERATIONS = 10000000;

    @Test
    public void stressTest() {
        Distribution distribution = new Distribution();
        Random random = new Random();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NUM_ITERATIONS; i++) {
            // Generate random test data
            String carId = String.valueOf(i);
            String carType = CAR_TYPES[random.nextInt(CAR_TYPES.length)];
            String personType = PERSON_TYPES[random.nextInt(PERSON_TYPES.length)];
            boolean isDining = random.nextBoolean();

            try {
                distribution.servePerson(carId, carType, personType, isDining);
            } catch (Exception e) {
                System.err.println("Error at iteration " + i + ": " + e.getMessage());
                System.err.println("Parameters: carId=" + carId + ", carType=" + carType +
                        ", personType=" + personType + ", isDining=" + isDining);
                throw e;
            }

            // Print progress every 1000 iterations
            if (i % 1000 == 0) {
                System.out.println("Completed " + i + " iterations");
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("\nStress Test Results:");
        System.out.println("Total iterations: " + NUM_ITERATIONS);
        System.out.println("Total time: " + totalTime + "ms");
        System.out.println("Average time per operation: " + (double)totalTime/NUM_ITERATIONS + "ms");
    }
}