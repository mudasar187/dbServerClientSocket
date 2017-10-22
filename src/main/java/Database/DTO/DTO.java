package Database.DTO;

import java.io.Serializable;
import java.sql.ResultSet;

public class DTO implements Serializable {

    private ResultSet resultSet;
    private String info = "";
    private int tableNumber;

    public DTO(){}

    public DTO(String info) {
        setInfo(info);
    }

    public DTO(ResultSet resultSet, int tableNumber) {
        setResultSet(resultSet);
        setTableNumber(tableNumber);
    }

    public ResultSet getResultSet() { return resultSet; }

    public void setResultSet(ResultSet resultSet) { this.resultSet = resultSet; }

    public String getInfo() { return info; }

    public void setInfo(String info) { this.info = info; }

    public int getTableNumber() { return tableNumber; }

    public void setTableNumber(int tableNumber) { this.tableNumber = tableNumber; }
}
