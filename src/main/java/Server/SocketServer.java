package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Klasse for å opprette server
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class SocketServer {

    private ServerSocket serverSocket;

    /**
     * Oppretter selve serveren
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
