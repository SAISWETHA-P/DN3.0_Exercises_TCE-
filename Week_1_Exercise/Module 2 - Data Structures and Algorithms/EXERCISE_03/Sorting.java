class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order[ID=" + orderId + ", Name=" + customerName + ", Total Price=" + totalPrice + "]";
    }
}

class Sorting {

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        Order pivot = orders[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot.getTotalPrice()) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(1, "Alice", 150.0),
            new Order(2, "Bob", 200.0),
            new Order(3, "Charlie", 100.0)
        };

        System.out.println("Before Sorting:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Bubble Sort
        bubbleSort(orders);
        System.out.println("\nAfter Bubble Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }

        // Reinitialize the array for demonstration purposes
        orders = new Order[]{
            new Order(1, "Alice", 150.0),
            new Order(2, "Bob", 200.0),
            new Order(3, "Charlie", 100.0)
        };

        // Quick Sort
        quickSort(orders, 0, orders.length - 1);
        System.out.println("\nAfter Quick Sort:");
        for (Order order : orders) {
            System.out.println(order);
        }
    }
}
