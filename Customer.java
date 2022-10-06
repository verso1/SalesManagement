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
        this.wallet = wallet;
        this.sales = new ArrayList <Sale>();
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

    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

    public void addSale(Sale sale) {
        sales.add(sale);
    }

    public List <Sale> getSales() {
        return sales;
    }

    public void printSales() {
        for (Sale sale : sales) {
            System.out.println(sale);
        }
    }

}
