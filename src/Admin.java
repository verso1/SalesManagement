
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

    public void getFeatures() {
        super.getFeatures();
        System.out.println("6. Annulla acquisto");

    }


    public void doFeatures(int choosenFeature, Shop choosenShop) {
        super.doFeatures(choosenFeature, choosenShop);
        Scanner scanner = new Scanner(System.in);

        switch (choosenFeature) {
            case 6:
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
        }
    }
}
