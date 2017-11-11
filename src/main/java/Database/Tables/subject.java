package Database.Tables;

/**
 * <p>subject class.</p>
 *
 * @author Mudasar Ahmad
 * @version 1.0
 *
 * Last modified 10 november 2017
 */
public class subject {

    private String id;
    private String subjectName;
    private int particants;
    private String type;
    private String firstName;
    private String lastName;

    /**
     * <p>Constructor for subject.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @param subjectName a {@link java.lang.String} object.
     * @param particants a int.
     * @param type a {@link java.lang.String} object.
     * @param firstName a {@link java.lang.String} object.
     * @param lastName a {@link java.lang.String} object.
     */
    public subject(String id, String subjectName, int particants, String type, String firstName, String lastName) {

        setId(id);
        setParticants(particants);
        setType(type);
        setSubjectName(subjectName);
        setFirstName(firstName);
        setLastName(lastName);

    }

    /**
     * <p>Getter for the field <code>subjectName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * <p>Setter for the field <code>subjectName</code>.</p>
     *
     * @param subjectName a {@link java.lang.String} object.
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    /**
     * <p>Constructor for subject.</p>
     *
     * @param id a {@link java.lang.String} object.
     */
    public subject(String id) {
        setId(id);
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getId() {

        return id;
    }

    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a {@link java.lang.String} object.
     */
    public void setId(String id) {

        this.id = id;
    }



    /**
     * <p>Getter for the field <code>particants</code>.</p>
     *
     * @return a int.
     */
    public int getParticants() {

        return particants;
    }

    /**
     * <p>Setter for the field <code>particants</code>.</p>
     *
     * @param particants a int.
     */
    public void setParticants(int particants) {

        this.particants = particants;
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
