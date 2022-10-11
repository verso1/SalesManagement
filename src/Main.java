import java.util.Scanner;

public class Main {
    // main method
    public static void main(String[] args) {

        Shop computerShop = new Shop("Computer Shop");
        Customer customer1 = new Customer("John", "Doe", "1234567890", "Via Roma, 1", 1000);
        Customer customer2 = new Customer("Anna", "Tat", "0987654321", "Via Roma, 2", 1000);
        Product computer1 = new Product(1,"Laptop", "Dell", 1000);
        Product computer2 = new Product(2,"Laptop", "HP", 800);
        Admin admin = new Admin("admin", "admin");
        Seller seller1 = new Seller("seller1", "seller1");

        computerShop.addAdmin(admin);
        computerShop.addSeller(seller1);
        computerShop.addCustomer(customer1);
        computerShop.addCustomer(customer2);

        // keep asking if the user wants to login until he wants to exit the program
        boolean exit = false;

        while (!exit) {
            // ask for login
            Scanner scanner = new Scanner(System.in);
            System.out.println("Inserisci il tuo username:");
            String login = scanner.nextLine();
            System.out.println("Inserisci la tua password:");
            String password = scanner.nextLine();

            // check if the user is an admin
            if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                // show admin features
                // keep asking for a feature until the user chooses to exit
                boolean exitAdmin = false;
                while(!exitAdmin) {
                    admin.getFeatures();
                    int choosenFeature = scanner.nextInt();
                    admin.doFeatures(choosenFeature, computerShop, exitAdmin);
                }
            }
            // check if the user is a seller
            else if (seller1.getLogin().equals(login) && seller1.getPassword().equals(password)) {
                // show seller features
                boolean exitSeller = false;
                while(!exitSeller) {
                    seller1.getFeatures();
                    int choosenFeature = scanner.nextInt();
                    seller1.doFeatures(choosenFeature, computerShop, exitSeller);
                }
            }
            // if the user is not an admin or a seller
            else {
                System.out.println("Username o password errati!");
            }
        }
    }
    void login() {


    }
}
