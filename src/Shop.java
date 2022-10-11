import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private String name;
    private List<Admin> admins;
    private List<Seller> sellers;
    private List<Customer> customers;
    private List<Product> products;

    public Shop(String name) {
        this.name = name;
        admins = new ArrayList<>();
        sellers = new ArrayList<>();
        customers = new ArrayList<>();
        products = new ArrayList<>();
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() { return products; }

    // get customer by cf
    public Customer getCustomerByCf(String cf) {
        for (Customer c : customers) {
            if (c.getCf().equals(cf)) {
                return c;
            }
        }
        return null;
    }

    public void addAdmin(Admin a) { admins.add(a); }
    public void addSeller(Seller s) { sellers.add(s); }
    public void addCustomer(Customer c) { customers.add(c); }
    public Product getProductById(int code) {
        for (Product product : products) {
            if (code == product.getId()) {
                return product;
            }
        }
        return null;
    }
    public Seller getSellerByLogin(String login) {
        for (Seller s : sellers) {
            if (s.getLogin().equals(login)) {
                return s;
            }
        }
        return null;
    }
    public void printCustomers() {
        for (Customer customer : customers) {
            customer.printInfo();
            System.out.println();
        }
    }

    public void printSellers() {
        for (Seller seller : sellers) {
            seller.printInfo();
        }
    }

}
