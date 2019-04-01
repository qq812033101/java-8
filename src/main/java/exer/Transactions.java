package exer;

public class Transactions {
    private Trader trader;
    private Integer year;
    private Integer price;

    public Transactions(Trader trader, Integer year, Integer price) {
        this.trader = trader;
        this.year = year;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "trader=" + trader +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
