public class Main {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl(); // The concrete instance
        CustomerService service = new CustomerService(repo); // Injecting it

        service.displayCustomer("C001");
    }
}
