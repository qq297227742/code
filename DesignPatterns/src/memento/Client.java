package memento;

public class Client {
    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();

        Emp emp = new Emp("搞起", 18, 900);
        System.out.println("第一次打印对象：" + emp.getEname() + "----" + emp.getAge() + "---" + emp.getSalary());

        //备忘一次
        careTaker.setMemento(emp.memento());

        emp.setAge(38);
        emp.setEname("高清哦");
        emp.setSalary(9000);
        System.out.println("第二次打印对象：" + emp.getEname() + "----" + emp.getAge() + "---" + emp.getSalary());

        //恢复到备忘录对象保存的状态
        emp.recovery(careTaker.getMemento());
        System.out.println("第三次打印对象：" + emp.getEname() + "----" + emp.getAge() + "---" + emp.getSalary());
    }
}
