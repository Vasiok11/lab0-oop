import java.util.List;

public class Input {
    private Long id;
    private Boolean isHumanoid;
    private String planet;
    private Long age;
    private List<String> traits;
    private String classification;

    // Constructor
    public Input(Long id, Boolean isHumanoid, String planet, Long age, List<String> traits, String classification) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
        this.classification = classification;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Boolean getIsHumanoid() {
        return isHumanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public Long getAge() {
        return age;
    }

    public List<String> getTraits() {
        return traits;
    }

    public String getClassification() {
        return classification;
    }

    @Override
    public String toString() {
        return "Input{" +
                "id=" + id +
                ", isHumanoid=" + isHumanoid +
                ", planet='" + planet + '\'' +
                ", age=" + age +
                ", traits=" + traits +
                ", classification='" + classification + '\'' +
                '}';
    }

}
