package clients.customer;
import catalogue.Basket;
import catalogue.Product;
import debug.DEBUG;
import dbAccess.StockR;
import middle.MiddleFactory;
import middle.OrderProcessing;
import middle.StockException;
import middle.StockReader;

import javax.swing.*;
import java.util.Observable;

/**
 * Implements the Model of the customer client
 */
public class CustomerModel extends Observable
{
  private Product     theProduct = null;          // Current product
  private Basket      theBasket  = null;          // Bought items

  private String      pn = "";                    // Product being processed

  private StockReader     theStock     = null;
  private OrderProcessing theOrder     = null;
  private ImageIcon       thePic       = null;

  /*
   * Construct the model of the Customer
   * @param mf The factory to create the connection objects
   */
  public CustomerModel(MiddleFactory mf)
  {
    try                                          //
    {
      theStock = mf.makeStockReader();           // Database access
    } catch ( Exception e )
    {
      DEBUG.error("CustomerModel.constructor\n" +
              "Database not created?\n%s\n", e.getMessage() );
    }
    theBasket = makeBasket();                    // Initial Basket
  }

  /**
   * return the Basket of products
   * @return the basket of products
   */
  public Basket getBasket()
  {
    return theBasket;
  }

  /**
   * Check if a product exists and add it to the basket
   * @param input The product number (up to 4 characters) or product description to search for
   * The method will:
   * - First try to match input as a product number if 4 or fewer characters
   * - Otherwise search for products with matching descriptions (case-insensitive)
   * - Clear the current basket
   * - If found, add one unit of the product to the basket
   * - Update the product image
   * - Notify observers with the result message
   * Example searches:
   * - "0001" searches by product number
   * - "Toaster" or "toaster" searches by description
   */
  public void doCheck(String input) {
    theBasket.clear();                          // Clear s. list
    String theAction = "";
    input = input.trim();                       // Remove whitespace

    try {
      // First try to find by product number
      if (input.length() <= 4 && theStock.exists(input)) {
        Product pr = theStock.getDetails(input);
        if (pr.getQuantity() >= 1) {
          theAction = String.format("%s : £%.2f (%d)",
                  pr.getDescription(),
                  pr.getPrice(),
                  pr.getQuantity());
          pr.setQuantity(1);
          theBasket.add(pr);
          thePic = theStock.getImage(input);
        }
      } else {
        // Try to find by description
        Product product = ((StockR)theStock).findByDescription(input);
        if (product != null) {
          theAction = String.format("%s : £%.2f (%d)",
                  product.getDescription(),
                  product.getPrice(),
                  product.getQuantity());
          product.setQuantity(1);
          theBasket.add(product);
          thePic = theStock.getImage(product.getProductNum());
        } else {
          theAction = "No products found matching: " + input;
        }
      }
    } catch (StockException e) {
      DEBUG.error("CustomerClient.doCheck()\n%s", e.getMessage());
    }

    setChanged();
    notifyObservers(theAction);
  }

  /**
   * Clear the products from the basket
   */
  public void doClear()
  {
    String theAction = "";
    theBasket.clear();                        // Clear s. list
    theAction = "Enter Product Number";       // Set display
    thePic = null;                            // No picture
    setChanged(); notifyObservers(theAction);
  }

  /**
   * Return a picture of the product
   * @return An instance of an ImageIcon
   */
  public ImageIcon getPicture()
  {
    return thePic;
  }

  /**
   * ask for update of view callled at start
   */
  private void askForUpdate()
  {
    setChanged(); notifyObservers("START only"); // Notify
  }

  /**
   * Make a new Basket
   * @return an instance of a new Basket
   */
  protected Basket makeBasket()
  {
    return new Basket();
  }



}