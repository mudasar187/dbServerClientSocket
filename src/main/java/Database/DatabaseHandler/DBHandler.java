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
public class DBHandler {

    private String sqlQuery;
    private DTOParser dbObject;
    private DTO returnDTO;
    private Util util;

    /**
     * <p>Constructor for DBManager.</p>
     */
    public DBHandler() {
        setSqlQuery("");
        returnDTO = new DTO();
        dbObject = new DTOParser();
        util = new Util("src/main/resources/socketdatabase.properties");
    }

    /**
     *
     * This method makes queries based on setSqlQuery and which table number the queries is getting from
     * Information is received from database, then parse to string and then return parsed object
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
            // Parse here based on which tablenumber -> DTOParser
            String parsedString = dbObject.parseResults(res, tableNumber);

            returnDTO = new DTO(parsedString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Return parsed object
        return returnDTO;

    }


    /**
     * setSqlQuery to get only firstNames of all lectures
     * <p>getLectures.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getLectures() {
        setSqlQuery("SELECT firstName FROM lecturer");
        return getInfo(3);
    }

    /**
     * setSqlQuery to get all information about the one specific teacher name
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
     * setSqlQuery to get all information about all availabilities for all teachers
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
     * setSqlQuery to get only roomnumbers for all rooms
     * <p>getRoomsOverview.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getRoomsOverview() {
        setSqlQuery("SELECT id from room");
        return getInfo(1);
    }

    /**
     * setSqlQuery to get all information about the the specific room number
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
     * setSqlQuery to get only names for all programs
     * <p>getProgramsOverview.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getProgramsOverview() {
        setSqlQuery("SELECT name from program");
        return getInfo(4);
    }

    /**
     * setSqlQuery to get all information about the specific program name
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
     * setSqlQuery to get only subjectcodes for all subjects
     * <p>getSubjectCodes.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getSubjectCodes() {
        setSqlQuery("SELECT id from subject");
        return getInfo(5);
    }

    /**
     * setSqlQuery to get all information about the specific subject code
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
