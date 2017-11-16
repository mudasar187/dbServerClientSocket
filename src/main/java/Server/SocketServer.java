package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <p>SocketServer class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 * <p>
 * Last modified 10 november 2017
 */
public class SocketServer {

    private ServerSocket serverSocket;

    /**
     * Create a server
     *
     * @param port a int.
     */
    public SocketServer(int port) throws Exception {

        serverSocket = new ServerSocket(port);
    }


    /**
     * This method listen to client who going to be connected, create thread for each client who get connected
     */
    public void serverListener() {

        System.out.println("### Server is started ###");
        while (true)
        {
            try
            {
                Socket clientConnection = serverSocket.accept();
                System.out.println("### Client is connected ###");
                SocketThread socketThread = new SocketThread(clientConnection);
                new Thread(socketThread).start();
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
