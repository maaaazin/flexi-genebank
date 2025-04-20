package Dashboards.Researcher.Forms;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends javax.swing.JPanel {
    private javax.swing.JLabel jLabel1;

    public Dashboard() {
        initComponents();
        customizeUI();
    }

    private void customizeUI() {
        setBackground(new Color(240, 248, 255)); // Alice blue
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setForeground(new java.awt.Color(0, 150, 0));
        jLabel1.setText("Dashboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addContainerGap(800, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1)
                                .addContainerGap(550, Short.MAX_VALUE)));
    }
}