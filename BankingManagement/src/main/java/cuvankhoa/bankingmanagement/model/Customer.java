/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuvankhoa.bankingmanagement.model;

/**
 *
 * @author TOTORO
 */
public class Customer {
    String name;
    String address;
    String atmKind;
    String  idCard;
    String birthDay;
    String phone;
    String bankName;
    String atmCardnumber;
    String atmPin;
    String validFrom;
    String goodThru;
    long balance;
    boolean atmStatus;

    public Customer() {
    }

    public Customer(String name, String  idCard, String birthDay ,String phone,String address,String bankName, 
            String atmCardnumber, String atmPin, String atmKind, boolean atmStatus, String validFrom, String goodThru, long balance) {
        this.name = name.trim();
        this.address = address.trim();
        this.atmKind = atmKind.trim();
        this.idCard = idCard.trim();
        this.birthDay = birthDay.trim();
        this.atmCardnumber = atmCardnumber.trim();
        this.atmPin = atmPin.trim();
        this.validFrom = validFrom.trim();
        this.goodThru = goodThru.trim();
        this.balance = balance;
        this.atmStatus = atmStatus;
        this.bankName = bankName.trim();
        this.phone = phone.trim();
    }

    public String getbankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAtmKind() {
        return atmKind;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getAtmCardnumber() {
        return atmCardnumber;
    }

    public String getAtmPin() {
        return atmPin;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public String getGoodThru() {
        return goodThru;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isAtmStatus() {
        return atmStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAtmKind(String atmKind) {
        this.atmKind = atmKind;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setAtmCardnumber(String atmCardnumber) {
        this.atmCardnumber = atmCardnumber;
    }

    public void setAtmPin(String atmPin) {
        this.atmPin = atmPin;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public void setGoodThru(String goodThru) {
        this.goodThru = goodThru;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setAtmStatus(boolean atmStatus) {
        this.atmStatus = atmStatus;
    }
    
}
