package lambda4;

import org.junit.Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8中内置的4大核心函数接口
 * <p>
 * Consumer<T>:消费型接口
 * void accept();
 * <p>
 * Supplier<T>:供给型接口
 * T get();
 * <p>
 * Function(T,R):函数接口
 * R apply(T t);
 * <p>
 * Predicate<T>:断言型接口
 * boolean test(T t);
 */
public class Lambda4 {

    /*消费接口*/
    @Test
    public void test1() {
        happy(10000, (m) -> System.out.println("大保健，每次消费：" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    /*供给接口*/
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }

    }

    /*需求产生一些整数，并放入集合中*/
    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    /*函数型接口*/
    @Test
    public void test3() {
        String s = strHandler(" \t\t\t 我操你妈逼死全家", (str) -> str.trim());
        System.out.println(s);
    }

    /*需求：用于处理字符串*/
    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


    @Test
    public void test4() {
        List<String> list;
        list = Arrays.asList("hello", "atGuigu", "lambda", "www", "ok");
        List<String> list1 = filteStr(list, (s) -> s.length() > 3);
        System.out.println(list1);
    }

    /*断言接口*/
    public List<String> filteStr(List<String> list, Predicate<String> pre) {
        List<String> list1 = new ArrayList<>();
        for (String str : list) {
            if (pre.test(str)) {
                list1.add(str);
            }
        }
        return list1;
    }
}




















































































