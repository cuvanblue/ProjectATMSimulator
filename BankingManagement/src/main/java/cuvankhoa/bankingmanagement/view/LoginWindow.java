/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cuvankhoa.bankingmanagement.view;

/**
 *
 * @author TOTORO
 */
import com.formdev.flatlaf.FlatLightLaf;
import cuvankhoa.bankingmanagement.model.Admin;
import cuvankhoa.bankingmanagement.model.Bank;
import cuvankhoa.bankingmanagement.view.MainWindow;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoginWindow extends javax.swing.JFrame {

    /**
     * Creates new form LoginWindow
     */
    ArrayList<Bank> bank;
    Admin currentAdmin;
    MainWindow mainWindow;
    boolean correct;
    
    public LoginWindow(ArrayList<Bank> bank) {
        this.bank =bank;
        FlatLightLaf.setup();
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/businessman.png")));
        correct = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BankSelection = new javax.swing.JComboBox<>();
        Account = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login BankingManagement");
        setResizable(false);

        jLabel1.setText("Account");

        jLabel2.setText("Password");

        Login.setText("Login");
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });

        jLabel3.setText("Bank");

        BankSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BIDV", "Agribank", "TPBank" }));
        BankSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankSelectionActionPerformed(evt);
            }
        });

        Account.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BankSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Account)
                            .addComponent(Password))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BankSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Login))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AccountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AccountActionPerformed

    private void BankSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BankSelectionActionPerformed

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
        // TODO add your handling code here:
        // kiem tra mat khau tim trong banks[] xem co tk va mk k
        String account = Account.getText().trim();
        String password = String.valueOf(Password.getPassword()).trim();
        String bankChoose = BankSelection.getSelectedItem().toString();
        if(account.length()> 0 && password.length() >0){
            boolean login = false;
            for(Bank i : bank)
            {
                if(bankChoose .equals( i.getName()))
                {
                   for(Admin k : i.getAdmin())
                   {    
                       if(account.equals(k.getAccount()) && password.equals(k.getPassword()))
                       {      
                           // nhap dung tai khoan mat khau
                           mainWindow = new MainWindow(i, k, this);
                           mainWindow.setVisible(true);
                           Account.setText("");
                           Password.setText("");
                           this.setVisible(false);
                           login = true;
                           break;
                       }
                   }
                }
            }
            if(!login)
            {Account.setText("");
            Password.setText("");
            JOptionPane.showMessageDialog(this, "Password is incorrect !");}
        }
        else
        {
            Account.setText("");
            Password.setText("");
            JOptionPane.showMessageDialog(this, "Name or password is empty!");
        }
    }//GEN-LAST:event_LoginActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Account;
    private javax.swing.JComboBox<String> BankSelection;
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField Password;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
