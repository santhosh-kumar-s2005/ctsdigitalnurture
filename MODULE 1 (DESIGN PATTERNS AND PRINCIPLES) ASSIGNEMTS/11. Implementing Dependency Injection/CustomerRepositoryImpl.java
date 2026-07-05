import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<Integer, Customer> customerDatabase = new HashMap<>();

    public CustomerRepositoryImpl() {
        customerDatabase.put(1, new Customer(1, "Alice Johnson", "alice@example.com"));
        customerDatabase.put(2, new Customer(2, "Bob Smith", "bob@example.com"));
        customerDatabase.put(3, new Customer(3, "Carol White", "carol@example.com"));
    }

    @Override
    public Customer findCustomerById(int id) {
        return customerDatabase.getOrDefault(id, null);
    }
}
