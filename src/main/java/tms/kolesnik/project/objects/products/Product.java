package tms.kolesnik.project.objects.products;

public class Product {

    private String name;
    private String description;
    private float price;
    private String img;

    Product(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return description.substring(0, 20);
    }

    public float getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }
}
