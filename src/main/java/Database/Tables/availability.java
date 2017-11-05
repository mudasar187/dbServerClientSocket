package Database.Tables;


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


    public void setWeekId(int weekId) {

        this.weekId = weekId;
    }


    public void setMonday(boolean monday) {

        this.monday = monday;
    }


    public void setTuesday(boolean tuesday) {

        this.tuesday = tuesday;
    }


    public void setWednesday(boolean wednesday) {

        this.wednesday = wednesday;
    }


    public void setThursday(boolean thursday) {

        this.thursday = thursday;
    }


    public void setFriday(boolean friday) {

        this.friday = friday;
    }


    public void setType(String type) {

        this.type = type;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

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
