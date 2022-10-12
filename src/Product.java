public class Product {
    private int id;
    private String name;
    private String manufacturer;
    private double uprice;

    public Product(int id, String name, String manufacturer, double uprice) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.uprice = uprice;
    }

    public int getId() { return id; }
    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getUprice() { return uprice; }
    public void setUprice(double uprice) {
        this.uprice = uprice;
    }

    public void print() {
        System.out.println("Product: " + name + " - " + manufacturer + " - " + uprice);
    }
}
