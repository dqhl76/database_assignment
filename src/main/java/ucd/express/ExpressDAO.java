package ucd.express;

import java.sql.*;
import java.util.UUID;

public class ExpressDAO {
    public static String generateID() {
        StringBuffer shortBuffer = new StringBuffer();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 1; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(x);
        }
        return shortBuffer.toString();
    }

    public static int addSender(String id, String name, String address, String phone, String password, String hub) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql1 = " INSERT INTO Sender VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, id);
            ps1.setString(2, name);
            ps1.setString(3, address);
            ps1.setString(4, phone);
            ps1.setString(5, password);
            ps1.setString(6, hub);
            result = ps1.executeUpdate();
            ps1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int addReceiver(String id, String name, String address, String phone, String password, String hub) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql1 = " INSERT INTO Receiver VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, id);
            ps1.setString(2, name);
            ps1.setString(3, address);
            ps1.setString(4, phone);
            ps1.setString(5, password);
            ps1.setString(6, hub);
            result = ps1.executeUpdate();
            ps1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int addRoutine(String start_id, String end_id, String current_id, String next_id){
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "insert into Routine values (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, start_id);
            ps.setString(2, end_id);
            ps.setString(3, current_id);
            ps.setString(4, next_id);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int updateStatus( String express_id, String hub_id, boolean is_receive) {
        /*
         * 接收express_id,hub_id,is_receive并获取系统时间，代表此快递员此时更新了这个快递express_id的状态
         */
        int result = 0;
        Timestamp time= new Timestamp(System.currentTimeMillis());
        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "insert into Status values (?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, express_id);
            ps.setString(2, hub_id);
            ps.setTimestamp(3, time);
            ps.setBoolean(4, is_receive);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int addEmployee(String e_id, String hub_id, String c_name) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "insert into Employee values (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e_id);
            ps.setString(2, hub_id);
            ps.setString(3, c_name);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int addHub(String name, String location) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "insert into Hub values (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, generateID());
            ps.setString(2, name);
            ps.setString(3, location);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static int addRequest(String id, String senderAd, String receiverAd, String senderID, String receiverID, String content, String company, Timestamp timestamp) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            Sender sender = getSenderByNumber(senderID);
            Receiver receiver = getReceiverByNumber(receiverID);
            String sql = "insert into Express values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, content);
            ps.setString(3, senderAd);
            ps.setString(4, receiverAd);
            ps.setString(5, receiverID);
            ps.setString(6, senderID);
            ps.setString(7, company);
            ps.setTimestamp(8, timestamp);
            ps.setString(9, sender.getHub());
            ps.setString(10, receiver.getHub());
            result = ps.executeUpdate();
            ps.close();
            conn.close();

            sql = "insert into Status values (?, ?, ?, ?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, sender.getHub());
            ps.setTimestamp(3, timestamp);
            ps.setBoolean(4, false);
            result = ps.executeUpdate() * result;
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    public static int addCompany(String name, String phone, String email) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "insert into Company values (?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, email);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Receiver getReceiverByNumber(String number) {
        Receiver result = new Receiver();

        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM Receiver WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("full_name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                String password = rs.getString("password");
                String hub = rs.getString("hub_id");
                Receiver e = new Receiver(id, name, address, phoneNumber, password, hub);
                result = e;
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Sender getSenderByNumber(String number) {
        Sender result = new Sender();

        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM Sender WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("full_name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phone_number");
                String password = rs.getString("password");
                String hub = rs.getString("hub_id");
                Sender e = new Sender(id, name, address, phoneNumber, password, hub);
                result = e;
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Express getExpressByID(String eid) {
        Express result = new Express();

        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM Express WHERE id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, eid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String content = rs.getString("content");
                String pickup_address = rs.getString("pickup_address");
                String ship_address = rs.getString("ship_address");
                int receiver_id = rs.getInt("receiver_id");
                int sender_id = rs.getInt("sender_id");
                String delivery_company = rs.getString("delivery_company");

                Express e = new Express(id, content, pickup_address, ship_address, receiver_id, sender_id, delivery_company);
                result = e;
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Employee getEmployeeByNumber(String number) {
        Employee result = new Employee();

        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "SELECT * FROM Employee WHERE e_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("e_id");
                String name = rs.getString("c_name");
                String hub = rs.getString("hub_id");
                Employee e = new Employee(id, hub, name);
                result = e;
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
