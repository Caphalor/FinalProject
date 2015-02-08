/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccessLayer.ItemDB;
import java.util.ArrayList;

/**
 *
 * @author JSaji
 */
public class Item {

    private String ItemID;
    private String ItemName;
    private double Price;
    private int StockInHand;

    public Item() {
    }

    public Item(String ItemID, String ItemName, double Price, int StockInHand) {
        this.ItemID = ItemID;
        this.ItemName = ItemName;
        this.Price = Price;
        this.StockInHand = StockInHand;
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

    public int getStockInHand() {
        return StockInHand;
    }

    public void setStockInHand(int StockInHand) {
        this.StockInHand = StockInHand;
    }



    public boolean addItem(Item itemObj) {
        boolean result = true;
        if (itemObj.getItemID() == null) {
            result = false;
        } else if (itemObj.getItemName() == null) {
            result = false;
        } else if (itemObj.getPrice() == 0.0) {
            result = false;
        } else if (itemObj.getStockInHand() == 0) {
            result = false;
        } else {
            result = new ItemDB().addItemDB(itemObj);
        }
        return result;
    }

    public boolean editItem(Item itemObj) {
        boolean result = true;
        if (itemObj.getItemID() == null) {
            result = false;
        } else if (itemObj.getItemName() == null) {
            result = false;
        } else if (itemObj.getPrice() == 0.0) {
            result = false;
        } else if (itemObj.getStockInHand() == 0) {
            result = false;
        } else {
            result = new ItemDB().editItemDB(itemObj);
        }
        return result;
    }

    public boolean removeItem(String ItemId) {
        boolean result = new ItemDB().removeItemDB(ItemId);
        return result;
    }
    
    public ArrayList<Item> getAllItem() { 
        ArrayList<Item> movieList = new ItemDB().getAllItemDB(); 
        return movieList; 
    }
    
    public Item getItem(String ItemID) { 
        Item itemObj = new ItemDB().getItemDB(ItemID); 
        return itemObj; 
    }
    
    public ArrayList<Item> getAllItemDB() { 
        ArrayList<Item> itemList = new ItemDB().getAllItem(); 
        return itemList; 
    }
    
    public ArrayList<Item> searchItem(String ItemName) { 
        ArrayList<Item> itemList = new ItemDB().searchItemDB(ItemName); 
        return itemList; 
    }
    
    public ArrayList<Item> searchItemID(String ItemName) { 
        ArrayList<Item> itemList = new ItemDB().searchItemIDDB(ItemName); 
        return itemList; 
    }
}
