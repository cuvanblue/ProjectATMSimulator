/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuvankhoa.bankingmanagement.model;

/**
 *
 * @author TOTORO
 */
public class ChangePinTransaction extends HistoryTransaction {
    String oldpin;
    String newpin;
    public ChangePinTransaction(String atmid, String transactionid, String atmcardnumber, String transactiontime, String oldpin, String newpin , String content) {
        super.atmid = atmid.trim();
        super.transactionid = transactionid.trim();
        super.atmcardnumber = atmcardnumber.trim();
        super.transactiontime = transactiontime.trim();
        this.oldpin = oldpin.trim();
        this.newpin = newpin.trim();
        super.content = content.trim();
    }
    
    public void transactionContent(boolean bill){
        String billInfor ="";
        if(bill == true){
            billInfor = ". Phí in hóa đơn: 1.500VNĐ.";
        }
        String a = "Thẻ "+ super.atmcardnumber +" đổi mã pin từ : "+this.oldpin + " sang " + this.newpin +  " vào lúc "+ super.transactiontime+ billInfor + "@";
        super.content += a;
    }

    public String getOldpin() {
        return oldpin;
    }

    public void setOldpin(String oldpin) {
        this.oldpin = oldpin;
    }

    public String getNewpin() {
        return newpin;
    }

    public void setNewpin(String newpin) {
        this.newpin = newpin;
    }
    
    
}
