package Database.Tables;



public class availability {

    private int weekId;
    private int lecturerId;
    private boolean monday;
    private boolean tuesday;
    private boolean wednesday;
    private boolean thursday;
    private boolean friday;
    private String type;


    public availability(int weekId, int lecturerId, boolean monday, boolean tuesday, boolean wednesday,
                        boolean thursday,
                        boolean friday, String type)
    {

        setWeekId(weekId);
        setLecturerId(lecturerId);
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

    public int getLecturerId() {

        return lecturerId;
    }

    public void setLecturerId(int lecturerId) {

        this.lecturerId = lecturerId;
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

    @Override
    public String toString() {

        return "availability{" +
                "weekId=" + weekId +
                ", lecturerId=" + lecturerId +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                '}';
    }
}
