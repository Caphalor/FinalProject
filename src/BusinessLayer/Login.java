/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLayer;

import DataAccessLayer.LoginDB;
/**
 *
 * @author JSaji
 */
public class Login {
    private String mUsername; //declaring mUsername String Variable
    private String mPassword; //declaring mPassword String Variable

    public Login() {
    }

    public Login(String mUsername, String mPassword) {
        this.mUsername = mUsername;
        this.mPassword = mPassword;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public Login getLoginDetails(String tUsername) { //this sub program used to get Username and password from the DataAccessLayer
        Login movieObj = new LoginDB().getLoginDetailsDB(tUsername); //create object for the MegaVideoDB class and pass to the getLoginDetailsDB sub program
        return movieObj; //return the result
    }
}
