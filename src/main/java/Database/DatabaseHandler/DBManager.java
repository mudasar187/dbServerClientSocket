package Database.DatabaseHandler;

import Database.DTO.DTOParser;
import Database.DTO.DTO;
import Database.DatabaseConnection.DBGetConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBManager {

    private String sqlQuery;
    private DTOParser dbObject;
    private DTO theReturninDTO;


    public DBManager() {
        setSqlQuery("");
        theReturninDTO = new DTO();
        dbObject = new DTOParser();
    }

    public DTO getInfo(int tableName) {
        System.out.println("I should get here");
        try (DBGetConnection theConnection = new DBGetConnection(); PreparedStatement statement = theConnection.getConnection().prepareStatement(getSqlQuery())) {
            System.out.println("I'm getting here");
            ResultSet res = statement.executeQuery();
            //PARSE HER
            String parsedString = dbObject.parseResults(res, tableName);

            System.out.println("RESULTS: " + parsedString);

            theReturninDTO = new DTO(parsedString);
        } catch (Exception e) {
            System.out.println("Exception!!!");
            System.out.println("Error occured: " + e.getMessage());
        }
        return theReturninDTO;

    }



   // private String [] comboBox = {"Choose your table", "Lectures", "Subject", "Room", "Program", "Semester", "Availability"};

    public DTO getTables() {
        setSqlQuery("SELECT table_name FROM information_schema.tables where table_schema = 'westerdals'");
        return getInfo(7);
    }

    public DTO getLectures() {
        setSqlQuery("SELECT id, firstName, lastName, email FROM lecturer");
        return getInfo(3);
    }

    public DTO getForeleserByName(String foreleserNavn) {
        setSqlQuery("SELECT id, firstname, lastName, email FROM lecturer WHERE firstname = " + "'" + foreleserNavn + "'");
        return getInfo(3);
    }

    /* ØVING!
    public DTO getEmneByEmneKode(String emneKode) {
        setSqlQuery("SELECT id, name, participants FROM subject WHERE id like " + "'" + emneKode + "'"+";");
        System.out.println("SQL!!!!!: " + getSqlQuery());
        return getInfo(6);
    }
    */



    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
}
