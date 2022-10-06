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

    public void Override getFeatures() {
        super.getFeatures();
        System.out.println("6. Annulla acquisto");

    }

    public void Override doFeatures() {
        super.doFeatures();
        case 6:
            // undo sale
            System.out.println("Inserisci il nome del cliente: ");
            String name = input.next();
            System.out.println("Inserisci il cognome del cliente: ");
            String surname = input.next();
            Customer customer = findCustomer(name, surname);
            if (customer != null) {
                System.out.println("Inserisci il codice del prodotto: ");
                String code = input.next();
                System.out.println("Inserisci la data dell'acquisto: ");
                String date = input.next();
                Sale sale = findSale(customer, code, date);
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
