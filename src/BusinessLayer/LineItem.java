/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccessLayer.LineItemDB;
import java.util.ArrayList;

/**
 *
 * @author JSaji
 */
public class LineItem {

    private String BillID;
    private String ItemID;
    private String ItemName;
    private int Quantity;
    private double Price;
    private double Total;

    public LineItem() {
    }

    public LineItem(String BillID, String ItemID, String ItemName, int Quantity, double Price, double Total) {
        this.BillID = BillID;
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.Quantity = Quantity;
        this.Price = Price;
        this.Total = Total;
    }

    public String getBillID() {
        return BillID;
    }

    public void setBillID(String BillID) {
        this.BillID = BillID;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String ItemName) {
        this.ItemName = ItemName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public boolean addLineItem(LineItem itemObj) {
        boolean result = false;
        result = new LineItemDB().addItemDB(itemObj);

        return result;
    }

    public ArrayList<LineItem> getList(String tBillNo) { //this sub program used to get lineItem List from the DataAccessLayer depends on the BillNo
        ArrayList<LineItem> itemList = new LineItemDB().getListDB(tBillNo); //create object for the lineItemDB class and pass to the getListDB sub program
        return itemList; //return the result
    }
}
