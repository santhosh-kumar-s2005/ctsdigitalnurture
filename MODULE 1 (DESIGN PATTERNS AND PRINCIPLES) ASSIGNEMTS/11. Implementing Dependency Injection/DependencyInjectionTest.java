public class DependencyInjectionTest {
    public static void main(String[] args) {
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        System.out.println("--- Looking up customers ---");
        service.getCustomerDetails(1);
        service.getCustomerDetails(2);
        service.getCustomerDetails(3);

        System.out.println("\n--- Looking up non-existent customer ---");
        service.getCustomerDetails(99);
    }
}
