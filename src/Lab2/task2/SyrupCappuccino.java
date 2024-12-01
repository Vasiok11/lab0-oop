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


    public SyrupCappuccino(Intensity intensity,SyrupType syrup, int mlOfMilk){
        super(intensity,"Syrup Cappucino", mlOfMilk);
        this.syrup = syrup;
    }


    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup Type:" + syrup + "\n");
    }
}