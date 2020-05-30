package singleton;

public class SingletonDemo03 {
    private static SingletonDemo03 instace = null;

    public static SingletonDemo03 getInstace() {
        if (instace == null) {
            SingletonDemo03 sc;
            synchronized (SingletonDemo03.class) {
                sc=instace;
                if (sc == null) {
                    synchronized (SingletonDemo03.class) {
                        if (sc == null) {
                            sc=new SingletonDemo03();
                        }
                    }
                    instace = sc;
                }
            }
        }
        return instace;
    }
    private SingletonDemo03() {

    }
}
