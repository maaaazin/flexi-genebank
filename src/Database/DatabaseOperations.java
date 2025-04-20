package Database;

import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

public class DatabaseOperations {

    public static void insertDonor(String donorId, String name, int age, String sex, String ethnicity, String familyId)
            throws DatabaseException {
        String query = "INSERT INTO donor (donor_id, name, age, sex, ethnicity, family_id) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, donorId);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);
            pstmt.setString(4, sex);
            pstmt.setString(5, ethnicity);
            pstmt.setString(6, familyId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting donor data", e);
        }
    }

    public static void insertConsent(String consentId, String donorId, Date dateOfGeneration,
            String lawyerName, String lawyerContact) throws DatabaseException {
        String query = "INSERT INTO consent (consent_id, donor_id, date_of_generation, lawyer_name, lawyer_contact) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, consentId);
            pstmt.setString(2, donorId);
            pstmt.setDate(3, dateOfGeneration);
            pstmt.setString(4, lawyerName);
            pstmt.setString(5, lawyerContact);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting consent data", e);
        }
    }

    public static void insertEpigeneticData(String epigeneticDataId, String sampleId, String methylationSite,
            String histoneModificationType, String expressionImpact) throws DatabaseException {
        String query = "INSERT INTO epigenetic_data (epigenetic_data_id, sample_id, methylation_site, " +
                "histone_modification_type, expression_impact) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, epigeneticDataId);
            pstmt.setString(2, sampleId);
            pstmt.setString(3, methylationSite);
            pstmt.setString(4, histoneModificationType);
            pstmt.setString(5, expressionImpact);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting epigenetic data", e);
        }
    }

    public static void insertFamilyHistory(String familyId, String donorId, String name,
            String relation, String geneticCondition) throws DatabaseException {
        String query = "INSERT INTO family_history (family_id, donor_id, name, relation, genetic_condition) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, familyId);
            pstmt.setString(2, donorId);
            pstmt.setString(3, name);
            pstmt.setString(4, relation);
            pstmt.setString(5, geneticCondition);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting family history", e);
        }
    }

    public static void insertGeneExpressionProfile(String expressionId, String sampleId,
            double expressionLevel, String tissueType, String experimentalConditions) throws DatabaseException {
        String query = "INSERT INTO gene_expression_profiles (expression_id, sample_id, expression_level, " +
                "tissue_type, experimental_conditions) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, expressionId);
            pstmt.setString(2, sampleId);
            pstmt.setDouble(3, expressionLevel);
            pstmt.setString(4, tissueType);
            pstmt.setString(5, experimentalConditions);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting gene expression profile", e);
        }
    }

    public static void insertGeneSample(String sampleId, String donorId, Date collectionDate,
            String sampleType, String rackId) throws DatabaseException {
        String query = "INSERT INTO gene_sample (sample_id, donor_id, collection_date, sample_type, rack_id) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, sampleId);
            pstmt.setString(2, donorId);
            pstmt.setDate(3, collectionDate);
            pstmt.setString(4, sampleType);
            pstmt.setString(5, rackId);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting gene sample", e);
        }
    }

    public static void insertGeneticMarker(String markerId, String sampleId, String chromosomeLocation,
            String mutationType, String impact) throws DatabaseException {
        String query = "INSERT INTO genetic_markers (marker_id, sample_id, chromosome_location, " +
                "mutation_type, impact) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, markerId);
            pstmt.setString(2, sampleId);
            pstmt.setString(3, chromosomeLocation);
            pstmt.setString(4, mutationType);
            pstmt.setString(5, impact);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting genetic marker", e);
        }
    }

    public static void insertLifestyle(String lifestyleId, String donorId, String smoking,
            String alcohol, String diet) throws DatabaseException {
        String query = "INSERT INTO lifestyle (lifestyle_id, donor_id, smoking, alcohol, diet) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, lifestyleId);
            pstmt.setString(2, donorId);
            pstmt.setString(3, smoking);
            pstmt.setString(4, alcohol);
            pstmt.setString(5, diet);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new DatabaseException("Error inserting lifestyle data", e);
        }
    }

    public ResultSet getInventoryData() throws SQLException {
        String query = "SELECT Rack_ID, Sample_ID, Current_Status, Last_Quality_Check FROM inventory ORDER BY Rack_ID";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public ResultSet getRequestLogs() throws SQLException {
        String query = "SELECT requestid, researcherid, researcherName, requestedSampleId, purpose, " +
                "sampleStatus, RequestDate, requestStatus FROM requestlogs ORDER BY RequestDate DESC";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }
}