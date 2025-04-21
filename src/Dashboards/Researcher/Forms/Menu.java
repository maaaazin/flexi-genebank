package Dashboards.Researcher.Forms;

import javax.swing.JFrame;
import Dashboards.Researcher.ResearcherDashboard;

public class Menu extends javax.swing.JPanel {
    private ResearcherDashboard researcherDashboard;

    public void setResearcherDashboard(ResearcherDashboard researcherDashboard) {
        this.researcherDashboard = researcherDashboard;
    }

    public Menu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(76, 175, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Genie's Genebank");

        jButton1.setBackground(new java.awt.Color(76, 175, 80));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Dashboard");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researcherDashboard.switchForm(new Dashboard());
            }
        });

        jButton2.setBackground(new java.awt.Color(76, 175, 80));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Request Samples");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researcherDashboard.switchForm(new RequestSample(researcherDashboard));
            }
        });

        jButton3.setBackground(new java.awt.Color(76, 175, 80));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("View Request Status");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researcherDashboard.switchForm(new ViewRequestStatus(researcherDashboard));
            }
        });

        jButton4.setBackground(new java.awt.Color(76, 175, 80));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("View Samples");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researcherDashboard.switchForm(new ViewSamples(researcherDashboard.getResearcherId()));
            }
        });

        jButton5.setBackground(new java.awt.Color(76, 175, 80));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Logout");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                researcherDashboard.dispose();
                login.Login login = new login.Login();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addContainerGap(14, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178,
                                        Short.MAX_VALUE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)));
    }

    // Variables declaration
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration
}