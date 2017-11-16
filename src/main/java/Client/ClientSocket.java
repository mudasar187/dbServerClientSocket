package Client;

import Database.DTO.DTO;

import java.io.*;
import java.net.Socket;

/**
 * <p>ClientSocket class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class ClientSocket {

    private Socket serverConnection;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    /**
     * Setting up connection for client to server
     *
     * @param host a {@link java.lang.String} object.
     * @param port a int.
     */
    public ClientSocket(String host, int port) throws Exception {
            setServerConnection(new Socket(host, port));
    }

    /**
     *
     * This method send message from client to server by creating an object of ObjectOutputStream
     *
     * @param message a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String sendMessage(String message) {
        try {
            output = new ObjectOutputStream(getServerConnection().getOutputStream());
            if(message != null)
            {
                System.out.println("### Client sending message to server ###");
                output.writeUTF(message);
                output.flush();

                // Answer from server
                return getMessage();
            }
        } catch (Exception e) {
            System.out.println("### Client cannot send message to server ###");
        }
        // If parameter is empty string
        return "### You must enter some value ###";

    }


    /**
     *
     * This method receive answer from server by creating an object of ObjectInputStream
     *
     * @return dto parsed object
     * @throws Exception
     */
    private String getMessage() throws Exception {

        input = new ObjectInputStream(getServerConnection().getInputStream());
        System.out.println("### Getting respons from server ###\n");

        DTO dto = (DTO) input.readObject();

        if (dto.getParsedString().equals("")) {
            // Return this message if no value found
            return "### Could not find anything ###";
        } else {
            // Return parsed value
            return dto.getParsedString();
        }


    }


    /**
     * <p>Getter for the field <code>serverConnection</code>.</p>
     *
     * @return a {@link java.net.Socket} object.
     */
    public Socket getServerConnection() { return serverConnection; }

    /**
     * <p>Setter for the field <code>serverConnection</code>.</p>
     *
     * @param serverConnection a {@link java.net.Socket} object.
     */
    public void setServerConnection(Socket serverConnection) { this.serverConnection = serverConnection; }

}
