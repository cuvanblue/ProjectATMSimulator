/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuvankhoa.bankingmanagement.model;

import java.util.ArrayList;

/**
 *
 * @author TOTORO
 */
public class Bank {
    String name;
    float withdrawfeeIn;
    float withdrawfeeOut;
    float transferfeeIn;
    float transferfeeOut;
    ArrayList<Customer> customer;
    ArrayList<Atm> atm;
    ArrayList<Admin> admin;

    public Bank() {
    }

    public Bank(String name, float withdrawfeeIn, float withdrawfeeOut, float transferfeeIn, float transferfeeOut, ArrayList<Customer> customer, ArrayList<Atm> atm, ArrayList<Admin> admin) {
        this.name = name.trim();
        this.withdrawfeeIn = withdrawfeeIn;
        this.withdrawfeeOut = withdrawfeeOut;
        this.transferfeeIn = transferfeeIn;
        this.transferfeeOut = transferfeeOut;
        this.customer = customer;
        this.atm = atm;
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWithdrawfeeIn() {
        return withdrawfeeIn;
    }

    public void setWithdrawfeeIn(float withdrawfeeIn) {
        this.withdrawfeeIn = withdrawfeeIn;
    }

    public float getWithdrawfeeOut() {
        return withdrawfeeOut;
    }

    public void setWithdrawfeeOut(float withdrawfeeOut) {
        this.withdrawfeeOut = withdrawfeeOut;
    }

    public float getTransferfeeIn() {
        return transferfeeIn;
    }

    public void setTransferfeeIn(float transferfeeIn) {
        this.transferfeeIn = transferfeeIn;
    }

    public float getTransferfeeOut() {
        return transferfeeOut;
    }

    public void setTransferfeeOut(float transferfeeOut) {
        this.transferfeeOut = transferfeeOut;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }

    public ArrayList<Atm> getAtm() {
        return atm;
    }

    public void setAtm(ArrayList<Atm> atm) {
        this.atm = atm;
    }

    public ArrayList<Admin> getAdmin() {
        return admin;
    }

    public void setAdmin(ArrayList<Admin> admin) {
        this.admin = admin;
    }

    
    
}
