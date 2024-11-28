package Lab3.task2;

public class Main {
    public static void main(String[] args) {
        Distribution distribution = new Distribution();
        Distribution distribution2 = new Distribution();
        Distribution distribution3 = new Distribution();
        Distribution distribution4 = new Distribution();
        distribution.servePerson("1", "Gas", "Human", true);
        distribution2.servePerson("2", "Electric", "Robot", true);
        distribution3.servePerson("3", "Electric", "Human", false);
        distribution4.servePerson("4", "Gas", "Robot", true);
    }
}
