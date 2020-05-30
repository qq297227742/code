package mediator;

public class Finacial implements Department{
    /**
     * 持有中介者（总经理）的引用
     */
    private Mediator mediator;

    public Finacial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("finacial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("数钱！");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，钱太多了，怎么花！？");
    }
}
