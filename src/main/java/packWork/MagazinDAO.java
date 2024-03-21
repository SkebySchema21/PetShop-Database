package packWork;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;

public class MagazinDAO {

        public static Magazin searchMagazin (Integer Magazin_ID) throws SQLException, ClassNotFoundException {
            //Declare a SELECT statement
            String selectStmt = "SELECT * FROM Magazin WHERE Magazin_ID="+Magazin_ID;

            //Execute SELECT statement
            try {
                //Get ResultSet from dbExecuteQuery method
                ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);

                //Send ResultSet to the getEmployeeFromResultSet method and get employee object
                Magazin magazin = getMagazinFromResultSet(rsEmp);

                //Return employee object
                return magazin;
            } catch (SQLException e) {
                System.out.println("While searching a food with " + Magazin_ID + " id, an error occurred: " + e);
                //Return exception
                throw e;
            }
        }

        private static Magazin getMagazinFromResultSet(ResultSet rs) throws SQLException
        {
            Magazin emp = null;
            if (rs.next()) {
                emp = new Magazin();
                emp.setMagazin_ID(rs.getInt("Magazin_ID"));
                emp.setJudet(rs.getString("Judet"));
                emp.setOras(rs.getString("Oras"));
                emp.setStrada(rs.getString("Strada"));
                emp.setNumar(rs.getString("Numar"));
                emp.setData_deschidere(rs.getDate("Data_deschidere"));
                emp.setChirie_luna(rs.getBigDecimal("Chirie_luna"));
            }
            return emp;
        }

        public static ObservableList<Magazin> searchAllMagazin () throws SQLException, ClassNotFoundException {
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
                Magazin emp = null;
                emp = new Magazin();
                emp.setMagazin_ID(rs.getInt("Magazin_ID"));
                emp.setJudet(rs.getString("Judet"));
                emp.setOras(rs.getString("Oras"));
                emp.setStrada(rs.getString("Strada"));
                emp.setNumar(rs.getString("Numar"));
                emp.setData_deschidere(rs.getDate("Data_deschidere"));
                emp.setChirie_luna(rs.getBigDecimal("Chirie_luna"));
                //Add employee to the ObservableList
                empList.add(emp);
            }
            //return empList (ObservableList of Employees)
            return empList;
        }

        //*************************************
        //UPDATE
        //*************************************

        public static void updateMagazin (Integer Magazin_ID, String Judet, String Oras, String Strada, String Numar, Date Data_deschidere, BigDecimal Chirie_luna) throws SQLException, ClassNotFoundException {
            //Declare a UPDATE statement
            String updateStmt =
                    "BEGIN\n" +
                            "   UPDATE Magazin\n" +
                            "      SET Judet = '" + Judet + ",Oras = " + Oras + ",Strada = " + Strada + ",Numar = " + Numar + ",Data_deschidere = " + Data_deschidere + ",Chirie_luna = " + Chirie_luna + "'\n" +

                            "    WHERE Magazin_ID = " + Magazin_ID + ";\n" +
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
        public static void deleteMagazinWithID (Integer Magazin_ID) throws SQLException, ClassNotFoundException {
            //Declare a DELETE statement
            String updateStmt =
                    "BEGIN\n" +
                            "   DELETE FROM Magazin\n" +
                            "         WHERE Magazin_ID ="+ Magazin_ID +";\n" +
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
        public static void insertMagazin (String Judet, String Oras, String Strada, String Numar, Date Data_deschidere, BigDecimal Chirie_luna) throws SQLException, ClassNotFoundException {
            //Declare a DELETE statement
            String updateStmt =
                    "BEGIN\n" +
                            "INSERT INTO Magazin\n" +
                            "(Judet, Oras, Strada, Numar, Data_deschidere, Chirie_luna)\n" +
                            "VALUES\n" +
                            "('"+Judet+"', '"+Oras+"','"+Strada+"', '"+Numar+"', '"+Data_deschidere+"', '"+Chirie_luna+"');\n" +
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
