/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import BusinessLayer.Customer;
import java.sql.*;
import java.util.*;

/**
 *
 * @author JSaji
 */
public class CustomerDB {

    public CustomerDB() {
    }

    public boolean addCusDB(Customer cusObj) {
        try {
            Connection cons = DBConnect.connect();
            String insertQuery = "insert into Customer (CusID, CusName, Address, TelephoneNo) values (?,?,?,?)";
            PreparedStatement ps = cons.prepareStatement(insertQuery);
            ps.setString(1, cusObj.getCusID());
            ps.setString(2, cusObj.getCusName());
            ps.setString(3, cusObj.getAddress());
            ps.setInt(4, cusObj.getTeleNo());
            ps.executeUpdate();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean editCusDB(Customer cusObj) {
        try {
            Connection cons = DBConnect.connect();
            String insertQuery = "update Customer set CusName=?, Address=?, TelephoneNo=? where CusID=?";
            PreparedStatement ps = cons.prepareStatement(insertQuery);
            ps.setString(1, cusObj.getCusName());
            ps.setString(2, cusObj.getAddress());
            ps.setInt(3, cusObj.getTeleNo());
            ps.setString(4, cusObj.getCusID());
            ps.executeUpdate();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public boolean removeCusDB(String CusId) {
        try {
            Connection cons = DBConnect.connect();
            String deleteQuery = "delete from Customer where CusID=?";
            PreparedStatement ps = cons.prepareStatement(deleteQuery);
            ps.setString(1, CusId);
            ps.executeUpdate();
            ps.close();
            cons.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ArrayList<Customer> getAllCusDB() {
        ArrayList<Customer> cusList = new ArrayList<Customer>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Customer";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer cusObj = new Customer();
                cusObj.setCusID(rs.getString(1));
                cusObj.setCusName(rs.getString(2));
                cusObj.setAddress(rs.getString(3));
                cusObj.setTeleNo(rs.getInt(4));
                cusList.add(cusObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return cusList;
        }
    }

    public Customer getCusDB(String CusID) {
        Customer cusObj = new Customer();
        try {
            Connection cons = DBConnect.connect();
            String selectQbyID = "select * from Customer where CusID = ?";
            PreparedStatement ps = cons.prepareStatement(selectQbyID);
            ps.setString(1, CusID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cusObj.setCusID(rs.getString(1));
                cusObj.setCusName(rs.getString(2));
                cusObj.setAddress(rs.getString(3));
                cusObj.setTeleNo(rs.getInt(4));
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return cusObj;
        }
    }

    public ArrayList<Customer> getAllCus() {
        ArrayList<Customer> cusList = new ArrayList<Customer>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Customer";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer cusObj = new Customer();
                cusObj.setCusID(rs.getString(1));
                cusObj.setCusName(rs.getString(2));
                cusObj.setAddress(rs.getString(3));
                cusObj.setTeleNo(rs.getInt(4));
                cusList.add(cusObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return cusList;
        }
    }

    public ArrayList<Customer> searchCusDB(String CusName) {
        ArrayList<Customer> cusList = new ArrayList<Customer>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Customer where CusName like '" + CusName + "%'";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer cusObj = new Customer();
                cusObj.setCusID(rs.getString(1));
                cusObj.setCusName(rs.getString(2));
                cusObj.setAddress(rs.getString(3));
                cusObj.setTeleNo(rs.getInt(4));
                cusList.add(cusObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return cusList;
        }
    }

    public ArrayList<Customer> searchCusIDDB(String CusID) {
        ArrayList<Customer> cusList = new ArrayList<Customer>();
        try {
            Connection cons = DBConnect.connect();
            String selectQ = "select * from Customer where CusID like '" + CusID + "%'";
            PreparedStatement ps = cons.prepareStatement(selectQ);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer cusObj = new Customer();
                cusObj.setCusID(rs.getString(1));
                cusObj.setCusName(rs.getString(2));
                cusObj.setAddress(rs.getString(3));
                cusObj.setTeleNo(rs.getInt(4));
                cusList.add(cusObj);
            }
            rs.close();
            ps.close();
            cons.close();
        } finally {
            return cusList;
        }
    }
}
