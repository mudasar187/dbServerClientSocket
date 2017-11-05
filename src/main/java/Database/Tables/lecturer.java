package Database.Tables;

public class lecturer {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String type;

    public lecturer(int id, String firstName, String lastName, String email, String type) {

        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setType(type);
    }

    public lecturer(String firstName) {
        setFirstName(firstName);
    }


    public void setId(int id) {

        this.id = id;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }



    public void setLastName(String lastName) {

        this.lastName = lastName;
    }



    public void setEmail(String email) {

        this.email = email;
    }


    public void setType(String type) {

        this.type = type;
    }

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
