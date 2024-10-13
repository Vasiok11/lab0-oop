import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileRead {
    public static InputContainer Parse() {
        JSONParser parser = new JSONParser();
        InputContainer inputContainer = new InputContainer(); // Create the container

        try {
            // Parse the JSON file
            Object obj = parser.parse(new FileReader("./doc/input.json"));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray inputArray = (JSONArray) jsonObject.get("input");

            if (inputArray != null) {
                for (Object o : inputArray) {
                    JSONObject character = (JSONObject) o;

                    // Extract fields from JSON
                    Long id = (Long) character.get("id");
                    Boolean isHumanoid = (Boolean) character.get("isHumanoid");
                    String planet = (String) character.get("planet");
                    Long age = (Long) character.get("age");
                    JSONArray traitsArray = (JSONArray) character.get("traits");

                    // Extract traits into a List
                    List<String> traits = new ArrayList<>();
                    if (traitsArray != null) {
                        for (Object trait : traitsArray) {
                            traits.add((String) trait);
                        }
                    }

                    // Classify based on isHumanoid
                    String classification = (isHumanoid != null && isHumanoid) ? "Humanoid" : "Non-Humanoid";

                    // Create Input object and add it to the container
                    Input input = new Input(id, isHumanoid, planet, age, traits, classification);
                    inputContainer.addInput(input);
                }
            } else {
                System.out.println("Key 'input' not found in the JSON object.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inputContainer; // Return the populated InputContainer
    }
}
