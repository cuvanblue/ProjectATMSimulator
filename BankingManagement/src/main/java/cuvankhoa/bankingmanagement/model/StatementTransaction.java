/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuvankhoa.bankingmanagement.model;

/**
 *
 * @author TOTORO
 */
public class StatementTransaction extends HistoryTransaction {

    public StatementTransaction(String atmid, String transactionid, String atmcardnumber, String transactiontime, String content) {
        super.atmid = atmid.trim();
        super.transactionid = transactionid.trim();
        super.atmcardnumber = atmcardnumber.trim();
        super.transactiontime = transactiontime.trim();
        super.content = content.trim();
    }

    public String getAtmid() {
        return atmid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public String getAtmcardnumber() {
        return atmcardnumber;
    }

    public String getTransactiontime() {
        return transactiontime;
    }

    public String getContent() {
        return content;
    }
    

    
}
