package ucd.express;

public class Test {
    private static void addHub() {
        System.out.println(ExpressDAO.addHub("Hangzhou ChunJiang Road", "Zhejiang Hangzhou"));
        System.out.println(ExpressDAO.addHub("Huabei ZhuanYun Center", "Hebei Shijiazhuang"));
        System.out.println(ExpressDAO.addHub("Beijing ChaoYang BeiGongDa", "Beijing Chaoyangs"));
    }

    private static void addCompany() {
        System.out.println(ExpressDAO.addCompany("SHUNFENG", "95338", "email@sf-express.com"));
    }


    public static void main(String[] args) {
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
