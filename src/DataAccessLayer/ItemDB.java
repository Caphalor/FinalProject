/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BusinessLayer.Item;
import java.sql.*;
import java.util.*;

/**
 *
 * @author JSaji
 */
public class ItemDB {

    public ItemDB() {
    }

    public boolean addItemDB(Item itemObj) {
        try {
            Connection cons = DBConnect.connect();
            String insertQuery = "insert into Item (ItemID, ItemName, Price, StockInHand) values (?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(insertQuery);
            ps.setString(1, itemObj.getItemID());
            ps.setString(2, itemObj.getItemName());
            ps.setDouble(3, itemObj.getPrice());
            ps.setInt(4, itemObj.getStockInHand());
            ps.executeUpdate();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean editItemDB(Item itemObj) {
        try {
            Connection cons = DBConnect.connect();
            String insertQuery = "update Item set ItemName=?, Price=?, StockInHand=? where ItemID=?";
            PreparedStatement ps = cons.prepareStatement(insertQuery);
            ps.setString(1, itemObj.getItemName());
            ps.setDouble(2, itemObj.getPrice());
            ps.setInt(3, itemObj.getStockInHand());
            ps.setString(4, itemObj.getItemID());
            ps.executeUpdate();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean removeItemDB(String ItemId) {
        try {
            Connection cons = DBConnect.connect();
            String deleteQuery = "delete from Item where ItemID=?";
            PreparedStatement ps = cons.prepareStatement(deleteQuery);
            ps.setString(1, ItemId);
            ps.executeUpdate();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ArrayList<Item> getAllItemDB() {
        ArrayList<Item> ItemList = new ArrayList<Item>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Item";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item itemObj = new Item();
                itemObj.setItemID(rs.getString(1));
                itemObj.setItemName(rs.getString(2));
                itemObj.setPrice(rs.getDouble(3));
                itemObj.setStockInHand(rs.getInt(4));
                ItemList.add(itemObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return ItemList;
        }
    }

    public Item getItemDB(String ItemID) {
        Item itemObj = new Item();
        try {
            Connection cons = DBConnect.connect();
            String selectQbyID = "select * from Item where ItemID = ?";
            PreparedStatement ps = cons.prepareStatement(selectQbyID);
            ps.setString(1, ItemID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                itemObj.setItemID(rs.getString(1));
                itemObj.setItemName(rs.getString(2));
                itemObj.setPrice(rs.getDouble(3));
                itemObj.setStockInHand(rs.getInt(4));
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return itemObj;
        }
    }

    public ArrayList<Item> getAllItem() {
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Item";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item itemObj = new Item();
                itemObj.setItemID(rs.getString(1));
                itemObj.setItemName(rs.getString(2));
                itemObj.setPrice(rs.getDouble(3));
                itemObj.setStockInHand(rs.getInt(4));
                itemList.add(itemObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return itemList;
        }
    }

    public ArrayList<Item> searchItemDB(String ItemName) { 
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Item where ItemName like '" + ItemName + "%'";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item itemObj = new Item();
                itemObj.setItemID(rs.getString(1));
                itemObj.setItemName(rs.getString(2));
                itemObj.setPrice(rs.getDouble(3));
                itemObj.setStockInHand(rs.getInt(4));
                itemList.add(itemObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return itemList;
        }
    }
    
    public ArrayList<Item> searchItemIDDB(String ItemID) { 
        ArrayList<Item> itemList = new ArrayList<Item>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Item where ItemID like '" + ItemID + "%'";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Item itemObj = new Item();
                itemObj.setItemID(rs.getString(1));
                itemObj.setItemName(rs.getString(2));
                itemObj.setPrice(rs.getDouble(3));
                itemObj.setStockInHand(rs.getInt(3));
                itemList.add(itemObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return itemList;
        }
    }
}
