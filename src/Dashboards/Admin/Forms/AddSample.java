package Dashboards.Admin.Forms;

import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import Database.DatabaseOperations;
import java.sql.Date;
import java.sql.Connection;
import java.sql.SQLException;
import Database.DatabaseConnection;

public class AddSample extends javax.swing.JPanel {
    private DatabaseOperations db;

    public AddSample() {
        initComponents();
        customizeUI();
        try {
            db = new DatabaseOperations();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error connecting to database: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();

        jLabel1.setText("Donor ID:");
        jLabel2.setText("Donor Name:");
        jLabel3.setText("Age:");
        jLabel4.setText("Sex:");
        jLabel5.setText("Ethnicity:");
        jLabel6.setText("Family ID:");
        jLabel7.setText("Consent ID:");
        jLabel8.setText("Date of Generation:");
        jLabel9.setText("Lawyer Name:");
        jLabel10.setText("Lawyer Contact:");
        jLabel11.setText("Sample ID:");
        jLabel12.setText("Collection Date:");
        jLabel13.setText("Sample Type:");
        jLabel14.setText("Rack ID:");
        jLabel15.setText("Methylation Site:");
        jLabel16.setText("Histone Modification Type:");
        jLabel17.setText("Expression Impact:");
        jLabel18.setText("Family Member Name:");
        jLabel19.setText("Relation:");
        jLabel20.setText("Genetic Condition:");
        jLabel21.setText("Expression Level:");
        jLabel22.setText("Tissue Type:");
        jLabel23.setText("Experimental Conditions:");
        jLabel24.setText("Chromosome Location:");
        jLabel25.setText("Mutation Type:");
        jLabel26.setText("Impact:");
        jLabel27.setText("Smoking Status:");
        jLabel28.setText("Alcohol Consumption:");
        jToggleButton1.setText("Add Sample");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        // Set background color
        this.setBackground(new Color(230, 255, 230)); // Very light mint

        // Create a scroll pane
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane();
        scrollPane.setBackground(new Color(230, 255, 230));

        // Create a panel to hold the form
        javax.swing.JPanel formPanel = new javax.swing.JPanel();
        formPanel.setBackground(new Color(230, 255, 230));

        // Add title
        javax.swing.JLabel titleLabel = new javax.swing.JLabel("Add Sample Details");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        // Set font size to 14
        Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font textFont = new Font("Segoe UI", Font.PLAIN, 14);
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);

        // Set fixed width for labels
        Dimension labelSize = new Dimension(200, 25);
        Dimension textFieldSize = new Dimension(250, 25);

        // Set fonts and sizes for all components
        for (javax.swing.JLabel label : new javax.swing.JLabel[] {
                jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8,
                jLabel9, jLabel10, jLabel11, jLabel12, jLabel13, jLabel14, jLabel15,
                jLabel16, jLabel17, jLabel18, jLabel19, jLabel20, jLabel21, jLabel22,
                jLabel23, jLabel24, jLabel25, jLabel26, jLabel27, jLabel28
        }) {
            label.setFont(labelFont);
            label.setPreferredSize(labelSize);
            label.setMinimumSize(labelSize);
            label.setMaximumSize(labelSize);
        }

        for (javax.swing.JTextField textField : new javax.swing.JTextField[] {
                jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6,
                jTextField7, jTextField8, jTextField9, jTextField10, jTextField11, jTextField12,
                jTextField13, jTextField14, jTextField15, jTextField16, jTextField17, jTextField18,
                jTextField19, jTextField20, jTextField21, jTextField22, jTextField23, jTextField24,
                jTextField25, jTextField26, jTextField27, jTextField28
        }) {
            textField.setFont(textFont);
            textField.setPreferredSize(textFieldSize);
            textField.setMinimumSize(textFieldSize);
            textField.setMaximumSize(textFieldSize);
        }

        jToggleButton1.setFont(buttonFont);
        jToggleButton1.setBackground(new Color(0, 150, 136)); // Teal color
        jToggleButton1.setForeground(Color.WHITE);

        // Create layout for form panel
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(layout);

        // Create two columns
        javax.swing.GroupLayout.ParallelGroup leftColumn = layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);
        javax.swing.GroupLayout.ParallelGroup rightColumn = layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);

        // Add components to columns with fixed alignment
        for (int i = 0; i < 14; i++) {
            leftColumn.addGroup(layout.createSequentialGroup()
                    .addComponent(getLabel(i + 1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(getTextField(i + 1)));

            rightColumn.addGroup(layout.createSequentialGroup()
                    .addComponent(getLabel(i + 15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(getTextField(i + 15)));
        }

        // Set horizontal layout with fixed gaps
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(leftColumn)
                                .addGap(30)
                                .addGroup(rightColumn)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jToggleButton1)
                                .addContainerGap()));

        // Set vertical layout with fixed gaps
        javax.swing.GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(20);

        // Add components to vertical layout with fixed gaps
        for (int i = 0; i < 14; i++) {
            verticalGroup.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(getLabel(i + 1))
                    .addComponent(getTextField(i + 1))
                    .addComponent(getLabel(i + 15))
                    .addComponent(getTextField(i + 15)))
                    .addGap(10);
        }

        verticalGroup.addGap(20)
                .addComponent(jToggleButton1)
                .addContainerGap();

        layout.setVerticalGroup(verticalGroup);

        // Add form panel to scroll pane
        scrollPane.setViewportView(formPanel);

        // Set layout for main panel
        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(this);
        this.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane));
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane));
    }

    // Helper methods to get components
    private javax.swing.JLabel getLabel(int index) {
        switch (index) {
            case 1:
                return jLabel1;
            case 2:
                return jLabel2;
            case 3:
                return jLabel3;
            case 4:
                return jLabel4;
            case 5:
                return jLabel5;
            case 6:
                return jLabel6;
            case 7:
                return jLabel7;
            case 8:
                return jLabel8;
            case 9:
                return jLabel9;
            case 10:
                return jLabel10;
            case 11:
                return jLabel11;
            case 12:
                return jLabel12;
            case 13:
                return jLabel13;
            case 14:
                return jLabel14;
            case 15:
                return jLabel15;
            case 16:
                return jLabel16;
            case 17:
                return jLabel17;
            case 18:
                return jLabel18;
            case 19:
                return jLabel19;
            case 20:
                return jLabel20;
            case 21:
                return jLabel21;
            case 22:
                return jLabel22;
            case 23:
                return jLabel23;
            case 24:
                return jLabel24;
            case 25:
                return jLabel25;
            case 26:
                return jLabel26;
            case 27:
                return jLabel27;
            case 28:
                return jLabel28;
            default:
                return null;
        }
    }

    private javax.swing.JTextField getTextField(int index) {
        switch (index) {
            case 1:
                return jTextField1;
            case 2:
                return jTextField2;
            case 3:
                return jTextField3;
            case 4:
                return jTextField4;
            case 5:
                return jTextField5;
            case 6:
                return jTextField6;
            case 7:
                return jTextField7;
            case 8:
                return jTextField8;
            case 9:
                return jTextField9;
            case 10:
                return jTextField10;
            case 11:
                return jTextField11;
            case 12:
                return jTextField12;
            case 13:
                return jTextField13;
            case 14:
                return jTextField14;
            case 15:
                return jTextField15;
            case 16:
                return jTextField16;
            case 17:
                return jTextField17;
            case 18:
                return jTextField18;
            case 19:
                return jTextField19;
            case 20:
                return jTextField20;
            case 21:
                return jTextField21;
            case 22:
                return jTextField22;
            case 23:
                return jTextField23;
            case 24:
                return jTextField24;
            case 25:
                return jTextField25;
            case 26:
                return jTextField26;
            case 27:
                return jTextField27;
            case 28:
                return jTextField28;
            default:
                return null;
        }
    }

    private void customizeUI() {
        // Remove setLocationRelativeTo since it's not needed for JPanel
    }

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        Connection conn = null;
        try {
            // Get all form values
            String donorId = jTextField1.getText();
            String donorName = jTextField2.getText();
            int age = Integer.parseInt(jTextField3.getText());
            String sex = jTextField4.getText();
            String ethnicity = jTextField5.getText();
            String familyId = jTextField6.getText();
            String consentId = jTextField7.getText();
            Date dateOfGeneration = Date.valueOf(jTextField8.getText());
            String lawyerName = jTextField9.getText();
            String lawyerContact = jTextField10.getText();
            String sampleId = jTextField11.getText();
            Date collectionDate = Date.valueOf(jTextField12.getText());
            String sampleType = jTextField13.getText();
            String rackId = jTextField14.getText();
            String methylationSite = jTextField15.getText();
            String histoneModificationType = jTextField16.getText();
            String expressionImpact = jTextField17.getText();
            String familyMemberName = jTextField18.getText();
            String relation = jTextField19.getText();
            String geneticCondition = jTextField20.getText();
            double expressionLevel = Double.parseDouble(jTextField21.getText());
            String tissueType = jTextField22.getText();
            String experimentalConditions = jTextField23.getText();
            String chromosomeLocation = jTextField24.getText();
            String mutationType = jTextField25.getText();
            String impact = jTextField26.getText();
            String smokingStatus = jTextField27.getText();
            String alcoholConsumption = jTextField28.getText();

            // Generate IDs for new records
            String expressionId = "EXP_" + sampleId;
            String markerId = "MARK_" + sampleId;
            String lifestyleId = "LIFE_" + donorId;
            String epigeneticDataId = "EPI_" + sampleId;

            // Validate required fields
            if (donorId.isEmpty() || donorName.isEmpty() || sampleId.isEmpty() ||
                    consentId.isEmpty() || familyId.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields");
                return;
            }

            // Validate dates
            if (dateOfGeneration.after(new java.util.Date())) {
                JOptionPane.showMessageDialog(this, "Date of Generation cannot be in the future");
                return;
            }
            if (collectionDate.after(new java.util.Date())) {
                JOptionPane.showMessageDialog(this, "Collection Date cannot be in the future");
                return;
            }

            // Validate numeric values
            if (age <= 0 || age > 120) {
                JOptionPane.showMessageDialog(this, "Please enter a valid age (1-120)");
                return;
            }
            if (expressionLevel < 0) {
                JOptionPane.showMessageDialog(this, "Expression level cannot be negative");
                return;
            }

            // Get database connection and start transaction
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);

            // Insert donor information
            db.insertDonor(donorId, donorName, age, sex, ethnicity, familyId);

            // Insert consent information
            db.insertConsent(consentId, donorId, dateOfGeneration, lawyerName, lawyerContact);

            // Insert sample information
            db.insertGeneSample(sampleId, donorId, collectionDate, sampleType, rackId);

            // Insert epigenetic data
            db.insertEpigeneticData(epigeneticDataId, sampleId, methylationSite, histoneModificationType,
                    expressionImpact);

            // Insert family history
            db.insertFamilyHistory(familyId, donorId, familyMemberName, relation, geneticCondition);

            // Insert gene expression profile
            db.insertGeneExpressionProfile(expressionId, sampleId, expressionLevel, tissueType, experimentalConditions);

            // Insert genetic markers
            db.insertGeneticMarker(markerId, sampleId, chromosomeLocation, mutationType, impact);

            // Insert lifestyle information
            db.insertLifestyle(lifestyleId, donorId, smokingStatus, alcoholConsumption, "Not specified");

            // Commit transaction if all inserts are successful
            conn.commit();
            JOptionPane.showMessageDialog(this, "Sample data added successfully!");
            clearForm();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for age and expression level");
            rollbackTransaction(conn);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid dates in the format YYYY-MM-DD");
            rollbackTransaction(conn);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            rollbackTransaction(conn);
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void rollbackTransaction(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void clearForm() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextField14.setText("");
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jTextField26.setText("");
        jTextField27.setText("");
        jTextField28.setText("");
    }

    // Variables declaration - do not modify
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration
}