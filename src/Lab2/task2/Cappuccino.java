package Lab2.task2;


public class Cappuccino extends Coffee {

    private int mlOfMilk;
    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public Cappuccino(Intensity intensity, String name,int mlOfMilk){
        super(intensity, name);
        this.mlOfMilk = mlOfMilk;
    }

    public Cappuccino(int mlOfMilk, Intensity intensity){
        super(intensity, "Cappuccino");
        this.mlOfMilk = mlOfMilk;
    }




    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Ml of milk:" + mlOfMilk);
    }
}
