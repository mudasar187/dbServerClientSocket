package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Klasse for å opprette server
 */

public class SocketServer {

    private ServerSocket serverSocket;
    private DataOutputStream output;
    private DataInputStream input;

    /**
     * Oppretter selve serveren
     * @param port
     */
    public SocketServer(int port) {
        try {
            serverSocket = new ServerSocket(port);

        } catch (Exception e) {

            System.out.println("### Server is down, or port in use ###");
        }
    }


    /**
     * Lytter til klient som skal kobles til
     */
    public void serverListener() {

        System.out.println("### Server is started !");
        while(true) {
            try {
                Socket clientConnection = serverSocket.accept();
                System.out.println("### Client is connected !");
                SocketThread socketThread = new SocketThread(clientConnection);
                new Thread(socketThread).start();
            } catch (IOException e) {

            }
        }
    }
}
