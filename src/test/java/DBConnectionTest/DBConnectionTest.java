package DBConnectionTest;

import Database.DatabaseConnection.DBConnection;
import Utility.Util;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class DBConnectionTest {

    DBConnection dbConnection = new DBConnection();

    @Test
    public void getConnection() throws Exception {

        Connection connection = dbConnection.getConnection();

        assertNotNull(connection);
    }

}