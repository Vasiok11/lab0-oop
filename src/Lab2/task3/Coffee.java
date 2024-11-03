package Lab2.task3;


public class Coffee {
    enum Intensity{
        LIGHT,
        NORMAL,
        STRONG
    }
    public Intensity coffeeIntensity;
    private String name;

    public Coffee(Intensity coffeeIntensity, String name) {
        this.coffeeIntensity = coffeeIntensity;
        this.name = name;
    }

    public void printCoffeeDetails(){
        System.out.println("You wanted:" + name + "\nwith intensity:" + coffeeIntensity);
    }

    public void makeCoffeeBase(){
        System.out.println("I am making: " + name+ "\nIntensity set to: " + coffeeIntensity);
    }
}

