package Database;

import Database.DTO.DTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManager {

    private String sqlQuery;
    private DBGetConnection dbGetConnection;



    public DBManager() {
        setSqlQuery("");
    }

    public DTO getInfo(int tableName) {
        try(Connection connection = dbGetConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getSqlQuery()))
        {
            return new DTO(preparedStatement.executeQuery(), tableName);

        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return null;
    }

    public DTO getEmneByEmneKode(String emneKode) {
        setSqlQuery("SELECT id FROM subject WHERE id like " + "'" + emneKode + "'"+";");
        return getInfo(1);
    }

    public void getAllTablesInDatabase() {
        setSqlQuery("SELECT table_name as 'Tables' FROM information_schema.tables where table_schema='westerdals';");

    }

    public void getContentFromTable(String tableName) {


    }

    public void getRowsInTable(String tableName) {
        setSqlQuery("select count(*) from " + tableName);
    }

    public void findAnyResultInTable(String tableName, String columnName, String value) {
        setSqlQuery("SELECT * FROM " + tableName + " WHERE " + columnName + " LIKE " + "'" + value + "'");
    }

    public String getSqlQuery() { return sqlQuery; }

    public void setSqlQuery(String sqlQuery) { this.sqlQuery = sqlQuery; }
}
