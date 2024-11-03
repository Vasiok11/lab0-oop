package Lab2.task2;

public class Main {
    public static void main(String[] args) {
    Coffee americano = new Americano(50, Coffee.Intensity.STRONG);
    americano.printCoffeeDetails();

    Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(Coffee.Intensity.LIGHT, 50, 50);
    pumpkinSpiceLatte.printCoffeeDetails();

    Coffee syrupCappuccino = new SyrupCappuccino(Coffee.Intensity.NORMAL, SyrupCappuccino.SyrupType.POPCORN,85);
    syrupCappuccino.printCoffeeDetails();

    Coffee cappuccino = new Cappuccino(90, Coffee.Intensity.LIGHT);
    cappuccino.printCoffeeDetails();
    }
}
