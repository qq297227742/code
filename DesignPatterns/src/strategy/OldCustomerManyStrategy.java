package strategy;

public class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getProce(double standardPrice) {
        System.out.println("打八折");
        return standardPrice*0.8;
    }
}
