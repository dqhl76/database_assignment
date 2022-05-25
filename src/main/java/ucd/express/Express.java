package ucd.express;

public class Express {
    private String id;
    private String content;
    private String pickup_address;
    private String ship_address;
    private String receiver_id;
    private String sender_id;
    private String delivery_company;

    public Express() {
    }

    public Express(String id, String content, String pickup_address, String ship_address, String receiver_id, String sender_id, String delivery_company) {
        super();
        this.id = id;
        this.content = content;
        this.pickup_address = pickup_address;
        this.ship_address = ship_address;
        this.receiver_id = receiver_id;
        this.sender_id = sender_id;
        this.delivery_company = delivery_company;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getPickup_address() {
        return pickup_address;
    }

    public String getShip_address() {
        return ship_address;
    }

    public String getReceiver_id() {
        return receiver_id;
    }

    public String getSender_id() {
        return sender_id;
    }

    public String getDelivery_company() {
        return delivery_company;
    }

    public String toString() {
        String outPut = this.id + "\t" + this.content + "\t" + this.pickup_address + "\t" + this.ship_address + "\t" + delivery_company;
        return outPut;
    }
}
