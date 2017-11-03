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




    public availability(int weekId, String firstName, String lastName, boolean monday, boolean tuesday, boolean wednesday,
                        boolean thursday,
                        boolean friday, String type)
    {

        setWeekId(weekId);
        setFirstName(firstName);
        setLastName(lastName);
        setMonday(monday);
        setThursday(tuesday);
        setWednesday(wednesday);
        setThursday(thursday);
        setFriday(friday);
        setType(type);
    }

    public int getWeekId() {

        return weekId;
    }

    public void setWeekId(int weekId) {

        this.weekId = weekId;
    }

    public boolean isMonday() {

        return monday;
    }

    public void setMonday(boolean monday) {

        this.monday = monday;
    }

    public boolean isTuesday() {

        return tuesday;
    }

    public void setTuesday(boolean tuesday) {

        this.tuesday = tuesday;
    }

    public boolean isWednesday() {

        return wednesday;
    }

    public void setWednesday(boolean wednesday) {

        this.wednesday = wednesday;
    }

    public boolean isThursday() {

        return thursday;
    }

    public void setThursday(boolean thursday) {

        this.thursday = thursday;
    }

    public boolean isFriday() {

        return friday;
    }

    public void setFriday(boolean friday) {

        this.friday = friday;
    }

    public String getType() {

        return type;
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

        return "availability{" +
                "weekId=" + weekId +
                "firstName = " + getFirstName() +
                "lastName = " + getLastName() +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                '}';
    }
}
