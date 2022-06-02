package ucd.express;

import java.sql.Timestamp;

public class Status {
    Status() {

    }

    String express_id;
    String hub_id;
    Timestamp time;
    Integer is_receive;

    Status(String express_id, String hub_id, Timestamp time, Integer is_receive) {
        this.express_id = express_id;
        this.hub_id = hub_id;
        this.time = time;
        this.is_receive = is_receive;
    }

    public String getHub_id() {
        return hub_id;
    }

    public Integer getIs_receive() {
        return is_receive;
    }

    public String getExpress_id() {
        return express_id;
    }

    public Timestamp getTime() {
        return time;
    }


}
