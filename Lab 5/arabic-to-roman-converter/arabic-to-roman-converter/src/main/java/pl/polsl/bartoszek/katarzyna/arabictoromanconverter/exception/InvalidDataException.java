package pl.polsl.bartoszek.katarzyna.arabictoromanconverter.exception;

/**
 * This exception is thrown when user input is not a valid number in the correct range.
 * The range accepted in this project is 1-3999. It can be changed in the <code>NumberValidator</code> class.
 * Roman numbers must be integers higher than 0.
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class InvalidDataException extends Exception {

    /**
     * Displays a message informing the user that the input data they entered was invalid.
     */
    public InvalidDataException() {
        super("Invalid data. Data should be an integer in the range of 1-3999.");
    }
}
