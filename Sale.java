public class Sale {
    private Product product;
    private int quantity;
    private double total;
    private string date;

    public Sale(Product product, int quantity, double total, string date) {
        this.product = product;
        this.quantity = quantity;
        this.total = prodotto.getUprice() * quantity;
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public string getDate() {
        return date;
    }

    public void print() {
        System.out.println("Sale: " + product.print() + " - " + quantity + " - " + total + " - " + date);
    }

}
