/**
 * @author  Yash Kapoor
 * @version 5.0
 */

// Student ID: 101163338

package myStore;

public interface ProductStockContainer {

    /**
     * Get the index of where the product is located in the ArrayList
     *
     * @param id    an int, the ID of the product
     * @return      an int, index of where the product is located in the ArrayList
     */
    int getProductIndex(int id);

    /**
     * Get the information of the product
     *
     * @param id    an int, the ID of the product
     * @return      a Product object, containing the information of the product
     */
    Product getProduct(int id);

    /**
     * Get the quantity of the product for a given product
     *
     * @param product    a Product Object
     * @return      an int, the quantity of the product
     */
    int getProductQuantity(Product product);

    /**
     * Get the quantity of the product for a given product
     *
     * @param id    an int, the ID of the product
     * @return      an int, the quantity of the product
     */
    int getProductQuantity(int id);

    /**
     * Get the number of unique products
     *
     * @return      an int, number of unique products
     */
    int getNumOfProducts();

    /**
     * Add a specified amount of stock for a given product to the ArrayList
     *
     * @param product   a Product object, containing the name, ID, and the price of the product
     * @param amount    an int, specifying the quantity of the product that needs to be added
     *
     * @return          a boolean, true if product is added to the ArrayList, false otherwise
     */
    boolean addProductQuantity(Product product, int amount);

    /**
     * Remove a specified amount of stock for a given product from the ArrayList
     *
     * @param product   a Product object, containing the name, ID, and the price of the product
     * @param amount    an int, specifying the quantity of the product that needs to be removed
     *
     * @return          a boolean, true if product is removed from the ArrayList, false otherwise
     */
    boolean removeProductQuantity(Product product, int amount);

}
