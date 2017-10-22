package Client;

import Database.DBGetObject;
import Database.DTO.DTOManager;

import java.io.*;
import java.net.Socket;

public class ClientSocket {

    private Socket serverConnection;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private DBGetObject dbGetObject;

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
                System.out.println("Sender melding");
                output.writeUTF(message);
                output.flush();
                return getMessage();
            }
        } catch (Exception e) {
            System.out.println("Cannot send message");
        }

        return "You must enter some value";

    }


    /**
     * Samme som over, bare får input
     */
    private String getMessage() throws Exception {

        input = new ObjectInputStream(getServerConnection().getInputStream());
        System.out.println("Skal få input fra serveren");

        DTOManager dtoManager = (DTOManager) input.readObject();
        if (dtoManager.getDto().getInfo().equals("")) {
//            new DBGetObject()
            dbGetObject = new DBGetObject();
            return dbGetObject.checkWichTypeOfTableIsIt(dtoManager);
            //return "Verdien til parsing metoden";
        } else {
            return dtoManager.getDto().getInfo();
        }
    }


    /**
     * Generet settere og gettere
     * @return
     */
    public Socket getServerConnection() { return serverConnection; }

    public void setServerConnection(Socket serverConnection) { this.serverConnection = serverConnection; }

    public ObjectOutputStream getOutput() { return output; }

    public void setOutput(ObjectOutputStream output) { this.output = output; }

    public ObjectInputStream getInput() { return input; }

    public void setInput(ObjectInputStream input) { this.input = input; }
}
