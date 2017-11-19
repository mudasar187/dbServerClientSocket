package Server;

import Database.DTO.DTO;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * <p>SocketThread class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
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
     * This method receive which client is getting connected from server side
     *
     * @param clientSocket a {@link java.net.Socket} object.
     */
    public SocketThread(Socket clientSocket) {
        messageFromClientToServer = "";
        setClientSocket(clientSocket);
        theDto = new DTO();
    }


    /**
     * This method receive message from client
     *
     * @throws java.lang.Exception if any.
     */
    public void getMessageFromClient() throws Exception {
            messageFromClientToServer = input.readUTF();
            sendMessageToClient();
    }


    /**
     * This method send message to client as an object
     */
    public void sendMessageToClient() {
        try {
            // Create a new DTO object
            DTO dtoToBeSent;


            if(messageFromClientToServer.equals("exit"))
            {
                // Assign new DTO to dtoToBeSent
                dtoToBeSent = new DTO("### You are now disconnected ###");
                whileIsRunning = false;
            } else {
                System.out.println("### Sending response to client ###");
                // Assign new dto to dtoToBeSent
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
     * <p>run.</p>
     */
    public void run() {

        try {
            while(whileIsRunning) {
                input = new ObjectInputStream(clientSocket.getInputStream());
                output = new ObjectOutputStream(clientSocket.getOutputStream());
                getMessageFromClient();
            }
            System.out.println("\n\n### Client is disconnecting ###");
            input.close();
            output.close();
            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
