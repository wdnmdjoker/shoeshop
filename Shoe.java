public class Shoe {
    //(1)Brand (e.g. Nike)
    //(2)Type(e.g. walking shoes,running shoes,basketball shoes)
    //(3)Size(e.g. 8.5)
    //(4)Price(e.g. 999 rmb)
    //(5)Color(e.g. white,red,black ect.)
    private String brand;
    private String type;
    private float size;
    private float price;
    private String color;

    public Shoe(String brand, String type, float size, float price, String color) {
        this.brand = brand;
        this.type = type;
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shoe [brand=" + brand + ", type=" + type + ", size=" + size + ", price=" + price + ", color=" + color
                + "]";
    }
}
