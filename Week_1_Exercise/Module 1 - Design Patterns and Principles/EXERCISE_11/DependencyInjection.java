// Dependency Injection Example
public class DependencyInjection {

    // Repository Interface
    public interface CustomerRepository {
        String findCustomerById(String id);
    }

    // Concrete Repository
    public static class CustomerRepositoryImpl implements CustomerRepository {
        @Override
        public String findCustomerById(String id) {
            // In a real application, this would query a database
            return "Customer details for ID: " + id;
        }
    }

    // Service Class
    public static class CustomerService {
        private CustomerRepository customerRepository;

        public CustomerService(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public void getCustomerDetails(String id) {
            System.out.println(customerRepository.findCustomerById(id));
        }
    }

    // Test the Dependency Injection Implementation
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);
        customerService.getCustomerDetails("12345");
    }
}
