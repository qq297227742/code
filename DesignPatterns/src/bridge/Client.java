package bridge;

public class Client {
    public static void main(String[] args) {
        //销售联想的笔记本电脑
        Brand brand=new Lenovo();
        Computer computer=new Laptop(brand);

        computer.sale();
    }
}
