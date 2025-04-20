package Dashboards.Admin;

import javax.swing.JPanel;
import javax.swing.UIManager;

public class AdminDashboard extends javax.swing.JFrame {
    private JPanel currentForm;

    public AdminDashboard() {
        initComponents();
        // Set initial form to dashboard
        switchForm(dashboard1);
    }

    public void switchForm(JPanel newForm) {
        if (currentForm != null) {
            contentPanel.remove(currentForm);
        }
        currentForm = newForm;
        contentPanel.add(newForm);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        menu1 = new Dashboards.Admin.Forms.Menu();
        contentPanel = new javax.swing.JPanel();
        dashboard1 = new Dashboards.Admin.Forms.Dashboard();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin Dashboard");
        setPreferredSize(new java.awt.Dimension(1200, 625));

        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 625));

        menu1.setPreferredSize(new java.awt.Dimension(200, 625));
        menu1.setAdminDashboard(this);

        contentPanel.setLayout(new java.awt.BorderLayout());
        contentPanel.add(dashboard1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1000,
                                        Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menu1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                        .addComponent(contentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JPanel contentPanel;
    private Dashboards.Admin.Forms.Dashboard dashboard1;
    private javax.swing.JPanel jPanel1;
    private Dashboards.Admin.Forms.Menu menu1;
    // End of variables declaration
}
