package pl.bartoszek.katarzyna.server;

import pl.bartoszek.katarzyna.server.protocol.ConverterProtocol;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

/**
 * Responsible for running the server.
 * Sets and saves the port number and address and enables to connect with the client.
 * The port number and server address are saved in the file with extension .properties.
 * Both files (for the client and the server) need to be the same.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class Server {

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
     * Server socket created in the method run().
     */
    private ServerSocket server;

    /**
     * Input data stream
     */
    private DataInputStream in;

    /**
     * Output data stream
     */
    private DataOutputStream out;

    /**
     * Reads port number from the file.
     */
    public Server() {
       TextProperties textProperties = new TextProperties();
       this.port = textProperties.getPort();
    }

    /**
     * Runs the protocol. Sets the input and output. Closes streams and socket after the task is done.
     */
    public void run() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started.");
            socket = server.accept();
            System.out.println("Server accepted the client.");
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));

            ConverterProtocol converterProtocol = new ConverterProtocol(in,out);
            converterProtocol.run();

            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
