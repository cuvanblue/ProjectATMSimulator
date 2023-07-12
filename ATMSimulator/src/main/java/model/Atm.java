/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author TOTORO
 */
public class Atm {
    String atmID;
    String address;
    String  ownerBank;
    int cash;
    int quanity50;
    int quanity100;
    int quanity200;
    int quanity500;
    boolean status;
    ArrayList<ChangePinTransaction> changePinTransactions;
    ArrayList<CheckBalanceTransaction> checkBalanceTransactions;
    ArrayList<TransferTransaction> transferTransactions;
    ArrayList<WithdrawTransaction> withdrawTransactions;
    ArrayList<StatementTransaction> statementTransaction;
    public Atm() {
    }

    public Atm(String atmID, String address, String ownerBank, int cash, int quanity50, int quanity100, int quanity200, int quanity500, boolean status, ArrayList<ChangePinTransaction> changePinTransactions, ArrayList<CheckBalanceTransaction> checkBalanceTransactions, ArrayList<TransferTransaction> transferTransactions, ArrayList<WithdrawTransaction> withdrawTransactions, ArrayList<StatementTransaction> statementTransaction) {
        this.atmID = atmID.trim();
        this.address = address.trim();
        this.ownerBank = ownerBank.trim();
        this.cash = cash;
        this.quanity50 = quanity50;
        this.quanity100 = quanity100;
        this.quanity200 = quanity200;
        this.quanity500 = quanity500;
        this.status = status;
        this.changePinTransactions = changePinTransactions;
        this.checkBalanceTransactions = checkBalanceTransactions;
        this.transferTransactions = transferTransactions;
        this.withdrawTransactions = withdrawTransactions;
        this.statementTransaction = statementTransaction;
    }

    public String getAtmID() {
        return atmID;
    }

    public void setAtmID(String atmID) {
        this.atmID = atmID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOwnerBank() {
        return ownerBank;
    }

    public void setOwnerBank(String ownerBank) {
        this.ownerBank = ownerBank;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getQuanity50() {
        return quanity50;
    }

    public void setQuanity50(int quanity50) {
        this.quanity50 = quanity50;
    }

    public int getQuanity100() {
        return quanity100;
    }

    public void setQuanity100(int quanity100) {
        this.quanity100 = quanity100;
    }

    public int getQuanity200() {
        return quanity200;
    }

    public void setQuanity200(int quanity200) {
        this.quanity200 = quanity200;
    }

    public int getQuanity500() {
        return quanity500;
    }

    public void setQuanity500(int quanity500) {
        this.quanity500 = quanity500;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ArrayList<ChangePinTransaction> getChangePinTransactions() {
        return changePinTransactions;
    }

    public void setChangePinTransactions(ArrayList<ChangePinTransaction> changePinTransactions) {
        this.changePinTransactions = changePinTransactions;
    }

    public ArrayList<CheckBalanceTransaction> getCheckBalanceTransactions() {
        return checkBalanceTransactions;
    }

    public void setCheckBalanceTransactions(ArrayList<CheckBalanceTransaction> checkBalanceTransactions) {
        this.checkBalanceTransactions = checkBalanceTransactions;
    }

    public ArrayList<TransferTransaction> getTransferTransactions() {
        return transferTransactions;
    }

    public void setTransferTransactions(ArrayList<TransferTransaction> transferTransactions) {
        this.transferTransactions = transferTransactions;
    }

    public ArrayList<WithdrawTransaction> getWithdrawTransactions() {
        return withdrawTransactions;
    }

    public void setWithdrawTransactions(ArrayList<WithdrawTransaction> withdrawTransactions) {
        this.withdrawTransactions = withdrawTransactions;
    }

    public ArrayList<StatementTransaction> getStatementTransaction() {
        return statementTransaction;
    }

    public void setStatementTransaction(ArrayList<StatementTransaction> statementTransaction) {
        this.statementTransaction = statementTransaction;
    }
    
    
    
    public void checkCash(){
        if(cash < 10000000)
        {
            System.out.println("run out of cash");
            //
            status = false;
        }
        else{
            status = true;
        }
    }

    
    
}
