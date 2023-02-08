package cpsc2150.MyVector;

import java.util.Scanner;

/**
 * <p>
 * An application that uses {@link IVector}.
 * </p>
 */
public class CharacterVectorApp <T> {

    /**
     * <p>
     * Choices for vector methods
     * </p>
     */
    private static final int ADDELEMENT_CHOICE = 1;
    private static final int REMOVEELEMENT_CHOICE = 2;
    private static final int CONTAINS_CHOICE = 3;
    private static final int GET_CHOICE = 4;
    private static final int REPLACE_CHOICE = 5;
    private static final int LENGTH_CHOICE = 6;
    private static final int CLEAR_CHOICE = 7;
    private static final int EXIT_CHOICE = 8;

    /**
     * <p>
     * Choices for vector implementations
     * </p>
     */
    private static final int ARRAY_VECTOR_CHOICE = 1;
    private static final int LIST_VECTOR_CHOICE = 2;

    /**
     * <p>
     * This method is our main entry point to our application.
     * </p>
     *
     * @param args
     *            Program arguments (not used)
     */
    public static void main(String[] args) {
        IVector v;
        String val;
        int pos;
        Scanner sc = new Scanner(System.in);




        // prompt the user to choose between ArrayVector and ListVector
        int option;
        do {
            System.out.println("Enter " + ARRAY_VECTOR_CHOICE + " for array implementation or " + LIST_VECTOR_CHOICE
                    + " for List implementation");
            option = Integer.parseInt(sc.nextLine());
        } while (option != ARRAY_VECTOR_CHOICE && option != LIST_VECTOR_CHOICE);

        // replace this so the user can choose between ArrayVector and ListVector


        if(option == ARRAY_VECTOR_CHOICE){
            v = new ArrayVector();
        }
        else if(option == LIST_VECTOR_CHOICE){
            v = new ListVector();
        }
        else v = new ListVector();




        // Print a menu of options
        printMenu();
        int input = Integer.parseInt(sc.nextLine());
        while (input != EXIT_CHOICE) {
            switch (input) {
            case ADDELEMENT_CHOICE:

                if(v.length() >= 100)
                {
                    System.out.println("Vector is full, choose another option");
                    break;
                }

                System.out.println("What value to add to the end of the vector?");
                val = sc.nextLine();
                v.addElement(val.charAt(0));
                break;
            case REMOVEELEMENT_CHOICE:
                System.out.println("Value at the front: " + v.removeElement());
                break;
            case CONTAINS_CHOICE:
                System.out.println("What value to check if it is in the vector?");
                val = sc.nextLine();

                // prints the appropriate message
                if (v.contains(val.charAt(0))) {
                    System.out.println(val + " was found in the vector.");
                } else {
                    System.out.println(val + " wasn't found in the vector.");
                }
                break;
            case GET_CHOICE:
                System.out.println("What position to get from the vector?");
                pos = Integer.parseInt(sc.nextLine());

                if(pos < 0 || pos > v.length()){
                    System.out.println("Invalid Position");
                    break;
                }

                // get value from the specified position
                System.out.println(v.get(pos) + " is at position " + pos + " in the vector.");
                break;
            case REPLACE_CHOICE:
                System.out.println("What value to replace in the vector?");
                val = sc.nextLine();

                System.out.println("What position to replace?");
                pos = Integer.parseInt(sc.nextLine());

                if(pos < 0 || pos > v.length()){
                    System.out.println("Invalid Position");
                    break;
                }

                // replace the value from the specified position
                v.replace(val.charAt(0), pos);
                System.out.println(val + " was replaced in position " + pos + " in the vector.");
                break;
            case LENGTH_CHOICE:
                System.out.println("Length of vector: " + v.length());
                break;
            case CLEAR_CHOICE:
                v.clear();
                System.out.println("Vector is now empty!");
                break;
            default:
                System.out.println("Not a valid option!");
                break;
            }

            // print the contents of the vector
            System.out.println("Vector is: ");
            System.out.println(v.toString());

            // print the menu and get the next option
            printMenu();
            input = Integer.parseInt(sc.nextLine());
        }
    }

    /**
     * <p>
     * This method will print the options menu.
     * </p>
     *
     * @pre none
     * 
     * @post [menu will be displayed to user]
     */
    private static void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println(ADDELEMENT_CHOICE + ". Add to the end of the vector");
        System.out.println(REMOVEELEMENT_CHOICE + ". Remove from the front of the vector");
        System.out.println(CONTAINS_CHOICE + ". Checks to see if value is in the vector");
        System.out.println(GET_CHOICE + ". Get a position in the vector");
        System.out.println(REPLACE_CHOICE + ". Replace a value with a position in the vector");
        System.out.println(LENGTH_CHOICE + ". Get the length of the vector");
        System.out.println(CLEAR_CHOICE + ". Clear the vector");
        System.out.println(EXIT_CHOICE + ". Quit");
    }
}