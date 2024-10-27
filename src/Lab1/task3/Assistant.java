package Lab1.task3;
import Lab1.task1.Display;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplay = new ArrayList<>();

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public List<Display> getAssignedDisplay() {
        return assignedDisplay;
    }

     void assignDisplay(Display d){
        assignedDisplay.add(d);
        System.out.println(d.getModel()+ " has been assigned to " + assistantName);
    }

    void assist(){
        for(int i = 0; i < assignedDisplay.size() - 1; i++){
            Display initialDisplay = assignedDisplay.get(i);
            Display nextDisplay = assignedDisplay.get(i+1);
            System.out.println("\nComparing " + initialDisplay.getModel() + " with " + nextDisplay.getModel());
            initialDisplay.compareWithMonitor(nextDisplay);
        }
        if(assignedDisplay.size() > 2){
            Display initialDisplay = assignedDisplay.get(assignedDisplay.size() - 1);
            Display nextDisplay = assignedDisplay.get(0);
            System.out.println("\nComparing " + initialDisplay.getModel() + " with " + nextDisplay.getModel());
            initialDisplay.compareWithMonitor(nextDisplay);
        }
    }

    Display buyDisplay(Display d){
        assignedDisplay.remove(d);
        System.out.println("\nBought " + d.getModel() + " display");
        return d;
    }
}
