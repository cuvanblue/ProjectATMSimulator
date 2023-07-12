/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cuvankhoa.bankingmanagement.view;


import com.formdev.flatlaf.FlatLaf;

/**
 *
 * @author TOTORO
 */
import com.formdev.flatlaf.FlatLightLaf;
import cuvankhoa.bankingmanagement.BankingManagement;
import cuvankhoa.bankingmanagement.model.*;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    boolean saved;
    BankingManagement bankingManagement;
    Bank currentBank;
    LoginWindow login;
    Admin currentAdmin;
    Connection conn;
    DefaultTableModel a;
    public MainWindow(Bank currentBank, Admin admin, LoginWindow login) {
        saved = true;
        this.login = login;
        this.currentBank = currentBank;
        this.currentAdmin = admin;
        FlatLightLaf.setup();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/businessman.png")));
        // bang customer
        a = (DefaultTableModel)customerTable.getModel();
        int stt=1;
        for (Customer i : currentBank.getCustomer()) {
            a.addRow(new Object[]{
            stt, i.getName(), i.getIdCard(),i.getBirthDay(),i.getPhone(), i.getAddress(), i.getAtmCardnumber()
                    , i.getAtmPin(), i.getAtmKind(), i.isAtmStatus(),i.getValidFrom(), i.getGoodThru(), i.getBalance()
            });
            stt++;
        }
        // bang atm
        a = (DefaultTableModel)atmTable.getModel();
        stt = 1;
        for (Atm i: currentBank.getAtm()) {
            a.addRow(new Object[]{
            stt, i.getAtmID(), i.getAddress(), i.getCash(), i.getQuanity50(), 
                i.getQuanity100(), i.getQuanity200(), i.getQuanity500(), i.isStatus()});
            stt++;
        }
        // bank fee
        wfeein.setText("Withdraw fee inside system: "+ currentBank.getWithdrawfeeIn()+"%");
        wfeeout.setText("Withdraw fee outside system: "+ currentBank.getWithdrawfeeOut() +"%");
        trfeein.setText("Transfer fee inside system: "+ currentBank.getTransferfeeIn()+"%");
        trfeeout.setText("Transfer fee outside system: "+ currentBank.getTransferfeeOut()+"%");
        
        // bang withdraw
        a = (DefaultTableModel)withdrawTable.getModel();
        stt = 1;
        for (Atm i: currentBank.getAtm()) {
            for( WithdrawTransaction k : i.getWithdrawTransactions())
            {
                a.addRow(new Object[]{
                stt, k.getAtmid(), k.getTransactionid(), k.getAtmcardnumber(), k.getTransactiontime(), k.getAmount(), k.getContent()
                });
                stt++;
            }
        }
        // bang transfer
        a = (DefaultTableModel)transferTable.getModel();
        stt = 1;
        for (Atm i: currentBank.getAtm()) {
            for( TransferTransaction k : i.getTransferTransactions())
            {
                a.addRow(new Object[]{
                stt, k.getAtmid(), k.getTransactionid(), k.getAtmcardnumber(), k.getTransactiontime(), k.getAmount(), k.getAtmcardnumber2(), k.getContent()
                });
                stt++;
            }
        }
        // bang change pin
        a = (DefaultTableModel)changePINTable.getModel();
        stt = 1;
        for (Atm i: currentBank.getAtm()) {
            for( ChangePinTransaction k : i.getChangePinTransactions())
            {
                a.addRow(new Object[]{
                stt, k.getAtmid(), k.getTransactionid(), k.getAtmcardnumber(), k.getTransactiontime(), k.getOldpin(), k.getNewpin(), k.getContent()
                });
                stt++;
            }
        }
        // bang checkbalance
        a = (DefaultTableModel)checkbalanceTable.getModel();
        stt = 1;
        for (Atm i: currentBank.getAtm()) {
            for( CheckBalanceTransaction k : i.getCheckBalanceTransactions())
            {
                a.addRow(new Object[]{
                stt, k.getAtmid(), k.getTransactionid(), k.getAtmcardnumber(), k.getTransactiontime(), k.getAmount(), k.getContent()
                });
                stt++;
            }
        }
        // bang statement
        a = (DefaultTableModel)statementTable.getModel();
        stt = 1;
        for (Atm i: currentBank.getAtm()) {
            for( StatementTransaction k : i.getStatementTransaction())
            {
                a.addRow(new Object[]{
                stt, k.getAtmid(), k.getTransactionid(), k.getAtmcardnumber(), k.getTransactiontime(), k.getContent()
                });
                stt++;
            }
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
        jPanel1 = new javax.swing.JPanel();
        addCustomer = new javax.swing.JButton();
        editCustomer = new javax.swing.JButton();
        findCustomer = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        atmTable = new javax.swing.JTable();
        pnWithdraw = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        withdrawTable = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();
        pnTransfer = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        transferTable = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        pnChangePIN = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        changePINTable = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        pnCheckBalance = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        checkbalanceTable = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        pnStatement = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        statementTable = new javax.swing.JTable();
        jButton15 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        wfeein = new javax.swing.JLabel();
        txtWfeeIn = new javax.swing.JTextField();
        wfeeout = new javax.swing.JLabel();
        txtWfeeOut = new javax.swing.JTextField();
        trfeein = new javax.swing.JLabel();
        txtTransFeeIn = new javax.swing.JTextField();
        txtTransFeeOut = new javax.swing.JTextField();
        trfeeout = new javax.swing.JLabel();
        btnFeeSave = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Banking Management");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(850, 650));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        addCustomer.setText("Add");
        addCustomer.setToolTipText("");
        addCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerActionPerformed(evt);
            }
        });

        editCustomer.setText("Edit");
        editCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCustomerActionPerformed(evt);
            }
        });

        findCustomer.setText("Find");
        findCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findCustomerActionPerformed(evt);
            }
        });

        jScrollPane3.setRequestFocusEnabled(false);

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Name", "ID ", "Birthday", "Phone", "Address", "Card number", "Card pin", "Card kind", "Card status", "Valid from", "Good thru", "Balance"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        customerTable.setEditingColumn(0);
        customerTable.setEditingRow(0);
        customerTable.setEnabled(false);
        customerTable.setFocusable(false);
        customerTable.setGridColor(new java.awt.Color(204, 204, 204));
        customerTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        customerTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        customerTable.setShowGrid(true);
        customerTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(customerTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(findCustomer)
                .addContainerGap(604, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCustomer)
                    .addComponent(editCustomer)
                    .addComponent(findCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Customer", jPanel1);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton6.setText("Add");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Edit");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Find");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jScrollPane2.setRequestFocusEnabled(false);

        atmTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ATMID", "Address", "Cash", "50quanity", "100quanity", "200quanity", "500quanity", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        atmTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        atmTable.setEditingColumn(0);
        atmTable.setEditingRow(0);
        atmTable.setEnabled(false);
        atmTable.setFocusable(false);
        atmTable.setGridColor(new java.awt.Color(204, 204, 204));
        atmTable.setRowSelectionAllowed(false);
        atmTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        atmTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        atmTable.setShowGrid(true);
        atmTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(atmTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ATM", jPanel5);

        pnWithdraw.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane9.setRequestFocusEnabled(false);

        withdrawTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ATM ID", "Trans ID", "ATM card", "Time", "Amount", "Content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        withdrawTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        withdrawTable.setEditingColumn(0);
        withdrawTable.setEditingRow(0);
        withdrawTable.setEnabled(false);
        withdrawTable.setFocusable(false);
        withdrawTable.setGridColor(new java.awt.Color(204, 204, 204));
        withdrawTable.setRowSelectionAllowed(false);
        withdrawTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        withdrawTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        withdrawTable.setShowGrid(true);
        withdrawTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(withdrawTable);
        if (withdrawTable.getColumnModel().getColumnCount() > 0) {
            withdrawTable.getColumnModel().getColumn(5).setHeaderValue("Amount");
        }

        jButton10.setText("Find");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnWithdrawLayout = new javax.swing.GroupLayout(pnWithdraw);
        pnWithdraw.setLayout(pnWithdrawLayout);
        pnWithdrawLayout.setHorizontalGroup(
            pnWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnWithdrawLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10)
                .addContainerGap(760, Short.MAX_VALUE))
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnWithdrawLayout.setVerticalGroup(
            pnWithdrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnWithdrawLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Withdraw", pnWithdraw);

        pnTransfer.setBackground(new java.awt.Color(255, 255, 255));

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
        if (transferTable.getColumnModel().getColumnCount() > 0) {
            transferTable.getColumnModel().getColumn(5).setHeaderValue("Amount");
        }

        jButton11.setText("Find");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTransferLayout = new javax.swing.GroupLayout(pnTransfer);
        pnTransfer.setLayout(pnTransferLayout);
        pnTransferLayout.setHorizontalGroup(
            pnTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
            .addGroup(pnTransferLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnTransferLayout.setVerticalGroup(
            pnTransferLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTransferLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transfer", pnTransfer);

        pnChangePIN.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane11.setRequestFocusEnabled(false);

        changePINTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ATM ID", "Trans ID", "ATM card", "Time", "old PIN", "new PIN", "Content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
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
        changePINTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        changePINTable.setEditingColumn(0);
        changePINTable.setEditingRow(0);
        changePINTable.setEnabled(false);
        changePINTable.setFocusable(false);
        changePINTable.setGridColor(new java.awt.Color(204, 204, 204));
        changePINTable.setRowSelectionAllowed(false);
        changePINTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        changePINTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        changePINTable.setShowGrid(true);
        changePINTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(changePINTable);

        jButton13.setText("Find");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnChangePINLayout = new javax.swing.GroupLayout(pnChangePIN);
        pnChangePIN.setLayout(pnChangePINLayout);
        pnChangePINLayout.setHorizontalGroup(
            pnChangePINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChangePINLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13)
                .addContainerGap(760, Short.MAX_VALUE))
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
        );
        pnChangePINLayout.setVerticalGroup(
            pnChangePINLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChangePINLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Change PIN", pnChangePIN);

        pnCheckBalance.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane12.setRequestFocusEnabled(false);

        checkbalanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ATM ID", "Trans ID", "ATM card", "Time", "Amount", "Content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        checkbalanceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        checkbalanceTable.setEditingColumn(0);
        checkbalanceTable.setEditingRow(0);
        checkbalanceTable.setEnabled(false);
        checkbalanceTable.setFocusable(false);
        checkbalanceTable.setGridColor(new java.awt.Color(204, 204, 204));
        checkbalanceTable.setRowSelectionAllowed(false);
        checkbalanceTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        checkbalanceTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        checkbalanceTable.setShowGrid(true);
        checkbalanceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(checkbalanceTable);
        if (checkbalanceTable.getColumnModel().getColumnCount() > 0) {
            checkbalanceTable.getColumnModel().getColumn(5).setHeaderValue("Amount");
        }

        jButton14.setText("Find");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnCheckBalanceLayout = new javax.swing.GroupLayout(pnCheckBalance);
        pnCheckBalance.setLayout(pnCheckBalanceLayout);
        pnCheckBalanceLayout.setHorizontalGroup(
            pnCheckBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCheckBalanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14)
                .addContainerGap(760, Short.MAX_VALUE))
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
        );
        pnCheckBalanceLayout.setVerticalGroup(
            pnCheckBalanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCheckBalanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Check Balance", pnCheckBalance);

        pnStatement.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane4.setRequestFocusEnabled(false);

        statementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ATM ID", "Trans ID", "ATM card", "Time", "Content"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        statementTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        statementTable.setEditingColumn(0);
        statementTable.setEditingRow(0);
        statementTable.setEnabled(false);
        statementTable.setFocusable(false);
        statementTable.setGridColor(new java.awt.Color(204, 204, 204));
        statementTable.setRowSelectionAllowed(false);
        statementTable.setSelectionBackground(new java.awt.Color(204, 204, 204));
        statementTable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        statementTable.setShowGrid(true);
        statementTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(statementTable);

        jButton15.setText("Find");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnStatementLayout = new javax.swing.GroupLayout(pnStatement);
        pnStatement.setLayout(pnStatementLayout);
        pnStatementLayout.setHorizontalGroup(
            pnStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStatementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15)
                .addContainerGap(760, Short.MAX_VALUE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
        );
        pnStatementLayout.setVerticalGroup(
            pnStatementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnStatementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Statement", pnStatement);

        wfeein.setText("Withdraw fee inside system: ");

        txtWfeeIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWfeeInActionPerformed(evt);
            }
        });

        wfeeout.setText("Withdraw fee outside system: ");

        txtWfeeOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWfeeOutActionPerformed(evt);
            }
        });

        trfeein.setText("Transfer fee inside system: ");

        trfeeout.setText("Transfer fee outside system: ");

        btnFeeSave.setText("Save");
        btnFeeSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFeeSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(wfeein, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trfeeout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trfeein, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wfeeout, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFeeSave, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWfeeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTransFeeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTransFeeOut, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWfeeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(536, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wfeein)
                    .addComponent(txtWfeeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wfeeout)
                    .addComponent(txtWfeeOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trfeein)
                    .addComponent(txtTransFeeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trfeeout)
                    .addComponent(txtTransFeeOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFeeSave)
                .addContainerGap(426, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bank", jPanel3);

        jButton12.setText("Change password");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(700, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogOut)
                .addContainerGap(555, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Account", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtWfeeInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWfeeInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWfeeInActionPerformed

    private void txtWfeeOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWfeeOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWfeeOutActionPerformed

    private void addCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCustomerActionPerformed
        AddCustomer a = new AddCustomer(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_addCustomerActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        this.login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnFeeSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFeeSaveActionPerformed

            if(txtWfeeIn.getText().length()>0)
            {
                try {
                    Float wfeein = Float.parseFloat(txtWfeeIn.getText());
                    currentBank.setWithdrawfeeIn(wfeein);
                    this.wfeein.setText("Withdraw fee inside system: "+ currentBank.getWithdrawfeeIn()+"%");
                    updateBank(currentBank);
                    JOptionPane.showMessageDialog(this, "Cập nhập phí rút tiền nội bộ thành công!");
                    txtWfeeIn.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ!");            
                    txtWfeeIn.setText("");
                }
            }
            if(txtWfeeOut.getText().length()>0)
            {
                try {
                    Float wfeeout = Float.parseFloat(txtWfeeOut.getText());
                    currentBank.setWithdrawfeeOut(wfeeout);
                    this.wfeeout.setText("Withdraw fee outside system: "+ currentBank.getWithdrawfeeOut() +"%");
                    updateBank(currentBank);
                    JOptionPane.showMessageDialog(this, "Cập nhập phí rút tiền liên ngân hàng thành công!");
                    txtWfeeOut.setText("");
                } catch (Exception e) { 
                    JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ!");
                    txtWfeeOut.setText("");}
            }
            if(txtTransFeeIn.getText().length()>0)
            {
                try {
                    Float transfeein = Float.parseFloat(txtTransFeeIn.getText());
                   currentBank.setTransferfeeIn(transfeein);
                    this.trfeein.setText("Transfer fee inside system: "+ currentBank.getTransferfeeIn()+"%");
                   updateBank(currentBank);
                   JOptionPane.showMessageDialog(this, "Cập nhập phí chuyển tiền nội bộ thành công!");
                   txtTransFeeIn.setText("");
                 } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ!");
                    txtTransFeeIn.setText("");;}
            }
            if(txtTransFeeOut.getText().length()>0)
            {
                try {
                    Float transfeeout = Float.parseFloat(txtTransFeeOut.getText());
                    currentBank.setTransferfeeOut(transfeeout);
                    this.trfeeout.setText("Transfer fee outside system: "+ currentBank.getTransferfeeOut()+"%");
                    updateBank(currentBank);
                    JOptionPane.showMessageDialog(this, "Cập nhập phí chuyển tiền liên ngân hàng thành công!");
                    txtTransFeeOut.setText("");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Dữ liệu nhập vào không hợp lệ!");
                    txtTransFeeOut.setText("");}
            }  
    }//GEN-LAST:event_btnFeeSaveActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        ChangePassForm a = new ChangePassForm(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void findCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findCustomerActionPerformed
        FindCustomer a = new FindCustomer(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_findCustomerActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        AddATM a = new AddATM(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        EditATM a = new EditATM(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        FindATM a = new FindATM(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void editCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCustomerActionPerformed
        EditCustomer a = new EditCustomer(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_editCustomerActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        FindWithdraw a = new FindWithdraw(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        FindTransfer a = new FindTransfer(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        FindChangePIN a = new FindChangePIN(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        FindCheckBalance a = new FindCheckBalance(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        FindStatement a = new FindStatement(this, rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed
    //add customer
    public void addCustomer(Customer cus ){
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
            String sql = "INSERT INTO Customer (Name, ID, Birthday, Phone, Address, Bank, ATMnumber, PIN, Kind, Status, ValidFrom, GoodThru, Balance) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)"; 
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cus.getName());
            ps.setString(2, cus.getIdCard());
            ps.setString(3, cus.getBirthDay());
            ps.setString(4, cus.getPhone());
            ps.setString(5, cus.getAddress());
            ps.setString(6, cus.getbankName());
            ps.setString(7, cus.getAtmCardnumber());
            ps.setString(8, cus.getAtmPin());
            ps.setString(9, cus.getAtmKind());
            ps.setBoolean(10, cus.isAtmStatus());
            ps.setString(11, cus.getValidFrom());
            ps.setString(12, cus.getGoodThru());
            ps.setLong(13, cus.getBalance());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // update customer
    public void updateCustomer(Customer cus ){
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
            String sql = "UPDATE Customer SET Phone=?, Address=?, PIN =?, Status=?, Balance=?  WHERE  ATMnumber=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, cus.getPhone());
            ps.setString(2, cus.getAddress());
            ps.setString(3, cus.getAtmPin());
            ps.setBoolean(4, cus.isAtmStatus());
            ps.setLong(5, cus.getBalance());
            ps.setString(6, cus.getAtmCardnumber());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // add ATM
    public void addATM(Atm atm ){
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
            String sql = "INSERT INTO ATM (ATMID, Address, BankName, Cash, q50, q100, q200, q500, Status) VALUES (?,?,?,?,?,?,?,?,?)";  
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, atm.getAtmID());
            ps.setString(2, atm.getAddress());
            ps.setString(3, atm.getOwnerBank());
            ps.setInt(4, atm.getCash());
            ps.setInt(5, atm.getQuanity50());
            ps.setInt(6, atm.getQuanity100());
            ps.setInt(7, atm.getQuanity200());
            ps.setInt(8, atm.getQuanity500());
            ps.setBoolean(9, atm.isStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //remove ATM
    public void removeATM(Atm atm ){
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
            String sql = "DELETE FROM ATM WHERE ATMID=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, atm.getAtmID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // update ATM
     public void updateATM(Atm atm ){
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
            String sql = "UPDATE ATM SET Cash=?, q50=?, q100 =?, q200=?, q500=?, Status=?  WHERE  ATMID=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, atm.getCash());
            ps.setInt(2, atm.getQuanity50());
            ps.setInt(3, atm.getQuanity100());
            ps.setInt(4, atm.getQuanity200());
            ps.setInt(5, atm.getQuanity500());
            ps.setBoolean(6, atm.isStatus());
            ps.setString(7, atm.getAtmID());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public void updateBank(Bank a ){
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
            String sql = "UPDATE Bank SET withdrawFeeIn=?, withdrawFeeOut=?, transferFeeIn =?, transferFeeOut=? WHERE  BankName=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setFloat(1, a.getWithdrawfeeIn());
            ps.setFloat(2, a.getWithdrawfeeOut());
            ps.setFloat(3, a.getTransferfeeIn());
            ps.setFloat(4, a.getTransferfeeOut());
            ps.setString(5, a.getName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
       public void updateAdmin(Admin a ){
        try {
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           this.conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-BHAS501\\SERVER1:1433;databaseName =BankingManagement;user = sa;password = sa;encrypt = false");
            String sql = "UPDATE Admin SET password=? WHERE  account=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getAccount());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCustomer;
    public javax.swing.JTable atmTable;
    private javax.swing.JButton btnFeeSave;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JTable changePINTable;
    private javax.swing.JTable checkbalanceTable;
    public javax.swing.JTable customerTable;
    private javax.swing.JButton editCustomer;
    private javax.swing.JButton findCustomer;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pnChangePIN;
    private javax.swing.JPanel pnCheckBalance;
    private javax.swing.JPanel pnStatement;
    private javax.swing.JPanel pnTransfer;
    private javax.swing.JPanel pnWithdraw;
    private javax.swing.JTable statementTable;
    private javax.swing.JTable transferTable;
    private javax.swing.JLabel trfeein;
    private javax.swing.JLabel trfeeout;
    private javax.swing.JTextField txtTransFeeIn;
    private javax.swing.JTextField txtTransFeeOut;
    private javax.swing.JTextField txtWfeeIn;
    private javax.swing.JTextField txtWfeeOut;
    private javax.swing.JLabel wfeein;
    private javax.swing.JLabel wfeeout;
    private javax.swing.JTable withdrawTable;
    // End of variables declaration//GEN-END:variables
}
