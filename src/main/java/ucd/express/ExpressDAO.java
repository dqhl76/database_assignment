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

    public static int addReceiver(String id, String name, String address, String phone, String password) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql1 = " INSERT INTO Receiver VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, id);
            ps1.setString(2, name);
            ps1.setString(3, address);
            ps1.setString(4, phone);
            ps1.setString(5, password);
            result = ps1.executeUpdate();
            ps1.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static int addRequest(String id, String senderAd, String receiverAd, String senderID, String receiverID, String content, String company) {
        int result = 0;
        try {
            Connection conn = JDBCTool.getConnection();
            String sql = "insert into Express values (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, content);
            ps.setString(3, senderAd);
            ps.setString(4, receiverAd);
            ps.setString(5, receiverID);
            ps.setString(6, senderID);
            ps.setString(7, company);
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
            String sql = "SELECT * FROM Receiver WHERE phone_number = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("full_name");
                String address = rs.getString("address");
                int phoneNumber = rs.getInt("phone_number");
                String password = rs.getString("password");

                Receiver e = new Receiver(id, name, address, phoneNumber, password);
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
            String sql = "SELECT * FROM Sender WHERE phone_number = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("full_name");
                String address = rs.getString("address");
                int phoneNumber = rs.getInt("phone_number");
                String password = rs.getString("password");

                Sender e = new Sender(id, name, address, phoneNumber, password);
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
}
