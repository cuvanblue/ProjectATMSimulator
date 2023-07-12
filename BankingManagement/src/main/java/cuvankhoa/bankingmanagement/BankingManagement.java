/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package cuvankhoa.bankingmanagement;

import cuvankhoa.bankingmanagement.model.*;
import cuvankhoa.bankingmanagement.view.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author TOTORO
 */
public class BankingManagement {

    
    public static void main(String[] args) {
        // thiet lap ket noi server
        Connection conn = null;
       try 
       {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
       }
       catch(ClassNotFoundException|SQLException e ){
           e.printStackTrace();
       }
       
       // gan du lieu
       //Customer
        ArrayList<Customer> customer = new ArrayList<Customer>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM Customer");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 Customer a = new Customer(rs.getString(1), rs.getString(2), rs.getString(3),
                 rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                 rs.getBoolean(10), rs.getString(11), rs.getString(12), rs.getLong(13));
                 customer.add(a);          
             }
        } catch (Exception e) {
            e.printStackTrace();
        }       
        
        
        // Admin
         ArrayList<Admin> admin = new ArrayList<Admin>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM Admin");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 Admin a = new Admin(rs.getString(1), rs.getString(2), rs.getString(3));
                 admin.add(a);               }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //statement
        ArrayList<StatementTransaction> statementTransactions = new ArrayList<StatementTransaction>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM statementTransaction");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 StatementTransaction a =  new StatementTransaction(rs.getString(1), rs.getString(2),
                 rs.getString(3), rs.getString(4), rs.getString(5));
                 statementTransactions.add(a);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //change pin
        ArrayList<ChangePinTransaction> changePinTrans = new ArrayList<ChangePinTransaction>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM changepinTransaction");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 ChangePinTransaction a =  new ChangePinTransaction(rs.getString(1), rs.getString(2),
                 rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                 changePinTrans.add(a);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //check balance
        ArrayList<CheckBalanceTransaction> checkBalanceTrans = new ArrayList<CheckBalanceTransaction>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM checkbalanceTransaction");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 CheckBalanceTransaction a =  new CheckBalanceTransaction(rs.getString(1), rs.getString(2),
                 rs.getString(3), rs.getString(4), rs.getLong(5),rs.getString(6));
                 checkBalanceTrans.add(a);
                 
             }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        
        
        //Transfer
        ArrayList<TransferTransaction> transferTrans = new ArrayList<TransferTransaction>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM transferTransaction");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 TransferTransaction a =  new TransferTransaction(rs.getString(1), rs.getString(2),
                                                                                                rs.getString(3), rs.getString(4),
                                                                                                rs.getInt(5), 
                                                                                                rs.getString(6),rs.getString(7) );
                 transferTrans.add(a);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //withdraw
        ArrayList<WithdrawTransaction> withdrawTrans = new ArrayList<WithdrawTransaction>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM withdrawTransaction");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 WithdrawTransaction a =  new WithdrawTransaction(rs.getString(1), rs.getString(2),
                 rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6));
                 withdrawTrans.add(a);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        //Atm
        ArrayList<Atm> atm = new ArrayList<Atm>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM ATM");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 String currentAtmid = rs.getString(1).trim();
                 ArrayList<ChangePinTransaction> changepin = new ArrayList<ChangePinTransaction>();
                 ArrayList<CheckBalanceTransaction> checkba = new ArrayList<CheckBalanceTransaction>();
                 ArrayList<TransferTransaction> transfer  = new ArrayList<TransferTransaction>();
                 ArrayList<WithdrawTransaction> withdraw = new ArrayList<WithdrawTransaction>();
                 ArrayList<StatementTransaction> statement = new ArrayList<StatementTransaction>();
                 for(ChangePinTransaction i : changePinTrans)
                 {
                     if(i.getAtmid().equals(currentAtmid)){  changepin.add(i);}
                 }
                 for(CheckBalanceTransaction i : checkBalanceTrans)
                 {
                     if(i.getAtmid().equals(currentAtmid)){  checkba.add(i);}
                 }
                 for(TransferTransaction i : transferTrans)
                 {
                     if(i.getAtmid().equals(currentAtmid)){  transfer.add(i);}
                 }
                 for(WithdrawTransaction i : withdrawTrans)
                 {
                     if(i.getAtmid().equals(currentAtmid)){  withdraw.add(i);}
                 }
                 for(StatementTransaction i : statementTransactions)
                 {
                     if(i.getAtmid().equals(currentAtmid)){  statement.add(i);}
                 }
                 Atm a =  new Atm(rs.getString(1), rs.getString(2), rs.getString(3), 
                         rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getBoolean(9),
                         changepin,checkba,transfer,withdraw, statement);
                atm.add(a);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        // bank
        ArrayList<Bank> bank = new ArrayList<Bank>();
        try {
             PreparedStatement prest = conn.prepareStatement("SELECT * FROM Bank");
             ResultSet rs = prest.executeQuery();
             while(rs.next()){
                 String currentBankName = rs.getString(1).trim();
                 ArrayList<Customer> cus = new ArrayList<Customer>();
                 ArrayList<Atm> at = new ArrayList<Atm>();
                 ArrayList<Admin> ad  = new ArrayList<Admin>();          
                 for(Customer i : customer )
                 {
                     if(i.getbankName().equals(currentBankName) ){  cus.add(i);}                 
                 }
                 for(Atm i : atm)
                 {
                     if(i.getOwnerBank().equals(currentBankName)){  at.add(i);}                    
                 }
                 for(Admin i : admin)
                 {
                     if(i.getbankName().equals(currentBankName) ){  ad.add(i);}          
                 }            
                 Bank a = new Bank(currentBankName, rs.getFloat(2), rs.getFloat(3), 
                         rs.getFloat(4), rs.getFloat(5), cus, at, ad);
                 bank.add(a);                 
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LoginWindow loginwindow = new LoginWindow(bank);
        loginwindow.setVisible(true);
    }
}
