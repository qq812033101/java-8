package exer;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestTransaction {

    List<Transactions> testTransactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        testTransactions = Arrays.asList(
                new Transactions(brian, 2011, 300),
                new Transactions(raoul, 2012, 1000),
                new Transactions(raoul, 2011, 400),
                new Transactions(mario, 2011, 710),
                new Transactions(mario, 2011, 700),
                new Transactions(alan, 2012, 950)
        );
    }


    /*找出2011年发生的所有交易，并按交易额排序(低到高)*/
    @Test
    public void test1() {
        testTransactions.stream().filter(e -> e.getYear() == 2011).
                sorted(Comparator.comparingInt(Transactions::getPrice)).
                forEach(System.out::println);
    }

    /*交易员都在哪些不同的城市工作过*/
    @Test
    public void test2() {
        testTransactions.stream().map(e -> e.getTrader().getCity()).
                distinct().forEach(System.out::println);
    }

    /*查找所有来自剑桥的交易员，并按姓名排序*/
    @Test
    public void test3() {
        testTransactions.stream().
                filter(e -> e.getTrader().getCity().equals("Cambridge")).
                sorted(Comparator.comparing(e -> e.getTrader().getName())).
                forEach(System.out::println);
        testTransactions.stream().
                filter(e -> e.getTrader().getCity().equals("Cambridge"))
                .map(Transactions::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .distinct()
                .forEach(System.out::println);
    }


}
