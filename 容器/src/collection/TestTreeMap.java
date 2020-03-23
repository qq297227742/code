package collection;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
    public static void main(String[] args) {
        Map map = new TreeMap();
    }
}

class Emp implements Comparable<Emp> {
    private int id;
    private String name;
    private double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int compareTo(@NotNull Emp o) {
        return (int) (this.salary-o.salary);
    }
}