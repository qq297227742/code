package factory.builder;

public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new WwwAirShipDirector(new WwwAirShipBuilder());
        AirShip airShip = director.directAirShip();
        System.out.println(airShip.getEngine().getName());
    }
}
