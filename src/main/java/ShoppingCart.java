/**
 * @author  Yash Kapoor
 * @version 5.0
 */

// Student ID: 101163338

package myStore;

import java.util.ArrayList;

public class ShoppingCart implements ProductStockContainer {

    // initializing two new ArrayLists called cart and products
    private ArrayList<int[]> cart;
    private ArrayList<Product> products;

    // cart ArrayList: stores the product ID and the quantity of that product
    // it can store multiple product ID's. For each product ID, it will display the quantity of that product.

    // products ArrayList: stores the information of the product: ID, name and the price

    /**
     * Create a new shopping cart with the supplied attributes.
     */
    public ShoppingCart() {
        this.cart = new ArrayList<>();
        this.products = new ArrayList<>();
    }

    /**
     * Get the index of where the product is located in the cart ArrayList
     *
     * @param id    an int, the ID of the product
     * @return      an int, index of where the product is located in the cart ArrayList
     */
    @Override
    public int getProductIndex(int id) {

        // for loop used to iterate through the cart ArrayList until the given product ID is found
        for (int i = 0; i < this.cart.size(); i++) {
            if (this.cart.get(i)[0] == id) return i;
        }
        return -1;
        // -1 will be returned if the index of the product ID is not found
    }

    /**
     * Get the information of the product with the help of getProductIndex: its ID, name and price
     *
     * @param id    an int, the ID of the product
     * @return      a Product object, containing the information of the product
     */
    @Override
    public Product getProduct(int id) {

        int index = getProductIndex(id);

        if (index != -1) return this.products.get(index);
        // if the product is found in the cart ArrayList, the information of the product is returned

        return null;
    }

    /**
     * Get the quantity of the product for a given product
     *
     * @param product    a Product Object
     * @return      an int, the quantity of the product
     */
    @Override
    public int getProductQuantity(Product product) {

        // for-each loop used to iterate through the cart ArrayList until the product's ID is found
        for(int[] pdt: this.cart) {
            if(pdt[0] == product.getID()) return pdt[1];
        }

        return 0;
        // if the product ID is not found, 0 will be returned

    }

    /**
     * Get the quantity of the product for a given product ID
     *
     * @param id    an int, the ID of the product
     * @return      an int, the quantity of the product
     */
    @Override
    public int getProductQuantity(int id) {

        // for-each loop used to iterate through the cart ArrayList until the product's ID is found
        for (int[] pdt : this.cart) {
            if (pdt[0] == id) return pdt[1];
        }

        return 0;
        // if the product ID is not found, 0 will be returned
    }

    /**
     * Get the number of unique products in the user's cart
     *
     * @return      an int, number of unique products
     */
    @Override
    public int getNumOfProducts() {

        return cart.size();

    }

    /**
     * Add a specified amount of stock for a given product to the user's shopping cart
     *
     * @param product   a Product object, containing the name, ID, and the price of the product
     * @param amount    an int, specifying the quantity of the product that needs to be added
     *
     * @return          a boolean, true if product is added to the cart, false otherwise
     */
    @Override
    public boolean addProductQuantity(Product product, int amount) {
        if (amount <= 0) return false;
        // cannot add a product to the cart if the specified amount is less than or equal to 0
        // false is returned if that is the case

        int index = getProductIndex(product.getID());

        /*
        if the product is not already in the ArrayList, the product will be added to both
        the cart and products ArrayList.
         */
        if (index == -1) {

            int[] info = {product.getID(), amount};
            this.products.add(product);
            this.cart.add(info);

            return true;
        } else {
            /*
            if the product exists in the ArrayList, the quantity of the product is increased
            by the specified amount.
            */
            this.cart.get(index)[1] += amount;
        }
        return false;
    }

    /**
     * Remove a specified amount of stock for a given product from the user's shopping cart
     *
     * @param product   a Product object, containing the name, ID, and the price of the product
     * @param amount    an int, specifying the quantity of the product that needs to be removed
     *
     * @return          a boolean, true if product is removed from the cart, false otherwise
     */
    @Override
    public boolean removeProductQuantity(Product product, int amount) {
        if (amount <= 0) return false;
        // cannot remove a product from the cart if the specified amount is less than or equal to 0
        // false is returned if that is the case

        int index = getProductIndex(product.getID());

        /*
        if the product is in the ArrayList, the cart of the product is decreased
        by the specified amount
        */
        if (index != -1) {
            int current_amount = this.cart.get(index)[1];

            if (current_amount < amount) {

                return false;
            }
            // cannot have negative stock, so false is returned

            this.cart.get(index)[1] -= amount;

            if (this.cart.get(index)[1] == 0) {
                // when the quantity of a product in the cart is 0
                // the product is removed from the cart and products ArrayList
                this.products.remove(index);
                this.cart.remove(index);
            }

            return true;
        }
        return false;
        // false is returned if the product is not found in the ArrayList
    }

    /**
     * Print out the information on a product in the cart
     */
    public StringBuilder printProdInfo() {
        StringBuilder sb = new StringBuilder();
        for (Product pdt : this.products) {
            // goes through products ArrayList
            sb.append(pdt);
            for (int i = 101; i < 108; i++) {
                /*
                if the ID of the product is found in the products ArrayList,
                information of that product is printed
                 */
                if (pdt.getID() == i)  {
                    sb.append(String.format(" %d \n", getProductQuantity(i)));
                }
            }
        }
        return sb;
    }

    /**
     * Removing every item from the cart and products ArrayList
     */
    public void removeAll() {
        this.cart.clear();
        this.products.clear();
    }

    /**
     * Getting the cart ArrayList
     *
     * @return  an ArrayList, containing an array that stores the product ID and quantity of product
     */
    public ArrayList<int[]> getCart() {
        return this.cart;
    }

}
