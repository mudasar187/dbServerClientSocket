package Utility;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * <p>Util class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class Util {

    /**
     * Connection metadata
     */
    private String hostName;
    private String dbName;
    private String userName;
    private String passWord;
    private int port;
    private String socketHost;
    private int socketIpPort;
    private Properties propFile;

    /**
     * Default constructor
     *
     * @param properties a {@link java.lang.String} object.
     */
    public Util(String properties)
    {

        try
        {
            propFile = new Properties();
            FileInputStream fileInputStream = new FileInputStream(properties);
            propFile.load(fileInputStream);
            setUserName(propFile.getProperty("userName"));
            setHostName(propFile.getProperty("hostName"));
            setDbName(propFile.getProperty("dbName"));
            setPassWord(propFile.getProperty("passWord"));
            setPort(Integer.parseInt(propFile.getProperty("port")));
            setSocketHost(propFile.getProperty("socketHost"));
            setSocketIpPort(Integer.parseInt(propFile.getProperty("socketIpPort")));
            fileInputStream.close();
        }
        catch (IOException se)
        {
            System.out.println("### Properties file not found ###");

        }
        catch (NullPointerException n)
        {
            System.out.println("### Properties file not added ###");
        }
    }

    /**
     * <p>Getter for the field <code>hostName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getHostName() { return hostName; }

    private void setHostName(String hostName) { this.hostName = hostName; }

    /**
     * <p>Getter for the field <code>dbName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDbName() { return dbName; }

    private void setDbName(String dbName) { this.dbName = dbName; }

    /**
     * <p>Getter for the field <code>userName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUserName() { return userName; }

    private void setUserName(String userName) { this.userName = userName; }

    /**
     * <p>Getter for the field <code>passWord</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPassWord() { return passWord; }

    private void setPassWord(String passWord) { this.passWord = passWord; }

    /**
     * <p>Getter for the field <code>port</code>.</p>
     *
     * @return a int.
     */
    public int getPort() { return port; }

    private void setPort(int port) { this.port = port; }

    /**
     * <p>Getter for the field <code>socketHost</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSocketHost() { return socketHost; }

    private void setSocketHost(String socketHost) { this.socketHost = socketHost; }

    /**
     * <p>Getter for the field <code>socketIpPort</code>.</p>
     *
     * @return a int.
     */
    public int getSocketIpPort() { return socketIpPort; }

    private void setSocketIpPort(int socketIpPort) { this.socketIpPort = socketIpPort; }
}
