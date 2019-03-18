package lambda;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

@SuppressWarnings("Duplicates")
public class TestLambda {

    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    //Lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }

    List<Employee> fuck = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 4999.99),
            new Employee("王五", 48, 5999.99),
            new Employee("赵六", 58, 8999.99),
            new Employee("天启", 16, 6999.99),
            new Employee("傻逼", 50, 7999.99));


//    @Test
//    public void test3() {
//        List<Employee> employees = filterEmployee(fuck);
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//    }

    @Test
    public void test4() {
        List<Employee> employees = filterEmployee(fuck, new FilterEmployeeByAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test5() {
        List<Employee> employees = filterEmployee(fuck, new FilterEmoloyeeBySalart());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void test6() {
        List<Employee> employees = filterEmployee(fuck, (e) -> e.getSlary() >= 5000);
        employees.forEach(System.out::println);

    }


    public List<Employee> filterEmployee(List<Employee> list, MyFilter<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }


}
