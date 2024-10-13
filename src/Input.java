public class Input {
    int id;
    boolean isHumanoid;
    String planet;
    int age;
    String traits;

    Input(int id, boolean isHumanoid, String planet, int age, String traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;

    }

    void Marvel(int id) {
        System.out.println(this.id + " is from the Marvel universe");
    }
}
