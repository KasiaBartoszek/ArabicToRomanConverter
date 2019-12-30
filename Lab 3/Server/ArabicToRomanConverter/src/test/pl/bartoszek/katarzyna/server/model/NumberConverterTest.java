package test.pl.bartoszek.katarzyna.server.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import pl.bartoszek.katarzyna.server.model.NumberConverter;

/**
 * NumberConverter tester
 * This tester checks if the Arabic to Roman number conversion works correctly.
 * In the <code>NumberConverter</code> class the input number is always valid,
 * because it has been already checked in the <code>NumberValidator</code> class.
 * Four situations are considered: correct value (in two ways - in the first test results should be equal,
 * in the second test results should be different) and both extreme values (1 and 3999).
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class NumberConverterTest {

    private NumberConverter numberConverter;

    @Before
    public void before() {
        numberConverter = new NumberConverter();
    }

    @After
    public void after() {
    }

    /**
     * Method: convertFromArabicToRoman
     * Should be equal.
     */
    @Test
    public void Should_ReturnCorrectRomanNumber_When_ArabicNumberCorrect() {
        //Given
        int arabicNumber = 34;

        //When
        String romanNumber = numberConverter.convertFromArabicToRoman(arabicNumber);

        //Then
        Assert.assertEquals("XXXIV", romanNumber);
    }

    /**
     * Method: convertFromArabicToRoman
     * Should not be equal.
     */
    @Test
    public void Should_NotBeEqual_When_ExpectedAndActualValueDiffer() {
        //Given
        int arabicNumber = 34;

        //When
        String romanNumber = numberConverter.convertFromArabicToRoman(arabicNumber);

        //Then
        Assert.assertNotEquals("XXV", romanNumber);
    }

    /**
     * Method: convertFromArabicToRoman
     * Correct minimum extreme value
     */
    @Test
    public void Should_ReturnCorrectRomanNumber_When_MinimumArabicNumberCorrect() {
        //Given
        int arabicNumber = 1;

        //When
        String romanNumber = numberConverter.convertFromArabicToRoman(arabicNumber);

        //Then
        Assert.assertEquals("I", romanNumber);
    }

    /**
     * Method: convertFromArabicToRoman
     * Correct maximum extreme value
     */
    @Test
    public void Should_ReturnCorrectRomanNumber_When_MaximumArabicNumberCorrect() {
        //Given
        int arabicNumber = 3999;

        //When
        String romanNumber = numberConverter.convertFromArabicToRoman(arabicNumber);

        //Then
        Assert.assertEquals("MMMCMXCIX", romanNumber);
    }
}
