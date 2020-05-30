package observer2;

import observer.Observer;

public class Client {
    public static void main(String[] args) {
        //创建目标对象Obserable
        ConcreteSubject subject=new ConcreteSubject();

//        创建观察者
        ObserverA obs1=new ObserverA();
        ObserverA obs2=new ObserverA();
        ObserverA obs3=new ObserverA();

        //将上面的三个观察者对象添加到subject的观察者容器中
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        //改变subject对象的状态
        subject.setState(100);

        //看看观察者的状态发生了变化
        System.out.println(obs1.getMyState());

    }
}
