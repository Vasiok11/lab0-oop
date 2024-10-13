import java.util.ArrayList;
import java.util.List;

public class InputContainer {
    private List<Input> inputs;


    public InputContainer() {
        this.inputs = new ArrayList<>();
    }


    public void addInput(Input input) {
        inputs.add(input);
    }


    public List<Input> filterByAgeAbove50() {
        List<Input> filtered = new ArrayList<>();
        for (Input input : inputs) {
            if (input.getAge() != null && input.getAge() > 50) {
                filtered.add(input);
            }
        }
        return filtered;
    }


    public List<Long> getAllIds() {
        List<Long> ids = new ArrayList<>();
        for (Input input : inputs) {
            ids.add(input.getId());
        }
        return ids;
    }
}
