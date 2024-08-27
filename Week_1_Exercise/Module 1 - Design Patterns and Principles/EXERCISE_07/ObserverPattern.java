import java.util.ArrayList;
import java.util.List;

// Observer Pattern Example
public class ObserverPattern {

    // Subject Interface
    public interface Stock {
        void register(Observer observer);
        void deregister(Observer observer);
        void notifyObservers();
    }

    // Concrete Subject
    public static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private double stockPrice;

        public void setStockPrice(double stockPrice) {
            this.stockPrice = stockPrice;
            notifyObservers();
        }

        @Override
        public void register(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void deregister(Observer observer) {
            observers.remove(observer);
        }

        @Override
        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockPrice);
            }
        }
    }

    // Observer Interface
    public interface Observer {
        void update(double stockPrice);
    }

    // Concrete Observer - MobileApp
    public static class MobileApp implements Observer {
        @Override
        public void update(double stockPrice) {
            System.out.println("MobileApp: Stock price updated to " + stockPrice);
        }
    }

    // Concrete Observer - WebApp
    public static class WebApp implements Observer {
        @Override
        public void update(double stockPrice) {
            System.out.println("WebApp: Stock price updated to " + stockPrice);
        }
    }

    // Test the Observer Implementation
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.register(mobileApp);
        stockMarket.register(webApp);

        stockMarket.setStockPrice(100.50);
        stockMarket.setStockPrice(102.75);
    }
}
