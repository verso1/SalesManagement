import java.util.ArrayList;
import java.util.List;
public class Customer {
    private String name;
    private String surname;
    private String cf;
    private String address;
    private List <Sale> sales;
    private double wallet;

    public Customer(String name, String surname, String cf, String address, double wallet) {
        this.name = name;
        this.surname = surname;
        this.cf = cf;
        this.address = address;
        sales = new ArrayList<>();
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getCf() {
        return cf;
    }
    public String getAddress() {
        return address;
    }
    public double getWallet() {
        return wallet;
    }
    public List <Sale> getSales() {
        return sales;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setCf(String cf) {
        this.cf = cf;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }
    public void addSale(Sale sale) {
        sales.add(sale);
    }
    public void printSales() {
        for (Sale s : sales) { s.printInfo(); }
    }

    // find sale by product id and date
    public Sale findSale(int id, String date) {
        for (Sale sale : sales) {
            if (sale.getProduct().getId() == id && sale.getDate().equals(date)) {
                return sale;
            }
        }
        return null;
    }

    // print customer's info
    public void printInfo() {
        System.out.println("Nome: " + name);
        System.out.println("Cognome: " + surname);
        System.out.println("Codice fiscale: " + cf);
        System.out.println("Indirizzo: " + address);
        System.out.println("Portafoglio: " + wallet);
        System.out.println("\n");
    }

}
