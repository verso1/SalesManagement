public class Sale {
    private Product product;
    private int quantity;
    private double total;
    private String date;

    public Sale(Product product, int quantity, double total, String date) {
        this.product = product;
        this.quantity = quantity;
        this.total = product.getUprice() * quantity;
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

    public String getDate() {
        return date;
    }

    public void printInfo() {
        product.print();
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: " + total);
        System.out.println("Date: " + date);
        System.out.println("\n");
    }

}
