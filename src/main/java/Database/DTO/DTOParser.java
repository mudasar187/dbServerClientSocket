package Database.DTO;

import Database.Tables.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * <p>DTOParser class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 * <p>
 * Last modified 10 november 2017
 */
public class DTOParser {

    private ArrayList<availability> availabilities;
    private ArrayList<lecturer> lecturers;
    private ArrayList<program> programs;
    private ArrayList<room> rooms;
    private ArrayList<subject> subjects;


    private String incrementalString;

    /**
     * Receive which table it is and make an arraylist of objects
     */
    public DTOParser() {

        availabilities = new ArrayList<>();
        lecturers = new ArrayList<>();
        programs = new ArrayList<>();
        rooms = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    /**
     * This method make resultSet operation, put all information in an arraylist based on which tablenumber it is
     *
     * @param resultSet   a java.sql.ResultSet object.
     * @param tableNumber a int.
     * @return a {@link java.lang.String} object.
     * @throws java.lang.Exception if any.
     */
    public String parseResults(ResultSet resultSet, int tableNumber) throws Exception {

        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next())
        {
            switch (tableNumber)
            {
                case 1:
                    if (checkColumns(metaData))
                    {
                        rooms.add(new room(resultSet.getString("id"), resultSet.getInt("capacity"),
                                resultSet.getString("roomType"), ""));
                    } else
                    {
                        rooms.add(new room(resultSet.getString("id")));
                    }

                    break;
                case 2:
                    availabilities.add(new availability(
                            resultSet.getInt("weekId"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getBoolean("monday"),
                            resultSet.getBoolean("tuesday"),
                            resultSet.getBoolean("wednesday"),
                            resultSet.getBoolean("thursday"),
                            resultSet.getBoolean("friday"),
                            "availability"));
                    break;
                case 3:
                    if (checkColumns(metaData))
                    {
                        lecturers.add(new lecturer(resultSet.getInt("id"), resultSet.getString("firstName"),
                                resultSet.getString("lastName"), resultSet.getString("email"), ""));
                    } else
                    {
                        lecturers.add(new lecturer(resultSet.getString("firstName")));
                    }

                    break;
                case 4:
                    if (checkColumns(metaData))
                    {
                        programs.add(new program(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("participants"), "",
                                resultSet.getString("start"),
                                resultSet.getString("end")));
                    } else
                    {
                        programs.add(new program(resultSet.getString("name")));
                    }

                    break;
                case 5:
                    if (checkColumns(metaData))
                    {
                        subjects.add(new subject(resultSet.getString("id"), resultSet.getString("name"),
                                resultSet.getInt("participants"), "",
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName")));
                    } else
                    {
                        subjects.add(new subject(resultSet.getString("id")));
                    }

                    break;

            }
        }
        return makeStringOfOfObject();
    }

    /**
     * This method loops trough the arraylist which have content, and make a incremental string with the content in arraylist by calling toString method
     * <p>
     * <p>makeStringOfOfObject.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String makeStringOfOfObject() {

        makeString(false, "");

        if (!rooms.isEmpty())
        {
            for (room R : rooms)
            {
                makeString(true, "\n " + R.toString());
            }
        } else if (!availabilities.isEmpty())
        {
            for (availability A : availabilities)
            {
                makeString(true, "\n" + A.toString());
            }

        } else if (!lecturers.isEmpty())
        {
            for (lecturer L : lecturers)
            {
                makeString(true, "\n" + L.toString());
            }

        } else if (!programs.isEmpty())
        {
            for (program P : programs)
            {
                makeString(true, "\n" + P.toString());
            }

        } else if (!subjects.isEmpty())
        {
            for (subject SU : subjects)
            {
                makeString(true, "\n" + SU.toString());
            }
        }

        // Clear the arraylist that is used
        clearArrays();

        // Return the incremental string
        return this.incrementalString;
    }

    /**
     * Increment string if true , otherwise false
     *
     * @param increment
     * @param newString
     */
    private void makeString(Boolean increment, String newString) {

        if (increment)
        {
            // If build string, then true
            this.incrementalString += newString;
        } else
        {
            // if not build string, then false
            this.incrementalString = newString;
        }
    }

    /**
     * Check if its more than one column in resultSet, call this method in parseResults()
     *
     * @param metaData
     *
     * @return
     *
     * @throws Exception
     */
    private Boolean checkColumns(ResultSetMetaData metaData) throws Exception {

        if (metaData.getColumnCount() > 1)
        {
            return true;
        } else
        {
            return false;
        }
    }


    /**
     * Clean up the arraylist after incremental string which going to be returned is build
     */
    private void clearArrays() {

        availabilities.clear();
        lecturers.clear();
        programs.clear();
        rooms.clear();
        subjects.clear();
    }

}
