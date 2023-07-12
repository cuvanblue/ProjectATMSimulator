/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author TOTORO
 */
public class TransferTransaction extends HistoryTransaction {
    int amount;
    String atmcardnumber;
    public TransferTransaction(String atmid, String transactionid, String atmcardnumber, String transactiontime, int amount, String atmcardnumber2,   String content) {
        super.atmid = atmid.trim();
        super.transactionid = transactionid.trim();
        super.atmcardnumber = atmcardnumber.trim();
        super.transactiontime = transactiontime.trim();
        this.amount = amount;
        this.atmcardnumber = atmcardnumber2.trim();
        super.content = content.trim();
    }
    
    public void transactionContent(boolean bill){
        String billInfor ="";
        if(bill == true){
            billInfor = ". Phí in hóa đơn: 1.500VNĐ.";
        }
        String a = "Thẻ "+ super.atmcardnumber +" chuyển khoản cho : "+this.atmcardnumber + " " + amount +  " VND vào lúc "+ super.transactiontime + billInfor + "@";
        super.content += a;
    }

    public int getAmount() {
        return amount;
    }

    public String getAtmcardnumber2() {
        return atmcardnumber;
    }
       
}
