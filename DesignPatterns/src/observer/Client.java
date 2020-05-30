package observer;

public class Client {
    public static void main(String[] args) {
        //目标对象
        ConcreteSubject subject = new ConcreteSubject();

        //创建多个观察者
        ObserverA obs1=new ObserverA();
        ObserverA obs2=new ObserverA();
        ObserverA obs3=new ObserverA();

        //将者三个观察者添加到subject对象的观察者容器中
        subject.register(obs1);
        subject.register(obs2);
        subject.register(obs3);

        //改变subject的状态
        subject.setState(3000);

        System.out.println(obs1.getMyState());
    }
}
