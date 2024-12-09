import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String name, double initialBalance){
        if (name == null || initialBalance < 0) {
            return false;
        }
        Customer newCustomer = new Customer(name, initialBalance);

        customers.add(newCustomer);
        return true;

    }

    public Customer addCustomerTransaction(String name, double amount) {
        ArrayList<Customer> newCustomers = getCustomers();
        for (Customer c : newCustomers) {
            if (c.getName().equals(name)) {
                c.addTransaction(amount);
                return c;
            }
        }
        return null;
    }

    private Customer findCustomer(String name) {
        for (Customer c : customers) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        return null;
    }


}
