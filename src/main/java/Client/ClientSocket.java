package Client;

import Database.DTO.DTO;

import java.io.*;
import java.net.Socket;

public class ClientSocket {

    private Socket serverConnection;
    private ObjectOutputStream output;
    private ObjectInputStream input;

    /**
     * Denne oppretter connection for client til server
     */
    public ClientSocket(String host, int port) {
        try {
            setServerConnection(new Socket(host, port));
        } catch (Exception e) {
            System.out.println("### Cannot find any server to connect!");
        }
    }

    /**
     * Oppretter objekt av outputstream for å kunne sende flere meldinger
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
     * @return
     */
    public Socket getServerConnection() { return serverConnection; }

    public void setServerConnection(Socket serverConnection) { this.serverConnection = serverConnection; }

}
