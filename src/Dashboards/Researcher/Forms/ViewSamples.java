package Dashboards.Researcher.Forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.DatabaseOperations;

public class ViewSamples extends javax.swing.JPanel {
    private DefaultTableModel tableModel;
    private int researcherId;

    public ViewSamples(int researcherId) {
        this.researcherId = researcherId;
        initComponents();
        customizeUI();
        loadSampleData();
    }

    private void customizeUI() {
        setBackground(new Color(240, 248, 255)); // Alice blue

        // Customize table
        jTable1.setBackground(Color.WHITE);
        jTable1.setGridColor(new Color(200, 200, 200));
        jTable1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        jTable1.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(new Color(0, 150, 0)); // Green
        jTable1.getTableHeader().setForeground(Color.WHITE);

        // Customize title
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(new Color(0, 150, 0)); // Green

        // Customize view button
        jButton1.setBackground(new Color(0, 150, 0)); // Green
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    private void loadSampleData() {
        try {
            ResultSet rs = DatabaseOperations.getSamplesWithGeneticMarkers();
            tableModel = new DefaultTableModel(
                    new Object[] { "Sample ID", "Sample Type", "Chromosome Location", "Mutation Type", "Impact" }, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return String.class; // All columns should be treated as strings
                }
            };

            while (rs.next()) {
                tableModel.addRow(new Object[] {
                        rs.getString("Sample_ID"),
                        rs.getString("Sample_Type"),
                        rs.getString("Chromosome_Location"),
                        rs.getString("Mutation_Type"),
                        rs.getString("Impact")
                });
            }

            jTable1.setModel(tableModel);
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading sample data: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a sample to view details",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String sampleId = (String) tableModel.getValueAt(selectedRow, 0);
        try {
            // Get researcher name
            String researcherName = DatabaseOperations.getResearcherName(researcherId);
            if (researcherName == null) {
                JOptionPane.showMessageDialog(this, "Researcher not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Record access log
            DatabaseOperations.insertAccessLog(researcherId, researcherName, sampleId);

            // Show details dialog
            SampleDetailsDialog dialog = new SampleDetailsDialog((JFrame) SwingUtilities.getWindowAncestor(this),
                    sampleId);
            dialog.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error recording access: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 248, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(0, 150, 0));
        jLabel1.setText("Gene Samples");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "Sample ID", "Sample Type", "Chromosome Location", "Mutation Type", "Impact" }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(0, 150, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("View Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(30, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE)));
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
}