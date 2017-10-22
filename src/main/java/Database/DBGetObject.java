package Database;
import Database.DTO.DTO;
import Database.DTO.DTOManager;
import Database.Tables.*;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DBGetObject {

    private Object theTable;
    private ArrayList<Object> tableObjects;
    private int tableNumber;
    private ArrayList<availability> availabilities;
    private ArrayList<lecturer> lecturers;
    private ArrayList<program> programs;
    private ArrayList<room> rooms;
    private ArrayList<semester> semesters;
    private ArrayList<subject> subjects;

    private String incrementalString;

    /**
     * Tar imot hvilket table det er, og lager en arraylist med objekter
     *
     */
    public DBGetObject() {
      availabilities = new ArrayList<availability>();
      lecturers = new ArrayList<lecturer>();
      programs = new ArrayList<program>();
      rooms = new ArrayList<room>();
      semesters = new ArrayList<semester>();
      subjects = new ArrayList<subject>();
    }

    /**
     * retunerer en arraylist med objekter fra tabellene
     *
     * @return
     * @throws Exception
     */
    public String checkWichTypeOfTableIsIt(DTOManager dtoManager) throws Exception {
        DTO theDTO =  dtoManager.getDto();
        return parseResults(theDTO.getResultSet(), theDTO.getTableNumber());
    }

    /**
     * legger til objekter i arraylist
     * @param resultSet
     * @return
     * @throws Exception
     */
    private String parseResults(ResultSet resultSet, int tableNumber) throws Exception {
        while(resultSet.next()) {
            switch (tableNumber) {
                case 1:
                    rooms.add(new room(resultSet.getString("id"),
                            resultSet.getInt("capacity"),
                            resultSet.getString("roomtype"),
                            "room"));
                    break;
                case 2:
                    availabilities.add(new availability(resultSet.getInt("weekId"),
                            resultSet.getInt("lecturerId"),
                            resultSet.getBoolean("monday"),
                            resultSet.getBoolean("tuesday"),
                            resultSet.getBoolean("wednesday"),
                            resultSet.getBoolean("thursday"),
                            resultSet.getBoolean("friday"),
                            "availability"));
                    break;
                case 3:
                    lecturers.add(new lecturer(resultSet.getInt("id"),
                            resultSet.getString("firstName"),
                            resultSet.getString("lastName"),
                            resultSet.getString("email"),
                            "lecturer"));
                    break;
                case 4:
                    programs.add(new program(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            "program"));
                    break;
                case 5:
                    semesters.add(new semester(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("start"),
                            resultSet.getString("end"),
                            "semester"));
                    break;
                case 6:
                    subjects.add(new subject(resultSet.getString("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("particants"),
                            "subject"));
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
                setIncrementalString(true, "\nRoom ID: " + R.getId()+"Room capacity: " + R.getCapacity()+"room type: " + R.getRoomType());
            }
        } else if (!availabilities.isEmpty()) {
            for (availability A : availabilities)
            {
                setIncrementalString(true,"\nWeek:" + A.getWeekId() + "Lecturer: "+ A.getLecturerId()+ "Mandag: " + A.isMonday() + "tirsdag: "+ A.isTuesday()+ "onsdag: " + A.isWednesday() + "torsdag: " + A.isThursday()+ "fredag: " + A.isFriday());
            }

        } else if (!lecturers.isEmpty()) {
            for(lecturer L : lecturers) {
                setIncrementalString(true, "\nLecturer ID: " + L.getId()+"Lecturer name: " + L.getFirstName()+"Lecturer lastname: " + L.getLastName()+"Lecturer mail: " + L.getEmail());
            }

        } else if (!programs.isEmpty()) {
            for(program P : programs) {
                setIncrementalString(true, "\nProgram ID: " + P.getId()+"Program Name: " + P.getName());
            }

        } else if (!semesters.isEmpty()) {
            for(semester S : semesters) {
                setIncrementalString(true, "\nSemster ID: " + S.getId()+
                                                                "Semster Name: " + S.getName()+
                                                                "Semster Start: " + S.getStart()+
                                                                "Semster end: " + S.getEnd());
            }

        } else {
            for (subject SU : subjects) {
                setIncrementalString(true, "\nSubject Code: " + SU.getId()+
                                                                "Subject Name: " + SU.getName()+
                                                                "Particants: " + SU.getParticants());
            }
        }

        return this.incrementalString;
    }

    private void setIncrementalString(Boolean increment, String newString) {
        if (increment) {
            this.incrementalString += newString;
        } else {
            this.incrementalString = newString;
        }
    }

}
