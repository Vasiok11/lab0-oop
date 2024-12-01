package Lab2.task4.coffee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Barista {

    private List<Order> orders;

    public Barista() {
        orders = new ArrayList<>();
    }

    public void startOrder() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");

        boolean ordering = true;
        while (ordering) {
            System.out.println("I had a lot of clients today, i'm a bit tired, so no life stories or wife complaints today. Please make your order quick. So what do you want?");
            System.out.println("1. Americano");
            System.out.println("2. Cappuccino");
            System.out.println("3. Pumpkin Spice Latte");
            System.out.println("4. Syrup Cappuccino");
            System.out.println("5. Finish order");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    orders.add(orderAmericano(scanner));
                    break;
                case 2:
                    orders.add(orderCappuccino(scanner));
                    break;
                case 3:
                    orders.add(orderPumpkinSpiceLatte(scanner));
                    break;
                case 4:
                    orders.add(orderSyrupCappuccino(scanner));
                    break;
                case 5:
                    ordering = false;
                    break;
                default:
                    System.out.println("You're wasting my time :(");
            }
        }

        for (Order order : orders) {
            Coffee coffee = null;
            switch (order.coffeeType) {
                case "Americano":
                    coffee = Americano.makeAmericano(order.mlOfWater, order.intensity);
                    break;
                case "Cappuccino":
                    coffee = Cappuccino.makeCappuccino(order.mlOfMilk, order.intensity);
                    break;
                case "Pumpkin Spice Latte":
                    coffee = PumpkinSpiceLatte.makeLatte(order.mlOfMilk, order.mgOfPumpkinSpice, order.intensity);
                    break;
                case "Syrup Cappuccino":
                    coffee = SyrupCappuccino.makeSyrupCappuccino(order.mlOfMilk, order.syrupType, order.intensity);
                    break;
            }

        }

        System.out.println("Thank you for your order!!!!!");
        scanner.close();
    }

    private Order orderAmericano(Scanner scanner) {
        System.out.println("Americano? A man of culture.");

        Coffee.Intensity intensity = getIntensity(scanner);
        int mlOfWater = getMlOfWater(scanner);

        Order order = new Order("Americano", intensity);
        order.mlOfWater = mlOfWater;
        return order;
    }

    private Order orderCappuccino(Scanner scanner) {
        System.out.println("Cappuccino? We have the best one out there.");

        Coffee.Intensity intensity = getIntensity(scanner);
        int mlOfMilk = getMlOfMilk(scanner);

        Order order = new Order("Cappuccino", intensity);
        order.mlOfMilk = mlOfMilk;
        return order;
    }

    private Order orderPumpkinSpiceLatte(Scanner scanner) {
        System.out.println("Never drank a Pumpkin Spice Latte and it sounds weird, but everyone has their tastes i guess.");

        Coffee.Intensity intensity = getIntensity(scanner);
        int mlOfMilk = getMlOfMilk(scanner);
        int mgOfPumpkinSpice = getMgOfPumpkinSpice(scanner);

        Order order = new Order("Pumpkin Spice Latte", intensity);
        order.mlOfMilk = mlOfMilk;
        order.mgOfPumpkinSpice = mgOfPumpkinSpice;
        return order;
    }

    private Order orderSyrupCappuccino(Scanner scanner) {
        System.out.println("Syrup Cappuccino? Nice!!!");

        Coffee.Intensity intensity = getIntensity(scanner);
        int mlOfMilk = getMlOfMilk(scanner);
        SyrupCappuccino.SyrupType syrup = getSyrupType(scanner);

        Order order = new Order("Syrup Cappuccino", intensity);
        order.mlOfMilk = mlOfMilk;
        order.syrupType = syrup;
        return order;
    }

    private Coffee.Intensity getIntensity(Scanner scanner) {
        System.out.println("Now tell me the intensity:");
        System.out.println("1. LIGHT");
        System.out.println("2. NORMAL");
        System.out.println("3. STRONG");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return Coffee.Intensity.LIGHT;
            case 2:
                return Coffee.Intensity.NORMAL;
            case 3:
                return Coffee.Intensity.STRONG;
            default:
                System.out.println("You're wasting my time :(");
                return Coffee.Intensity.NORMAL;
        }
    }

    private int getMlOfWater(Scanner scanner) {
        System.out.println("How much water do you want?");
        System.out.println("1. 50 ml");
        System.out.println("2. 100 ml");
        System.out.println("3. 150 ml");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return 50;
            case 2:
                return 100;
            case 3:
                return 150;
            default:
                System.out.println("I'm not gonna take you seriously if u decided to make fun of me, so i'll just add 100 ml.");
                return 100;
        }
    }

    private int getMlOfMilk(Scanner scanner) {
        System.out.println("How much milk do you want?");
        System.out.println("1. 50 ml");
        System.out.println("2. 100 ml");
        System.out.println("3. 150 ml");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return 50;
            case 2:
                return 100;
            case 3:
                return 150;
            default:
                System.out.println("I'm not gonna take you seriously if u decided to make fun of me, so i'll just add 100 ml.");
                return 100;
        }
    }

    private int getMgOfPumpkinSpice(Scanner scanner) {
        System.out.println("I'm still not over the fact that you want pumpkin spice, but whatever. Choose how many mg you want:");
        System.out.println("1. 10 mg");
        System.out.println("2. 20 mg");
        System.out.println("3. 30 mg");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return 10;
            case 2:
                return 20;
            case 3:
                return 30;
            default:
                System.out.println("I'm not gonna take you seriously if u decided to make fun of me, so i'll just add 20 mg.");
                return 20;
        }
    }

    private SyrupCappuccino.SyrupType getSyrupType(Scanner scanner) {
        System.out.println("Which syrup type do you want?(not to imply anything ,but CARAMEL is the best)");
        System.out.println("1. MACADAMIA");
        System.out.println("2. VANILLA");
        System.out.println("3. COCONUT");
        System.out.println("4. CARAMEL");
        System.out.println("5. CHOCOLATE");
        System.out.println("6. POPCORN");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                return SyrupCappuccino.SyrupType.MACADAMIA;
            case 2:
                return SyrupCappuccino.SyrupType.VANILLA;
            case 3:
                return SyrupCappuccino.SyrupType.COCONUT;
            case 4:
                return SyrupCappuccino.SyrupType.CARAMEL;
            case 5:
                return SyrupCappuccino.SyrupType.CHOCOLATE;
            case 6:
                return SyrupCappuccino.SyrupType.POPCORN;
            default:
                System.out.println("I'm not gonna take you seriously if u decided to make fun of me, so i'll just add POPCORN lol");
                return SyrupCappuccino.SyrupType.POPCORN;
        }
    }

    private class Order {
        String coffeeType;
        Coffee.Intensity intensity;
        int mlOfMilk;
        int mlOfWater;
        int mgOfPumpkinSpice;
        SyrupCappuccino.SyrupType syrupType;

        public Order(String coffeeType, Coffee.Intensity intensity) {
            this.coffeeType = coffeeType;
            this.intensity = intensity;
            this.mlOfMilk = 0;
            this.mlOfWater = 0;
            this.mgOfPumpkinSpice = 0;
            this.syrupType = null;
        }
    }
}
