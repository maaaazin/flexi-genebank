/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Dashboards.Admin.Forms;

import Database.DatabaseOperations;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maazi
 */
public class ViewRequests extends javax.swing.JPanel {
    private DatabaseOperations db;
    private DefaultTableModel tableModel;

    /**
     * Creates new form ViewRequests
     */
    public ViewRequests() {
        initComponents();
        customizeUI();
        try {
            db = new DatabaseOperations();
            loadPendingRequests();
            // Auto-reject any requests for depleted samples
            db.autoRejectDepletedSamples();
            // Reload the table to reflect any auto-rejections
            loadPendingRequests();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage());
        }
    }

    private void customizeUI() {
        // Set background color
        this.setBackground(new Color(240, 248, 255)); // Alice blue background

        // Customize table appearance
        jTable1.setBackground(new Color(255, 255, 255));
        jTable1.setGridColor(new Color(200, 200, 200));
        jTable1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        jTable1.getTableHeader().setBackground(new Color(0, 150, 136)); // Teal header
        jTable1.getTableHeader().setForeground(Color.WHITE);
        jTable1.setRowHeight(25);
        jTable1.setShowGrid(true);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);

        // Customize buttons
        jButton1.setBackground(new Color(0, 150, 136)); // Teal
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 12));

        jButton2.setBackground(new Color(220, 53, 69)); // Red
        jButton2.setForeground(Color.WHITE);
        jButton2.setFont(new Font("Segoe UI", Font.BOLD, 12));

        // Customize scroll pane
        jScrollPane1.setBackground(new Color(240, 248, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Customize title label
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(new Color(0, 150, 136));
    }

    private void loadPendingRequests() {
        try {
            ResultSet rs = db.getPendingRequests();
            tableModel = (DefaultTableModel) jTable1.getModel();
            tableModel.setRowCount(0); // Clear existing data

            while (rs.next()) {
                Object[] row = {
                        rs.getInt("requestid"),
                        rs.getInt("researcherid"),
                        rs.getString("researcherName"),
                        rs.getInt("requestedSampleId"),
                        rs.getString("purpose"),
                        rs.getString("sampleStatus"),
                        rs.getDate("RequestDate"),
                        rs.getString("requestStatus")
                };
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading pending requests: " + e.getMessage());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a request to approve");
            return;
        }

        int requestId = (int) jTable1.getValueAt(selectedRow, 0);
        try {
            db.updateRequestStatus(requestId, "Approved");
            loadPendingRequests(); // Refresh the table
            JOptionPane.showMessageDialog(this, "Request approved successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error approving request: " + e.getMessage());
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a request to reject");
            return;
        }

        int requestId = (int) jTable1.getValueAt(selectedRow, 0);
        try {
            db.updateRequestStatus(requestId, "Rejected");
            loadPendingRequests(); // Refresh the table
            JOptionPane.showMessageDialog(this, "Request rejected successfully");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error rejecting request: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 248, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 150, 136));
        jLabel1.setText("Pending Requests");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null }
                },
                new String[] {
                        "Request ID", "Researcher ID", "Researcher Name", "Sample ID", "Purpose", "Sample Status",
                        "Request Date", "Request Status"
                }));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Approve");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reject");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(350, 350, 350)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(103, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(54, Short.MAX_VALUE)));
    }// </editor-fold>

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
