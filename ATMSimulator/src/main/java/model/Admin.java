/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TOTORO
 */
public class Admin {
    String bankName;
    String account;
    String password;

    public Admin() {
    }

    public Admin(String  bankName, String account, String password) {
        this.bankName = bankName.trim();
        this.account = account.trim();
        this.password = password.trim();
    }

    public String getbankName() {
        return bankName;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }
     
    
    public void changePassword(String newpass){
        this.password = newpass;
    }
}
