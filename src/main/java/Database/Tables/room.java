package Database.Tables;

/**
 * <p>room class.</p>
 *
 * @author mudasar
 * @version $Id: $Id
 */
public class room {

    private String id;
    private int capacity;
    private String roomType;
    private String type;

    /**
     * <p>Constructor for room.</p>
     *
     * @param id a {@link java.lang.String} object.
     * @param capacity a int.
     * @param roomType a {@link java.lang.String} object.
     * @param type a {@link java.lang.String} object.
     */
    public room(String id, int capacity, String roomType, String type) {

        setId(id);
        setCapacity(capacity);
        setRoomType(roomType);
        setType(type);
    }

    /**
     * <p>Constructor for room.</p>
     *
     * @param id a {@link java.lang.String} object.
     */
    public room(String id) {
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
     * <p>Setter for the field <code>capacity</code>.</p>
     *
     * @param capacity a int.
     */
    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    /**
     * <p>Getter for the field <code>roomType</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRoomType() {

        return roomType;
    }

    /**
     * <p>Setter for the field <code>roomType</code>.</p>
     *
     * @param roomType a {@link java.lang.String} object.
     */
    public void setRoomType(String roomType) {

        this.roomType = roomType;
    }

    /**
     * <p>Setter for the field <code>type</code>.</p>
     *
     * @param type a {@link java.lang.String} object.
     */
    public void setType(String type) {

        this.type = type;
    }

    /**
     * <p>toString.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String toString() {
        String returnString = "";
        if (getRoomType() != null) {
            returnString = "Roomnumber: " + id +
                    "\nCapacity: " + capacity +
                    "\nRoomtype: " + roomType +
                    "\n";
        } else {
            returnString = "\nRoom number: "+ getId();
        }
        return returnString;
    }
}
