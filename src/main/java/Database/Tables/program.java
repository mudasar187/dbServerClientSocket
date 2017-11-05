package Database.Tables;

public class program {

    private Integer id;
    private String name;
    private String type;
    private String start;
    private String end;



    private int participants;

    public program(int id, String name, int participants, String type, String start, String end) {

        setId(id);
        setName(name);
        setType(type);
        setStart(start);
        setEnd(end);
        setParticipants(participants);
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    public program(String name) {
        setName(name);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }


    public void setType(String type) {

        this.type = type;
    }

    @Override
    public String toString() {
        String returnString = "";
        if (getId() != null) {
            returnString = "Id: " + id +
                    "\nProgram ame: " + name +
                    "\nParticipants: " + getParticipants() +
                    "\nStart: " + getStart() +
                    "\nEnd: " + getEnd() +
                    "\n";
        } else {
            returnString = "\n Program name: "+ getName();
        }
        return returnString;
    }
}
