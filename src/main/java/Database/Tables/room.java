package Database.Tables;

public class room {

    private String id;
    private int capacity;
    private String roomType;
    private String type;

    public room(String id, int capacity, String roomType, String type) {

        setId(id);
        setCapacity(capacity);
        setRoomType(roomType);
        setType(type);
    }

    public room(String id) {
        setId(id);
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public int getCapacity() {

        return capacity;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    public String getRoomType() {

        return roomType;
    }

    public void setRoomType(String roomType) {

        this.roomType = roomType;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public String toString() {
        String returnString = "";
        if (getRoomType() != null) {
            returnString = "room{" +
                    "id='" + id + '\'' +
                    ", capacity=" + capacity +
                    ", roomType='" + roomType + '\'' +
                    '}';
        } else {
            returnString = getId() + ", ";
        }
        return returnString;
    }
}
