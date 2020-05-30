package adapter;

/**
 * 客户端类
 * （相当于例子中的，笔记本电脑，只有USB接口）
 */
public class Client {
    public void test1(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Client client = new Client();
        Adaptee a = new Adaptee();
       Target target=new Adapter();

        client.test1(target);
    }
}
