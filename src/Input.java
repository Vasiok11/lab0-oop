import java.util.ArrayList;
import java.util.List;

public class Input {
    private Long id;
    private Boolean isHumanoid;
    private String planet;
    private Long age;
    private List<String> traits;
    private String classification;

    public Input(Long id, Boolean isHumanoid, String planet, Long age, List<String> traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = (planet != null) ? planet.trim().toLowerCase() : "";
        this.age = age;
        this.traits = (traits != null) ? normalizeTraits(traits) : new ArrayList<>();
        this.classification = classify();
    }

    private String classify() {
        boolean humanoid = (isHumanoid != null) && isHumanoid;

        if (planet.equals("kashyyyk") && isHumanoidFalse() && ageInRangeOrNull(0, 400) && hasAllTraits("hairy", "tall")) {
            return "Star Wars Universe (Wookie)";
        }
        if (planet.equals("endor")) {
            return "Star Wars Universe (Ewok)";
        }
        if (planet.equals("asgard") && humanoid && ageInRangeOrNull(0, 5000) && hasAllTraits("blonde", "tall")) {
            return "Marvel Universe (Asgardian)";
        }
        if (planet.equals("betelgeuse") && humanoid && ageInRangeOrNull(0, 100) && hasAllTraits("extra_arms", "extra_head")) {
            return "Hitchhiker's Universe (Betelgeusian)";
        }
        if (planet.equals("vogsphere") && isHumanoidFalse() && ageInRangeOrNull(0, 200) && hasAllTraits("green", "bulky")) {
            return "Hitchhiker's Universe (Vogons)";
        }
        if (planet.equals("earth")) {
            if (humanoid && hasAllTraits("blonde", "pointy_ears")) {
                return "Lord of the Rings Universe (Elf)";
            }
            if (humanoid && ageInRangeOrNull(0, 200) && hasAllTraits("short", "bulky")) {
                return "Lord of the Rings Universe (Dwarf)";
            }
        }

        if (hasAllTraits("green", "bulky")) return "Hitchhiker's Universe (Vogons)";
        if (hasAllTraits("green")) return "Hitchhiker's Universe (Vogons)";
        if (hasAnyTrait("bulky") && !hasAnyTrait("green")) return "Lord of the Rings Universe (Dwarf)";
        if (hasAllTraits("hairy", "tall")) return "Star Wars Universe (Wookie)";
        if (hasAllTraits("short", "hairy")) return "Star Wars Universe (Ewok)";
        if (hasAllTraits("blonde", "tall")) return "Marvel Universe (Asgardian)";
        if (hasAllTraits("extra_arms", "extra_head")) return "Hitchhiker's Universe (Betelgeusian)";
        if (hasAnyTrait("extra_arms")) return "Hitchhiker's Universe (Betelgeusian)";
        if (hasAnyTrait("extra_head")) return "Hitchhiker's Universe (Betelgeusian)";

        return "Lord of the Rings Universe (Elf)";
    }

    public String getClassification() {
        return classification;
    }

    private boolean isHumanoidFalse() {
        return isHumanoid != null && !isHumanoid;
    }

    private boolean hasAllTraits(String... requiredTraits) {
        for (String trait : requiredTraits) {
            if (!traits.contains(trait.toLowerCase())) return false;
        }
        return true;
    }

    private boolean hasAnyTrait(String... requiredTraits) {
        for (String trait : requiredTraits) {
            if (traits.contains(trait.toLowerCase())) return true;
        }
        return false;
    }

    private boolean ageInRangeOrNull(int min, int max) {
        if (age == null) return true;
        return age >= min && age <= max;
    }

    private List<String> normalizeTraits(List<String> traits) {
        List<String> normalized = new ArrayList<>();
        for (String trait : traits) {
            normalized.add(trait.trim().toLowerCase());
        }
        return normalized;
    }

    public String toJson() {
        StringBuilder json = new StringBuilder("{ ");
        json.append("\"id\": ").append(id).append(", ");
        json.append("\"isHumanoid\": ").append(isHumanoid).append(", ");
        json.append("\"planet\": \"").append(planet).append("\", ");
        json.append("\"age\": ").append(age != null ? age : "null").append(", ");
        json.append("\"traits\": ").append(traitsToJson()).append(", ");
        json.append("\"classification\": \"").append(classification).append("\" ");
        json.append("}");
        return json.toString();
    }

    private String traitsToJson() {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < traits.size(); i++) {
            json.append("\"").append(traits.get(i)).append("\"");
            if (i < traits.size() - 1) json.append(", ");
        }
        json.append("]");
        return json.toString();
    }
}
