package tms.kolesnik.project.controllers;

public class DeveloperBuilder {

    private Developer developer = new Developer();

    public DeveloperBuilder addInCart(Command addInCart) {
        developer.addInCart = addInCart;
        return this;
    }

    public DeveloperBuilder deleteFromCart(Command deleteFromCart) {
        developer.deleteFromCart = deleteFromCart;
        return this;
    }

    public DeveloperBuilder addInFavourite(Command addInFavourite) {
        developer.addInFavourite = addInFavourite;
        return this;
    }

    public DeveloperBuilder deleteFromFavourite(Command deleteFromFavourite) {
        developer.deleteFromFavourite = deleteFromFavourite;
        return this;
    }

    public DeveloperBuilder displayCart(Command displayCart) {
        developer.displayCart = displayCart;
        return this;
    }

    public DeveloperBuilder displayFavourite(Command displayFavourite) {
        developer.displayFavourite = displayFavourite;
        return this;
    }

    public DeveloperBuilder displayOrders(Command displayOrders) {
        developer.displayOrders = displayOrders;
        return this;
    }

    public DeveloperBuilder placeOrder(Command placeOrder) {
        developer.placeOrder = placeOrder;
        return this;
    }

    public Developer build() {
        return developer;
    }
}
