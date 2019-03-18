package lambda3;

import lambda.Employee;
import org.junit.Test;

import javax.swing.text.LabelView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda {
    @Test
    public void test() {
        List<Employee> fuck = Arrays.asList(
                new Employee("张三", 18, 9999.99),
                new Employee("李四", 38, 4999.99),
                new Employee("王五", 48, 5999.99),
                new Employee("赵六", 58, 8999.99),
                new Employee("天启", 16, 6999.99),
                new Employee("傻逼", 50, 7999.99));

        Collections.sort(fuck, (e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        for (Employee employee : fuck) {
            System.out.println(employee);
        }
    }


    @Test
    public void test2() {
        String a = str2STR("a", (e) -> e.toUpperCase());
        System.out.println(a);
    }

    public String str2STR(String str, MyFun mp) {
        return mp.getValue(str);
    }

    public void op(Long l1, Long l2, MyFun2<Long,Long> mp) {
        System.out.println(mp.getValue(l1, l2));
    }

    @Test
    public void test3() {
        op(100L, 200L, (x, y) -> x + y);
        op(100L, 200L, (x, y) -> x * y);
    }


}
