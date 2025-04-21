package Dashboards.Researcher.Forms;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import Database.DatabaseOperations;
import Dashboards.Researcher.ResearcherDashboard;

public class ViewRequestStatus extends javax.swing.JPanel {
    private ResearcherDashboard researcherDashboard;
    private DefaultTableModel tableModel;
    private int researcherId;

    public ViewRequestStatus() {
        initComponents();
        customizeUI();
        setupTable();
    }

    public ViewRequestStatus(ResearcherDashboard dashboard) {
        initComponents();
        customizeUI();
        setupTable();
        setResearcherDashboard(dashboard);
        loadRequestData();
    }

    public void setResearcherDashboard(ResearcherDashboard dashboard) {
        this.researcherDashboard = dashboard;
        this.researcherId = dashboard.getResearcherId();
    }

    private void customizeUI() {
        // Set background color
        this.setBackground(new Color(240, 248, 255)); // Alice blue background

        // Customize table appearance - matching ViewRequests style
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

        // Customize title label
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 24));
        jLabel1.setForeground(new Color(0, 150, 136));

        // Customize scroll pane
        jScrollPane1.setBackground(new Color(240, 248, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Add status-based coloring
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected && column == 4) { // Status column
                    String status = (String) value;
                    if (status != null) {
                        if (status.equals("Pending")) {
                            c.setBackground(new Color(255, 255, 153)); // Yellow
                        } else if (status.equals("Rejected")) {
                            c.setBackground(new Color(255, 153, 153)); // Red
                        } else if (status.equals("Approved")) {
                            c.setBackground(new Color(153, 255, 153)); // Green
                        }
                    }
                } else if (!isSelected) {
                    c.setBackground(Color.WHITE);
                }

                if (isSelected) {
                    c.setBackground(new Color(204, 204, 255)); // Light blue for selection
                }

                return c;
            }
        });
    }

    private void setupTable() {
        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tableModel.addColumn("Request ID");
        tableModel.addColumn("Sample ID");
        tableModel.addColumn("Purpose");
        tableModel.addColumn("Request Date");
        tableModel.addColumn("Status");

        jTable1.setModel(tableModel);
    }

    private void loadRequestData() {
        try {
            ResultSet rs = DatabaseOperations.getResearcherRequests(researcherId);
            tableModel.setRowCount(0); // Clear existing data

            while (rs.next()) {
                int requestId = rs.getInt("requestid");
                String sampleId = rs.getString("requestedSampleId");
                String purpose = rs.getString("purpose");
                Date requestDate = rs.getDate("RequestDate");
                String status = rs.getString("requestStatus");

                tableModel.addRow(new Object[] { requestId, sampleId, purpose, requestDate, status });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading request data: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(240, 248, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(0, 150, 136));
        jLabel1.setText("Your Requests");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[] {
                        "Request ID", "Sample ID", "Purpose", "Request Date", "Status"
                }));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(103, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(95, Short.MAX_VALUE)));
    }

    // Variables declaration
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration
}