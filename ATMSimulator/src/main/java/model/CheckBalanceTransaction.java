/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TOTORO
 */
public class CheckBalanceTransaction extends HistoryTransaction {
    long amount;
    
    public CheckBalanceTransaction(String atmid, String transactionid, String atmcardnumber, String transactiontime, long  amount, String content) {
        super.atmid = atmid.trim();
        super.transactionid = transactionid.trim();
        super.atmcardnumber = atmcardnumber.trim();
        super.transactiontime = transactiontime.trim();
        this.amount = amount;
        super.content = content;
    }   
    
    public void transactionContent(boolean bill){
        String billInfor ="";
        if(bill == true){
            billInfor = ". Phí in hóa đơn: 1.500VNĐ.";
        }
        String a = "Thẻ "+ super.atmcardnumber +" kiểm tra số dư: " + amount +  "VND vào lúc "+ super.transactiontime + billInfor + "@";
        super.content += a;
    }

    public long getAmount() {
        return amount;
    }
    
    
}
