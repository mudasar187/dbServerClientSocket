package Database.Tables;

public class semester {

    private int id;
    private String name;
    private String start;
    private String end;
    private String type;

    public semester(int id, String name, String start, String end, String type) {

        setId(id);
        setName(name);
        setStart(start);
        setEnd(end);
        setType(type);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getStart() {

        return start;
    }

    public void setStart(String start) {

        this.start = start;
    }

    public String getEnd() {

        return end;
    }

    public void setEnd(String end) {

        this.end = end;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    @Override
    public String toString() {

        return "semester{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
