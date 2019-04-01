package streamapi;

import lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 终止操作
 */
public class TestStramApi3 {
    /*查找跟匹配
     * allMatch-检查是否匹配所有元素
     * anyMatch-检查是否至少匹配一给元素
     * noneMatch-检查是否没有匹配所有元素
     * findFirst-返回第一个元素
     * findAny-返回当前流中的任意元素
     * count-返回流中的总数
     * min-返回流中的最小值
     * max-返回流中的最大值
     * */
    @Test
    public void test() {
        boolean b = employees.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        boolean b1 = employees.stream().anyMatch((e) -> e.getStatus().equals(Employee.Status.FREE));
        System.out.println(b1);
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        boolean b2 = employees.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        Optional<Employee> first = employees.stream().sorted((x, y) -> Double.compare(x.getSlary(), y.getSlary()))
                .findFirst();
        System.out.println(first.get());
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        Optional<Employee> b3 = employees.stream().filter(e -> e.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(b3.get());
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        long count = employees.stream().count();
        System.out.println(count);
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*/*/*/*/*/*/");
        Optional<Employee> max = employees.stream().max(Comparator.comparingDouble(Employee::getSlary));
        System.out.println(max.get());
        Optional<Employee> min = employees.stream().min(Comparator.comparingDouble(Employee::getSlary));
        System.out.println(min.get());
    }

    /*归约
     * reduce(T identity,BinaryOperator)
     * /
     * reduce(BinaryOperator)
     * 可以将流中的元素反复结合起来，得到一个值
     * */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        Optional<Double> reduce = employees.stream().map(Employee::getSlary).reduce(Double::sum);
        System.out.println(reduce.get());
    }

    /*收集
     * collect--将流转换为其他形式。
     * 接收一个 Collector 接口的实现，用于给Stream中元素做汇总方法
     * */
    @Test
    public void test3() {
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(collect);
        Set<String> collect1 = employees.stream().map(Employee::getName).collect(Collectors.toSet());
        System.out.println(collect1);
        HashSet<String> collect2 = employees.stream().map(Employee::getName).
                collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect2);
    }

    @Test
    public void test4() {
        Long collect = employees.stream().map(Employee::getName).collect(Collectors.counting());
        System.out.println(collect);
        /*平均值*/
        Double collect1 = employees.stream().
                collect(Collectors.averagingDouble(Employee::getSlary));
        System.out.println(collect1);

        Double collect2 = employees.stream().mapToDouble(Employee::getSlary).sum();
        System.out.println(collect2);

        Optional<Employee> collect3 = employees.stream().max(Comparator.comparingDouble(Employee::getSlary));
        System.out.println(collect3.get());

        Optional<Double> collect4 = employees.stream().map(Employee::getSlary).min(Double::compareTo);
        System.out.println(collect4);
    }

    /*分组*/
    @Test
    public void tes5() {
        Map<Employee.Status, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);

    }

    /*多级分组*/
    @Test
    public void test6() {
        Map<Employee.Status, Map<String, List<Employee>>> collect = employees.stream().
                collect(Collectors.
                        groupingBy(Employee::getStatus, Collectors.groupingBy(e -> {
                            if (e.getAge() <= 35) {
                                return "青年";
                            } else if (e.getAge() <= 50) {
                                return "中年";
                            } else {
                                return "老年";
                            }
                        })));
        System.out.println(collect);
    }


    /*分区*/
    @Test
    public void test7() {
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(e -> e.getSlary() > 6000));
        System.out.println(collect);
    }

    @Test
    public void test8() {
        DoubleSummaryStatistics collect = employees.stream().collect(Collectors.summarizingDouble(
                Employee::getSlary
        ));
        System.out.println(collect);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.FREE),
            new Employee("张三", 38, 4999.99, Employee.Status.BUSY),
            new Employee("王五", 48, 5999.99, Employee.Status.VOCATION),
            new Employee("赵六", 58, 8999.99, Employee.Status.FREE),
            new Employee("天启", 16, 6999.99, Employee.Status.BUSY),
            new Employee("傻逼", 50, 7999.99, Employee.Status.VOCATION));


}
