public class Seller {
    public String login;
    public String password;

    public Seller(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    // create new Customer
    public Customer createCustomer(String name, String surname, String cf, String address, double wallet) {
        return new Customer(name, surname, cf, address, wallet);
    }

    // edit Customer
    public void editCustomer(Customer customer, String name, String surname, String cf, String address, double wallet) {
        customer.setName(name);
        customer.setSurname(surname);
        customer.setCf(cf);
        customer.setAddress(address);
        customer.setWallet(wallet);
    }

    // show customer's list of sales
    public void showCustomerSales(Customer customer) {
        customer.printSales();
    }

    // register a new sale to a customer
    public void registerSale(Customer customer, Product product, int quantity, double total, String date) {
        Sale sale = new Sale(product, quantity, total, date);
        customer.addSale(sale);
    }


}
