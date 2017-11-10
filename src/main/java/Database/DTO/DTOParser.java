package Database.DTO;
import Database.Tables.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

/**
 * <p>DTOParser class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class DTOParser {

    private ArrayList<availability> availabilities;
    private ArrayList<lecturer> lecturers;
    private ArrayList<program> programs;
    private ArrayList<room> rooms;
    private ArrayList<subject> subjects;


    private String incrementalString;

    /**
     * Tar imot hvilket table det er, og lager en arraylist med objekter
     */
    public DTOParser() {
      availabilities = new ArrayList<availability>();
      lecturers = new ArrayList<lecturer>();
      programs = new ArrayList<program>();
      rooms = new ArrayList<room>();
      subjects = new ArrayList<subject>();
    }

    /**
     * Denne metoden gjør resultset spørringen, legger alt info i en arraylist utifra hva den henter basert på tabell nr
     *
     * @param resultSet a java.sql.ResultSet object.
     * @throws java.lang.Exception if any.
     * @param tableNumber a int.
     * @return a {@link java.lang.String} object.
     */
    public String parseResults(ResultSet resultSet, int tableNumber) throws Exception {
        ResultSetMetaData metaData = resultSet.getMetaData();

        while(resultSet.next()) {
            switch (tableNumber) {
                case 1:
                    if (checkColumns(metaData)) {
                        rooms.add(new room(resultSet.getString("id"), resultSet.getInt("capacity"), resultSet.getString("roomType"),""));
                    } else {
                        rooms.add(new room(resultSet.getString("id")));
                    }

                    break;
                case 2:
                    availabilities.add(new availability(resultSet.getInt("weekId"),
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
                    if (checkColumns(metaData)) {
                        lecturers.add(new lecturer(resultSet.getInt("id"), resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("email"), ""));
                    } else {
                        lecturers.add(new lecturer(resultSet.getString("firstName")));
                    }

                    break;
                case 4:
                    if (checkColumns(metaData)) {
                        programs.add(new program(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("participants"), "",
                                resultSet.getString("start"),
                                resultSet.getString("end")));
                    } else {
                        programs.add(new program(resultSet.getString("name")));
                    }

                    break;
                case 5:
                    if (checkColumns(metaData)) {
                        subjects.add(new subject(resultSet.getString("id"), resultSet.getString("name"),
                                resultSet.getInt("participants"), "",
                                resultSet.getString("firstName"),
                                resultSet.getString("lastName")));
                    } else {
                        subjects.add(new subject(resultSet.getString("id")));
                    }

                    break;

            }
        }
        return makeStringOfOfObject();
    }

    /**
     *
     * Denne looper gjennom arraylisten som har innhold, så lager man en stor streng med arraylistens innhold,
     * så retunerer stringen
     *
     * <p>makeStringOfOfObject.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String makeStringOfOfObject() {
        makeString(false, "");
        if (!rooms.isEmpty()) {
            for (room R : rooms)
            {
                makeString(true, "\n " + R.toString());
            }
        } else if (!availabilities.isEmpty()) {
            for (availability A : availabilities)
            {
                makeString(true,"\n" + A.toString());
            }

        } else if (!lecturers.isEmpty()) {
            for(lecturer L : lecturers) {
                makeString(true,"\n" + L.toString());
            }

        } else if (!programs.isEmpty()) {
            for(program P : programs) {
                makeString(true, "\n" + P.toString());
            }

        } else if (!subjects.isEmpty()) {
            for (subject SU : subjects) {
                makeString(true, "\n" + SU.toString());
            }
        }

        clearArrays();
        return this.incrementalString;
    }

    /**
     * Forstørrer strengen om ønsket basert på parameter
     * @param increment
     * @param newString
     */
    private void makeString(Boolean increment, String newString) {
        if (increment) {
            this.incrementalString += newString;
        } else {
            this.incrementalString = newString;
        }
    }

    /**
     * Sjekker om det er flere kolonner enn en kolonne i resultset, hvis flere, kjør den med flere, hvis en, kjør den ene, se over
     *
     * @param metaData
     * @return
     * @throws Exception
     */
    private Boolean checkColumns(ResultSetMetaData metaData) throws Exception {
        if (metaData.getColumnCount() > 1) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Rense arraylist etter at strengen (increment string) som skal retuneres er laget
     */
    private void clearArrays() {
        availabilities.clear();
        lecturers.clear();
        programs.clear();
        rooms.clear();
        subjects.clear();
    }

}
