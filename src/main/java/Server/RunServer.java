package Server;

import Utility.Util;

/**
 * <p>ServerRun class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class RunServer {

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     */
    public static void main(String[] args) {

        Util util = new Util("src/main/resources/socketdatabase.properties");
        SocketServer socketServer = new SocketServer(util.getSocketIpPort());
        socketServer.serverListener();
    }


}
