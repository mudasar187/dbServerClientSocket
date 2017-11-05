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
 * Last modified 05 november 2017
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
    public ClientSocket(String host, int port) {
        try {
            setServerConnection(new Socket(host, port));
        } catch (Exception e) {
            System.out.println("### Cannot find any server to connect!");
        }
    }

    /**
     *
     * Oppretter objekt av outputstream for å kunne sende flere meldinger
     *
     * @param message a {@link java.lang.String} object.
     * @return a {@link java.lang.String} object.
     */
    public String sendMessage(String message) {
        try {
            output = new ObjectOutputStream(getServerConnection().getOutputStream());
            if(message != null)
            {
                System.out.println("### Client sending message to server ...");
                output.writeUTF(message);
                output.flush();
                return getMessage();
            }
        } catch (Exception e) {
            System.out.println("### Client cannot send message to server ...");
        }

        return "### You must enter some value";

    }



    /**
     * Samme som over, bare får input
     */
    private String getMessage() throws Exception {

        input = new ObjectInputStream(getServerConnection().getInputStream());
        System.out.println("### Getting respons from server ...");

        DTO dto = (DTO) input.readObject();

        if (dto.getParsedString().equals("")) {
            return "### Could not find anything ...";
        } else {
            return dto.getParsedString();
        }


    }


    /**
     * Generet settere og gettere
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
