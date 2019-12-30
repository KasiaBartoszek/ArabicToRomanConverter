package pl.bartoszek.katarzyna.server.model;

import java.util.Scanner;

/**
 * Reads data from the command line or from the keyboard after asking the user to enter a number.
 *
 * @author Katarzyna Bartoszek
 * @version 1.2
 */
public class DataReader {

    /**
     * Input data entered by the user from the command line or the keyboard.
     */
    private String data;

    /**
     * Returns input data entered by the user.
     * @return data provided by the user
     */
    public String getData() { return data; }

    /**
     * Saves input data as <code>data</code>.
     * @param data first execution parameter
     */
    private void setData(String data) {
        this.data = data;
    }

    /**
     * Checks if the number was entered in the command line and then saves it as the <code>data</code> parameter.
     * @param args execution parameters
     * @return <code>true</code> if the number was entered in the command line
     *         <code>false</code> otherwise
     */
    public boolean readNumberFromCommandLine(String... args) {
        if (args.length != 0) {
            setData(args[0]);
            return true;
        }
        return false;
    }

    /**
     * Reads user data from the keyboard.
     */
    public void readNumberFromUser() {
        Scanner scan = new Scanner(System.in);
        data = scan.nextLine();
    }
}