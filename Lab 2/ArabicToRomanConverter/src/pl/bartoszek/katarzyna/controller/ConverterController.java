package pl.bartoszek.katarzyna.controller;

import pl.bartoszek.katarzyna.exception.InvalidDataException;
import pl.bartoszek.katarzyna.model.DataReader;
import pl.bartoszek.katarzyna.model.NumberConverter;
import pl.bartoszek.katarzyna.model.NumberValidator;
import pl.bartoszek.katarzyna.view.MessagePrinter;

/**
 * Controls the view and the model.
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class ConverterController {

    /**
     * Starts reading user input from either the command line or the keyboard.
     * Runs the number validation and prints a message when catches an exception.
     * Runs the number converter and the message printer providing the correct Roman number.
     * @param args execution parameters
     */
    public void convertData(String[] args) {

        DataReader dataReader = new DataReader();
        boolean isTheNumberInCommandLine = dataReader.readNumberFromCommandLine(args);

        if(!isTheNumberInCommandLine) {
            MessagePrinter messageGetDataFromUser = new MessagePrinter();
            messageGetDataFromUser.getDataFromUser();
            dataReader.readNumberFromUser();
        }

        NumberValidator numberValidator = new NumberValidator();

        try {
            numberValidator.isDataValid((dataReader.getData()));
            NumberConverter numberConverter = new NumberConverter();
            String romanNumber = numberConverter.convertFromArabicToRoman(numberValidator.getArabicNumber());

            MessagePrinter messageRomanNumber = new MessagePrinter();
            messageRomanNumber.printRomanNumber(romanNumber);
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
