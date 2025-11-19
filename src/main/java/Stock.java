import java.util.ArrayList;
import java.util.List;

public class Stock {
    private final List<Observer> observers = new ArrayList<>();
    private final String symbol;
    private double price;

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    public void acceptObserver(Observer observer) {
        observers.add(observer);
    }

    public void setPrice(double price) {
        this.price = price;
        for (Observer observer : this.observers) {
            observer.update(this.symbol, price);
        }
    }

    public double getPrice() {
        return this.price;
    }
}
