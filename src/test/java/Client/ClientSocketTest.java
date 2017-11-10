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
    public void sendMessageEmptyStringToReturnWelcomeMessage() throws Exception {
        Assert.assertEquals(clientSocket.sendMessage("Choose options here"), " Welcome !\n" +
                " You can click on the box above to select options.\n" +
                " You can choose to retrieve all teachers, topics, rooms, programs and accessibility for teachers.\n" +
                " When you select one of these options, you will get a name for these choices.\n" +
                "\n" +
                " If you would like more information about teacher, subject, room or program, you can type it in the search field.\n" +
                "\n" +
                " Enjoy !");
    }

    @Test
    public void getServerConnection() throws Exception {
        Assert.assertNotNull(connection.getConnection());
    }

}