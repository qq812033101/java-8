package lambda;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    private double slary;
    private Integer a;
    private Status status;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, int age, double slary) {
        this.name = name;
        this.age = age;
        this.slary = slary;
    }

    public Employee(String name, int age, double slary, Integer a) {
        this.name = name;
        this.age = age;
        this.slary = slary;
        this.a = a;
    }

    public Employee(String name, int age, double slary, Status status) {
        this.name = name;
        this.age = age;
        this.slary = slary;
        this.status = status;
    }

    public Employee(String name, int age, double slary, Integer a, Status status) {
        this.name = name;
        this.age = age;
        this.slary = slary;
        this.a = a;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Double.compare(employee.slary, slary) == 0 &&
                Objects.equals(name, employee.name) &&
                Objects.equals(a, employee.a) &&
                status == employee.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, slary, a, status);
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", slary=" + slary +
                ", a=" + a +
                ", status=" + status +
                '}';
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSlary() {
        return slary;
    }

    public void setSlary(double slary) {
        this.slary = slary;
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION;
    }
}
