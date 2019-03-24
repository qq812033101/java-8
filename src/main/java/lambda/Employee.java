package lambda;

public class Employee {
    private String name;
    private int age;
    private double slary;
    private Integer a;


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", slary=" + slary +
                '}';
    }

    public Employee() {
    }

    public Employee(String name, int age, double slary) {
        this.name = name;
        this.age = age;
        this.slary = slary;
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
}
