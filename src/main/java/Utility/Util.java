package Utility;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
     * @param properties, file path
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

    public String getHostName() { return hostName; }

    private void setHostName(String hostName) { this.hostName = hostName; }

    public String getDbName() { return dbName; }

    private void setDbName(String dbName) { this.dbName = dbName; }

    public String getUserName() { return userName; }

    private void setUserName(String userName) { this.userName = userName; }

    public String getPassWord() { return passWord; }

    private void setPassWord(String passWord) { this.passWord = passWord; }

    public int getPort() { return port; }

    private void setPort(int port) { this.port = port; }

    public String getSocketHost() { return socketHost; }

    private void setSocketHost(String socketHost) { this.socketHost = socketHost; }

    public int getSocketIpPort() { return socketIpPort; }

    private void setSocketIpPort(int socketIpPort) { this.socketIpPort = socketIpPort; }
}
