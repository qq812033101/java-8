package streamapi;

import lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStramApi4 {
    /*1 给定一个数字列表
    *   如何返回一个由每个数的平方构成的列表？
    *   1 2 3 4 5 返回 1 4 9 16 25
    * */
    /*map完成*/
    @Test
    public void test1(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().map(x->x*x).forEach(System.out::println);
    }
    /*map+reduce完成*/
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("张三", 38, 4999.99, Employee.Status.BUSY),
            new Employee("王五", 48, 5999.99, Employee.Status.VOCATION),
            new Employee("赵六", 58, 8999.99, Employee.Status.FREE),
            new Employee("天启", 16, 6999.99, Employee.Status.BUSY),
            new Employee("傻逼", 50, 7999.99, Employee.Status.VOCATION));

    @Test
    public void test2(){
        Optional<Integer> reduce = employees.stream().map(e -> 1).reduce(Integer::sum);
        System.out.println(reduce);
    }


}
