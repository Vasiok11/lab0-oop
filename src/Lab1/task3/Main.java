package Lab1.task3;

import Lab1.task1.Display;

public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(100, 50, 40, "Dell");
        Display display2 = new Display(100, 50, 88, "HP");
        Display display3 = new Display(480, 90, 55, "Lenovo");
        Assistant assistant= new Assistant("Displays list");
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);
        assistant.assist();
        assistant.buyDisplay(display2);
        assistant.assist();

    }
}
