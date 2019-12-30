package pl.bartoszek.katarzyna.client.view;

/**
 * Prints messages to the client.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class ClientView {

    /**
     * Prints the conversion result.
     * @param arabicNumber Arabic number entered by the client
     * @param romanNumber Roman number as a result
     */
    public static void printConversionResult(int arabicNumber, String romanNumber) {
        System.out.println("Arabic number: " + arabicNumber + " is a Roman number: " + romanNumber);
    }

    /**
     * Prints the messages from the server.
     * @param message message from the server
     */
    public static void printServerResponse(String message) {
        System.out.println("Server: " + message);
    }

    /**
     * Prints help whenever the client enters "HELP".
     */
    public static void getHelp() {
        System.out.println("Please enter one of the following commands:\n"
                + "CONVERT - to convert an Arabic number to Roman number\n"
                + "HELP - to get help\n"
                + "EXIT - to quit");
    }

    /**
     * Asks the client to provide some number.
     */
    public static void enterTheNumber() {
        System.out.println("Please enter an Arabic number.");
    }
}
