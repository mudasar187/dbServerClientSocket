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

    private String query;
    private DTOParser dbObject;
    private DTO returnDTO;
    private Util util;

    /**
     * <p>Constructor for DBManager.</p>
     */
    public DBHandler() {
        setQuery("");
        returnDTO = new DTO();
        dbObject = new DTOParser();
        util = new Util("src/main/resources/socketdatabase.properties");
    }

    /**
     *
     * This method makes queries based on setQuery and which table number the queries is getting from
     * Information is received from database, then parse to string and then return parsed object
     *
     * <p>getInfo.</p>
     *
     * @param tableNumber a int.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getInfo(int tableNumber) {
        try (Connection connection = new DBConnection().getConnection();
             PreparedStatement statement = connection.prepareStatement(getQuery())) {
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
     * setQuery to get only firstNames of all lectures
     * <p>getLectures.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getLectures() {
        setQuery("SELECT firstName FROM lecturer");
        return getInfo(3);
    }

    /**
     * setQuery to get all information about the one specific teacher name
     * <p>getLecturedInfo.</p>
     *
     * @param lectureName a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getLecturedInfo(String lectureName) {
        setQuery("SELECT id, firstName, lastName, email FROM lecturer WHERE firstName = " + "'" + lectureName + "'");
        return getInfo(3);
    }

    /**
     * setQuery to get all information about all availabilities for all teachers
     * <p>getAvailability.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getAvailability() {
        setQuery("SELECT availability.weekId, lecturer.firstName, lecturer.lastName, availability.monday, availability.tuesday, availability.wednesday, availability.thursday, availability.friday " +
                "FROM lecturer LEFT JOIN availability ON lecturer.id = availability.lecturerId");
        return getInfo(2);
    }

    /**
     * setQuery to get only roomnumbers for all rooms
     * <p>getRoomsOverview.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getRoomsOverview() {
        setQuery("SELECT id from room");
        return getInfo(1);
    }

    /**
     * setQuery to get all information about the the specific room number
     * <p>getRoomInformation.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getRoomInformation(String id) {
        setQuery("SELECT id, capacity, roomType From room WHERE id = " + "'" + id + "'");
        return getInfo(1);
    }

    /**
     * setQuery to get only names for all programs
     * <p>getProgramsOverview.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getProgramsOverview() {
        setQuery("SELECT name from program");
        return getInfo(4);
    }

    /**
     * setQuery to get all information about the specific program name
     * <p>getProgramInformation.</p>
     *
     * @param programName a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getProgramInformation(String programName) {
        setQuery("SELECT id, name, participants, start, end From program WHERE name = " + "'" + programName + "'");
        return getInfo(4);
    }

    /**
     * setQuery to get only subjectcodes for all subjects
     * <p>getSubjectCodes.</p>
     *
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getSubjectCodes() {
        setQuery("SELECT id from subject");
        return getInfo(5);
    }

    /**
     * setQuery to get all information about the specific subject code
     * <p>getInformationBySubjectCode.</p>
     *
     * @param subjectCode a {@link java.lang.String} object.
     * @return a {@link Database.DTO.DTO} object.
     */
    public DTO getInformationBySubjectCode(String subjectCode) {
        setQuery("SELECT subject.id, subject.name, subject.participants, lecturer.firstName, lecturer.lastName FROM " +
        "lecturer LEFT JOIN subject ON lecturer.id = subject.lecturerId WHERE subject.id = " + "'" + subjectCode + "'");
        return getInfo(5);

    }

    /**
     * <p>Getter for the field <code>query</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getQuery() {
        return query;
    }

    /**
     * <p>Setter for the field <code>query</code>.</p>
     *
     * @param query a {@link java.lang.String} object.
     */
    public void setQuery(String query) {
        this.query = query;
    }
}
