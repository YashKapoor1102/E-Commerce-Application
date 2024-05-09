/**
 * @author  Yash Kapoor
 * @version 5.0
 */

// Student ID: 101163338

package myStore;

public class Product {
    private final String NAME;                                        // the product's name
    private final int ID;                                          // the product's ID number
    private final double PRICE;                                       // the product's price

    /**
     * Create a new product with the supplied attributes.
     *
     * @param name      a String, the NAME of the product
     * @param id        an int, the ID of the product
     * @param price     an int, the PRICE of the product
     */
    public Product(String name, int id, double price) {
        this.NAME = name;
        this.ID = id;
        this.PRICE = price;
    }

    /**
     * Get the name of this product.
     *
     * @return  a String, the name of the product
     */
    public String getName() {
        return this.NAME;
    }

    /**
     * Get the ID of this product.
     *
     * @return  an int, the ID of the product
     */
    public int getID() {
        return this.ID;
    }

    /**
     * Get the price of this product.
     *
     * @return  an int, the price of the product
     */
    public double getPrice(){
        return this.PRICE;
    }


    /**
     * Convert the name, ID and the price of the product to a string to print the information of the product
     *
     * @return  a String, formatting the name, ID, and price of the product
     */
    @Override
    public String toString()    {
        return String.format("%15s | %03d | $%.2f |", this.NAME, this.ID, this.PRICE);
    }


}
