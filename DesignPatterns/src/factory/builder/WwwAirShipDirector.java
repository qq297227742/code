package factory.builder;

public class WwwAirShipDirector implements AirShipDirector {

    private AirShipBuilder builder;

    public WwwAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip directAirShip() {
        Engine engine = builder.buiderEngine();
        EscapeTower escapeTower = builder.builderEscapeTower();
        OrbitalModule orbitalModule = builder.builderOrbitalModule();

        AirShip airShip=new AirShip();

        airShip.setEngine(engine);
        airShip.setEscapeTower(escapeTower);
        airShip.setOrbitalModule(orbitalModule);

        return airShip;
    }
}
