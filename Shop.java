public class Shop {
    private String name;
    // list of admins
    private ArrayList<Admin> admins;
    // list of sellers
    private ArrayList<Seller> sellers;
    // list of customers
    private ArrayList<Customer> customers;

    public shop(String name) {
        this.name = name;
        this.admins = new ArrayList<Admin>();
        this.sellers = new ArrayList<Seller>();
        this.customers = new ArrayList<Customer>();
    }

    public Shop() {
        this.admins = new ArrayList<Admin>();
        this.sellers = new ArrayList<Seller>();
        this.customers = new ArrayList<Customer>();
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public ArrayList<Seller> getSellers() {
        return sellers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    // get customer by cf
    public Customer getCustomerByCf(String cf) {
        for (Customer customer : customers) {
            if (customer.getCf().equals(cf)) {
                return customer;
            }
        }
        return null;
    }

    //getProductbyCode
    public Product getProductByCode(String code) {
        for (Seller seller : sellers) {
            for (Product product : seller.getProducts()) {
                if (product.getCode().equals(code)) {
                    return product;
                }
            }
        }
        return null;
    }

    // add a new admin
    public void addAdmin(Admin admin) {
        admins.add(admin);
    }

    // add a new seller
    public void addSeller(Seller seller) {
        sellers.add(seller);
    }

    // add a new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

}
