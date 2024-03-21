package packWork;

/*
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
/*
public class MagazineDAO {
    public static Magazin searchMagazin (String Oras) throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Magazin WHERE Oras="+Oras;

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeFromResultSet method and get employee object
            Magazin magazin = getHranaFromResultSet(rsEmp);

            //Return employee object
            return magazin;
        } catch (SQLException e) {
            System.out.println("While searching a shop with " + Oras + " id, an error occurred: " + e);
            //Return exception
            throw e;
        }
    }

    private static Magazin getMagazinFromResultSet(ResultSet rs) throws SQLException
    {
        Magazin emp = null;
        if (rs.next()) {
            emp = new Magazin();
            emp.setHrana_ID(rs.getInt("Hrana_ID"));
            emp.setData_expirare(rs.getDate("Data_expirare"));
            emp.setPret(rs.getBigDecimal("Pret"));
            emp.setGramaj(rs.getInt("Gramaj"));
            emp.setCod_bare(rs.getString("Cod_bare"));
        }
        return emp;
    }

    public static ObservableList<Magazin> searchMagazin () throws SQLException, ClassNotFoundException {
        //Declare a SELECT statement
        String selectStmt = "SELECT * FROM Magazin";

        //Execute SELECT statement
        try {
            //Get ResultSet from dbExecuteQuery method
            ResultSet rsEmps = DBUtil.dbExecuteQuery(selectStmt);

            //Send ResultSet to the getEmployeeList method and get employee object
            ObservableList<Magazin> empList = getMagazinList(rsEmps);

            //Return employee object
            return empList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            //Return exception
            throw e;
        }
    }

    private static ObservableList<Magazin> getMagazinList(ResultSet rs) throws SQLException, ClassNotFoundException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<Magazin> empList = FXCollections.observableArrayList();

        while (rs.next()) {
            Magazin emp = new Magazin();
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

    public static void updateMagazin (Date Data_expirare, Currency Pret, double Gramaj, String Cod_bare) throws SQLException, ClassNotFoundException {
        //Declare a UPDATE statement
        String updateStmt =
                "BEGIN\n" +
                        "   UPDATE Magazin\n" +
                        "      SET Data_expirare = '" + Oras + ",Pret = " + Pret + ",Gramaj = " + Gramaj + ",Cod_bare = " + Cod_bare +"'\n" +

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
    public static void deleteMagazinWithOras (String Oras) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "   DELETE FROM Magazin\n" +
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
    public static void insertMagazin (Date Oras, Currency Pret, double Gramaj, String Cod_bare) throws SQLException, ClassNotFoundException {
        //Declare a DELETE statement
        String updateStmt =
                "BEGIN\n" +
                        "INSERT INTO Magazin\n" +
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
*/