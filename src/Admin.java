
import java.util.Scanner;

public class Admin extends Seller {
    public Admin(String login, String password) {
        super(login, password);
    }

    // undo a sale
    public void undoSale(Customer customer, Sale sale) {
        customer.getSales().remove(sale);
        // increase wallet
        customer.setWallet(customer.getWallet() + sale.getTotal());
    }

    // add new seller
    public Seller addSeller(String login, String password) { return new Seller(login, password); }

    // reset seller's password
    public void resetSellerPassword(Seller seller) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la nuova password: ");
        String newPassword = scanner.nextLine();
        seller.setPassword(newPassword);
    }

    // reset seller's login
    public void resetSellerLogin(Seller seller) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci il nuovo login: ");
        String newLogin = scanner.nextLine();
        seller.setLogin(newLogin);
    }

    public void getFeatures() {
        super.getFeatures();
        System.out.println("7. Annulla acquisto");
        System.out.println("8. Registra un nuovo venditore");
        System.out.println("9. Resetta password di un dipendente");
        System.out.println("10. Resetta login di un dipendente");

    }


    public void doFeatures(int choosenFeature, Shop choosenShop, boolean exit) {
        super.doFeatures(choosenFeature, choosenShop, exit);
        Scanner scanner = new Scanner(System.in);

        switch (choosenFeature) {
            case 7:
                System.out.println("Lista clienti: ");
                choosenShop.printCustomers();

                System.out.println("Inserisci il CF del cliente: ");
                String cf = scanner.nextLine();
                Customer customer = choosenShop.getCustomerByCf(cf);
                if (customer != null) {

                    System.out.println("Acquisti di " + customer.getName() + " " + customer.getSurname() + ":");
                    customer.printSales();
                    System.out.println("Inserisci il codice del prodotto: ");
                    int code = scanner.nextInt();

                    System.out.println("Inserisci la data dell'acquisto: ");
                    String date = scanner.nextLine();

                    Sale sale = customer.findSale(code, date);
                    if (sale != null) {
                        undoSale(customer, sale);
                    } else {
                        System.out.println("Acquisto non trovato!");
                    }
                } else {
                    System.out.println("Cliente non trovato!");
                }
                break;

            case 8:
                System.out.println("Inserisci il login del nuovo venditore: ");
                String login = scanner.nextLine();
                System.out.println("Inserisci la password del nuovo venditore: ");
                String password = scanner.nextLine();
                Seller seller = addSeller(login, password);
                choosenShop.addSeller(seller);
                System.out.println("Venditore aggiunto con successo!");
                break;

            case 9:
                System.out.println("Lista dipendenti: ");
                choosenShop.printSellers();
                System.out.println("Inserisci il login del dipendente: ");
                String loginSeller = scanner.nextLine();
                Seller sellerToReset = choosenShop.getSellerByLogin(loginSeller);
                if (sellerToReset != null) {
                    resetSellerPassword(sellerToReset);
                    System.out.println("Password resettata con successo!");
                } else {
                    System.out.println("Dipendente non trovato!");
                }
                break;

            case 10:
                System.out.println("Lista dipendenti: ");
                choosenShop.printSellers();
                System.out.println("Inserisci il login del dipendente: ");
                String loginSeller2 = scanner.nextLine();
                Seller sellerToReset2 = choosenShop.getSellerByLogin(loginSeller2);
                if (sellerToReset2 != null) {
                    resetSellerLogin(sellerToReset2);
                    System.out.println("Login resettato con successo!");
                } else {
                    System.out.println("Dipendente non trovato!");
                }
                break;
        }
    }
}
