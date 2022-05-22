package ucd.express;

public class Receiver {
    private int id;
    private String name;
    private String address;
    private int number;
    private String password;

    public Receiver() {
    }

    public Receiver(int id, String name, String address, int number, String password) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.number = number;
        this.password = password;
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

    public int getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}
