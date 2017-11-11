package Database.Tables;


/**
 * <p>availability class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class availability {

    private int weekId;
    private String firstName;
    private String lastName;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private String type;


    /**
     * <p>Constructor for availability.</p>
     *
     * @param weekId a int.
     * @param firstName a {@link java.lang.String} object.
     * @param lastName a {@link java.lang.String} object.
     * @param monday a boolean.
     * @param tuesday a boolean.
     * @param wednesday a boolean.
     * @param thursday a boolean.
     * @param friday a boolean.
     * @param type a {@link java.lang.String} object.
     */
    public availability(int weekId, String firstName, String lastName, boolean monday, boolean tuesday,
                        boolean wednesday,
                        boolean thursday,
                        boolean friday, String type)
    {

        setWeekId(weekId);
        setFirstName(firstName);
        setLastName(lastName);
        setMonday(monday);
        setTuesday(tuesday);
        setWednesday(wednesday);
        setThursday(thursday);
        setFriday(friday);
        setType(type);
    }


    /**
     * <p>Setter for the field <code>weekId</code>.</p>
     *
     * @param weekId a int.
     */
    public void setWeekId(int weekId) {

        this.weekId = weekId;
    }


    /**
     * <p>Setter for the field <code>monday</code>.</p>
     *
     * @param monday a boolean.
     */
    public void setMonday(boolean monday) {

        this.monday = monday;
    }


    /**
     * <p>Setter for the field <code>tuesday</code>.</p>
     *
     * @param tuesday a boolean.
     */
    public void setTuesday(boolean tuesday) {

        this.tuesday = tuesday;
    }


    /**
     * <p>Setter for the field <code>wednesday</code>.</p>
     *
     * @param wednesday a boolean.
     */
    public void setWednesday(boolean wednesday) {

        this.wednesday = wednesday;
    }


    /**
     * <p>Setter for the field <code>thursday</code>.</p>
     *
     * @param thursday a boolean.
     */
    public void setThursday(boolean thursday) {

        this.thursday = thursday;
    }


    /**
     * <p>Setter for the field <code>friday</code>.</p>
     *
     * @param friday a boolean.
     */
    public void setFriday(boolean friday) {

        this.friday = friday;
    }


    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link java.lang.String} object.
     */
    public void setType(String type) {

        this.type = type;
    }

    /**
     * <p>Getter for the field <code>firstName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * <p>Setter for the field <code>firstName</code>.</p>
     *
     * @param firstName a {@link java.lang.String} object.
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    /**
     * <p>Getter for the field <code>lastName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastName() {

        return lastName;
    }

    /**
     * <p>Setter for the field <code>lastName</code>.</p>
     *
     * @param lastName a {@link java.lang.String} object.
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {

        return "WeekNumber: " + weekId +
                "\nFirstName: " + getFirstName() +
                "\nLastname: " + getLastName() +
                "\nMonday" + monday +
                "\nTuesday: " + tuesday +
                "\nWednesday: " + wednesday +
                "\nThursday: " + thursday +
                "\nFriday: " + friday +
                "\n";
    }
}
