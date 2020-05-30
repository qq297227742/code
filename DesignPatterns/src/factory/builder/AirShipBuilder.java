package factory.builder;

/**
 *
 */
public interface AirShipBuilder {
    Engine buiderEngine();

    OrbitalModule builderOrbitalModule();

    EscapeTower builderEscapeTower();
}
