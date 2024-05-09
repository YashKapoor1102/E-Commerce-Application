/**
 * @author  Yash Kapoor
 * @version 5.0
 */

// Student ID: 101163338

package myStore;

import java.util.*;

public class Inventory implements ProductStockContainer {

    // initializing two new ArrayLists called stocks and products
    private ArrayList<int[]> stocks;
    private ArrayList<Product> products;

    // stocks ArrayList: stores the product ID and the quantity of that product
    // it can store multiple product ID's. For each product ID, it will display the quantity of that product.

    // products ArrayList: stores the information of the product: ID, name and the price

    /**
     * Create a new inventory with the supplied attributes.
     */
    public Inventory() {
        this.stocks = new ArrayList<>();
        this.products = new ArrayList<>();

        init();
    }

    /**
     * Initializing the inventory with default products
     */
    private void init() {

        Product potatoes = new Product("potatoes", 101, 4.00);
        Product bagels = new Product("bagels", 102, 5.00);
        Product cereal = new Product("cereal", 103, 6.00);
        Product oatmeal = new Product("oatmeal", 104, 4.50);
        Product waffles = new Product("waffles", 105, 6.50);
        Product bread = new Product("bread", 106, 7.00);
        Product mapleSyrup = new Product("Maple Syrup", 107, 15.00);

        addProductQuantity(potatoes, 100);
        addProductQuantity(bagels, 76);
        addProductQuantity(cereal, 10);
        addProductQuantity(oatmeal, 3);
        addProductQuantity(waffles, 200);
        addProductQuantity(bread, 300);
        addProductQuantity(mapleSyrup, 250);

    }

    /**
     * Get the index of where the product is located in the stocks ArrayList
     *
     * @param id    an int, the ID of the product
     * @return      an int, index of where the product is located in the stocks ArrayList
     */
    @Override
    public int getProductIndex(int id) {

        // for loop used to iterate through the stocks ArrayList until the given product ID is found
        for(int i = 0; i < this.stocks.size(); i++) {
            if(this.stocks.get(i)[0] == id) return i;
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
    public Product getProduct(int id){

        int index = getProductIndex(id);

        if(index != -1) return this.products.get(index);
        // if the product is found in the stocks ArrayList, the information of the product is returned

        return null;
    }

    /**
     * Get the amount of stock for a given product
     *
     * @param product    a Product Object
     * @return      an int, the quantity of the product
     */
    @Override
    public int getProductQuantity(Product product) {

        // for-each loop used to iterate through the stocks ArrayList until the product's ID is found
        for(int[] pdt: this.stocks) {
            if(pdt[0] == product.getID()) return pdt[1];
        }

        return 0;
        // if the product ID is not found, 0 will be returned

    }

    /**
     * Get the amount of stock for a given product ID
     *
     * @param id    an int, the ID of the product
     * @return      an int, the quantity of the product
     */
    @Override
    public int getProductQuantity(int id) {

        // for-each loop used to iterate through the stocks ArrayList until the product's ID is found
        for(int[] pdt: this.stocks){
            if(pdt[0] == id) return pdt[1];
        }

        return 0;
        // if the product ID is not found, 0 will be returned
    }

    /**
     * Get the number of unique products in the inventory
     *
     * @return      an int, number of unique products
     */
    @Override
    public int getNumOfProducts() {

        return stocks.size();

    }

    /**
     * Add a specified amount of stock for a given product to the inventory
     *
     * @param product   a Product object, containing the name, ID, and the price of the product
     * @param amount    an int, specifying the quantity of the product that needs to be added
     *
     * @return          a boolean, true if product is added to the inventory, false otherwise
     */
    @Override
    public boolean addProductQuantity(Product product, int amount) {
        if(amount <= 0) return false;
        //cannot add a product to the inventory if the specified amount is less than or equal to 0
        //false is returned if that is the case

        int index = getProductIndex(product.getID());

        /*
        if the product is not already in the ArrayList, the product will be added to both
        the stocks and products ArrayList.
         */
        if(index == -1){

            int[] info = {product.getID(), amount};
            this.products.add(product);
            this.stocks.add(info);
            return true;
        }
        else{
            /*
            if the product exists in the ArrayList, the quantity of the product is increased
            by the specified amount.
             */
            this.stocks.get(index)[1] += amount;
        }
        return false;
    }

    /**
     * Remove a specified amount of stock for a given product from the inventory
     *
     * @param product   a Product object, containing the name, ID, and the price of the product
     * @param amount    an int, specifying the quantity of the product that needs to be removed
     *
     * @return          a boolean, true if product is removed from the inventory, false otherwise
     */
    @Override
    public boolean removeProductQuantity(Product product, int amount) {
        if (amount < 0) return false;
        // cannot remove a product from the inventory if the specified amount is less than 0
        // false is returned if that is the case

        int index = getProductIndex(product.getID());

        /*
        if the product is in the ArrayList, the quantity of the product is decreased
        by the specified amount
        */
        if(index != -1){
            int current_amount = this.stocks.get(index)[1];

            if(current_amount < amount) return false;
            //cannot have negative stock, so false is returned


            this.stocks.get(index)[1] = current_amount - amount;
            return true;
        }
        return false;
        // false is returned if the product is not found in the ArrayList
    }

    /**
     * Print out the information on a product in the inventory given a product ID
     *
     * @param id    an int, the ID of the product
     * @return      a Product object, containing the information of the product
     */
    public Product getProdInfo(int id) {
        int index = getProductIndex(id);

        // checks to ensure that the product is in the ArrayList
        if(index != -1) {

            System.out.print(this.products.get(index));
            System.out.println(String.format(" %d ", getProductQuantity(id)));

            return this.products.get(index);
        }

        return null;
    }

    /**
     * Get the price of the product
     *
     * @param id    an int, the ID of the product
     * @return      a double, containing the price of the product
     */
    public double getProdPrice(int id) {
        int index = getProductIndex(id);

        return this.products.get(index).getPrice();
    }

}
