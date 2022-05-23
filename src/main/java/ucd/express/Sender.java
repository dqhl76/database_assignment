package ucd.express;

public class Sender {
    private int id;
    private String name;
    private String address;
    private String number;
    private String password;

    private String hub;

    public Sender() {
    }

    public Sender(int id, String name, String address, String number, String password, String hub) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.password = password;
        this.hub = hub;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getHub() {
        return hub;
    }
}
