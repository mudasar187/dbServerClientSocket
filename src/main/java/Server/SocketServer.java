package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>SocketServer class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class SocketServer {

    private ServerSocket serverSocket;

    /**
     * Create a server
     *
     * @param port a int.
     */
    public SocketServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {

            System.out.println("### Server is down, or port in use ###");
        }
    }


    /**
     * This method listen to client which going to the connected, create thread for each client who get connected
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
