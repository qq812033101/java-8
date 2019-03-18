package lambda2;

import org.junit.Test;

import java.util.Comparator;

/**
 * 一,lambda的基础语法：Java8中引入了一个新的操作符 "->" 该操作符成为箭头操作符或者lambda 操作符
 * 箭头操作符将 lambda 表达式拆分成两部分：
 * 左侧：lambda 表示的参数列表
 * 右侧：lambda 表示中所需要执行的功能，及 lambda 体
 * 语法格式一：无参数，五返回值的方法
 * () -> System.out.println("hello lambda!")
 * <p>
 * 语法格式2：有一个参数，无返回值
 * (x) -> System.out.println(x)
 * <p>
 * 语法格式3：若只有一个参数，那么参数的小括号可以省略不写
 * x -> System.out.println(x)
 * <p>
 * 语法格式4：多个参数，并且lambda体中有多条语句，有返回值。
 * Comparator<Integer> com = (x, y) -> {
 * System.out.println("函数接口");
 * return Integer.compare(x, y);
 * };
 * <p>
 * 语法格式5：多个参数，有返回值，lambda体只有一条语句，return {} 都可以不写
 * Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
 * <p>
 * 语法格式6：lambda 的参数列表的数据类型可以省略不写，因为jvm编译器可以从上下文推断出数据类型
 * 即"类型推断"
 * 二，lambda表达式需要‘函数式接口’的支持
 * 函数式接口：接口中只有一个抽象方法的接口，可以使用注解 @FunctionalInterface 修饰一下
 * 可以检擦是否是一个函数接口
 */
public class TestLambda {

    @Test
    public void test1() {
        Runnable r = () -> System.out.println("fuck");
        r.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
    }

    @Test
    public void test3() {
        Integer operation = operation(100, (x) -> x * x);
        System.out.println(operation);
        System.out.println(operation(200, (x) -> x + 200));
    }

    public Integer operation(Integer num, MyFun mf) {
        return mf.getValue(num);
    }
}
