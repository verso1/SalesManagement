import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    // main method
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Shop computerShop = new Shop("Computer Shop");
        Customer customer1 = new Customer("John", "Doe", "1234567890", "Via Roma, 1", 1000);
        Customer customer2 = new Customer("Anna", "Tat", "0987654321", "Via Roma, 2", 1000);
        Product computer1 = new Product(1,"Laptop", "Dell", 1000);
        Product computer2 = new Product(2,"Laptop", "HP", 800);
        Admin admin = new Admin("admin", "admin");
        Seller seller1 = new Seller("seller1", "seller1");
        Seller seller2 = new Seller("seller2", "seller2");

        computerShop.addAdmin(admin);
        computerShop.addSeller(seller1);
        computerShop.addCustomer(customer1);
        computerShop.addCustomer(customer2);

        while (true) {
            System.out.println("Scegli a quale shop accedere:");
            System.out.println("1. Computer Shop");
            //System.out.println("2. Book Shop");
            System.out.println("2. Exit");

            int choice = Main.scanner.nextInt();
            Main.scanner.nextLine();

            switch(choice){
                case 1:
                    login(computerShop);
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }

        }
    }

    public static void login(@NotNull Shop choosenShop) {
        while (true) {
            System.out.println("Inserisci il tuo username:");
            String login = Main.scanner.nextLine();
            System.out.println("Inserisci la tua password:");
            String password = Main.scanner.nextLine();

            if (!checkAdmin(login, password, choosenShop) && !checkSeller(login, password, choosenShop)) {
                System.out.println("Username o password errati!");
            } else {
                break;
            }

        }
    }

    public static boolean checkAdmin(String login, String password, Shop choosenShop) {
        for (Admin a : choosenShop.getAdmins()) {
            if (a.getLogin().equals(login) && a.getPassword().equals(password)) {
                while (true) {
                    a.getFeatures();
                    int choosenFeature = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    if (!a.doFeatures(choosenFeature, choosenShop))
                        break;
                }
            } else {
                return false;
                //System.out.println("Le credenziali inserite non ti consentono l'accesso come amministratore");
            }
        }
        return true;
    }

    public static boolean checkSeller(String login, String password, Shop choosenShop) {
        for (Seller s : choosenShop.getSellers()) {
            if (s.getLogin().equals(login) && s.getPassword().equals(password)) {
                while (true) {
                    s.getFeatures();
                    int choosenFeature = Main.scanner.nextInt();
                    Main.scanner.nextLine();
                    if (!s.doFeatures(choosenFeature, choosenShop))
                        break;
                }
            } else {
                return false;
                //System.out.println("Le credenziali inserite non ti consentono l'accesso come venditore");
            }
        }
        return true;
    }
}
