package Server;

import Utility.Util;

/**
 * <p>ServerRun class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class ServerRun {

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
