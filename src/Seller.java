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
        // decrease wallet
        customer.setWallet(customer.getWallet() - total);
    }

    public void getFeatures() {
        System.out.println("Account loggato: " + this.login + "!");
        System.out.println("0. Esci");
        System.out.println("1. Aggiungi cliente");
        System.out.println("2. Modifica cliente");
        System.out.println("3. Mostra acquisti di un cliente");
        System.out.println("4. Aggiungi acquisto");
        System.out.println("5. Mostra lista clienti");
        }
    public void doFeatures(int choosenFeature, Shop choosenShop, boolean exit) {
        Scanner scanner = new Scanner(System.in);
        // keep asking for a feature until the user chooses to exit
            switch (choosenFeature) {
                case 0:
                    System.out.println("Grazie per aver usato il programma!");
                    exit = true;
                    break;
                case 1:
                    System.out.println("Inserisci nome: ");
                    String name = scanner.nextLine();
                    System.out.println("Inserisci cognome: ");
                    String surname = scanner.nextLine();
                    System.out.println("Inserisci codice fiscale: ");
                    String cf = scanner.nextLine();
                    System.out.println("Inserisci indirizzo: ");
                    String address = scanner.nextLine();
                    System.out.println("Inserisci portafoglio: ");
                    double wallet = scanner.nextDouble();
                    scanner.nextLine();
                    Customer customer = createCustomer(name, surname, cf, address, wallet);

                    choosenShop.addCustomer(customer);
                    System.out.println("Cliente aggiunto con successo!");
                    break;
                case 2:
                    choosenShop.printCustomers();
                    System.out.println("Inserisci codice fiscale del cliente da modificare: ");
                    String cfToEdit = scanner.nextLine();
                    Customer customerToEdit = choosenShop.getCustomerByCf(cfToEdit);
                    if (customerToEdit != null) {
                        System.out.println("Inserisci nuovo nome: ");
                        String newName = scanner.nextLine();
                        System.out.println("Inserisci nuovo cognome: ");
                        String newSurname = scanner.nextLine();
                        System.out.println("Inserisci nuovo codice fiscale: ");
                        String newCf = scanner.nextLine();
                        System.out.println("Inserisci nuovo indirizzo: ");
                        String newAddress = scanner.nextLine();
                        System.out.println("Inserisci nuovo portafoglio: ");
                        double newWallet = scanner.nextDouble();
                        scanner.nextLine();
                        editCustomer(customerToEdit, newName, newSurname, newCf, newAddress, newWallet);
                        System.out.println("Cliente modificato con successo!");
                    } else {
                        System.out.println("Cliente non trovato!");
                    }
                    break;
                case 3:
                    // show customers
                    choosenShop.printCustomers();
                    System.out.println("Inserisci codice fiscale del cliente: ");
                    String cfToShow = scanner.nextLine();
                    Customer customerToShow = choosenShop.getCustomerByCf(cfToShow);
                    if (customerToShow != null) {
                        customerToShow.printSales();
                    } else {
                        System.out.println("Cliente non trovato!");
                    }
                    break;
                case 4:
                    System.out.println("Inserisci codice fiscale del cliente: ");
                    String cfToRegister = scanner.nextLine();
                    Customer customerToRegister = choosenShop.getCustomerByCf(cfToRegister);
                    if (customerToRegister != null) {
                        System.out.println("Inserisci codice del prodotto: ");
                        int code = scanner.nextInt();
                        Product product = choosenShop.getProductById(code);
                        if (product != null) {
                            System.out.println("Inserisci quantità: ");
                            int quantity = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inserisci data: ");
                            String date = scanner.nextLine();
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
                default:
                    System.out.println("Scelta non valida!");
                    break;

            }
        }
}
