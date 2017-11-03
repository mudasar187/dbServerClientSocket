package Database.DatabaseHandler;

import Database.DTO.DTOParser;
import Database.DTO.DTO;
import Database.DatabaseConnection.DBConnection;
import Utility.Util;

import java.sql.*;


public class DBManager {

    private String sqlQuery;
    private DTOParser dbObject;
    private DTO theReturninDTO;
    private Util util;

    public DBManager() {
        setSqlQuery("");
        theReturninDTO = new DTO();
        dbObject = new DTOParser();
        util = new Util("src/main/resources/socketdatabase.properties");
    }

    public DTO getInfo(int tableNumber) {
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement statement = connection.prepareStatement(getSqlQuery())) {
            ResultSet res = statement.executeQuery();
            //PARSE HER
            String parsedString = dbObject.parseResults(res, tableNumber);

            theReturninDTO = new DTO(parsedString);
        } catch (Exception e) {
            System.out.println("Exception!!!");
            System.out.println("Error occured: " + e.getMessage());
        }
        return theReturninDTO;

    }



   // private String [] comboBox = {"Choose your table", "Lectures", VENT -> "Subject", "Room", "Program", "Semester", "Availability"};

    public DTO getTables() {
        setSqlQuery("SELECT table_name FROM information_schema.tables where table_schema = " + "'" + util.getDbName() + "'");
        return getInfo(7);
    }

    public DTO getLectures() {
        setSqlQuery("SELECT firstName FROM lecturer");
        return getInfo(3);
    }

    public DTO getLecturedInfo(String lectureName) {
        setSqlQuery("SELECT id, firstName, lastName, email FROM lecturer WHERE firstName = " + "'" + lectureName + "'");
        return getInfo(3);
    }

    public DTO getAvailability() {
        setSqlQuery("SELECT availability.weekId, lecturer.firstName, lecturer.lastName, availability.monday, availability.tuesday, availability.wednesday, availability.thursday, availability.friday " +
                "FROM lecturer LEFT JOIN availability ON lecturer.id = availability.lecturerId");
        return getInfo(2);
    }

    public DTO getRoomsOverview() {
        setSqlQuery("SELECT id from room");
        return getInfo(1);
    }

    public DTO getRoomInformation(String id) {
        setSqlQuery("SELECT id, capacity, roomType From room WHERE id = " + "'" + id + "'");
        return getInfo(1);
    }

    public DTO getProgramsOverview() {
        setSqlQuery("SELECT name from program");
        return getInfo(4);
    }

    public DTO getProgramInformation(String programName) {
        setSqlQuery("SELECT id, name, participants, start, end From program WHERE name = " + "'" + programName + "'");
        return getInfo(4);
    }

    public DTO getSubjectCodes() {
        setSqlQuery("SELECT id from subject");
        return getInfo(5);
    }

    public DTO getInformationBySubjectCode(String subjectCode) {
        setSqlQuery("SELECT subject.id, subject.name, subject.participants, lecturer.firstName, lecturer.lastName FROM " +
        "lecturer LEFT JOIN subject ON lecturer.id = subject.lecturerId WHERE subject.id = " + "'" + subjectCode + "'");
        return getInfo(5);

    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
}
