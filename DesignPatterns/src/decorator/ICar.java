package decorator;

/**
 * 抽象构件
 */
public interface ICar {
    void move();
}

/**
 * 具体构件角色（真实对象）
 */
class Car implements ICar {

    @Override
    public void move() {
        System.out.println("陆地上跑 ！");
    }
}

/**
 * 装饰角色
 */
class SuperCar implements ICar{

    protected ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}
//具体装饰角色
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }
    public void fly(){
        System.out.println("天上飞！");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

//具体装饰角色
class WaterCar extends SuperCar {

    public WaterCar(ICar car) {
        super(car);
    }
    public void swim(){
        System.out.println("水上游！");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}

//具体装饰角色
class AIrCar extends SuperCar {

    public AIrCar(ICar car) {
        super(car);
    }
    public void auto(){
        System.out.println("自动驾驶！");
    }

    @Override
    public void move() {
        super.move();
        auto();
    }
}