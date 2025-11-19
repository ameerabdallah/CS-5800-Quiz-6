import java.util.HashMap;
import java.util.Map;

public class ObserverImpl implements Observer {
    public final String name;
    Map<String, Double> stockPrices = new HashMap<>();

    public ObserverImpl(String name) {
        this.name = name;
    }

    @Override
    public void update(String symbol, double price) {
        double oldPrice = stockPrices.getOrDefault(symbol, price);
        stockPrices.put(symbol, price);

        if (oldPrice == price) {
            System.out.printf("Observer %s > No change in price for %s%n", this.name, symbol);
            return;
        }

        String change;

        if (price > oldPrice) {
            change = "+";
        } else { // must be price < oldPrice since equality is handled above
            change = "-";
        }

        change += String.format("$%.2f", Math.abs(price - oldPrice));

        System.out.printf("Observer %s > %s price change is %s. New price is $%.2f%n%n", this.name, symbol, change, price);
    }
}
