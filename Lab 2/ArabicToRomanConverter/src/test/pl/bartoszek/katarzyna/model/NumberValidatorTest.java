package test.pl.bartoszek.katarzyna.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bartoszek.katarzyna.exception.InvalidDataException;
import pl.bartoszek.katarzyna.model.NumberValidator;

/**
 * NumberValidator tester
 * This tester checks if the number validation works correctly.
 * Tests include a valid value (from the range), incorrect value (out of the range),
 * minimum extreme value (1) and maximum extreme value (3999).
 *
 * @author Kastarzyna Bartoszek
 * @version 1.0
 */

public class NumberValidatorTest {

    private NumberValidator numberValidator;

    @Before
    public void before() { numberValidator = new NumberValidator(); }

    @After
    public void after() {
    }

    /**
     * Method: getArabicNumber
     * Correct value
     * @throws InvalidDataException
     */
    @Test
    public void Should_SaveArabicNumber_When_DataIsValid() throws InvalidDataException {
        //Given
        String inputData = "6";

        //When
        numberValidator.isDataValid(inputData);

        //Then
        Assert.assertEquals(Integer.parseInt(inputData), numberValidator.getArabicNumber());
    }

    /**
     * Method: getArabicNumber
     * Correct minimum extreme value
     * @throws InvalidDataException
     */
    @Test
    public void Should_SaveArabicNumber_When_DataIsValidAndMinimumArabicValueWasGiven() throws InvalidDataException {
        //Given
        String inputData = "1";

        //When
        numberValidator.isDataValid(inputData);

        //Then
        Assert.assertEquals(Integer.parseInt(inputData), numberValidator.getArabicNumber());
    }

    /**
     *  Method: getArabicNumber
     *  Correct maximum extreme value
     * @throws InvalidDataException
     */
    @Test
    public void Should_SaveArabicNumber_When_DataIsValidAndMaximumArabicValueWasGiven() throws InvalidDataException {
        //Given
        String inputData = "3999";

        //When
        numberValidator.isDataValid(inputData);

        //Then
        Assert.assertEquals(Integer.parseInt(inputData), numberValidator.getArabicNumber());
    }

    /**
     *  Method: getArabicNumber
     *  Incorrect value
     * @throws InvalidDataException
     */
    @Test(expected = InvalidDataException.class)
    public void Should_ThrowInvalidDataException_When_ArabicNumberIsNotInRange() throws InvalidDataException {
        //Given
        String inputData = "-34";

        //When
        numberValidator.isDataValid(inputData);
    }
}