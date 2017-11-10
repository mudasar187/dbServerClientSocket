package Database.DatabaseConnection;

import Utility.Util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;
import java.sql.SQLException;

/**
 * <p>DBConnection class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 * <p>
 * DBConnection
 * Class for connection to database
 * <p>
 * Last modified 10 november 2017
 */
public class DBConnection {

    /**
     * Get connection to database
     *
     * @return connection
     */
    public Connection getConnection() {
        Util util = new Util("src/main/resources/socketdatabase.properties");
        MysqlDataSource mysqlDataSource;

        mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setServerName(util.getHostName());
        mysqlDataSource.setUser(util.getUserName());
        mysqlDataSource.setPassword(util.getPassWord());
        mysqlDataSource.setDatabaseName(util.getDbName());
        mysqlDataSource.setPort(util.getPort());
        Connection connection = null;
        try
        {
            connection = mysqlDataSource.getConnection();

        }
        catch (SQLException se)
        {
            //se.printStackTrace();
            System.out.println("\n### Database connection error ###");
        }
        return connection;
    }
}
