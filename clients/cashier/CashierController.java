package clients.cashier;

import clients.cashier.CashierModel;

import clients.cashier.CashierView;
import clients.cashier.CashierController;
import catalogue.BetterBasket;
import catalogue.Product;
/**
 * The Cashier Controller
 */

public class CashierController
{
  private CashierModel model = null;
  private CashierView  view  = null;

  /**
   * Constructor
   * @param model The model
   * @param view  The view from which the interaction came
   */
  public CashierController( CashierModel model, CashierView view )
  {
    this.view  = view;
    this.model = model;
  }

  /**
   * Check interaction from view
   * @param pn The product number to be checked
   */
  public void doCheck( String pn )
  {
    model.doCheck(pn);
  }

   /**
   * Buy interaction from view
   */
  public void doBuy()
  {
    model.doBuy();
  }

   /**
   * Bought interaction from view
   */
  public void doBought()
  {
    model.doBought();
  }
  /**
   * Clear basket interaction from view
   */
  public void doClearBasket(){
    model.clearBasket(); //call the model's method
  }
}

