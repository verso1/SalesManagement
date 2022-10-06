/*
public class Main {
    // main method
    */
    public static void main(String[] args) {
        // new shop of computer
        Shop computerShop = new Shop("Computer Shop");
        Customer customer1 = new Customer("John", "Doe", "1234567890", "Via Roma, 1", 1000);
        Customer customer2 = new Customer("Anna", "Tat", "0987654321", "Via Roma, 2", 1000);
        Product computer1 = new Product("Laptop", "Dell", 1000);
        Product computer2 = new Product("Laptop", "HP", 800);
        Admin admin = new Admin("admin", "admin");
        Seller seller1 = new Seller("seller1", "seller1");

        computerShop.addAdmin(admin);
        computerShop.addSeller(seller1);
        computerShop.addCustomer(customer1);
        computerShop.addCustomer(customer2);

        // ask user to login
        Scanner scanner = new Scanner(System.in);
        System.out.println("Prego effettuare login: ");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        // check if user is admin of computerShop
        if (username.equals(admin.getLogin()) && password.equals(admin.getPassword())) {
        Sale sale = new Sale(computer1, 1, 1000, "01/01/2020");
        customer.addSale(sale);
        customer.printSales();
        admin.undoSale(customer1, sale);
        customer.printSales();
    }
        /*
}
*/
