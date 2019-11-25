package pl.bartoszek.katarzyna.view;

/**
 * Displays messages every time the controller launches this class.
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class MessagePrinter {

    /**
     * Prints a message for the user to enter an Arabic number.
     * Used in <code>ConverterController</code>.
     */
    public void getDataFromUser() {
        System.out.println("Please enter an Arabic number (between 1 and 3999): ");
    }

    /**
     * Prints the result as a Roman number.
     * Used in <code>ConverterController</code>.
     * @param romanNumber result Roman number converted by the program
     */
    public void printRomanNumber(String romanNumber) { System.out.println("Roman number: " + romanNumber);}
}
