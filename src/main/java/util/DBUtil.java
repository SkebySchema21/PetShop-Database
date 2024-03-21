package util;

import com.sun.rowset.CachedRowSetImpl;
import javafx.scene.control.Alert;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;

public class DBUtil {
    //Declare JDBC Driver
    final static String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    private static Connection conn = null;

    //Connect to DB
    private static void dbConnect() {
        final String DB_URL = "jdbc:jtds:sqlserver://localhost:1433/Proiect_Petshop;instance=SQLEXPRESS;";
        final String user = "test";
        final String password = "1234";

        System.out.println("Attempting to connect to the database");
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, user, password);
            //Connection
            Statement stmt = conn.createStatement();
            System.out.println("Successfully connected to the database!");
        } catch (Exception e) {
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        }
    }

    //Close Connection
    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e){
            throw e;
        }
    }

    //DB Execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");

            //Create statement
            stmt = conn.createStatement();

            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);

            //CachedRowSet Implementation
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
        //Return CachedRowSet
        return crs;
    }

    public static ResultSet dbExecuteQuery1(String queryStmt) throws SQLException, ClassNotFoundException {
        // Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSet crs = null;

        try {
            // Connect to DB (Establish Oracle Connection)
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");

            // Create statement
            stmt = conn.createStatement();

            // Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);

            // CachedRowSet Implementation
            // In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            // We are using CachedRowSet
            crs = RowSetProvider.newFactory().createCachedRowSet();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                // Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                // Close Statement
                stmt.close();
            }
            // Close connection
            dbDisconnect();
        }
        // Return CachedRowSet
        return crs;
    }
    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
    }
}