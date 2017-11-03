package Database.DTO;
import Database.Tables.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class DTOParser {

    private ArrayList<availability> availabilities;
    private ArrayList<lecturer> lecturers;
    private ArrayList<program> programs;
    private ArrayList<room> rooms;
    private ArrayList<subject> subjects;
    private ArrayList<getAllTables> allTables;

    private String incrementalString;

    /**
     * Tar imot hvilket table det er, og lager en arraylist med objekter
     *
     */
    public DTOParser() {
      availabilities = new ArrayList<availability>();
      lecturers = new ArrayList<lecturer>();
      programs = new ArrayList<program>();
      rooms = new ArrayList<room>();
      subjects = new ArrayList<subject>();
      allTables = new ArrayList<getAllTables>();
    }

    /**
     * legger til objekter i arraylist
     * @param resultSet
     * @return
     * @throws Exception
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
                case 6:
                    allTables.add(new getAllTables(resultSet.getString("table_name")));
                    break;

            }
        }
        return makeStringOfOfObject();
    }

    public String makeStringOfOfObject() {
        setIncrementalString(false, "");
        if (!rooms.isEmpty()) {
            for (room R : rooms)
            {
                setIncrementalString(true, "\n " + R.toString());
            }
        } else if (!availabilities.isEmpty()) {
            for (availability A : availabilities)
            {
                setIncrementalString(true,"\n" + A.toString());
            }

        } else if (!lecturers.isEmpty()) {
            for(lecturer L : lecturers) {
                setIncrementalString(true, L.toString());
            }

        } else if (!programs.isEmpty()) {
            for(program P : programs) {
                setIncrementalString(true, "\n" + P.toString());
            }

        } else if (!subjects.isEmpty()) {
            for (subject SU : subjects) {
                setIncrementalString(true, "\n" + SU.toString());
            }
        } else {
            for (getAllTables T: allTables) {
                setIncrementalString(true, T.toString());
            }
        }

        clearArrays();
        return this.incrementalString;
    }

    private void setIncrementalString(Boolean increment, String newString) {
        if (increment) {
            this.incrementalString += newString;
        } else {
            this.incrementalString = newString;
        }
    }

    private Boolean checkColumns(ResultSetMetaData metaData) throws Exception {
        if (metaData.getColumnCount() > 1) {
            return true;
        } else {
            return false;
        }
    }

    private void clearArrays() {
        availabilities.clear();
        lecturers.clear();
        programs.clear();
        rooms.clear();
        subjects.clear();
        allTables.clear();
    }

}
