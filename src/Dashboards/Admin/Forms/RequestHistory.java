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
public class RequestHistory extends javax.swing.JPanel {
    private DatabaseOperations db;
    private DefaultTableModel tableModel;

    /**
     * Creates new form RequestHistory
     */
    public RequestHistory() {
        initComponents();
        customizeUI();
        try {
            db = new DatabaseOperations();
            loadRequestLogs();
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

        // Set custom cell renderer for status-based coloring
        jTable1.setDefaultRenderer(Object.class, new StatusCellRenderer());

        // Customize scroll pane
        jScrollPane1.setBackground(new Color(240, 248, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Customize title label
        jLabel2.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel2.setForeground(new Color(0, 150, 136));
    }

    private void loadRequestLogs() {
        try {
            ResultSet rs = db.getRequestLogs();
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
            JOptionPane.showMessageDialog(this, "Error loading request logs: " + e.getMessage());
        }
    }

    // Custom cell renderer for status-based coloring
    private class StatusCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            if (!isSelected) {
                // Color based on request status (column 7)
                String status = (String) table.getValueAt(row, 7);
                switch (status) {
                    case "Approved":
                        c.setBackground(new Color(200, 255, 200)); // Light green
                        break;
                    case "Pending":
                        c.setBackground(new Color(255, 255, 200)); // Light yellow
                        break;
                    case "Rejected":
                        c.setBackground(new Color(255, 200, 200)); // Light red
                        break;
                    default:
                        c.setBackground(Color.WHITE);
                }
            }

            return c;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(240, 248, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Request History");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(55, 55, 55)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(103, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(54, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
