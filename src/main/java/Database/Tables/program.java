package Database.Tables;

public class program {

    private int id;
    private String name;
    private String type;

    public program(int id, String name, String type) {

        setId(id);
        setName(name);
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

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    @Override
    public String toString() {

        return "program{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
