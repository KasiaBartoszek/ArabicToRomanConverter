package pl.bartoszek.katarzyna.server.controller;

import pl.bartoszek.katarzyna.server.exception.InvalidDataException;
import pl.bartoszek.katarzyna.server.model.NumberConverter;
import pl.bartoszek.katarzyna.server.model.NumberValidator;

/**
 * Controls the view and the model.
 *
 * @author Katarzyna Bartoszek
 * @version 1.1
 */
public class ConverterController {

    /**
     * Starts reading user input from either the command line or the keyboard.
     * Runs the number validation and prints a message when catches an exception.
     * Runs the number converter and the message printer providing the correct Roman number.
     *
     * @param data execution parameters
     */
    public String convertData(String data) throws InvalidDataException {
        NumberValidator numberValidator = new NumberValidator();
        numberValidator.isDataValid(data);
        NumberConverter numberConverter = new NumberConverter();
        String romanNumber = numberConverter.convertFromArabicToRoman(numberValidator.getArabicNumber());
        return romanNumber;
    }
}
