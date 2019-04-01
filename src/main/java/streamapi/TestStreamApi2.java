package streamapi;

import lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@SuppressWarnings("Duplicates")
public class TestStreamApi2 {
    /*排序
     * sorted()-自然排序
     * sorted(Comparator com)-定制排序
     *
     * */
    @Test
    public void test3() {
        List<String> list = Arrays.asList("aaa", "ccc", "bbb", "ddd", "eee");
        list.stream().sorted().forEach(System.out::println);
        System.out.println("---------------------");
        employees.stream().sorted((x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return Integer.compare(x.getAge(), y.getAge());
            }
        }).forEach(System.out::println);
    }


    /*映射
     * map--接受 lambda 将元素转成其他形式或提取信息。接收一个函数作为参数
     * 该函数会被应用到每个元素上，并将其映射成一个新的元素。
     * flatMap-- 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成1个流
     * */
    @Test
    public void test1() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
        System.out.println("------------------------");
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("------------------------");

        list.stream().map(TestStreamApi2::filterCharacter)
                .forEach((sm) -> sm.forEach(System.out::println));
        System.out.println("------------------------");


        list.stream().flatMap(TestStreamApi2::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }


    /*中间操作*/
    /*筛选跟切片
     * filter-接收 lambda .从流中排除某些元素
     * limit-截断流，使其中的元素不超过给定的数量
     * skip(n)-跳过元素，返回一个扔掉了N个元素的流。若流中元素不足N个，则返回一个空流，一Limit(N)互补
     * distinct-筛选，通过流所生成的元素 hashcode()和 equals() 去重
     *
     * */

    List<Employee> employees = Arrays.asList(new Employee("张三", 18, 9999.99), new Employee("李四", 38, 4999.99), new Employee("王五", 48, 5999.99), new Employee("赵六", 58, 8999.99), new Employee("天启", 16, 6999.99), new Employee("傻逼", 50, 7999.99));

    @Test
    public void test() {
        /*第一种方式*/
        /*中间操作：不会执行任何的操作*/
        Stream<Employee> employeeStream = employees.stream().filter((e) -> {
            System.out.printf("中间操作");
            return e.getAge() > 35;
        });
        /*终止操作：一次性执行全部的内容 （惰性求值）*/
        employeeStream.forEach(System.out::println);

        /*第二种方式*/
        employees.stream().filter((e) -> e.getAge() > 35).forEach(System.out::println);

    }

}
