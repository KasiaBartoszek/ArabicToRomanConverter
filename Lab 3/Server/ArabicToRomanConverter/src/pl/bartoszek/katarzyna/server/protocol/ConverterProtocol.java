package pl.bartoszek.katarzyna.server.protocol;

import pl.bartoszek.katarzyna.server.controller.ConverterController;
import pl.bartoszek.katarzyna.server.exception.InvalidDataException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * This class is responsible for running the server.
 * Waits for commands from the server. Once it gets them, specific actions are taken.
 * If CONVERT then asks the client to provide some number.
 * If HELP then shows the help.
 * If EXIT then exits the project.
 * In case of unknown instruction shows the available instructions.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class ConverterProtocol {

    /**
     * Input data stream
     */
    private DataInputStream in;

    /**
     * Output data stream
     */
    private DataOutputStream out;

    /**
     * Instance of Converter Controller class.
     * Used in the method <code>run()<code> to convert the number.
     */
    private ConverterController converterController;

    /**
     *
     * @param in input data
     * @param out output data
     */
    public ConverterProtocol(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
        converterController = new ConverterController();
    }

    /**
     * Runs the project. Checks the data entered by the client. Depends on the command, takes different actions.
     * Gets responses from the client (CONVERT, HELP, EXIT, an Arabic number or unknown instruction).
     * If CONVERT then asks for the number (CONVERT ACCEPTED).
     * If the number was given then converts it into a Roman number (NUMBER RECEIVED).
     * If unknown instruction was given then shows the possible instructions.
     */
    public void run() {
        while (true) {
            try {
                String command = in.readUTF();
                System.out.println("COMMAND FROM THE CLIENT: "+ command);

                switch (command) {
                    case "CONVERT": {
                        out.writeUTF("CONVERT ACCEPTED");
                        out.flush();
                        command = in.readUTF();
                        out.writeUTF("NUMBER RECEIVED");
                        out.flush();
                        String romanNumber = converterController.convertData(command);
                        out.writeUTF(romanNumber);
                        out.flush();
                        break;
                    }
                    case "HELP": {
                        out.writeUTF("HELP");
                        out.flush();
                        break;
                    }
                    case "EXIT": {
                        out.writeUTF("EXIT");
                        out.flush();
                        return;
                    }
                    default: {
                        out.writeUTF("Unknown instruction.\n"
                                + "Please enter one of the following commands:\n"
                                + "CONVERT - to convert an Arabic number to Roman number\n"
                                + "HELP - to get help\n"
                                + "EXIT - to quit");
                        out.flush();
                        break;
                    }
                }
            } catch (InvalidDataException e) {
                try {
                    out.writeUTF("INVALID REQUEST. " + e.getMessage());
                    out.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println(ex.getMessage());
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }

    }

}
