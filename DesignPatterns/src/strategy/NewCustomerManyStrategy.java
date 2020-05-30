package strategy;

public class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getProce(double standardPrice) {
        System.out.println("打九折，");
        return standardPrice*0.9;
    }
}
