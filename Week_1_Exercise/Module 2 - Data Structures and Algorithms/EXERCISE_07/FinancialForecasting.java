
class FinancialForecasting {

    public static double calculateFutureValue(double presentValue, double rate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return (1 + rate) * calculateFutureValue(presentValue, rate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000;
        double rate = 0.05;
        int periods = 10;

        double futureValue = calculateFutureValue(presentValue, rate, periods);
        System.out.println("Future Value after " + periods + " periods: " + futureValue);
    }
}
