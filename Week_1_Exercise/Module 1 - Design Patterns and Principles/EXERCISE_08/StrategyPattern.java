// Strategy Pattern Example
public class StrategyPattern {

    // Strategy Interface
    public interface PaymentStrategy {
        void pay(String amount);
    }

    // Concrete Strategy - CreditCardPayment
    public static class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(String amount) {
            System.out.println("Payment of " + amount + " made using Credit Card.");
        }
    }

    // Concrete Strategy - PayPalPayment
    public static class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(String amount) {
            System.out.println("Payment of " + amount + " made using PayPal.");
        }
    }

    // Context Class
    public static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(String amount) {
            paymentStrategy.pay(amount);
        }
    }

    // Test the Strategy Implementation
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        paymentContext.setPaymentStrategy(new CreditCardPayment());
        paymentContext.executePayment("100 USD");

        paymentContext.setPaymentStrategy(new PayPalPayment());
        paymentContext.executePayment("200 USD");
    }
}
