package streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一 Stram 的三个操作步骤：
 * 1 创建Stream
 * 2 中间操作
 * 3 终止操作
 */
public class TestStreamApi1
{
    //1创建Stream
    @Test
    public void test1()
    {
        //1 可以通过 Collection 系列集合提供的 stream() 或 parallelStream
        List<String> list = new ArrayList<>();
        /*第一种获取流的方式*/
        Stream<String> stream = list.stream();
        /*第二种获取流的方式*/
        Stream<String> stream1 = Arrays.stream(new String[10]);
        /*第三种获取流的方式*/
        Stream<String> aa = Stream.of("aa", "bb", "cc");
        /*第四种 获取无限流*/
        //迭代
        Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);
        //生成
        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(1).forEach(System.out::println);
    }
}
