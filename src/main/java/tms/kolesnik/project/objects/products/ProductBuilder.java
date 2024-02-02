package tms.kolesnik.project.objects.products;

public class ProductBuilder {

    private final Product product;

    public ProductBuilder() {
        product = new Product();
    }

    public ProductBuilder name(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder description(String description) {
        product.setDescription(description);
        return this;
    }

    public ProductBuilder price(float price) {
        product.setPrice(price);
        return this;
    }

    public ProductBuilder img(String img) {
        product.setImg(img);
        return this;
    }

    public Product build() {
        return product;
    }
}
