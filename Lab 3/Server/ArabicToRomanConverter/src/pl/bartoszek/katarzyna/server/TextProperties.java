package pl.bartoszek.katarzyna.server;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * The class is responsible for creating the file with extension .properties for the server.
 * Port number and address needed to connect the client with the server are saved in this file.
 * This class saves and reads data from the file.
 *
 * @author Katarzyna Bartoszek
 * @version 1.0
 */
public class TextProperties {

    /**
     * Port number
     */
    private int port = 0;

    /**
     * Server address
     */
    private String address = new String();

    /**
     * Public constructor that calls the methods responsible for saving and reading properties.
     */
    public TextProperties() {
        saveProperties();
        readProperties();
    }

    /**
     * Allows to get the port number.
     * @return port number
     */
    public int getPort() {
        return port;
    }

    /**
     * Allows to get the address.
     * @return <code>String</code> address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the port number.
     * @param port port number from the "Properties" file
     */
    private void setPort(int port) {
        this.port = port;
    }

    /**
     * Sets the address.
     * @param address address from the "Properties" file
     */
    private void setAddress(String address) {
        this.address = address;
    }

    /**
     * Reads properties.
     */
    void readProperties(){
        Properties properties = new Properties();
        try (FileInputStream in = new FileInputStream(".properties")) {
            properties.load(in);
            this.setPort(Integer.parseInt(properties.getProperty("port")));
            this.setAddress(properties.getProperty("address"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Sets and saves properties.
     */
    private void saveProperties() {
        Properties properties = new Properties();
        properties.setProperty("port", "1234");
        properties.setProperty("address", "127.0.0.1");
        try (FileOutputStream out = new FileOutputStream(".properties")) {
            properties.store(out, "--Config--");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
