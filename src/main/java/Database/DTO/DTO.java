package Database.DTO;

import java.io.Serializable;

/**
 *
 * Denne klassen tar imot en string og gir muligheten til å sende ut stringen
 *
 * <p>DTO class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class DTO implements Serializable {

    private String parsedString = "";

    /**
     * <p>Constructor for DTO.</p>
     */
    public DTO(){}


    /**
     * <p>Constructor for DTO.</p>
     *
     * @param parsedString a {@link java.lang.String} object.
     */
    public DTO(String parsedString) {

        setParsedString(parsedString);
    }


    /**
     * <p>Setter for the field <code>parsedString</code>.</p>
     *
     * @param parsedString a {@link java.lang.String} object.
     */
    public void setParsedString(String parsedString) {

        this.parsedString = parsedString;
    }

    /**
     * <p>Getter for the field <code>parsedString</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getParsedString() {
        return this.parsedString;
    }
}
