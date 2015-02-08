/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BusinessLayer.Item;
import BusinessLayer.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author JSaji
 */
public class OrderDB {

    public boolean AddOrderDB(Order ordObj) {
        try {
            Connection cons = DBConnect.connect();
            String InsertQuery = "insert into OrderTb (BillID, CustomerID, CustomerName, GrandTotal) values (?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(InsertQuery);
            ps.setString(1, ordObj.getBillID());
            ps.setString(2, ordObj.getCustomerID());
            ps.setString(3, ordObj.getCustomerName());
            ps.setDouble(4, ordObj.getGrandTotal());
            ps.executeUpdate();
            ps.close();
            cons.close();

            return true;

        } catch (Exception ex) {
            return false;
        }
    }

    public ArrayList<Order> getAllItemDB() {
        ArrayList<Order> ItemList = new ArrayList<Order>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from OrderTb";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order itemObj = new Order();
                itemObj.setBillID(rs.getString(1));
                ItemList.add(itemObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return ItemList;
        }
    }
}
