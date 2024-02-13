package tms.kolesnik.project.controllers;

public class Developer {

    Command addInCart;
    Command deleteFromCart;
    Command addInFavourite;
    Command deleteFromFavourite;
    Command displayCart;
    Command displayFavourite;
    Command displayOrders;
    Command placeOrder;

    void setAddInCart(Command addInCart) {
        this.addInCart = addInCart;
    }

    void setDeleteFromCart(Command deleteFromCart) {
        this.deleteFromCart = deleteFromCart;
    }

    void setAddInFavourite(Command addInFavourite) {
        this.addInFavourite = addInFavourite;
    }

    void setDeleteFromFavourite(Command deleteFromFavourite) {
        this.deleteFromFavourite = deleteFromFavourite;
    }

    void setDisplayCart(Command displayCart) {
        this.displayCart = displayCart;
    }

    void setDisplayFavourite(Command displayFavourite) {
        this.displayFavourite = displayFavourite;
    }

    void setDisplayOrders(Command displayOrders) {
        this.displayOrders = displayOrders;
    }

    void setPlaceOrder(Command placeOrder) {
        this.placeOrder = placeOrder;
    }

    public void addInCartRecord() {
        addInCart.execute();
    }

    public void deleteFromCart() {
        deleteFromCart.execute();
    }
    public void addInFavourite() {
        addInFavourite.execute();
    }
    public void deleteFromFavourite() {
        deleteFromFavourite.execute();
    }
    public void displayCart() {
        displayCart.execute();
    }
    public void displayFavourite() {
        displayFavourite.execute();
    }
    public void displayOrders() {
        displayOrders.execute();
    }
    public void placeOrder() {
        placeOrder.execute();
    }
}