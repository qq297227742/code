package factory.builder;

public class WwwAirShipBuilder implements AirShipBuilder{
    @Override
    public Engine buiderEngine() {
        System.out.println("构建维维牌发动机");
        return new Engine("维维牌发动机");
    }

    @Override
    public OrbitalModule builderOrbitalModule() {
        System.out.println("构建维维牌轨道舱");
        return new OrbitalModule("维维牌轨道舱");
    }

    @Override
    public EscapeTower builderEscapeTower() {
        System.out.println("构建维维牌逃生舱");
        return new EscapeTower("维维牌逃生舱");
    }
}
