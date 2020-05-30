package iterator;

public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma=new ConcreteMyAggregate();
        cma.addObject("AAA");
        cma.addObject("BBB");
        cma.addObject("CCC");

        MyIterator iterator = cma.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }
    }
}
