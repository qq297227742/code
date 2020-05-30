package factory.abstractfactory;

public class Client {
    public static void main(String[] args) {
        CarFactory carFactory=new LuxuryCarFactory();
        Engine engine = carFactory.createEngine();

        engine.run();
        engine.start();
    }
}
