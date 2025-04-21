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

    public ResultSet getPendingRequests() throws SQLException {
        String query = "SELECT requestid, researcherid, researcherName, requestedSampleId, purpose, " +
                "sampleStatus, RequestDate, requestStatus FROM requestlogs " +
                "WHERE requestStatus = 'Pending' ORDER BY RequestDate DESC";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public void updateRequestStatus(int requestId, String status) throws SQLException {
        // First get the request details
        String selectQuery = "SELECT * FROM requestlogs WHERE requestid = ?";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement selectStmt = conn.prepareStatement(selectQuery)) {
            selectStmt.setInt(1, requestId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                // Update the request status
                String updateQuery = "UPDATE requestlogs SET requestStatus = ? WHERE requestid = ?";
                try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                    updateStmt.setString(1, status);
                    updateStmt.setInt(2, requestId);
                    updateStmt.executeUpdate();
                }

                // If approved, update inventory status
                if (status.equals("Approved")) {
                    String inventoryQuery = "UPDATE inventory SET Current_Status = 'In Use' WHERE Sample_ID = ?";
                    try (PreparedStatement inventoryStmt = conn.prepareStatement(inventoryQuery)) {
                        inventoryStmt.setString(1, rs.getString("requestedSampleId"));
                        inventoryStmt.executeUpdate();
                    }
                }
            }
        }
    }

    public void autoRejectDepletedSamples() throws SQLException {
        String query = "UPDATE requestlogs r " +
                "JOIN inventory i ON r.requestedSampleId = i.Sample_ID " +
                "SET r.requestStatus = 'Rejected' " +
                "WHERE r.requestStatus = 'Pending' AND i.Current_Status = 'Depleted'";
        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.executeUpdate();
        }
    }

    public ResultSet getRequestLogs() throws SQLException {
        String query = "SELECT requestid, researcherid, researcherName, requestedSampleId, purpose, " +
                "sampleStatus, RequestDate, requestStatus FROM requestlogs ORDER BY RequestDate DESC";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public static ResultSet getResearcherRequests(int researcherId) throws SQLException {
        String query = "SELECT requestid, requestedSampleId, purpose, RequestDate, requestStatus " +
                "FROM requestlogs " +
                "WHERE researcherid = ? " +
                "ORDER BY RequestDate DESC";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, researcherId);
        return pstmt.executeQuery();
    }

    public static boolean isSampleAvailable(String sampleId) throws SQLException {
        String query = "SELECT Current_Status FROM inventory WHERE Sample_ID = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, sampleId);
        ResultSet rs = pstmt.executeQuery();
        return rs.next() && rs.getString("Current_Status").equals("Available");
    }

    public static String getResearcherName(int researcherId) throws SQLException {
        String query = "SELECT Name FROM researcher WHERE Researcher_ID = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, researcherId);
        ResultSet rs = pstmt.executeQuery();

        if (!rs.next()) {
            System.out.println("No researcher found with ID: " + researcherId);
            return null;
        }

        String name = rs.getString("Name");
        System.out.println("Found researcher: " + name);
        return name;
    }

    public static int getNextRequestId() throws SQLException {
        String query = "SELECT MAX(requestid) as max_id FROM requestlogs";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery();
        return rs.next() ? rs.getInt("max_id") + 1 : 1;
    }

    public static void insertRequestLog(int requestId, int researcherId, String researcherName,
            String sampleId, String purpose) throws SQLException {
        String query = "INSERT INTO requestlogs (requestid, researcherid, researcherName, " +
                "requestedSampleId, purpose, sampleStatus, RequestDate, requestStatus) " +
                "VALUES (?, ?, ?, ?, ?, (SELECT Current_Status FROM inventory WHERE Sample_ID = ?), " +
                "CURRENT_DATE, 'Pending')";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, requestId);
        pstmt.setInt(2, researcherId);
        pstmt.setString(3, researcherName);
        pstmt.setString(4, sampleId);
        pstmt.setString(5, purpose);
        pstmt.setString(6, sampleId);
        pstmt.executeUpdate();
    }

    public static ResultSet getSamplesWithGeneticMarkers() throws SQLException {
        String query = "SELECT gs.Sample_ID, gs.Sample_Type, gm.Chromosome_Location, gm.Mutation_Type, gm.Impact " +
                "FROM gene_sample gs " +
                "LEFT JOIN genetic_markers gm ON gs.Sample_ID = gm.Sample_ID " +
                "ORDER BY gs.Sample_ID";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public static ResultSet getSampleDetails(String sampleId) throws SQLException {
        String query = "SELECT " +
                "gs.*, d.*, fh.*, l.*, ed.*, gep.*, gm.*, c.* " +
                "FROM gene_sample gs " +
                "LEFT JOIN donor d ON gs.Donor_ID = d.Donor_ID " +
                "LEFT JOIN family_history fh ON d.Donor_ID = fh.Donor_ID " +
                "LEFT JOIN lifestyle l ON d.Donor_ID = l.Donor_ID " +
                "LEFT JOIN epigenetic_data ed ON gs.Sample_ID = ed.Sample_ID " +
                "LEFT JOIN gene_expression_profiles gep ON gs.Sample_ID = gep.Sample_ID " +
                "LEFT JOIN genetic_markers gm ON gs.Sample_ID = gm.Sample_ID " +
                "LEFT JOIN consent c ON d.Donor_ID = c.Donor_ID " +
                "WHERE gs.Sample_ID = ?";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, sampleId);
        return pstmt.executeQuery();
    }

    public static void insertAccessLog(int researcherId, String name, String sampleId) throws SQLException {
        String query = "INSERT INTO access_logs (researcherid, name, sampleid, date, time) " +
                "VALUES (?, ?, ?, CURRENT_DATE, CURRENT_TIME)";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, researcherId);
        pstmt.setString(2, name);
        pstmt.setString(3, sampleId);
        pstmt.executeUpdate();
    }

    public ResultSet getAccessLogs() throws SQLException {
        String query = "SELECT researcherid, name, sampleid, date, time FROM access_logs ORDER BY date DESC, time DESC";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public ResultSet getSamplesInUse() throws SQLException {
        String query = "SELECT COUNT(*) as count FROM inventory WHERE Current_Status = 'In Use'";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public ResultSet getPendingRequestsCount() throws SQLException {
        String query = "SELECT COUNT(*) as count FROM requestlogs WHERE requestStatus = 'Pending'";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public ResultSet getReportsViewedToday() throws SQLException {
        String query = "SELECT COUNT(*) as count FROM access_logs WHERE date = CURRENT_DATE";
        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        return pstmt.executeQuery();
    }

    public ResultSet getResearcherMetrics(int researcherId) throws SQLException {
        String query = "SELECT " +
                "(SELECT COUNT(*) FROM requestlogs WHERE researcherid = ?) as total_requests, " +
                "(SELECT COUNT(*) FROM requestlogs WHERE researcherid = ? AND requeststatus = 'Approved') as approved_requests, "
                +
                "(SELECT COUNT(*) FROM requestlogs WHERE researcherid = ? AND requeststatus = 'Pending') as pending_requests";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setInt(1, researcherId);
        pstmt.setInt(2, researcherId);
        pstmt.setInt(3, researcherId);
        return pstmt.executeQuery();
    }
}