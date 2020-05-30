package strategy;

public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getProce(double standardPrice) {
        System.out.println("不打折，原价");
        return standardPrice;
    }
}
