 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cuvankhoa.bankingmanagement.view;


import cuvankhoa.bankingmanagement.model.*;
import cuvankhoa.bankingmanagement.view.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TOTORO
 */
public class FindTransfer extends javax.swing.JDialog {

    /**
     * Creates new form AddATM
     */
    MainWindow mainWindow;
    DefaultTableModel dtm;
    public FindTransfer(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.mainWindow = (MainWindow)parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ATMID = new javax.swing.JLabel();
        txtATMID = new javax.swing.JTextField();
        address = new javax.swing.JLabel();
        txtTransID = new javax.swing.JTextField();
        txtATMcard = new javax.swing.JTextField();
        ATMID2 = new javax.swing.JLabel();
        ATMID3 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        txtAmount = new javax.swing.JTextField();
        ATMID4 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        transferTable = new javax.swing.JTable();
        txtCardReceive = new javax.swing.JTextField();
        ATMID5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Find Transfer transactions");
        setResizable(false);

        ATMID.setText("ATMID");

        txtATMID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtATMIDActionPerformed(evt);
            }
        });

        address.setText("Trans ID");

        txtTransID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTransIDActionPerformed(evt);
            }
        });

        txtATMcard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtATMcardActionPerformed(evt);
            }
        });

        ATMID2.setText("ATM card");

        ATMID3.setText("Time");

        txtTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimeActionPerformed(evt);
            }
        });

        txtAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAmountActionPerformed(evt);
            }
        });

        ATMID4.setText("Amount");

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        add.setText("Find");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        jScrollPane10.setRequestFocusEnabled(false);

        transferTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ATM ID", "Trans ID", "ATM card", "Time", "Amount", "ATM card receive", "Content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        transferTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        transferTable.setEditingColumn(0);
        transferTable.setEditingRow(0);
        transferTable.setEnabled(false);
        transferTable.setFocusable(false);
        transferTable.setGridColor(new java.awt.Color(204, 204, 204));
        transferTable.setRowSelectionAllowed(false);
        transferTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        transferTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        transferTable.setShowGrid(true);
        transferTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(transferTable);

        txtCardReceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCardReceiveActionPerformed(evt);
            }
        });

        ATMID5.setText("Card received");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ATMID4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ATMID3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ATMID2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ATMID, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ATMID5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAmount, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txtATMcard, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txtTransID, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                            .addComponent(txtATMID)
                            .addComponent(txtCardReceive, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(add)))
                .addGap(533, 533, 533))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(249, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtATMID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATMID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTransID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtATMcard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATMID2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATMID3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATMID4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCardReceive, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATMID5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add)
                    .addComponent(cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtATMIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtATMIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtATMIDActionPerformed

    private void txtTransIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTransIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTransIDActionPerformed

    private void txtATMcardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtATMcardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtATMcardActionPerformed

    private void txtTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeActionPerformed

    private void txtAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAmountActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
       this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            TransferTransaction a = new TransferTransaction("*", "*", "*", "*", -1,"*", "*");
            dtm = (DefaultTableModel)transferTable.getModel();
            // clear table
            int rows = dtm.getRowCount();
            for(int i = rows-1;i>=0;i--)
            {
                dtm.removeRow(i);
            }
            int condition = 0; // nho nhat la 1, lon nhat bang 12
            int stt = 1;
            // nhan input
            if(txtATMID.getText().length()>0){
                a.setAtmid(txtATMID.getText());
                condition++;}
            if(txtTransID.getText().length()>0){
                a.setTransactionid(txtTransID.getText());
                condition++; }
            if(txtATMcard.getText().length()>0){
                a.setAtmcardnumber(txtATMcard.getText());
                condition++;
            }
            if(txtTime.getText().length()>0){
                a.setTransactiontime(txtTime.getText());
                condition++;
            }
            if(txtAmount.getText().length()>0){
                a.setAmount(Integer.parseInt(txtAmount.getText()));
                condition++;
            }
            if(txtCardReceive.getText().length()>0){
                a.setAtmcardnumber2(txtCardReceive.getText());
                condition++;
            }
            if(condition > 0)
            {
                for(Atm i: mainWindow.currentBank.getAtm())
                {
                    for(TransferTransaction k : i.getTransferTransactions())
                    {       int conditionPass = 0;
                            if(k.getAtmid().contains(a.getAtmid()))
                            {
                                conditionPass++;
                            }
                            if(k.getTransactionid().contains(a.getTransactionid()))
                            {
                                conditionPass++;
                            }
                            if(k.getAtmcardnumber().contains(a.getAtmcardnumber()))
                            {
                                conditionPass++;
                            }
                            if(k.getTransactiontime().contains(a.getTransactiontime()))
                            {
                                conditionPass++;
                            }
                            if(a.getAmount()==k.getAmount())
                            {
                                conditionPass++;
                            }
                            if(k.getAtmcardnumber2().contains(a.getAtmcardnumber2())){
                                conditionPass++;
                            }
                            if(conditionPass == condition)
                            {
                                // them du lieu ra bang
                                dtm.addRow(new Object[]{
                            stt,k.getAtmid(), k.getTransactionid(), k.getAtmcardnumber(), k.getTransactiontime(), k.getAmount(), k.getAtmcardnumber2(), k.getContent()
                            });
                                stt++;
                            }
                    }
                }
              }else{
                JOptionPane.showMessageDialog(this, "Nhập ít nhất một trường để tìm kiếm");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ!");
                txtAmount.setText("");
        }
    }//GEN-LAST:event_addActionPerformed

    private void txtCardReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCardReceiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCardReceiveActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ATMID;
    private javax.swing.JLabel ATMID2;
    private javax.swing.JLabel ATMID3;
    private javax.swing.JLabel ATMID4;
    private javax.swing.JLabel ATMID5;
    private javax.swing.JButton add;
    private javax.swing.JLabel address;
    private javax.swing.JButton cancel;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JTable transferTable;
    private javax.swing.JTextField txtATMID;
    private javax.swing.JTextField txtATMcard;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtCardReceive;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtTransID;
    // End of variables declaration//GEN-END:variables
}
