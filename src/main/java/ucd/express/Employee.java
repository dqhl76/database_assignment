package ucd.express;

public class Employee {
    private String e_id;
    private String hub_id;
    private String c_name;

    public Employee() {

    }

    public Employee(String e_id, String hub_id, String c_name) {
        super();
        this.e_id = e_id;
        this.hub_id = hub_id;
        this.c_name = c_name;
    }

    public String getC_name() {
        return c_name;
    }

    public String getE_id() {
        return e_id;
    }

    public String getHub_id() {
        return hub_id;
    }
}
