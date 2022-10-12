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

    //togliere il passaggio della password, è inutile al controllo
    public boolean sellerExists(String login, String password, Shop choosenShop) {
        for (Seller s : choosenShop.getSellers()) {
            if (s.getLogin().equals(login)) {
                return true;
            }
        }
        return false;
    }

    public Seller addSeller(String login, String password, Shop choosenShop) { return new Seller(login, password); }

    // reset seller's password
    public void resetSellerPassword(Seller seller) {
        System.out.println("Inserisci la nuova password: ");
        String newPassword = Main.scanner.nextLine();
        seller.setPassword(newPassword);
    }

    // reset seller's login
    public void resetSellerLogin(Seller seller) {
        System.out.println("Inserisci il nuovo login: ");
        String newLogin = Main.scanner.nextLine();
        seller.setLogin(newLogin);
    }
    @Override
    public void getFeatures() {
        super.getFeatures();
        System.out.println("7. Annulla acquisto");
        System.out.println("8. Registra un nuovo venditore");
        System.out.println("9. Resetta password di un dipendente");
        System.out.println("10. Resetta login di un dipendente");

    }

    @Override
    public boolean doFeatures(int choosenFeature, Shop choosenShop) {
        switch (choosenFeature) {
            case 0:
                System.out.println("Grazie per aver usato il programma!");
                // TODO aggiustare la condizione di uscita
                return false;
            case 1:
                System.out.println("Inserisci nome: ");
                String name = Main.scanner.nextLine();
                System.out.println("Inserisci cognome: ");
                String surname = Main.scanner.nextLine();
                System.out.println("Inserisci codice fiscale: ");
                String cf = Main.scanner.nextLine();
                System.out.println("Inserisci indirizzo: ");
                String address = Main.scanner.nextLine();
                System.out.println("Inserisci portafoglio: ");
                double wallet = Main.scanner.nextDouble();
                Main.scanner.nextLine();
                Customer newCustomer = createCustomer(name, surname, cf, address, wallet);

                choosenShop.addCustomer(newCustomer);
                System.out.println("Cliente aggiunto con successo!");
                break;
            case 2:
                choosenShop.printCustomers();
                System.out.println("Inserisci codice fiscale del cliente da modificare: ");
                String cfToEdit = Main.scanner.nextLine();
                Customer customerToEdit = choosenShop.getCustomerByCf(cfToEdit);
                if (customerToEdit != null) {
                    System.out.println("Inserisci nuovo nome: ");
                    String newName = Main.scanner.nextLine();
                    System.out.println("Inserisci nuovo cognome: ");
                    String newSurname = Main.scanner.nextLine();
                    System.out.println("Inserisci nuovo codice fiscale: ");
                    String newCf = Main.scanner.nextLine();
                    System.out.println("Inserisci nuovo indirizzo: ");
                    String newAddress = Main.scanner.nextLine();
                    // ask if the user wants to change the wallet
                    System.out.println("Vuoi modificare il portafoglio? (y/n)");
                    String changeWallet = Main.scanner.nextLine();
                    if (changeWallet.equals("y")) {
                        System.out.println("Inserisci nuovo portafoglio: ");
                        double newWallet = Main.scanner.nextDouble();
                        Main.scanner.nextLine();
                        editCustomer(customerToEdit, newName, newSurname, newCf, newAddress, newWallet);
                    } else {
                        editCustomer(customerToEdit, newName, newSurname, newCf, newAddress, customerToEdit.getWallet());
                    }
                    System.out.println("Cliente modificato con successo!");
                } else {
                    System.out.println("Cliente non trovato!");
                }
                break;
            case 3:
                // show customers
                choosenShop.printCustomers();
                System.out.println("Inserisci codice fiscale del cliente: ");
                String cfToShow = Main.scanner.nextLine();
                Customer customerToShow = choosenShop.getCustomerByCf(cfToShow);
                if (customerToShow != null) {
                    customerToShow.printSales();
                } else {
                    System.out.println("Cliente non trovato!");
                }
                break;
            case 4:
                System.out.println("Inserisci codice fiscale del cliente: ");
                String cfToRegister = Main.scanner.nextLine();
                Customer customerToRegister = choosenShop.getCustomerByCf(cfToRegister);
                if (customerToRegister != null) {
                    System.out.println("Inserisci codice del prodotto: ");
                    int code = Main.scanner.nextInt();
                    Product product = choosenShop.getProductById(code);
                    if (product != null) {
                        System.out.println("Inserisci quantità: ");
                        int quantity = Main.scanner.nextInt();
                        Main.scanner.nextLine();
                        System.out.println("Inserisci data: ");
                        String date = Main.scanner.nextLine();
                        double total = quantity * product.getUprice();
                        if (customerToRegister.getWallet() >= total) {
                            registerSale(customerToRegister, product, quantity, total, date);
                            System.out.println("Acquisto registrato con successo!");
                        } else {
                            System.out.println("Acquisto non registrato, portafoglio insufficiente!");
                        }
                    } else {
                        System.out.println("Prodotto non trovato!");
                    }
                } else {
                    System.out.println("Cliente non trovato!");
                }
                break;
            case 5:
                choosenShop.printCustomers();
                break;
            case 6:
                editPassword();
                System.out.println("Password modificata con successo!");
                break;

            case 7:
                System.out.println("Lista clienti: ");
                choosenShop.printCustomers();
                System.out.println("Inserisci il CF del cliente: ");
                // to avoid redefinition of cf
                cf = Main.scanner.nextLine();
                Customer customer = choosenShop.getCustomerByCf(cf);
                if (customer != null) {

                    System.out.println("Acquisti di " + customer.getName() + " " + customer.getSurname() + ":");
                    customer.printSales();
                    System.out.println("Inserisci il codice del prodotto: ");
                    int code = Main.scanner.nextInt();

                    System.out.println("Inserisci la data dell'acquisto: ");
                    String date = Main.scanner.nextLine();

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
                // TODO: continua a chiedere nome utente finche non valido, poi password e infine registralo
                System.out.println("Inserisci il login del nuovo venditore: ");
                String login = Main.scanner.nextLine();
                System.out.println("Inserisci la password del nuovo venditore: ");
                String password = Main.scanner.nextLine();
                if (!sellerExists(login, password, choosenShop)) {
                    Seller seller = addSeller(login, password, choosenShop);
                    choosenShop.addSeller(seller);
                    System.out.println("Venditore registrato con successo!");
                } else {
                    System.out.println("Venditore già registrato!");
                }
                break;

            case 9:
                System.out.println("Lista dipendenti: ");
                choosenShop.printSellers();
                Main.scanner.nextLine();

                System.out.println("Inserisci il login del dipendente: ");
                String loginSeller = Main.scanner.nextLine();
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
                Main.scanner.nextLine();

                System.out.println("Inserisci il login del dipendente: ");
                String sellerToEdit = Main.scanner.nextLine();
                Seller loginToReset = choosenShop.getSellerByLogin(sellerToEdit);
                if (loginToReset != null) {
                    resetSellerLogin(loginToReset);
                    System.out.println("Login resettato con successo!");
                } else {
                    System.out.println("Dipendente non trovato!");
                }
                break;

            default:
                System.out.println("Scelta non valida!");
                break;
        }
        return true;
    }
}
