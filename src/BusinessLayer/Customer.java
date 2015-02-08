/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccessLayer.CustomerDB;
import java.util.ArrayList;

/**
 *
 * @author JSaji
 */
public class Customer {

    private String CusID;
    private String CusName;
    private String Address;
    private int TeleNo;

    public Customer() {
    }

    public Customer(String CusID, String CusName, String Address, int TeleNo) {
        this.CusID = CusID;
        this.CusName = CusName;
        this.Address = Address;
        this.TeleNo = TeleNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCusID() {
        return CusID;
    }

    public void setCusID(String CusID) {
        this.CusID = CusID;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String CusName) {
        this.CusName = CusName;
    }

    public int getTeleNo() {
        return TeleNo;
    }

    public void setTeleNo(int TeleNo) {
        this.TeleNo = TeleNo;
    }
    
    public boolean addCus(Customer cusObj) {
        boolean result = true;
        if (cusObj.getCusID() == null) {
            result = false;
        } else if (cusObj.getCusName() == null) {
            result = false;
        } else if (cusObj.getAddress() == null) {
            result = false;
        } else if (cusObj.getTeleNo() == 0) {
            result = false;
        } else {
            result = new CustomerDB().addCusDB(cusObj);
        }
        return result;
    }

    public boolean editCus(Customer cusObj) {
        boolean result = true;
        if (cusObj.getCusID() == null) {
            result = false;
        } else if (cusObj.getCusName() == null) {
            result = false;
        } else if (cusObj.getAddress() == null) {
            result = false;
        } else if (cusObj.getTeleNo() == 0) {
            result = false;
        } else {
            result = new CustomerDB().editCusDB(cusObj);
        }
        return result;
    }

    public boolean removeCus(String CusId) {
        boolean result = new CustomerDB().removeCusDB(CusId);
        return result;
    }
    
    public ArrayList<Customer> getAllCus() { 
        ArrayList<Customer> CusList = new CustomerDB().getAllCusDB(); 
        return CusList; 
    }
    
    public Customer getCus(String CusID) { 
        Customer CusObj = new CustomerDB().getCusDB(CusID); 
        return CusObj; 
    }
    
    public ArrayList<Customer> getAllCusDB() { 
        ArrayList<Customer> cusList = new CustomerDB().getAllCus(); 
        return cusList; 
    }
    
    public ArrayList<Customer> searchCus(String CusName) { 
        ArrayList<Customer> cusList = new CustomerDB().searchCusDB(CusName); 
        return cusList; 
    }
    
    public ArrayList<Customer> searchCusID(String CusName) { 
        ArrayList<Customer> cusList = new CustomerDB().searchCusIDDB(CusName); 
        return cusList; 
    }
}
