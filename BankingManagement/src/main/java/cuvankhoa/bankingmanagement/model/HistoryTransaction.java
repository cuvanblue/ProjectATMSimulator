/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuvankhoa.bankingmanagement.model;

/**
 *
 * @author TOTORO
 */
public class HistoryTransaction {
    String atmid;
    String transactionid;
    String atmcardnumber;
    String transactiontime;
    String content;

    public HistoryTransaction() {
    }

    public String getAtmid() {
        return atmid;
    }

    public void setAtmid(String atmid) {
        this.atmid = atmid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid;
    }

    public String getAtmcardnumber() {
        return atmcardnumber;
    }

    public void setAtmcardnumber(String atmcardnumber) {
        this.atmcardnumber = atmcardnumber;
    }

    public String getTransactiontime() {
        return transactiontime;
    }

    public void setTransactiontime(String transactiontime) {
        this.transactiontime = transactiontime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    void transactionContent()
    {}
    
}
