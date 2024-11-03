package Lab2.task4.coffee;

class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;

    public SyrupType getSyrup() {
        return syrup;
    }

    enum SyrupType {
        MACADAMIA,
        VANILLA,
        COCONUT,
        CARAMEL,
        CHOCOLATE,
        POPCORN
    }

    public SyrupCappuccino(Intensity intensity, SyrupType syrup, int mlOfMilk) {
        super(intensity, "Syrup Cappucino", mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup Type:" + syrup + "\n");
    }

    public static SyrupCappuccino makeSyrupCappuccino(int mlOfMilk, SyrupType syrup, Intensity intensity) {
        SyrupCappuccino coffee = new SyrupCappuccino(intensity, syrup, mlOfMilk);
        coffee.makeCoffeeBase();
        System.out.println("Amount of milk:" + mlOfMilk + " ml");
        System.out.println("Syrup type: " + syrup + "\n");
        return coffee;
    }
}
