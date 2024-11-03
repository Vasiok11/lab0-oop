package Lab2.task2;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    enum SyrupType{
        MACADAMIA,
        VANILLA,
        COCONUT,
        CARAMEL,
        CHOCOLATE,
        POPCORN
    }


    public SyrupCappuccino(SyrupType syrup, int mlOfMilk){
        super(mlOfMilk);
        this.syrup = syrup;
        getName("Syrup Cappuccino");
    }


    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup Type:" + syrup + "\n");
    }
}