package Client;

import Database.DatabaseConnection.DBConnection;
import Utility.Util;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientSocketTest {

    private DBConnection connection;
    private ClientSocket clientSocket;
    private Util util;

    /**
     * Start server for å kunne teste client
     */
    @Before
    public void setup() {
        connection = new DBConnection();
        util = new Util("src/main/resources/socketdatabase.properties");
        clientSocket = new ClientSocket(util.getSocketHost(), util.getSocketIpPort());
    }

    @Test
    public void sendMessage() throws Exception {
        Assert.assertEquals(clientSocket.sendMessage("Welcome"), "Welcome");
    }

    @Test
    public void getServerConnection() throws Exception {
        Assert.assertNotNull(connection.getConnection());
    }

}