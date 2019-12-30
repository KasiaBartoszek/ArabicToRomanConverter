package pl.bartoszek.katarzyna.client.protocol;

import pl.bartoszek.katarzyna.client.view.ClientView;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class is responsible for running the server.
 * Waits for commands from the server. Once it gets them, specific actions are taken.
 * If CONVERT ACCEPTED then asks the client to provide some number.
 * If HELP then shows the help.
 * If EXIT then exits the project.
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
     * Sets input and output streams.
     * @param in input data stream
     * @param out output data stream
     */
    public ConverterProtocol(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }

    /**
     * Runs the project. Checks the data entered by the client. Depends on the command, takes different actions.
     * Gets responses from the server (CONVERT ACCEPTED, NUMBER RECEIVED, INVALID REQUEST, HELP, EXIT).
     * If CONVERT ACCEPTED then asks for the number.
     * If HELP then shows the help.
     * If EXIT then exits the project.
     */
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            out.writeUTF(command);
            out.flush();
            while (true) {
                command = in.readUTF();
//                ClientView.printServerResponse(command);
                switch (command) {
                    case "CONVERT ACCEPTED": {
                        ClientView.enterTheNumber();
                        int number = scanner.nextInt();
                        out.writeUTF(String.valueOf(number));
                        out.flush();
                        command = in.readUTF();
                        ClientView.printServerResponse(command);
                        if (command.equals("NUMBER RECEIVED")) {
                            command = in.readUTF();
                            if (!command.contains("INVALID REQUEST. ")) {
                                ClientView.printConversionResult(number, command);
                            } else {
                                ClientView.printServerResponse(command);
                            }
                        }
                        break;
                    }

                    case "HELP": {
                        ClientView.getHelp();
                        break;
                    }

                    case "EXIT": {
                        return;
                    }

                    default: {
                        ClientView.printServerResponse(command);
                    }
                }

                command = scanner.nextLine();

                if (command.equals("")) {
                    command = scanner.nextLine();
                }
                out.writeUTF(command);
                out.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
