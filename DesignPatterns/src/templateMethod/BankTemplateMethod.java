package templateMethod;

public abstract class BankTemplateMethod {
    /**
     * 具体方法
     */
    public void takeNumber(){
        System.out.println("取号排队");
    }

    /**
     * 办理具体业务
     * 钩子方法
     */
    public abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");
    }

    public final void process(){
        this.takeNumber();

        this.transact();

        this.evaluate();
    }

}
