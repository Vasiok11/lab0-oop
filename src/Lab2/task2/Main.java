package Lab2.task2;

public class Main {
    public static void main(String[] args) {
    Coffee americano = new Americano(50);
    americano.printCoffeeDetails();

    Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(50, 50);
    pumpkinSpiceLatte.printCoffeeDetails();

    Coffee syrupCappuccino = new SyrupCappuccino(SyrupCappuccino.SyrupType.POPCORN, 50);
    syrupCappuccino.printCoffeeDetails();

    Coffee cappuccino = new Cappuccino(50);
    cappuccino.printCoffeeDetails();
    }
}
