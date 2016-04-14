package pointofsalesystem;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Billy
 */
public class PointOfSaleUI extends javax.swing.JFrame {
    DefaultTableModel modelT;
    private PointOfSaleController posController;
    private int lineItemSelected; //to be used to change purchase/rent/return
    
    /**
     * Creates new form PointOfSaleUI
     */
    private PointOfSaleUI() {
        //this.modelT = (DefaultTableModel) lineItemTable.getModel();
        initComponents();
    }
    
    public PointOfSaleUI(PointOfSaleController posController){
        this();
        this.modelT = (DefaultTableModel) lineItemTable.getModel();
        this.posController = posController;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        enterItemIDLabel = new javax.swing.JLabel();
        itemIdField = new javax.swing.JTextField();
        enterItemButton = new javax.swing.JButton();
        purchaseItemButton = new javax.swing.JButton();
        rentItemButton = new javax.swing.JButton();
        removeItemButton1 = new javax.swing.JButton();
        returnItemButton = new javax.swing.JButton();
        customerIDLabel = new javax.swing.JLabel();
        customerIdTextField = new javax.swing.JTextField();
        enterCustomerIDButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lineItemTable = new javax.swing.JTable();
        cancelSaleButton = new javax.swing.JButton();
        checkoutButton = new javax.swing.JButton();
        subtotalLabel = new javax.swing.JLabel();
        SubtotalField = new javax.swing.JTextField();
        TaxField = new javax.swing.JTextField();
        TotalField = new javax.swing.JTextField();
        taxLabel = new javax.swing.JLabel();
        totalLabel = new javax.swing.JLabel();
        cashierID = new javax.swing.JLabel();
        cashierIDLable = new javax.swing.JLabel();
        makeNewCustomerButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setAutoscrolls(true);
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Welcome to the POS System");

        enterItemIDLabel.setText("Item ID:");

        enterItemButton.setText("Enter Item");
        enterItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterItemButtonActionPerformed(evt);
            }
        });

        purchaseItemButton.setText("Purchase Item");
        purchaseItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchaseItemButtonActionPerformed(evt);
            }
        });

        rentItemButton.setText("Rent Item");
        rentItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentItemButtonActionPerformed(evt);
            }
        });

        removeItemButton1.setText("Remove Item");
        removeItemButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeItemButton1ActionPerformed(evt);
            }
        });

        returnItemButton.setText("Return Item");

        customerIDLabel.setText("Cutomer ID:");

        enterCustomerIDButton.setText("Enter Customer ID");
        enterCustomerIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterCustomerIDButtonActionPerformed(evt);
            }
        });

        lineItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemId", "Name", "Price", "Quantity", "Transaction"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        lineItemTable.setColumnSelectionAllowed(true);
        lineItemTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lineItemTable.getTableHeader().setReorderingAllowed(false);
        lineItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lineItemTableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(lineItemTable);
        lineItemTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (lineItemTable.getColumnModel().getColumnCount() > 0) {
            lineItemTable.getColumnModel().getColumn(0).setResizable(false);
            lineItemTable.getColumnModel().getColumn(1).setResizable(false);
            lineItemTable.getColumnModel().getColumn(2).setResizable(false);
            lineItemTable.getColumnModel().getColumn(3).setResizable(false);
            lineItemTable.getColumnModel().getColumn(4).setResizable(false);
        }

        cancelSaleButton.setText("Cancel Sale");

        checkoutButton.setText("Checkout");
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        subtotalLabel.setText("Subtotal");

        taxLabel.setText("Tax");

        totalLabel.setText("Total");

        cashierID.setText("Cashier ID:");

        makeNewCustomerButton.setText("Make New Customer");
        makeNewCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeNewCustomerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(customerIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(enterCustomerIDButton))
                                        .addComponent(customerIdTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cancelSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(purchaseItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(returnItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rentItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(removeItemButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(58, 58, 58)
                        .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(subtotalLabel)
                                .addGap(30, 30, 30)
                                .addComponent(SubtotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(taxLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TaxField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(totalLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(TotalField, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(58, 58, 58)
                                .addComponent(cashierID))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(enterItemIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(makeNewCustomerButton)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(enterItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cashierIDLable, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cashierID))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cashierIDLable, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterItemIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(itemIdField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enterItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(purchaseItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeItemButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(customerIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enterCustomerIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(customerIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(makeNewCustomerButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SubtotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subtotalLabel))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TaxField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(taxLabel))
                                .addGap(18, 18, 18)
                                .addComponent(TotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(totalLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(cancelSaleButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(252, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterItemButtonActionPerformed
        // when Enter is pressed
        String itemId = itemIdField.getText();      //get id entered
        posController.addItem(itemId);
        this.updateTotals();
        
    }//GEN-LAST:event_enterItemButtonActionPerformed
    
            private void updateTotals() {
        //Updates Subtotal, tax, and Total
        this.updateSubtotal(String.valueOf(posController.getSubTotal()));
        this.updateTax(String.valueOf(posController.getTax()));
        this.updateTotal(String.valueOf(posController.getTotal()));
        
        
    }

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        posController.preCheckout();
    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void lineItemTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lineItemTableMousePressed
        // TODO add your handling code here:
        int[] selected = lineItemTable.getSelectedRows();
        if(selected.length==1){
            int temp = selected[0];
            lineItemSelected = temp;
        }else{
            return;
        }
    }//GEN-LAST:event_lineItemTableMousePressed

    private void rentItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentItemButtonActionPerformed
        // TODO add your handling code here:
//        int itemIndex = getSelectedItem();
//        if(itemIndex == -1){
//            return;
//        }
//        
//        String message = "Renting item #"+itemIndex;
//        ErrorScreen test = new ErrorScreen(message);
        String itemId = itemIdField.getText();      //get id entered
        
        RentItemUI rentUI = new RentItemUI(itemId, posController);
        rentUI.setVisible(true);
        
    }//GEN-LAST:event_rentItemButtonActionPerformed

    private void makeNewCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeNewCustomerButtonActionPerformed
        // TODO add your handling code here:
        MakeCustomerUI mcui = new MakeCustomerUI(posController);
        mcui.setVisible(true);
    }//GEN-LAST:event_makeNewCustomerButtonActionPerformed

    private void enterCustomerIDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterCustomerIDButtonActionPerformed
        // TODO add your handling code here:
        posController.enterCustomerID(customerIdTextField.getText());
    }//GEN-LAST:event_enterCustomerIDButtonActionPerformed

    private void purchaseItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchaseItemButtonActionPerformed
        // TODO add your handling code here:
        enterItemButtonActionPerformed(evt);
    }//GEN-LAST:event_purchaseItemButtonActionPerformed

    private void removeItemButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeItemButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_removeItemButton1ActionPerformed

    private int getSelectedItem(){
        int[] selected = lineItemTable.getSelectedRows();
        if(selected.length==1){
            int temp = selected[0];
            lineItemSelected = temp;
            return temp;
        }else{
            return -1;
        }
    }
    
    public void displayError(String message){
        JOptionPane.showMessageDialog(null, message, "InfoBox: " + "Error", JOptionPane.INFORMATION_MESSAGE);
    }
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
            java.util.logging.Logger.getLogger(PointOfSaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PointOfSaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PointOfSaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PointOfSaleUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PointOfSaleUI().setVisible(true);
            }
        });
    }
    
    public void setID(String cID){
        cashierIDLable.setText(cID);
    }
    
    public void addLineItem(String id, String name, String price, String quantity){
        modelT.addRow(new Object[]{id, name, price, quantity});
    }
    
    public void clearTable(){
        int rowNumber = lineItemTable.getRowCount();
        
        //System.out.println("rows to cleared in table "+ rowNumber);
        
        for(int i = 0; i < rowNumber; i++){
            modelT.removeRow(0);
        }
        
    }
    
    public void updateSubtotal(String subTotal){
        SubtotalField.setText(subTotal);
    }
    
    public void updateTax(String tax){
        TaxField.setText(tax);
    }
    
    public void updateTotal(String total){
        TotalField.setText(total);
	}
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SubtotalField;
    private javax.swing.JTextField TaxField;
    private javax.swing.JTextField TotalField;
    private javax.swing.JButton cancelSaleButton;
    private javax.swing.JLabel cashierID;
    private javax.swing.JLabel cashierIDLable;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JLabel customerIDLabel;
    private javax.swing.JTextField customerIdTextField;
    private javax.swing.JButton enterCustomerIDButton;
    private javax.swing.JButton enterItemButton;
    private javax.swing.JLabel enterItemIDLabel;
    private javax.swing.JTextField itemIdField;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable lineItemTable;
    private javax.swing.JButton makeNewCustomerButton;
    private javax.swing.JButton purchaseItemButton;
    private javax.swing.JButton removeItemButton1;
    private javax.swing.JButton rentItemButton;
    private javax.swing.JButton returnItemButton;
    private javax.swing.JLabel subtotalLabel;
    private javax.swing.JLabel taxLabel;
    private javax.swing.JLabel totalLabel;
    // End of variables declaration//GEN-END:variables
}
