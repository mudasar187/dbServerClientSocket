package Server;

import Database.DTO.DTO;
import Database.DTO.DTOManager;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketThread implements Runnable {

    private Socket clientSocket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ThreadManager threadManager = new ThreadManager();
    private String messageFromClientToServer;
    private boolean whileIsRunning = true;


    /**
     * Oppretter en socket, og connecter til server
     * @param clientSocket
     */
    public SocketThread(Socket clientSocket) {
        messageFromClientToServer = "";
        setClientSocket(clientSocket);

    }


    /**
     * Mottar beskjed fra client å sender beskjed til send metoden
     */
    public void getMessageFromClient() {
        try {
            messageFromClientToServer = input.readUTF();
            System.out.println("message from client: " + messageFromClientToServer);
            sendMessageToClient();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    /**
     * Denne metoden sender message som et objekt til client fra thread
     */
    public void sendMessageToClient() {
        try {
            DTOManager dtoManager;
            if(messageFromClientToServer.equals("exit"))
            {
                dtoManager = new DTOManager(new DTO("You are now disconnected"));
                whileIsRunning = false;
            } else {
                //Når du har skrevet parsing på client side så bruker du dto-en som er kommentert vekk istedenfor.
                dtoManager = new DTOManager(threadManager.getInformationFromDataBase(messageFromClientToServer));
                if(dtoManager.getDto() == null) {
                    dtoManager = new DTOManager(new DTO("Test......"));
                }

            }
            output.writeObject(dtoManager);
            output.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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
            System.out.println("Client is disconnecting");
            input.close();
            output.close();
            clientSocket.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
