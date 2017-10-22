package Database.Tables;

public class subject {

    private String id;
    private String name;
    private int particants;
    private String type;

    public subject(String id, String name, int particants, String type) {

        setId(id);
        setName(name);
        setParticants(particants);
        setType(type);
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getParticants() {

        return particants;
    }

    public void setParticants(int particants) {

        this.particants = particants;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    @Override
    public String toString() {

        return "subject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", particants=" + particants +
                '}';
    }
}
