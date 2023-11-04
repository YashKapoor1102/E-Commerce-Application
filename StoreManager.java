/**
 * @author  Yash Kapoor
 * @version 5.0
 */

// Student ID: 101163338

package myStore;

import java.util.ArrayList;

public class StoreManager {

    private long counter;
    private Inventory inventory;
    private ShoppingCart shoppingCart;

    /**
     * Create a new StoreManager with the supplied attributes.
     */
    public StoreManager() {

        this.counter = 0;
        // counter initialized to 0

        this.inventory = new Inventory();
        // creating a new Inventory object

        this.shoppingCart = new ShoppingCart();
        // creating a new ShoppingCart object

    }

    /**
     * Get the amount of stock of a given product that is in the cart
     *
     * @param product   a Product object
     * @return  an int, quantity of the product in the cart
     */
    public int getCartStock(Product product) {
        return this.shoppingCart.getProductQuantity(product);
    }

    /**
     * Outputs the items in the user's cart and calculates the total price
     *
     * @return  a StringBuilder object, containing the total of all the products in the user's shopping cart
     */
    public StringBuilder checkout() {
        StringBuilder sa;

        double total = 0;
        sa =  this.shoppingCart.printProdInfo();

        for (int[] pdt : this.shoppingCart.getCart()) {
            // going through the carts ArrayList that is in the shoppingCart Class
            for (int j = 101; j < 108; j++) {
                /*
                if the ID of the product is found in the carts ArrayList,
                the total price of the product is stored in a variable
                 */
                if (pdt[0] == j) {

                    // total of the product obtained by multiplying the price by the quantity
                    double value = this.inventory.getProdPrice(j) * getCartStock(this.shoppingCart.getProduct(j));

                    // total of all the products in the carts ArrayList
                    total += value;
                }
            }
        }
        sa.append((String.format("\nThe total of these items is $%.2f", total)));

        return sa;
    }

    /**
     * Checks if the product is in the inventory
     *
     * @param id    an int, the ID of the product
     * @return      a boolean, true if the product is in the inventory, false otherwise
     */
    public int inStock(int id) {
        if(this.inventory.getProductIndex(id) == -1) {
            // product is not found
            return 0;
        }
        return this.inventory.getProductQuantity(id);
    }

    /**
     * Checks if the product is in the shopping cart
     *
     * @param id    an int, the ID of the product
     * @return      a boolean, true if the product is in the cart, false otherwise
     */
    public int inCart(int id) {
        if(this.shoppingCart.getProductIndex(id) == -1) {
            return 0;
        }
        return this.shoppingCart.getProductQuantity(id);
    }

    /**
     * Adding more products to the cart
     *
     * @param option    an int, the ID of the product that the user wants to add
     * @param amount    an int, the number of products the user wants to add
     *
     * @return          a boolean, true if item is added to the user's shopping cart, false otherwise
     */
    public boolean addToCart(int option, int amount) {

        for (int i = 101; i < 108; i++) {
            if (option == i) {
                boolean sufficientQuantity = this.inventory.removeProductQuantity(this.inventory.getProduct(i), amount);
                // ensuring the user does not enter an amount greater than the number of products in the inventory

                if (sufficientQuantity) {
                    this.shoppingCart.addProductQuantity(this.inventory.getProduct(i), amount);
                }
                else {
                    return false;
                }
                i++;
            }
        }
        return true;
    }


    /**
     * Removing products from the cart
     *
     * @param option    an int, the ID of the product that the user wants to remove
     * @param amount    an int, the number of products the user wants to remove
     *
     * @return          a boolean, true if item is in the user's shopping cart, false otherwise
     */
    public boolean removeFromCart(int option, int amount) {

        if (this.shoppingCart.getProductQuantity(option) < amount) {
            return false;
        }

        for (int i = 101; i < 108; i++) {
            if (option == i) {
                boolean sufficientQuantity = shoppingCart.removeProductQuantity(this.inventory.getProduct(i), amount);
                // ensuring the user does not enter an amount greater than the number of items in the cart

                if (sufficientQuantity) {
                    this.inventory.addProductQuantity(this.inventory.getProduct(i), amount);
                }
                i++;
            }
        }
        return true;
    }

    /**
     * Printing the information in the cart of the user
     *
     * @return      a StringBuilder object, containing all the items in the user's cart
     */
    public StringBuilder viewCart() {

        StringBuilder sb = this.shoppingCart.printProdInfo();
        // adding all the items in the cart to a StringBuilder object

        if (shoppingCart.getCart().isEmpty()) {
            sb.append("\nThere is nothing in your cart.");
        }
        return sb;
    }

    /**
     * Removing every product from the cart and returning it to the inventory upon user request
     */
    public void emptyCart() {

        for (int[] item : this.shoppingCart.getCart()) {
            this.inventory.addProductQuantity(this.shoppingCart.getProduct(item[0]), item[1]);
        }

        this.shoppingCart.removeAll();

    }

    /**
     * Increments counter every time a new ShoppingCart is made
     *
     * @return  a long, that increments its previous value by 1 each time to obtain a new value
     */
    public long assignNewCartID() {
        return ++counter;
    }

    /**
     * Getting the cart ArrayList
     *
     * @return  an ArrayList, containing an array that stores the product ID and quantity of product
     */
    public ArrayList<int[]> getCart() {
        return shoppingCart.getCart();
    }

}