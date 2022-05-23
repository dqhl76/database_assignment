package ucd.express;

import java.sql.Timestamp;

public class Test {
    private static void addHub() {
        System.out.println(ExpressDAO.addHub("Hangzhou ChunJiang Road", "Zhejiang Hangzhou"));
        System.out.println(ExpressDAO.addHub("Huabei ZhuanYun Center", "Hebei Shijiazhuang"));
        System.out.println(ExpressDAO.addHub("Beijing ChaoYang BeiGongDa", "Beijing Chaoyangs"));
    }

    private static void addCompany() {
        System.out.println(ExpressDAO.addCompany("SHUNFENG", "95338", "email@sf-express.com"));
    }

    private static void addSender() {
        System.out.println(ExpressDAO.addSender(ExpressDAO.generateID(), "Cao Zhe", "Beijing ChaoYang GongDa 11 Building", "13012341234", "114514", "45069"));
    }

    private static void addReceiver() {
        System.out.println(ExpressDAO.addReceiver(ExpressDAO.generateID(), "Mu Chen", "Hangzhou ChunJiang Road", "13843214321", "114514", "7764"));
    }

    private static void addRequest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(ExpressDAO.addRequest(ExpressDAO.generateID(), "Beijing ChaoYang GongDa 11 Building", "Hangzhou ChunJiang Road", "16463", "29443", "A package", "SHUNFENG", timestamp));
    }

    public static void main(String[] args) {
        System.out.println(ExpressDAO.addRoutine("45069", "7764", "45069", "58634"));
//        ExpressDAO.getSenderByNumber("16463");
//            addReceiver();
//            addSender();
//        addRequest();
//        Express e = ExpressDAO.getExpressByID("114514");
//        System.out.println(e.toString());
//        System.out.println(ExpressDAO.addSender("29443", "A", "11 Building", "100861", "114514"));
//        System.out.println(ExpressDAO.addReceiver("29443", "A", "11 Building", "100861", "114514"));
//        Sender s = ExpressDAO.getSenderByNumber("10086");
//        Receiver r = ExpressDAO.getReceiverByNumber("1919810");
//        System.out.println(s.getName() + " " + r.getName());
//        System.out.println(ExpressDAO.addRequest(ExpressDAO.generateID(), "11 Building", "first class", "20372318", "20372315", "C Coin", "SHUNFENG"));
//        System.out.println(ExpressDAO.generateID());
    }
}
