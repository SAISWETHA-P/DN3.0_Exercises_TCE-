public class AdapterPattern {

    // Target Interface
    public interface PaymentProcessor {
        void processPayment(String amount);
    }

    // Adaptee Class 1
    public static class Paytm {
        public void makePayment(String amount) {
            System.out.println("Payment of " + amount + " made using Paytm.");
        }
    }

    // Adaptee Class 2
    public static class Googlepay {
        public void charge(String amount) {
            System.out.println("Payment of " + amount + " charged using Googlepay.");
        }
    }

    // Adapter Class for Paytm
    public static class PaytmAdapter implements PaymentProcessor {
        private Paytm paytm;

        public PaytmAdapter(Paytm paytm) {
            this.paytm = paytm;
        }

        @Override
        public void processPayment(String amount) {
            paytm.makePayment(amount);
        }
    }

    // Adapter Class for Googlepay
    public static class GooglepayAdapter implements PaymentProcessor {
        private Googlepay googlepay;

        public GooglepayAdapter(Googlepay googlepay) {
            this.googlepay = googlepay;
        }

        @Override
        public void processPayment(String amount) {
            googlepay.charge(amount);
        }
    }

    // Test the Adapter Implementation
    public static void main(String[] args) {
        PaymentProcessor paytmProcessor = new PaytmAdapter(new Paytm());
        paytmProcessor.processPayment("100 Rupees");

        PaymentProcessor googlepayProcessor = new GooglepayAdapter(new Googlepay());
        googlepayProcessor.processPayment("200 Rupees");
    }
}
