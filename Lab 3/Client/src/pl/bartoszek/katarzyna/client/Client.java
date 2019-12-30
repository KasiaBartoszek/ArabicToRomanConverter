package pl.bartoszek.katarzyna.client;

import pl.bartoszek.katarzyna.client.protocol.ConverterProtocol;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

/**
 * Responsible for running the client.
 * Sets and saves the port number and address and enables to connect with the server.
 *  The port number and server address are saved in the file with extension .properties.
 *  Both files (for the client and the server) need to be the same.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class Client {

    private Properties properties;
    /**
     * Port number read from the "Properties" file.
     */
    private int port;

    /**
     * Socket that consists of address and port number.
     */
    private Socket socket;

    /**
     * Input data stream
     */
    private DataInputStream in;

    /**
     * Output data stream
     */
    private DataOutputStream out;

    /**
     * Address read from the "Properties" file.
     */
    private String address;

    /**
     * Sets the port number and address according to some data provided in the "Properties" file.
     */
    public Client() {

        TextProperties textProperties = new TextProperties();
        textProperties.saveProperties();
        this.port = textProperties.getPort();
        this.address = textProperties.getAddress();
    }

    /**
     * Runs the protocol. Sets the input and output. Closes streams and socket after the task is done.
     */
    public void run() {
        try {
            socket = new Socket(address, port);

            System.out.println("Client connected.");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            ConverterProtocol converterProtocol = new ConverterProtocol(in, out);
            converterProtocol.run();

            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
