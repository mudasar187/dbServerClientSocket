package Database.Tables;

/**
 * <p>lecturer class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class lecturer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String type;

    /**
     * <p>Constructor for lecturer.</p>
     *
     * @param id a int.
     * @param firstName a {@link java.lang.String} object.
     * @param lastName a {@link java.lang.String} object.
     * @param email a {@link java.lang.String} object.
     * @param type a {@link java.lang.String} object.
     */
    public lecturer(int id, String firstName, String lastName, String email, String type) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setType(type);
    }

    /**
     * <p>Constructor for lecturer.</p>
     *
     * @param firstName a {@link java.lang.String} object.
     */
    public lecturer(String firstName) {
        setFirstName(firstName);
    }


    /**
     * <p>Setter for the field <code>id</code>.</p>
     *
     * @param id a int.
     */
    public void setId(int id) {

        this.id = id;
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
     * <p>Setter for the field <code>lastName</code>.</p>
     *
     * @param lastName a {@link java.lang.String} object.
     */
    public void setLastName(String lastName) {

        this.lastName = lastName;
    }



    /**
     * <p>Setter for the field <code>email</code>.</p>
     *
     * @param email a {@link java.lang.String} object.
     */
    public void setEmail(String email) {

        this.email = email;
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
        if (lastName != null) {
            returnString = "Id: " + id +
                    "\nFirstName: " + firstName +
                    "\nLastName: " + lastName  +
                    "\nEmail: " + email +
                    "\n";
        } else {
            returnString = "\n Firstname: " + getFirstName();
        }
        return returnString;
    }
}
