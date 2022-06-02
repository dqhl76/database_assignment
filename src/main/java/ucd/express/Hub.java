package ucd.express;

public class Hub {
    String id;
    String name;
    String location;

    Hub() {

    }

    Hub(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
