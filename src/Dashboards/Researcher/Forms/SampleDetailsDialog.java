package Dashboards.Researcher.Forms;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import Database.DatabaseOperations;

public class SampleDetailsDialog extends JDialog {
    private JTextArea detailsArea;

    public SampleDetailsDialog(JFrame parent, String sampleId) {
        super(parent, "Sample Details - " + sampleId, true);
        setSize(800, 600);
        setLocationRelativeTo(parent);
        setResizable(false);

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        detailsArea.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(detailsArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(scrollPane, BorderLayout.CENTER);

        loadSampleDetails(sampleId);
    }

    private void loadSampleDetails(String sampleId) {
        try {
            ResultSet rs = DatabaseOperations.getSampleDetails(sampleId);
            if (rs.next()) {
                StringBuilder details = new StringBuilder();

                // Gene Sample Details
                details.append("GENE SAMPLE DETAILS\n");
                details.append("------------------\n");
                details.append("Sample ID: ").append(rs.getString("Sample_ID")).append("\n");
                details.append("Sample Type: ").append(rs.getString("Sample_Type")).append("\n");
                details.append("Collection Date: ").append(rs.getString("Collection_Date")).append("\n");
                details.append("Rack ID: ").append(rs.getString("Rack_ID")).append("\n\n");

                // Donor Details
                details.append("DONOR DETAILS\n");
                details.append("-------------\n");
                details.append("Donor ID: ").append(rs.getString("Donor_ID")).append("\n");
                details.append("Name: ").append(rs.getString("Name")).append("\n");
                details.append("Age: ").append(rs.getString("Age")).append("\n");
                details.append("Sex: ").append(rs.getString("Sex")).append("\n");
                details.append("Ethnicity: ").append(rs.getString("Ethnicity")).append("\n\n");

                // Family History
                details.append("FAMILY HISTORY\n");
                details.append("-------------\n");
                details.append("Family ID: ").append(rs.getString("Family_ID")).append("\n");
                details.append("Relation: ").append(rs.getString("Relation")).append("\n");
                details.append("Genetic Condition: ").append(rs.getString("Genetic_Condition")).append("\n\n");

                // Lifestyle
                details.append("LIFESTYLE\n");
                details.append("---------\n");
                details.append("Smoking: ").append(rs.getString("Smoking")).append("\n");
                details.append("Alcohol: ").append(rs.getString("Alcohol")).append("\n");
                details.append("Diet: ").append(rs.getString("Diet")).append("\n\n");

                // Epigenetic Data
                details.append("EPIGENETIC DATA\n");
                details.append("---------------\n");
                details.append("Methylation Site: ").append(rs.getString("Methylation_Site")).append("\n");
                details.append("Histone Modification: ").append(rs.getString("Histone_Modification_Type")).append("\n");
                details.append("Expression Impact: ").append(rs.getString("Expression_Impact")).append("\n\n");

                // Gene Expression
                details.append("GENE EXPRESSION\n");
                details.append("---------------\n");
                details.append("Expression Level: ").append(rs.getString("Expression_Level")).append("\n");
                details.append("Tissue Type: ").append(rs.getString("Tissue_Type")).append("\n");
                details.append("Experimental Conditions: ").append(rs.getString("Experimental_Conditions"))
                        .append("\n\n");

                // Genetic Markers
                details.append("GENETIC MARKERS\n");
                details.append("---------------\n");
                details.append("Chromosome Location: ").append(rs.getString("Chromosome_Location")).append("\n");
                details.append("Mutation Type: ").append(rs.getString("Mutation_Type")).append("\n");
                details.append("Impact: ").append(rs.getString("Impact")).append("\n\n");

                // Consent
                details.append("CONSENT\n");
                details.append("-------\n");
                details.append("Consent ID: ").append(rs.getString("Consent_ID")).append("\n");
                details.append("Date of Generation: ").append(rs.getString("Date_of_Generation")).append("\n");
                details.append("Lawyer Name: ").append(rs.getString("Lawyer_Name")).append("\n");
                details.append("Lawyer Contact: ").append(rs.getString("Lawyer_Contact")).append("\n");

                detailsArea.setText(details.toString());
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading sample details: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}