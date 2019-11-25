package pl.bartoszek.katarzyna;

import pl.bartoszek.katarzyna.controller.ConverterController;
import pl.bartoszek.katarzyna.exception.InvalidDataException;
import pl.bartoszek.katarzyna.model.NumberConverter;

import java.sql.NClob;

/**
 * The purpose of this project is to convert an Arabic number entered by the user to a Roman number.
 * The user is asked to enter a number either using the command line or the keyboard.
 * The number should be an integer in the specified range.
 * The range accepted in this program is 1-3999 but can easily be modified in the <code>NumberValidator</code> class.
 * Several numbers (such as 1, 4, 5, 9) are saved in advance. The other numbers are based on these numbers and calculated by the algorithm.
 * Roman numbers cannot contain more than three identical letters in a row.
 * Program returns a Roman number.
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class Main {
    /**
     * Runs the controller responsible for controlling both the model and the view.
     * Only one parameter required (Arabic number).
     * If the number of execution parameters is higher than 1, the first argument is taken into account.
     * Roman numbers must be integers higher than 0 so the input data should also meet these requirements.
     * @param args execution parameters
     */
    public static void main(String[] args) {
        ConverterController converterController = new ConverterController();
        converterController.convertData(args);
    }
}
