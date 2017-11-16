package Client;

import Database.DatabaseConnection.DBConnection;
import Server.RunServer;
import Server.SocketServer;
import Utility.Util;
import org.junit.*;

import static org.junit.Assert.*;

public class ClientSocketTest {

    private DBConnection connection;
    private ClientSocket clientSocket;
    private Util util;

    /**
     * Start server and xampp to test
     */
    @Before
    public void setup() throws Exception {
        connection = new DBConnection();
        util = new Util("src/main/resources/socketdatabase.properties");
        clientSocket = new ClientSocket(util.getSocketHost(), util.getSocketIpPort());
    }

    @Test
    public void sendMessageEmptyStringToReturnWelcomeMessage() throws Exception {
        assertEquals(clientSocket.sendMessage("Choose options here"), " Welcome !\n" +
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
        assertNotNull(connection.getConnection());
    }
}