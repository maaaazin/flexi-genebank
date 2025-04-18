/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dashboards.Admin.Forms;

/**
 *
 * @author ASUS
 */
import javax.swing.JFrame;


public class TestAddSample {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("Add Sample Form");

        // Set default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add your custom panel
        frame.setContentPane(new AddSample());

        // Set size and make it visible
        frame.setSize(800, 800); // You can adjust the size
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }
}
