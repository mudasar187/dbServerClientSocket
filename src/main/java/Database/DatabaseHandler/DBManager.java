package Database.DatabaseHandler;

import Database.DTO.DTOParser;
import Database.DTO.DTO;
import Database.DatabaseConnection.DBConnection;
import Utility.Util;

import java.sql.*;


/**
 * <p>DBManager class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class DBManager {

    private String sqlQuery;
    private DTOParser dbObject;
    private DTO returnDTO;
    private Util util;

    /**
     * <p>Constructor for DBManager.</p>
     */
    public DBManager() {
        setSqlQuery("");
        returnDTO = new DTO();
        dbObject = new DTOParser();
        util = new Util("src/main/resources/socketdatabase.properties");
    }

    /**
     * her gjør man spørringer basert på sql spørringer og hvilken tabell nr.
     * info hentes fra databasen, så til dto parser, parser om til string for så deretter retunere et parsed objekt
     *
     * <p>getInfo.</p>
     *
     * @param tableNumber a int.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getInfo(int tableNumber) {
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement statement = connection.prepareStatement(getSqlQuery())) {
            ResultSet res = statement.executeQuery();
            //PARSE HER
            String parsedString = dbObject.parseResults(res, tableNumber);

            returnDTO = new DTO(parsedString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return returnDTO;

    }


    /**
     * <p>getLectures.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getLectures() {
        setSqlQuery("SELECT firstName FROM lecturer");
        return getInfo(3);
    }

    /**
     * <p>getLecturedInfo.</p>
     *
     * @param lectureName a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getLecturedInfo(String lectureName) {
        setSqlQuery("SELECT id, firstName, lastName, email FROM lecturer WHERE firstName = " + "'" + lectureName + "'");
        return getInfo(3);
    }

    /**
     * <p>getAvailability.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getAvailability() {
        setSqlQuery("SELECT availability.weekId, lecturer.firstName, lecturer.lastName, availability.monday, availability.tuesday, availability.wednesday, availability.thursday, availability.friday " +
                "FROM lecturer LEFT JOIN availability ON lecturer.id = availability.lecturerId");
        return getInfo(2);
    }

    /**
     * <p>getRoomsOverview.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getRoomsOverview() {
        setSqlQuery("SELECT id from room");
        return getInfo(1);
    }

    /**
     * <p>getRoomInformation.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getRoomInformation(String id) {
        setSqlQuery("SELECT id, capacity, roomType From room WHERE id = " + "'" + id + "'");
        return getInfo(1);
    }

    /**
     * <p>getProgramsOverview.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getProgramsOverview() {
        setSqlQuery("SELECT name from program");
        return getInfo(4);
    }

    /**
     * <p>getProgramInformation.</p>
     *
     * @param programName a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getProgramInformation(String programName) {
        setSqlQuery("SELECT id, name, participants, start, end From program WHERE name = " + "'" + programName + "'");
        return getInfo(4);
    }

    /**
     * <p>getSubjectCodes.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getSubjectCodes() {
        setSqlQuery("SELECT id from subject");
        return getInfo(5);
    }

    /**
     * <p>getInformationBySubjectCode.</p>
     *
     * @param subjectCode a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getInformationBySubjectCode(String subjectCode) {
        setSqlQuery("SELECT subject.id, subject.name, subject.participants, lecturer.firstName, lecturer.lastName FROM " +
        "lecturer LEFT JOIN subject ON lecturer.id = subject.lecturerId WHERE subject.id = " + "'" + subjectCode + "'");
        return getInfo(5);

    }

    /**
     * <p>Getter for the field <code>sqlQuery</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSqlQuery() {
        return sqlQuery;
    }

    /**
     * <p>Setter for the field <code>sqlQuery</code>.</p>
     *
     * @param sqlQuery a {@link java.lang.String} object.
     */
    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }
}
