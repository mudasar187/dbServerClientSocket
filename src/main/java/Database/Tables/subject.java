package Database.Tables;

public class subject {

    private String id;
    private String subjectName;
    private int particants;
    private String type;
    private String firstName;
    private String lastName;

    public subject(String id, String subjectName, int particants, String type, String firstName, String lastName) {

        setId(id);
        setParticants(particants);
        setType(type);
        setSubjectName(subjectName);
        setFirstName(firstName);
        setLastName(lastName);

    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public subject(String id) {
        setId(id);
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }



    public int getParticants() {

        return particants;
    }

    public void setParticants(int particants) {

        this.particants = particants;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    @Override
    public String toString() {
        String returnString = "";
        if (getSubjectName() != null) {
            returnString = "subject{" +
                    "id='" + id + '\'' +
                    ", name='" + getSubjectName() + '\'' +
                    ", particants=" + getParticants() +
                    ", teacher name= " + getFirstName() + " " + getLastName() +
                    '}';
        } else {
            returnString = getId();
        }
        return returnString;
    }
}
