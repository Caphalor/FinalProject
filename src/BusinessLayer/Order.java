/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccessLayer.ItemDB;
import DataAccessLayer.OrderDB;
import java.util.ArrayList;

/**
 *
 * @author JSaji
 */
public class Order {

    private String BillID;
    private String CustomerID;
    private String CustomerName;
    private double GrandTotal;

    public Order() {
    }

    public Order(String BillID, String CustomerID, String CustomerName, double GrandTotal) {
        this.BillID = BillID;
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.GrandTotal = GrandTotal;
    }

    public String getBillID() {
        return BillID;
    }

    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public double getGrandTotal() {
        return GrandTotal;
    }

    public void setGrandTotal(double GrandTotal) {
        this.GrandTotal = GrandTotal;
    }

    public boolean AddOrder(Order ordObj) { //this sub program used to check null values and transfer data to the DataAccesslayer
        boolean result = true;
        if (ordObj.getBillID() == null) {
            result = false;
        } else if (ordObj.getCustomerID() == null) {
            result = false;
        } else if (ordObj.getCustomerName() == null) {
            result = false;
        } else if (ordObj.getGrandTotal() == 0.0) {
            result = false;
        } else {
            result = new OrderDB().AddOrderDB(ordObj);
        }
        return result;

    }

    public ArrayList<Order> getAllItem() {
        ArrayList<Order> movieList = new OrderDB().getAllItemDB();
        return movieList;
    }
}
