import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileRead {
    public static void Parse() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("./doc/input.json"));
            JSONObject jsonObject = (JSONObject) obj;

            System.out.println("JSON Object: " + jsonObject);

            JSONArray inputArray = (JSONArray) jsonObject.get("input");

            if (inputArray != null) {
                for (Object o : inputArray) {
                    JSONObject character = (JSONObject) o;

                    Long id = (Long) character.get("id");
                    Boolean isHumanoid = (Boolean) character.get("isHumanoid");
                    String planet = (String) character.get("planet");
                    Long age = (Long) character.get("age");
                    JSONArray traits = (JSONArray) character.get("traits");

                    System.out.println("\nid: " + (id != null ? id : "null"));
                    System.out.println("isHumanoid: " + (isHumanoid != null ? isHumanoid : "null"));
                    System.out.println("planet: " + (planet != null ? planet : "null"));
                    System.out.println("age: " + (age != null ? age : "null"));

                    System.out.println("traits:");
                    if (traits != null) {
                        for (Object trait : traits) {
                            System.out.println(trait);
                        }
                    } else {
                        System.out.println("null");
                    }
                }
            } else {
                System.out.println("Key 'input' not found in the JSON object.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}