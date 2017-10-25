package Database.Tables;

public class getAllTables {

    private String tableName;

    public getAllTables(String tableName) {
        setTableName(tableName);
    }

    private void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return this.tableName;
    }

    public String toString() {
        return "\n Table: " + getTableName();
    }

}
