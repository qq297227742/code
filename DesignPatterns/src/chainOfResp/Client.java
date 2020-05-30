package chainOfResp;

public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new GeneralManager("王五");

        a.setNextLeader(b);
        b.setNextLeader(c);

        LeaveRequest request = new LeaveRequest("赵六",20,"度蜜月");
        a.handleRequest(request);


    }
}
