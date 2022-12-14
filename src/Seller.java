import java.util.Scanner;

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) { this.password = password; }
    public void setLogin(String login) { this.login = login; }

    // print customer info
    public void printInfo() {
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
    }

    // create new Customer
    public Customer createCustomer(String name, String surname, String cf, String address, double wallet) {
        return new Customer(name, surname, cf, address, wallet);
    }

    // edit Customer
    public void editCustomer(Customer customer, String name, String surname, String cf, String address, double wallet) {
        if (!name.equals("")) { customer.setName(name); }

        if (!surname.equals("")) { customer.setSurname(surname); }

        if (!cf.equals("")) { customer.setCf(cf); }

        if (!address.equals("")) { customer.setAddress(address);}

        // cast wallet to a string and check if it's not empty
        if (!String.valueOf(wallet).equals("")) { customer.setWallet(wallet); }
    }
    public void showCustomerSales(Customer customer) { customer.printSales(); }
    public void registerSale(Customer customer, Product product, int quantity, double total, String date) {
        Sale sale = new Sale(product, quantity, total, date);
        customer.addSale(sale);
        customer.setWallet(customer.getWallet() - total);
    }

    public void editPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci la vecchia password: ");
        String oldPassword = scanner.nextLine();
        if (oldPassword.equals(this.password)) {
            System.out.println("Inserisci la nuova password: ");
            String newPassword = scanner.nextLine();
            this.password = newPassword;
        } else {
            System.out.println("Password errata!");
        }
    }
    public void getFeatures() {
        System.out.println("Account loggato: " + this.login + "!");
        System.out.println("0. Esci");
        System.out.println("1. Aggiungi cliente");
        System.out.println("2. Modifica cliente");
        System.out.println("3. Mostra acquisti di un cliente");
        System.out.println("4. Aggiungi acquisto");
        System.out.println("5. Mostra lista clienti");
        System.out.println("6. Modifica la tua password");
        }
    public boolean doFeatures(int choosenFeature, Shop choosenShop) {
        // keep asking for a feature until the user chooses to exit
            switch (choosenFeature) {
                case 0:
                    System.out.println("Grazie per aver usato il programma!");
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
                    Customer customer = createCustomer(name, surname, cf, address, wallet);

                    choosenShop.addCustomer(customer);
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
                            System.out.println("Inserisci quantit??: ");
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

                default:
                    System.out.println("Scelta non valida!");
                    break;

            }
            return true;
        }
}
