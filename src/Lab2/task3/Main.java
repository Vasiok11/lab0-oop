package Lab2.task3;

public class Main {
    public static void main(String[] args) {
//    Coffee americano = new Americano(50);
//    americano.printCoffeeDetails();
//
//    Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(50, 50);
//    pumpkinSpiceLatte.printCoffeeDetails();
//
//    Coffee syrupCappuccino = new SyrupCappuccino(SyrupCappuccino.SyrupType.POPCORN, 50);
//    syrupCappuccino.printCoffeeDetails();
//
//    Coffee cappuccino = new Cappuccino(50);
//    cappuccino.printCoffeeDetails();

        Coffee coffee = Americano.makeAmericano(50, Coffee.Intensity.STRONG);
        Coffee coffee1 = Cappuccino.makeCappuccino(90, Coffee.Intensity.NORMAL);
        Coffee coffee2 = PumpkinSpiceLatte.makeLatte(30, 10, Coffee.Intensity.LIGHT);
        Coffee coffee3 = SyrupCappuccino.makeSyrupCappuccino(65, SyrupCappuccino.SyrupType.POPCORN, Coffee.Intensity.NORMAL);
    }
}
