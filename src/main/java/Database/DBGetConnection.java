package Database;

import Utility.Util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Mudasar Ahmad
 * @version 1.0
 * <p>
 * DBConnection
 * Class for connection to database
 * <p>
 * Last modified 19 october 2017
 */


public class DBGetConnection {


    /**
     * Get connection to database
     *
     * @return connection
     */
    public Connection getConnection() {

        Util util = new Util("src/main/resources/socketdatabase.properties");
        MysqlDataSource mysqlDataSource = new MysqlDataSource();

        mysqlDataSource.setServerName(util.getHostName());
        mysqlDataSource.setUser(util.getUserName());
        mysqlDataSource.setPassword(util.getPassWord());
        mysqlDataSource.setPort(util.getPort());
        Connection connection = null;
        try
        {
            connection = mysqlDataSource.getConnection();

        }
        catch (SQLException se)
        {
            se.printStackTrace();
            System.out.println("\n### Connection error ###");
        }
        return connection;
    }
}
