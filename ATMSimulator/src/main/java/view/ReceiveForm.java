/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

/**
 *
 * @author TOTORO
 */
import java.util.ArrayList;
import model.*;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Time;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReceiveForm extends javax.swing.JDialog {

    /**
     * Creates new form ReceiveForm1
     */
    HistoryTransaction transaction;
    MainWindow mainWindow;
    DefaultTableModel a;
    public ReceiveForm(java.awt.Frame parent, boolean modal, String typeTransaction) {
        super(parent, modal);
        this.mainWindow = (MainWindow)parent;
        FlatLightLaf.setup();
        initComponents();
        if(typeTransaction == "withdraw")
        {
            withdrawExcute();         
        }
        if(typeTransaction == "checkbalance")
        {
           checkbalanceExcute();
        }
        if(typeTransaction == "changepin")
        {
           changepinExcute();
        }
        if(typeTransaction == "transfer")
        {
           transferExcute();
        }
        if(typeTransaction == "statement")
        {
           statementExcute();          
        }
    }
    
    private void statementExcute() {
        for(Bank i : this.mainWindow.bank)
        {
            for(Atm k : i.getAtm())
            {
                for(StatementTransaction j : k.getStatementTransaction())
                {
                    if(j.getAtmcardnumber().equals(this.mainWindow.currentCustomer.getAtmCardnumber()))
                    {
                        a = (DefaultTableModel)Statement.getModel();
                    a.addRow(new Object[]{ j.getTransactionid() , j.getContent()});
                    }
                }
                for(ChangePinTransaction j : k.getChangePinTransactions())
                {
                    if(j.getAtmcardnumber().equals(this.mainWindow.currentCustomer.getAtmCardnumber()))
                    {
                        a = (DefaultTableModel)Statement.getModel();
                    a.addRow(new Object[]{ j.getTransactionid() , j.getContent()});
                    }
                }
                for(CheckBalanceTransaction j : k.getCheckBalanceTransactions())
                {
                    if(j.getAtmcardnumber().equals(this.mainWindow.currentCustomer.getAtmCardnumber()))
                    {
                        a = (DefaultTableModel)Statement.getModel();
                    a.addRow(new Object[]{ j.getTransactionid() , j.getContent()});
                    }
                }
                for(WithdrawTransaction j : k.getWithdrawTransactions())
                {
                    if(j.getAtmcardnumber().equals(this.mainWindow.currentCustomer.getAtmCardnumber()))
                    {
                        a = (DefaultTableModel)Statement.getModel();
                    a.addRow(new Object[]{ j.getTransactionid() , j.getContent()});
                    }
                }
                for(TransferTransaction j : k.getTransferTransactions())
                {
                    if(j.getAtmcardnumber().equals(this.mainWindow.currentCustomer.getAtmCardnumber()))
                    {
                        a = (DefaultTableModel)Statement.getModel();
                    a.addRow(new Object[]{ j.getTransactionid() , j.getContent()});
                    }
                }
            }
        }
        txtResult.setText("Bạn đã sao kê thành công");
        // hien thi cash
        txtCash.setText( this.mainWindow.withdrawAmount + " "+  txtCash.getText());
        txtQ50.setText(Integer.toString(this.mainWindow.cash[0]));
        txtQ100.setText(Integer.toString(this.mainWindow.cash[1]));
        txtQ200.setText(Integer.toString(this.mainWindow.cash[2]));
        txtQ500.setText(Integer.toString(this.mainWindow.cash[3]));
        // hien thi bill
        if(this.mainWindow.isPrintBill()){
            pnBill.setVisible(true);
            txtCurrentBank.setText(this.mainWindow.currentBank.getName());
            txtCurrentATM.setText(this.mainWindow.currentAtm.getAtmID() + " ATM "
                                                       + this.mainWindow.currentAtm.getOwnerBank() + " " 
                                                       + this.mainWindow.currentAtm.getAddress());
            txtContent.setText("Thẻ "+ this.mainWindow.currentCustomer.getAtmCardnumber() +" thực hiện sao kê ");
            txtContent1.setText("vào lúc: "+ LocalDateTime.now().toString());
            txtContent2.setText("Phí in hóa đơn: 1.500VND)");
        }
        else
        {
            txtCurrentBank.setText("");
            txtCurrentATM.setText("");
            txtContent.setText("");
            txtContent1.setText("");
        }
        // hien thi sao ke
        
    }
    
     private void transferExcute() {
        txtResult.setText("Bạn đã chuyển khoản thành công");
        // hien thi cash
        txtCash.setText( this.mainWindow.withdrawAmount + " "+  txtCash.getText());
        txtQ50.setText(Integer.toString(this.mainWindow.cash[0]));
        txtQ100.setText(Integer.toString(this.mainWindow.cash[1]));
        txtQ200.setText(Integer.toString(this.mainWindow.cash[2]));
        txtQ500.setText(Integer.toString(this.mainWindow.cash[3]));
        // hien thi bill
        if(this.mainWindow.isPrintBill()){
            txtCurrentBank.setText(this.mainWindow.currentBank.getName());
            txtCurrentATM.setText(this.mainWindow.currentAtm.getAtmID() + " ATM "
                                                       + this.mainWindow.currentAtm.getOwnerBank() + " " 
                                                       + this.mainWindow.currentAtm.getAddress());
            txtContent.setText("Thẻ "+ this.mainWindow.currentCustomer.getAtmCardnumber() +" chuyển khoản đến " + this.mainWindow.currentCustomerTrans.getAtmCardnumber());
            txtContent1.setText("vào lúc: "+ LocalDateTime.now().toString()+ " số tiền: "+ this.mainWindow.transferAmount +" VND");
            txtContent2.setText("Số dư còn lại: "+Long.toString(mainWindow.currentCustomer.getBalance() + (int)mainWindow.fee)+" VND"+ " (Phí in hóa đơn: 1.500VND)");
        }
        else
        {
            txtCurrentBank.setText("");
            txtCurrentATM.setText("");
            txtContent.setText("");
            txtContent1.setText("");
        }
    }
    
    private  void changepinExcute(){
         // hien thi result
        txtResult.setText("Bạn đã đổi PIN thành công");
        // hien thi cash
        txtCash.setText( this.mainWindow.withdrawAmount + " "+  txtCash.getText());
        txtQ50.setText(Integer.toString(this.mainWindow.cash[0]));
        txtQ100.setText(Integer.toString(this.mainWindow.cash[1]));
        txtQ200.setText(Integer.toString(this.mainWindow.cash[2]));
        txtQ500.setText(Integer.toString(this.mainWindow.cash[3]));
        // hien thi bill
        if(this.mainWindow.isPrintBill()){
            txtCurrentBank.setText(this.mainWindow.currentBank.getName());
            txtCurrentATM.setText(this.mainWindow.currentAtm.getAtmID() + " ATM "
                                                       + this.mainWindow.currentAtm.getOwnerBank() + " " 
                                                       + this.mainWindow.currentAtm.getAddress());
            txtContent.setText("Thẻ "+ this.mainWindow.currentCustomer.getAtmCardnumber() +" thay đổi PIN");
            txtContent1.setText("vào lúc: "+ LocalDateTime.now().toString());
            txtContent2.setText("Số dư còn lại: "+Long.toString(mainWindow.currentCustomer.getBalance())+" VND"+ " (Phí in hóa đơn: 1.500VND)");
        }
        else
        {
            txtCurrentBank.setText("");
            txtCurrentATM.setText("");
            txtContent.setText("");
            txtContent1.setText("");
        }
    }
    
    private  void checkbalanceExcute(){
         // hien thi result
        txtResult.setText("Số dư còn lại: "+ this.mainWindow.currentCustomer.getBalance());
        // hien thi cash
        txtCash.setText( this.mainWindow.withdrawAmount + " "+  txtCash.getText());
        txtQ50.setText(Integer.toString(this.mainWindow.cash[0]));
        txtQ100.setText(Integer.toString(this.mainWindow.cash[1]));
        txtQ200.setText(Integer.toString(this.mainWindow.cash[2]));
        txtQ500.setText(Integer.toString(this.mainWindow.cash[3]));
        // hien thi bill
        if(this.mainWindow.isPrintBill()){
            txtCurrentBank.setText(this.mainWindow.currentBank.getName());
            txtCurrentATM.setText(this.mainWindow.currentAtm.getAtmID() + " ATM "
                                                       + this.mainWindow.currentAtm.getOwnerBank() + " " 
                                                       + this.mainWindow.currentAtm.getAddress());
            txtContent.setText("Thẻ "+ this.mainWindow.currentCustomer.getAtmCardnumber() +" kiểm tra số dư");
            txtContent1.setText("vào lúc: "+ LocalDateTime.now().toString());
            txtContent2.setText("Số dư còn lại: "+Long.toString(mainWindow.currentCustomer.getBalance())+" VND"+ " (Phí in hóa đơn: 1.500VND)");
        }
        else
        {
            txtCurrentBank.setText("");
            txtCurrentATM.setText("");
            txtContent.setText("");
            txtContent1.setText("");
        }
    }
    
    private void withdrawExcute(){
        // hien thi result
        txtResult.setText("Bạn đã rút " + this.mainWindow.withdrawAmount + " VNĐ");
        // hien thi cash
        txtCash.setText( this.mainWindow.withdrawAmount + " "+  txtCash.getText());
        txtQ50.setText(Integer.toString(this.mainWindow.cash[0]));
        txtQ100.setText(Integer.toString(this.mainWindow.cash[1]));
        txtQ200.setText(Integer.toString(this.mainWindow.cash[2]));
        txtQ500.setText(Integer.toString(this.mainWindow.cash[3]));
        // hien thi bill
        if(this.mainWindow.isPrintBill()){
            txtCurrentBank.setText(this.mainWindow.currentBank.getName());
            txtCurrentATM.setText(this.mainWindow.currentAtm.getAtmID() + " ATM "
                                                       + this.mainWindow.currentAtm.getOwnerBank() + " " 
                                                       + this.mainWindow.currentAtm.getAddress());
            txtContent.setText("Thẻ "+ this.mainWindow.currentCustomer.getAtmCardnumber() +" rút: " 
                                                             + (this.mainWindow.withdrawAmount + (int)this.mainWindow.fee)
                                                             +  " VND" );
            txtContent1.setText("vào lúc: "+ LocalDateTime.now().toString());
            txtContent2.setText("Số dư còn lại: "+Long.toString(mainWindow.currentCustomer.getBalance())+" VND"+ " (Phí in hóa đơn: 1.500VND)");
        }
        else
        {
            txtCurrentBank.setText("");
            txtCurrentATM.setText("");
            txtContent.setText("");
            txtContent1.setText("");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        txtResult = new javax.swing.JLabel();
        pnCash = new javax.swing.JPanel();
        txtCash = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtQ50 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtQ100 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtQ200 = new javax.swing.JLabel();
        txtQ500 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnStatement = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Statement = new javax.swing.JTable();
        pnBill = new javax.swing.JPanel();
        txtCurrentBank = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCurrentATM = new javax.swing.JLabel();
        txtContent = new javax.swing.JLabel();
        txtContent1 = new javax.swing.JLabel();
        txtContent2 = new javax.swing.JLabel();
        btnOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alert");
        setResizable(false);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        txtResult.setText("Ban da rut");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Result", jPanel3);

        pnCash.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                pnCashComponentHidden(evt);
            }
        });

        txtCash.setText("VND");

        jLabel1.setText("Cash receive: ");

        jLabel2.setText("50 quanity:");

        jLabel3.setText("100 quanity:");

        jLabel4.setText("200 quanity:");

        jLabel5.setText("500 quanity:");

        javax.swing.GroupLayout pnCashLayout = new javax.swing.GroupLayout(pnCash);
        pnCash.setLayout(pnCashLayout);
        pnCashLayout.setHorizontalGroup(
            pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCashLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCashLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQ500, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE))
                    .addGroup(pnCashLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQ200, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnCashLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnCashLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQ50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnCashLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQ100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnCashLayout.setVerticalGroup(
            pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCashLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCash))
                .addGap(14, 14, 14)
                .addGroup(pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQ50))
                .addGap(14, 14, 14)
                .addGroup(pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQ100))
                .addGap(14, 14, 14)
                .addGroup(pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQ200))
                .addGap(14, 14, 14)
                .addGroup(pnCashLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtQ500))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Cash", pnCash);

        Statement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Transaction ID", "Information"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Statement);

        javax.swing.GroupLayout pnStatementLayout = new javax.swing.GroupLayout(pnStatement);
        pnStatement.setLayout(pnStatementLayout);
        pnStatementLayout.setHorizontalGroup(
            pnStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );
        pnStatementLayout.setVerticalGroup(
            pnStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Statement", pnStatement);

        txtCurrentBank.setText("BIDV");

        jLabel7.setText("*********************************************************************************************");

        txtCurrentATM.setText("00001 ATM Agrigank");
        txtCurrentATM.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        txtCurrentATM.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        txtContent.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtContent.setText("- The 0000000000000000 da rut 600000VND");
        txtContent.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtContent1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtContent1.setText("Vao luc:");
        txtContent1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtContent2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtContent2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout pnBillLayout = new javax.swing.GroupLayout(pnBill);
        pnBill.setLayout(pnBillLayout);
        pnBillLayout.setHorizontalGroup(
            pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCurrentBank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtCurrentATM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtContent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtContent2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnBillLayout.setVerticalGroup(
            pnBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBillLayout.createSequentialGroup()
                .addComponent(txtCurrentBank, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCurrentATM, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtContent, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContent1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContent2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jTabbedPane1.addTab("Bill", pnBill);

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(btnOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnOk)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnCashComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnCashComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_pnCashComponentHidden

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        a = (DefaultTableModel)Statement.getModel();
        int rows = a.getRowCount();
        for(int i = rows-1;i>=0;i--)
        {
            a.removeRow(i);
        }
        this.mainWindow.continueTransaction();
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

    }//GEN-LAST:event_jTabbedPane1StateChanged

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Statement;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnBill;
    private javax.swing.JPanel pnCash;
    private javax.swing.JPanel pnStatement;
    private javax.swing.JLabel txtCash;
    private javax.swing.JLabel txtContent;
    private javax.swing.JLabel txtContent1;
    private javax.swing.JLabel txtContent2;
    private javax.swing.JLabel txtCurrentATM;
    private javax.swing.JLabel txtCurrentBank;
    private javax.swing.JLabel txtQ100;
    private javax.swing.JLabel txtQ200;
    private javax.swing.JLabel txtQ50;
    private javax.swing.JLabel txtQ500;
    private javax.swing.JLabel txtResult;
    // End of variables declaration//GEN-END:variables

   
}
