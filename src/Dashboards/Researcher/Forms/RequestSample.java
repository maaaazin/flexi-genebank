package Dashboards.Researcher.Forms;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import Database.DatabaseOperations;
import Dashboards.Researcher.ResearcherDashboard;

public class RequestSample extends javax.swing.JPanel {
    private ResearcherDashboard researcherDashboard;
    private int researcherId;

    public void setResearcherDashboard(ResearcherDashboard researcherDashboard) {
        this.researcherDashboard = researcherDashboard;
        this.researcherId = researcherDashboard.getResearcherId();
    }

    public RequestSample() {
        initComponents();
        customizeUI();
    }

    public RequestSample(ResearcherDashboard dashboard) {
        initComponents();
        customizeUI();
        setResearcherDashboard(dashboard);
    }

    private void customizeUI() {
        setBackground(new Color(240, 248, 255)); // Alice blue
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        String sampleId = jTextField1.getText().trim();
        String purpose = jTextArea1.getText().trim();

        if (sampleId.isEmpty() || purpose.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Check if sample is available
            if (!DatabaseOperations.isSampleAvailable(sampleId)) {
                JOptionPane.showMessageDialog(this, "Sample is not available",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get researcher name
            String researcherName = DatabaseOperations.getResearcherName(researcherId);
            if (researcherName == null) {
                JOptionPane.showMessageDialog(this, "Researcher not found",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get next request ID and insert request
            int requestId = DatabaseOperations.getNextRequestId();
            DatabaseOperations.insertRequestLog(requestId, researcherId, researcherName,
                    sampleId, purpose);

            JOptionPane.showMessageDialog(this, "Sample request submitted successfully",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            clearForm();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error submitting request: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        jTextField1.setText("");
        jTextArea1.setText("");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(240, 248, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(0, 150, 136));
        jLabel1.setText("Request Sample");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel2.setText("Sample ID:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jLabel3.setText("Purpose:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jTextField1.setPreferredSize(new java.awt.Dimension(200, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14));
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setBackground(new java.awt.Color(0, 150, 136));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submit Request");
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
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 200,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 400,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(103, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE)));
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration
}