package pl.bartoszek.katarzyna.server.model;

import pl.bartoszek.katarzyna.server.exception.InvalidDataException;

/**
 * Checks if the user input is an integer in the specified range.
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class NumberValidator {

    /**
     * Minimum value of the number that the user can enter.
     * Should be higher than 0 as Roman numerals does not include 0 and negative values.
     */
    private int arabicMinValue;

    /**
     * Maximum value of the number that the user can enter. In this version the maximum is 3999.
     * If higher values are required, basic Roman numerals should be added to the list of numerals in the <code>NumberConverter</code> class.
     */
    private int arabicMaxValue;

    /**
     * Arabic number entered by the user, it becomes saved as <code>arabicNumber</code> only after successful validation.
     */
    private int arabicNumber;

    /**
     * Sets the maximum and minimum value that the user can enter.
     */
    public NumberValidator() {
        arabicMaxValue = 3999;
        arabicMinValue = 1;
    }

    /**
     * Checks if the data provided by the user is in the correct range.
     * @param data first execution parameter
     * @throws InvalidDataException if the parameter is not an integer in the range of 1-3999
     */
    public void isDataValid(String data) throws InvalidDataException {
        int inputDataInt = Integer.parseInt(data);
        if ((inputDataInt < arabicMinValue) || (inputDataInt > arabicMaxValue)) {
            throw new InvalidDataException();
        }
        arabicNumber = inputDataInt;
    }

    /**
     * Returns correct Arabic already checked in the <code>isDataValid</code> method.
     * @return valid Arabic number
     */
    public int getArabicNumber() {
        return arabicNumber;
    }
}
