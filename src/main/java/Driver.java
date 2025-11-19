void main() {
    Stock stock1 = new Stock("AAPL");
    Stock stock2 = new Stock("GOOGL");

    Observer observer1 = new ObserverImpl("Ameer");
    Observer observer2 = new ObserverImpl("Zain");

    stock1.acceptObserver(observer1);
    stock1.acceptObserver(observer2);

    stock2.acceptObserver(observer2);

    stock1.setPrice(120.00);
    stock2.setPrice(1550.00);

    System.out.println("AAPL has 2 observers and GOOGL has 1 observer\n");

    for (int i = 0; i < 3; i++) {
        System.out.println("=========");
        System.out.println("Round " + (i + 1) + " of price updates:\n");
        double price1 = stock1.getPrice() + Math.random() * 50;
        double price2 = stock2.getPrice() + Math.random() * 100;

        stock1.setPrice(price1);
        stock2.setPrice(price2);
    }
}
