package mediator;

public class Client {
    public static void main(String[] args) {
        Mediator mediator = new President();

        Market market = new Market(mediator);
        Department department = new Development(mediator);
        Finacial finacial=new Finacial(mediator);

        market.selfAction();
        market.outAction();
    }
}
