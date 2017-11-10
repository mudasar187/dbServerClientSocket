package Utility;

import org.junit.Test;

import static org.junit.Assert.*;

public class UtilTest {

    Util util = new Util("src/test/resources/testSocketdatabase.properties");
    Util testUtil;

    @Test
    public void testGetAllSettings() throws Exception {

        String hostname = util.getHostName();
        String dbName = util.getDbName();
        String userName = util.getUserName();
        String passWord = util.getPassWord();
        int port = util.getPort();
        String socketHost = util.getSocketHost();
        int socketPort = util.getSocketIpPort();


        assertEquals("localhost", hostname);
        assertEquals("westerdals", dbName);
        assertEquals("admin", userName);
        assertEquals("root", passWord);
        assertEquals(3306, port);
        assertEquals("localhost", socketHost);
        assertEquals(9999, socketPort);

    }

    @Test
    public void testUtilIfEmptyStringInParameter()throws Exception {

       testUtil = new Util("");

       assertNotNull(testUtil);
    }

    @Test
    public void testUtilIfNullInParameter() throws Exception {

        testUtil = new Util(null);

        assertNotNull(testUtil);
    }


}