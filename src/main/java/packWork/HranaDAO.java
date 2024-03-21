package packWork;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

public class HranaDAO{

    public static Hrana searchHrana (String Cod_bare) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Hrana WHERE Cod_bare="+Cod_bare;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery1(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Hrana hrana = getHranaFromResultSet(rsEmp);

            //Return employee object
            return hrana;
        } catch (SQLException e) {
            System.out.println("While searching a food with " + Cod_bare + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    private static Hrana getHranaFromResultSet(ResultSet rs) throws SQLException
    {
        Hrana emp = null;
        if (rs.next()) {
            emp = new Hrana();
            emp.setHrana_ID(rs.getInt("Hrana_ID"));
            emp.setData_expirare(rs.getDate("Data_expirare"));
            emp.setPret(rs.getBigDecimal("Pret"));
            emp.setGramaj(rs.getInt("Gramaj"));
            emp.setCod_bare(rs.getString("Cod_bare"));
        }
        return emp;
    }

    public static ObservableList<Hrana> searchAllHrana () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Hrana";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Hrana> empList = getHranaList(rsEmps);

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    private static ObservableList<Hrana> getHranaList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Hrana> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Hrana emp = new Hrana();
            emp = new Hrana();
            emp.setHrana_ID(rs.getInt("Hrana_ID"));
            emp.setData_expirare(rs.getDate("Data_expirare"));
            emp.setPret(rs.getBigDecimal("Pret"));
            emp.setGramaj(rs.getInt("Gramaj"));
            emp.setCod_bare(rs.getString("Cod_bare"));
            //Add employee to the ObservableList
            empList.add(emp);
        }
        //return empList (ObservableList of Employees)
        return empList;
    }

    //*************************************
    //UPDATE
    //*************************************

    public static void updateHrana (Date Data_expirare, BigDecimal Pret, double Gramaj, String Cod_bare) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE Hrana\n" +
                        "      SET Data_expirare = '" + Data_expirare + ",Pret = " + Pret + ",Gramaj = " + Gramaj + ",Cod_bare = " + Cod_bare +"'\n" +

                        "    WHERE Cod_bare = " + Cod_bare + ";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }


    //*************************************
    //DELETE
    //*************************************
    public static void deleteHranaWithCod (String Cod_bare) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM Hrana\n" +
                        "         WHERE Cod_bare ="+ Cod_bare +";\n" +
                        "   COMMIT;\n" +
                        "END;";

        //Execute UPDATE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    //*************************************
    //INSERT
    //*************************************
    public static void insertHrana (Date Data_expirare, Currency Pret, double Gramaj, String Cod_bare) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO Hrana\n" +
                        "(Data_expirare, Pret, Gramaj, Cod_bare)\n" +
                        "VALUES\n" +
                        "('"+Data_expirare+"', '"+Pret+"','"+Gramaj+"', '"+Cod_bare+"');\n" +
                        "END;";

        //Execute DELETE operation
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }


}

