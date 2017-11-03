package Database.DTO;

import java.io.Serializable;

public class DTO implements Serializable {

    private String parsedString = "";

    public DTO(){}


    public DTO(String parsedString) {
        setParsedString(parsedString);
    }


    public void setParsedString(String parsedString) {
        this.parsedString = parsedString;
    }

    public String getParsedString() {
        return this.parsedString;
    }
}
