package test.pl.bartoszek.katarzyna.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bartoszek.katarzyna.model.Numeral;

/**
 * Numeral tester
 * This tester checks if the method <code>toString()</code> works correctly.
 * The test result should be equal when the expected value and the actual value are the same.
 * If expected and actual Numerals are different, the test should check that they are not equal.
 * Extreme values (1 and 3999) are also taken into account.
 *
 * @author Kastarzyna Bartoszek
 * @version 1.0
 */

public class NumeralTest {

    private Numeral numeral;

    @Before
    public void before() { numeral = new Numeral("II", 2); }

    @After
    public void after() {
    }

    /**
     * Method: toString
     * Correct value
     * Should be equal.
     */
    @Test
    public void Should_ReturnCorrectNumeral_When_CorrectArabicAndRomanValuesGiven() {
        //Given
        String expectedString = "Numeral{" +
                "romanValue='" + "II" + '\'' +
                ", arabicValue=" + 2 +
                '}';

        //When
        String actualString = numeral.toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Method: toString
     * Correct minimum extreme value
     */
    @Test
    public void Should_ReturnCorrectNumeral_When_MinimumExtremeArabicValueGiven() {
        //Given
        String expectedString = "Numeral{" +
                "romanValue='" + "I" + '\'' +
                ", arabicValue=" + 1 +
                '}';

        //When
        numeral = new Numeral("I", 1);
        String actualString = numeral.toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Method: toString
     * Correct maximum extreme value
     */
    @Test
    public void Should_ReturnCorrectNumeral_When_MaximumExtremeArabicValueGiven() {
        //Given
        String expectedString = "Numeral{" +
                "romanValue='" + "MMMCMXCIX" + '\'' +
                ", arabicValue=" + 3999 +
                '}';

        //When
        numeral = new Numeral("MMMCMXCIX", 3999);
        String actualString = numeral.toString();

        //Then
        Assert.assertEquals(expectedString, actualString);
    }

    /**
     * Method: toString
     * Correct value
     * Should not be equal.
     */
    @Test
    public void Should_NotBeEqual_When_ExpectedAndActualStringDiffer() {
        //Given
        String expectedString = "Numeral{" +
                "romanValue='" + "III" + '\'' +
                ", arabicValue=" + 3 +
                '}';

        //When
        String actualString = numeral.toString();

        //Then
        Assert.assertNotEquals(expectedString, actualString);
    }
}