package test.pl.bartoszek.katarzyna.server.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.bartoszek.katarzyna.server.model.DataReader;

import java.io.ByteArrayInputStream;

/**
 * DataReader tester
 * This tester checks if the keyboard and command line data reading works correctly.
 * Both situations are considered: when command line arguments were given or not.
 * Keyboard data scanning is also tested.
 *
 * @author Kastarzyna Bartoszek
 * @version 1.0
 */
public class DataReaderTest {

    private DataReader dataReader;

    @Before
    public void before() { dataReader = new DataReader(); }

    @After
    public void after() {
    }

    /**
     * Method: readNumberFromCommandLine
     * Args exist.
     */
    @Test
    public void Should_ReturnTrue_When_ArgsExist() {
        //Given
        String[] args = new String[2];
        args[0] = "p";
        args[1] = "i";

        //When
        boolean areArgsValid = dataReader.readNumberFromCommandLine(args);

        //Then
        Assert.assertEquals(true, areArgsValid);
    }

    /**
     * Method: readNumberFromCommandLine
     * Args do not exist.
     */
    @Test
    public void Should_ReturnFalse_When_ArgsNotExist() {
        //Given
        String[] args = new String[0];

        //When
        boolean areArgsValid = dataReader.readNumberFromCommandLine(args);

        //Then
        Assert.assertEquals(false, areArgsValid);
    }

    /**
     * Method: readNumberFromUser
     * Should be equal.
     */
    @Test
    public void Should_StringsBeEqual_When_UserDataWasGiven() {
        //Given
        String data = "1";
        ByteArrayInputStream input = new ByteArrayInputStream(data.getBytes());

        //When
        System.setIn(input);
        dataReader.readNumberFromUser();

        //Then
        Assert.assertEquals(data, dataReader.getData());
    }

    /**
     * Method: readNumberFromUser
     * Should not be equal.
     */
    @Test
    public void Should_StringsNotBeEqual_When_ExpectedDataAndUserDataDiffer() {
        //Given
        String data = "1";
        ByteArrayInputStream input = new ByteArrayInputStream("2".getBytes());

        //When
        System.setIn(input);
        dataReader.readNumberFromUser();

        //Then
        Assert.assertNotEquals(data, dataReader.getData());
    }
}