package Lab1.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Display display1 = new Display(100, 50, 40, "Dell");
        Display display2 = new Display(100, 50, 88, "HP");
        Display display3 = new Display(480, 90, 55, "Lenovo");

        menu(display1, display2, display3);
    }

    public static void menu(Display display1, Display display2, Display display3) {

        Scanner input = new Scanner(System.in);
        int option;
        int displaySelection;

        do {

            System.out.println("Choose whether you want to compare size, sharpness, or both:");
            System.out.println("1. size \n2. sharpness \n3. both");
            option = input.nextInt();

            if (option < 1 || option > 3) {
                System.out.println("Invalid option");
                continue;
            }

            System.out.println("Which displays do you want to compare?");
            System.out.println("1. Display 1 and Display 2\n2. Display 2 and Display 3\n3. Display 1 and Display 3");
            displaySelection = input.nextInt();


            if (displaySelection < 1 || displaySelection > 3) {
                System.out.println("Invalid option");
                continue;
            }

            switch (option) {
                case 1:
                    switch (displaySelection) {
                        case 1:
                            display1.compareSize(display2);
                            break;
                        case 2:
                            display2.compareSize(display3);
                            break;
                        case 3:
                            display1.compareSize(display3);
                            break;
                    }
                    break;

                case 2:
                    switch (displaySelection) {
                        case 1:
                            display1.compareSharpness(display2);
                            break;
                        case 2:
                            display2.compareSharpness(display3);
                            break;
                        case 3:
                            display1.compareSharpness(display3);
                            break;
                    }
                    break;

                case 3:
                    switch (displaySelection) {
                        case 1:
                            display1.compareWithMonitor(display2);
                            break;
                        case 2:
                            display2.compareWithMonitor(display3);
                            break;
                        case 3:
                            display1.compareWithMonitor(display3);
                            break;
                    }
                    break;

            }

            break;

        } while (true);
    }
}
