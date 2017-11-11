package Database.Tables;

/**
 * <p>program class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class program {

    private Integer id;
    private String name;
    private String type;
    private String start;
    private String end;



    private int participants;

    /**
     * <p>Constructor for program.</p>
     *
     * @param id a int.
     * @param name a {@link java.lang.String} object.
     * @param participants a int.
     * @param type a {@link java.lang.String} object.
     * @param start a {@link java.lang.String} object.
     * @param end a {@link java.lang.String} object.
     */
    public program(int id, String name, int participants, String type, String start, String end) {

        setId(id);
        setName(name);
        setType(type);
        setStart(start);
        setEnd(end);
        setParticipants(participants);
    }

    /**
     * <p>Getter for the field <code>participants</code>.</p>
     *
     * @return a int.
     */
    public int getParticipants() {
        return participants;
    }

    /**
     * <p>Setter for the field <code>participants</code>.</p>
     *
     * @param participants a int.
     */
    public void setParticipants(int participants) {
        this.participants = participants;
    }

    /**
     * <p>Getter for the field <code>start</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getStart() {
        return start;
    }

    /**
     * <p>Setter for the field <code>start</code>.</p>
     *
     * @param start a {@link java.lang.String} object.
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * <p>Getter for the field <code>end</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getEnd() {
        return end;
    }

    /**
     * <p>Setter for the field <code>end</code>.</p>
     *
     * @param end a {@link java.lang.String} object.
     */
    public void setEnd(String end) {
        this.end = end;
    }
    /**
     * <p>Constructor for program.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public program(String name) {
        setName(name);
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.Integer} object.
     */
    public Integer getId() {

        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.Integer} object.
     */
    public void setId(Integer id) {

        this.id = id;
    }

    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {

        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {

        this.name = name;
    }


    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link java.lang.String} object.
     */
    public void setType(String type) {

        this.type = type;
    }

    /** {@inheritDoc} */
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
