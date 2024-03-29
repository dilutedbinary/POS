/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointofsalesystem;

import javax.swing.JFrame;

/**
 *
 * @author Owner
 */
public class MakeCustomerUI extends javax.swing.JFrame {

    /**
     * Creates new form MakeCustomerUI
     */
    private PointOfSaleController controller;
    
    private MakeCustomerUI(){
        
    }
    
    public MakeCustomerUI(PointOfSaleController posc) {
        this();
        controller = posc;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        creditcardField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        mobileLabel = new javax.swing.JLabel();
        mobileField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        shipAddressLabel = new javax.swing.JLabel();
        ship_address_line1 = new javax.swing.JTextField();
        ship_address_line2 = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        password1Field = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        password2Field = new javax.swing.JPasswordField();
        password2Label = new javax.swing.JLabel();
        createCutomerButton = new javax.swing.JButton();
        creditCardLabel = new javax.swing.JLabel();
        cred_name = new javax.swing.JTextField();
        cred_number = new javax.swing.JTextField();
        cred_month = new javax.swing.JTextField();
        cred_year = new javax.swing.JTextField();
        cred_cvc = new javax.swing.JTextField();
        ship_address_city = new javax.swing.JTextField();
        ship_address_state = new javax.swing.JTextField();
        ship_address_zip = new javax.swing.JTextField();

        creditcardField.setText("################");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setText("Create Customer");

        nameField.setText("name");

        nameLabel.setText("Name:");

        phoneLabel.setText("Phone #:");

        phoneField.setText("##########");

        mobileLabel.setText("Mobile #:");

        mobileField.setText("##########");

        emailLabel.setText("Email:");

        emailField.setText("myemail@email.com");

        shipAddressLabel.setText("Shipping Address:");

        ship_address_line1.setText("line1");

        ship_address_line2.setText("line2");

        usernameLabel.setText("Username:");

        usernameField.setText("username");

        password1Field.setText("jPasswordField1");

        passwordLabel.setText("Enter Password:");

        password2Field.setText("jPasswordField1");

        password2Label.setText("Re-Enter Password:");

        createCutomerButton.setText("Create Customer");
        createCutomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createCutomerButtonActionPerformed(evt);
            }
        });

        creditCardLabel.setText("CreditCard:");

        cred_name.setText("Card Name");
        cred_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cred_nameActionPerformed(evt);
            }
        });

        cred_number.setText("Card Number");
        cred_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cred_numberActionPerformed(evt);
            }
        });

        cred_month.setText("Exp Month (ex 06)");
        cred_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cred_monthActionPerformed(evt);
            }
        });

        cred_year.setText("Exp Year");
        cred_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cred_yearActionPerformed(evt);
            }
        });

        cred_cvc.setText("Cvc");
        cred_cvc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cred_cvcActionPerformed(evt);
            }
        });

        ship_address_city.setText("city");

        ship_address_state.setText("state");

        ship_address_zip.setText("zip");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(title))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(emailLabel)
                            .addComponent(shipAddressLabel)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phoneLabel)
                                .addComponent(mobileLabel))
                            .addComponent(usernameLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(password2Label, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(creditCardLabel, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ship_address_zip, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ship_address_state, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cred_cvc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cred_year, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cred_month, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cred_number, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createCutomerButton)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(password2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cred_name, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ship_address_line2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                        .addComponent(ship_address_line1)
                        .addComponent(ship_address_city, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneLabel)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mobileLabel)
                    .addComponent(mobileField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shipAddressLabel)
                    .addComponent(ship_address_line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ship_address_line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ship_address_city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ship_address_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ship_address_zip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(password1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password2Label)
                    .addComponent(password2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cred_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creditCardLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cred_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cred_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cred_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cred_cvc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createCutomerButton)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createCutomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createCutomerButtonActionPerformed
        // TODO add your handling code here:
        String name = nameField.getText();
        String phone = phoneField.getText();
        String mobile = mobileField.getText();
        String email = emailField.getText();
        String ship_add_line1 = ship_address_line1.getText();
        String ship_add_line2 = ship_address_line2.getText();
         String ship_add_city = ship_address_city.getText();
         String ship_add_state = ship_address_state.getText();
         String ship_add_zip = ship_address_zip.getText();
        String cc_name = cred_name.getText();
         String cc_number = cred_number.getText();
          String cc_month = cred_month.getText();
          String cc_year = cred_year.getText();
          String cc_cvc = cred_cvc.getText();
        String username = usernameField.getText();
        String password1 = password1Field.getText();
        String password2 = password2Field.getText();
        
        controller.createCustomer(name,phone,mobile,email,ship_add_line1, ship_add_line2, ship_add_city, ship_add_state, ship_add_zip,cc_name,cc_number, cc_month,cc_year,cc_cvc, username, password1, password2);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_createCutomerButtonActionPerformed

    private void cred_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cred_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cred_nameActionPerformed

    private void cred_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cred_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cred_numberActionPerformed

    private void cred_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cred_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cred_monthActionPerformed

    private void cred_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cred_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cred_yearActionPerformed

    private void cred_cvcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cred_cvcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cred_cvcActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakeCustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeCustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeCustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeCustomerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeCustomerUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createCutomerButton;
    private javax.swing.JTextField cred_cvc;
    private javax.swing.JTextField cred_month;
    private javax.swing.JTextField cred_name;
    private javax.swing.JTextField cred_number;
    private javax.swing.JTextField cred_year;
    private javax.swing.JLabel creditCardLabel;
    private javax.swing.JTextField creditcardField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mobileField;
    private javax.swing.JLabel mobileLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPasswordField password1Field;
    private javax.swing.JPasswordField password2Field;
    private javax.swing.JLabel password2Label;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel shipAddressLabel;
    private javax.swing.JTextField ship_address_city;
    private javax.swing.JTextField ship_address_line1;
    private javax.swing.JTextField ship_address_line2;
    private javax.swing.JTextField ship_address_state;
    private javax.swing.JTextField ship_address_zip;
    private javax.swing.JLabel title;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
