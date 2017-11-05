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

    public void setType(String type) {

        this.type = type;
    }

    @Override
    public String toString() {
        String returnString = "";
        if (getSubjectName() != null) {
            returnString = "SubjectCode: " + id +
                    "\nSubject name: " + getSubjectName() +
                    "\nParticants: " + getParticants() +
                    "\nTeacher: " + getFirstName() + " " + getLastName() +
                    "\n";
        } else {
            returnString = "\n Subject code: "+ getId();
        }
        return returnString;
    }
}
