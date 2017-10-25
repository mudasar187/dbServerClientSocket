package Database.DatabaseConnection;

import Utility.Util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Mudasar Ahmad
 * @version 1.0
 * <p>
 * DBConnection
 * Class for connection to database
 * <p>
 * Last modified 19 october 2017
 */


public class DBGetConnection implements AutoCloseable {

    private Connection theConnection;

    public DBGetConnection() {
        getConnection();
    }

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
        mysqlDataSource.setDatabaseName(util.getDbName());
        Connection connection = null;
        try
        {
            setTheConnection(mysqlDataSource.getConnection());

        }
        catch (SQLException se)
        {
            se.printStackTrace();
            System.out.println("\n### Connection error ###");
        }
        return getTheConnection();
    }

    private void setTheConnection(Connection theConnection) {
        this.theConnection = theConnection;
    }

    public Connection getTheConnection() {
        return this.theConnection;
    }

    @Override
    public void close() throws Exception {
        getTheConnection().close();
    }
}
