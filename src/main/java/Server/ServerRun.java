package Server;

import Utility.Util;

public class ServerRun {

    public static void main(String[] args) {

        Util util = new Util("src/main/resources/socketdatabase.properties");
        SocketServer socketServer = new SocketServer(util.getSocketIpPort());
        socketServer.serverListener();
    }


}
