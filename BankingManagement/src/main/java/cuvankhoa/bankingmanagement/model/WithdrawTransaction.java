/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuvankhoa.bankingmanagement.model;

/**
 *
 * @author TOTORO
 */
public class WithdrawTransaction extends HistoryTransaction{
    
    int amount;
    
    public WithdrawTransaction(String atmid, String transactionid, String atmcardnumber, String transactiontime, int amount , String content) {
        super.atmid = atmid.trim();
        super.transactionid = transactionid.trim();
        super.atmcardnumber = atmcardnumber.trim();
        super.transactiontime = transactiontime.trim();
        this.amount = amount;
        super.content = content.trim();
    }
    
    public void transactionContent(boolean bill){
        String billInfor ="";
        if(bill == true){
            billInfor = ". Phí in hóa đơn: 1.500VNĐ.";
        }
        String a = "Thẻ "+ super.atmcardnumber +" rút: " + amount +  " VND vào lúc "+ super.transactiontime + billInfor + "@";
        super.content += a;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public String getContent() {
        return content;
    }
    
    
}
