public class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(String id) {
        // Simulated DB call
        return "Customer[ID=" + id + ", Name=Ginny Weasley]";
    }
}
