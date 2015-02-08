/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BusinessLayer.LineItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JSaji
 */
public class LineItemDB {

    public boolean addItemDB(LineItem itemObj) {
        try {
            Connection cons = DBConnect.connect();
            String insertQuery = "insert into LineItem (BillID, ItemID, ItemName, Quantity, Price, Total) values (?,?,?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(insertQuery);
            ps.setString(1, itemObj.getBillID());
            ps.setString(2, itemObj.getItemID());
            ps.setString(3, itemObj.getItemName());
            ps.setInt(4, itemObj.getQuantity());
            ps.setDouble(5, itemObj.getPrice());
            ps.setDouble(6, itemObj.getTotal());
            ps.executeUpdate();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ArrayList<LineItem> getListDB(String tBillNo) {
        ArrayList<LineItem> itemList = new ArrayList<LineItem>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from LineItem where BillID=?";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ps.setString(1, tBillNo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LineItem itemObj = new LineItem();
                itemObj.setBillID(rs.getString(1));
                itemObj.setItemID(rs.getString(2));
                itemObj.setItemName(rs.getString(3));
                itemObj.setPrice(rs.getDouble(4));
                itemObj.setQuantity(rs.getInt(5));
                itemObj.setTotal(rs.getDouble(6));

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
