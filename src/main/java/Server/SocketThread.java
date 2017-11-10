package Server;

import Database.DTO.DTO;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <p>SocketThread class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class SocketThread implements Runnable {

    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ThreadManager threadManager = new ThreadManager();
    private String messageFromClientToServer;
    private boolean whileIsRunning = true;
    private DTO theDto;

    /**
     * Denne tar imot hvilken klient som kobles til fra server siden
     *
     * @param clientSocket a {@link java.net.Socket} object.
     */
    public SocketThread(Socket clientSocket) {
        messageFromClientToServer = "";
        setClientSocket(clientSocket);
        theDto = new DTO();
    }


    /**
     * Mottar beskjed fra client å sender beskjed til send metoden
     */
    public void getMessageFromClient() {
        try {
            messageFromClientToServer = input.readUTF();
            sendMessageToClient();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Denne metoden sender message som et objekt til client
     */
    public void sendMessageToClient() {
        try {
            //Lager nytt object av DTO
            DTO dtoToBeSent;


            if(messageFromClientToServer.equals("exit"))
            {
                //Assigner ny DTO til dtoToBeSent
                dtoToBeSent = new DTO("### You are now disconnected");
                whileIsRunning = false;
            } else {
                System.out.println("### Sending response to client ...");
                //Assigner ny dto til dtoToBeSent
                dtoToBeSent = threadManager.getInformationFromDataBase(messageFromClientToServer);
            }
            output.writeObject(dtoToBeSent);
            output.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * <p>Setter for the field <code>clientSocket</code>.</p>
     *
     * @param clientSocket a {@link java.net.Socket} object.
     */
    public void setClientSocket(Socket clientSocket) {

        this.clientSocket = clientSocket;
    }


    /**
     * Denne kjøres selve tråden
     */
    public void run() {

        try {
            while(whileIsRunning) {
                input = new ObjectInputStream(clientSocket.getInputStream());
                output = new ObjectOutputStream(clientSocket.getOutputStream());
                getMessageFromClient();
            }
            System.out.println("### Client is disconnecting ...");
            input.close();
            output.close();
            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
