package packWork;

import javafx.scene.*;
import javafx.fxml.FXML;
import javafx.fxml.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import util.DBUtil;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

public class HelloController {

    @FXML
    private TextField Search_box;
    @FXML
    private TextField Search_box1;
    @FXML
    private TextArea Hrana_txt;
    @FXML
    private TextArea Magazine_txt;
    @FXML
    private TableView Hrana_table;
    @FXML
    private TableColumn<Hrana, Integer> Hrana_ID_tbl;
    @FXML
    private TableColumn<Hrana, Date> Hrana_Data_expirare_tbl;
    @FXML
    private TableColumn<Hrana, BigDecimal> Hrana_Pret_tbl;
    @FXML
    private TableColumn<Hrana, Double> Hrana_Gramaj_tbl;
    @FXML
    private TableColumn<Hrana, String> Hrana_Cod_bare_tbl;

    @FXML
    private TableView Magazine_table;
    @FXML
    private TableColumn<Magazin, Integer> Magazine_ID_tbl;
    @FXML
    private TableColumn<Magazin, String> Magazine_Judet_tbl;
    @FXML
    private TableColumn<Magazin, String> Magazine_Oras_tbl;
    @FXML
    private TableColumn<Magazin, String> Magazine_Strada_tbl;
    @FXML
    private TableColumn<Magazin, String> Magazine_Numar_tbl;
    @FXML
    private TableColumn<Magazin, Date> Magazine_Data_deschidere_tbl;
    @FXML
    private TableColumn<Magazin, BigDecimal> Magazine_Chirie_luna_tbl;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private Button Magazine_Insert;
    @FXML
    private Button Magazine_Update;
    @FXML
    private Button Magazine_Delete;
    @FXML
    private Button Magazine_Search;
    @FXML
    private Button Hrana_Insert;
    @FXML
    private Button Hrana_Update;
    @FXML
    private Button Hrana_Delete;
    @FXML
    private Button Hrana_Search;
    @FXML
    private Label Hrana_label;
    @FXML
    private Label Magazine_label;

    @FXML
    private Button Send;
    @FXML
    private Button Send1;
    @FXML
    private TextArea Statistici_txt1;
    @FXML
    private TextArea Statistici_txt11;
    @FXML
    private TextArea Statistici_txt12;
    @FXML
    private TextArea Statistici_txt13;
    @FXML
    private TextArea Statistici_txt14;
    @FXML
    private TextArea Statistici_txt15;
    @FXML
    private TextArea Statistici_txt16;
    @FXML
    private TextArea Statistici_txt17;
    @FXML
    private TextArea Statistici_txt18;
    @FXML
    private TextArea Statistici_txt19;
    @FXML
    private TextArea Statistici_txt20;

    public String Statistici1 = "SELECT TOP 1\n" +
            "    Profit - Rent AS NetProfit\n" +
            "FROM\n" +
            "    (\n" +
            "        SELECT\n" +
            "            S.Magazin_ID,\n" +
            "            COALESCE(SUM(B.Suma_totala), 0) AS Profit,\n" +
            "            COALESCE(SUM(S.Chirie_luna), 0) AS Rent\n" +
            "        FROM\n" +
            "            Magazin S\n" +
            "        LEFT JOIN\n" +
            "            Factura B ON S.Magazin_ID = B.Magazin_ID\n" +
            "        GROUP BY\n" +
            "            S.Magazin_ID\n" +
            "    ) AS ShopProfit\n" +
            "ORDER BY\n" +
            "    NetProfit DESC;";

    public String Statistici11 = "SELECT TOP 1\n" +
            "    S.Magazin_ID,\n" +
            "    S.Oras,\n" +
            "    COUNT(B.Factura_ID) AS NumberOfFacturi\n" +
            "FROM\n" +
            "    Magazin S\n" +
            "LEFT JOIN\n" +
            "    Factura B ON S.Magazin_ID = B.Magazin_ID\n" +
            "GROUP BY\n" +
            "    S.Magazin_ID, S.Oras\n" +
            "ORDER BY NumberOfFacturi DESC;";

    private String Statistici12 = "SELECT TOP 1 S.Oras, B.Suma_Totala\n" +
            "FROM Factura B\n" +
            "JOIN Magazin S ON B.Magazin_ID = S.Magazin_ID\n" +
            "WHERE B.Suma_Totala = (\n" +
            "    SELECT MAX(Suma_Totala)\n" +
            "    FROM Factura\n" +
            "    WHERE Factura_ID = B.Factura_ID\n" +
            ")ORDER BY Suma_Totala DESC;";

    private String Statistici13 = "SELECT\n" +
            "    SUM(F.Pret * F.Gramaj / 100) AS TotalValue\n" +
            "FROM\n" +
            "    Hrana F\n" +
            "JOIN\n" +
            "    Hrana_Animal D ON F.Hrana_ID = D.Hrana_ID\n" +
            "WHERE D.Disponabilitate_depozit = 'Da';";
    private String Statistici14 = "SELECT S.Denumire_latina, S.Familie\n" +
            "FROM Specie S\n" +
            "JOIN Animal A ON S.Specie_ID = A.Specie_ID\n" +
            "WHERE A.Animal_ID NOT IN (\n" +
            "    SELECT DISTINCT A2.Animal_ID\n" +
            "    FROM Animal A2\n" +
            "    JOIN Hrana_Animal HA ON A2.Animal_ID = HA.Animal_ID\n" +
            ");\n";

    private String Statistici15 = "SELECT TOP 1\n" +
            "    F.Cod_bare,\n" +
            "    F.Data_expirare\n" +
            "FROM\n" +
            "    Hrana F\n" +
            "JOIN\n" +
            "    Hrana_Animal D ON F.Hrana_ID = D.Hrana_ID\n" +
            "\tWHERE D.Disponabilitate_depozit = 'Da'\n" +
            "ORDER BY\n" +
            "    F.Data_expirare ASC;";

    private String Statistici16 = "\tSELECT TOP 1\n" +
            "    S.Denumire_latina,\n" +
            "\tA.Data_nastere\n" +
            "FROM\n" +
            "    Animal A\n" +
            "JOIN\n" +
            "    Hrana_Animal D ON A.Animal_ID = D.Animal_ID\n" +
            "JOIN\n" +
            "    Specie S ON A.Specie_ID = S.Specie_ID\n" +
            "\tWHERE D.Disponabilitate_depozit = 'Nu'\n" +
            "ORDER BY\n" +
            "    A.Data_nastere DESC;";

    private String Statistici17 = "SELECT TOP 1\n" +
            "    COALESCE(\n" +
            "        (SELECT SUM(H.Cantitate) FROM Bon_Hrana H WHERE F.Factura_ID = H.Factura_ID),\n" +
            "        0\n" +
            "    ) AS Sum_Hrana,\n" +
            "    COALESCE(\n" +
            "        (SELECT SUM(A.Cantitate) FROM Bon_Animal A WHERE F.Factura_ID = A.Factura_ID),\n" +
            "        0\n" +
            "    ) AS Sum_Animal,\n" +
            "    COALESCE(\n" +
            "        (SELECT SUM(val) FROM (VALUES (SUM(H.Cantitate)), (SUM(A.Cantitate))) AS value(val)),\n" +
            "        0\n" +
            "    ) AS MaxSum\n" +
            "FROM\n" +
            "    Factura F\n" +
            "    LEFT JOIN Bon_Hrana H ON F.Factura_ID = H.Factura_ID\n" +
            "    LEFT JOIN Bon_Animal A ON F.Factura_ID = A.Factura_ID\n" +
            "GROUP BY\n" +
            "    F.Factura_ID,\n" +
            "    F.Data_emitere,\n" +
            "    F.Suma_Totala\n" +
            "ORDER BY MaxSum DESC;";

    private String Statistici19 = "SELECT SUM(B.Cantitate) AS TotalCantitate\n" +
            "FROM Animal A\n" +
            "JOIN Bon_Animal B ON A.Animal_ID = B.Animal_ID;";

    private String Statistici20 = "SELECT SUM(F.Suma_Totala) AS SumAnimale\n" +
            "FROM Factura F\n" +
            "JOIN Bon_Animal B ON B.Factura_ID = F.Factura_ID\n" +
            "JOIN Animal A ON A.Animal_ID = B.Animal_ID;";
    private Connection conn = null;
    private Statement stmt = null;

    public void initialize() {
        //initializeDB();
        Send.setOnAction(e -> {
            String query = Statistici_txt18.getText().trim();
            try {
                DBUtil.dbExecuteQuery1(query);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Send1.setOnAction(e -> {
            String query = Statistici_txt18.getText().trim();
            try {
                DBUtil.dbExecuteUpdate(query);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });

        Hrana_Search.setOnAction(e -> {
            String query = Search_box.getText().trim();
            if(query == "")
            try {
                searchAllHrana();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
            else
            {
                try {
                    searchHrana();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        initializeHrana();
        initializeMagazin();
        int val = Statistici1(Statistici1);
        Statistici_txt1.setText("Total Net: " + val);
        String[] sir = Statistici11(Statistici11);
        Statistici_txt11.setText("Magazin_ID: " + sir[0] + ",Oras: " + sir[1] + ",NumberOfFacturi: " + sir[2]);
        String[] sir2 = Statistici12(Statistici12);
        Statistici_txt12.setText("Oras: " + sir2[0] + ",Suma_Totala: " + sir2[1]);
        String[] sir4 = Statistici14(Statistici14);
        Statistici_txt14.setText("Denumire_latina: " + sir4[0] + ",Familie: " + sir4[1]);
        String[] sir5 = Statistici15(Statistici15);
        Statistici_txt15.setText("Cod_bare: " + sir5[0] + ",Data_expirare: " + sir5[1]);
        String[] sir6 = Statistici16(Statistici16);
        Statistici_txt16.setText("Denumire_latina: " + sir6[0] + ",Data_nastere: " + sir6[1]);
        String[] sir7 = Statistici17(Statistici17);
        Statistici_txt17.setText("Sum_Hrana: " + sir7[0] + ",Sum_Animal: " + sir7[1] + ",MaxSum: " + sir7[2]);
        int val3 = Statistici13(Statistici13);
        Statistici_txt13.setText("TotalValue: " + val3);
        int val9 = Statistici19(Statistici19);
        Statistici_txt19.setText("TotalCantitate: " + val9);
        int val10 = Statistici20(Statistici20);
        Statistici_txt20.setText("SumAnimale: " + val10);
    }

    public static int Statistici1(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            int colVal = 1;
            while(rez.next())
            {colVal = (int)rez.getDouble("NetProfit");
            rez.close();}
            return colVal;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return 0;
        }
    }

    public static int Statistici13(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            int colVal = 1;
            while(rez.next())
            {colVal = (int)rez.getDouble("TotalValue");
                rez.close();}
            return colVal;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return 0;
        }
    }

    public static int Statistici19(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            int colVal = 1;
            while(rez.next())
            {colVal = (int)rez.getDouble("TotalCantitate");
                rez.close();}
            return colVal;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return 0;
        }
    }

    public static int Statistici20(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            int colVal = 1;
            while(rez.next())
            {colVal = (int)rez.getDouble("SumAnimale");
                rez.close();}
            return colVal;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return 0;
        }
    }

    public static String[] Statistici11(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            String[] sir = new String[3];
            while(rez.next())
            {
                sir[0] = rez.getString("Magazin_ID");
                sir[1] = rez.getString("Oras");
                sir[2] = rez.getString("NumberOfFacturi");
                rez.close();}
            return sir;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return null;
        }
    }

    public static String[] Statistici12(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            String[] sir = new String[2];
            while(rez.next())
            {
                sir[0] = rez.getString("Oras");
                sir[1] = rez.getString("Suma_Totala");
                rez.close();}
            return sir;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return null;
        }
    }

    public static String[] Statistici14(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            String[] sir = new String[2];
            while(rez.next())
            {
                sir[0] = rez.getString("Denumire_latina");
                sir[1] = rez.getString("Familie");
                rez.close();}
            return sir;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return null;
        }
    }

    public static String[] Statistici15(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            String[] sir = new String[2];
            while(rez.next())
            {
                sir[0] = rez.getString("Cod_bare");
                sir[1] = rez.getString("Data_expirare");
                rez.close();}
            return sir;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return null;
        }
    }

    public static String[] Statistici16(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            String[] sir = new String[2];
            while(rez.next())
            {
                sir[0] = rez.getString("Denumire_latina");
                sir[1] = rez.getString("Data_nastere");
                rez.close();}
            return sir;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return null;
        }
    }
    public static String[] Statistici17(String Statistici)
    {
        try {
            ResultSet rez = DBUtil.dbExecuteQuery1(Statistici);
            String[] sir = new String[3];
            while(rez.next())
            {
                sir[0] = rez.getString("Sum_Hrana");
                sir[1] = rez.getString("Sum_Animal");
                sir[2] = rez.getString("MaxSum");
                rez.close();}
            return sir;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.print("Error" + e);
            //throw e;
            return null;
        }
    }
    /*
    private void initializeDB() {
        final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String DB_URL = "jdbc:jtds:sqlserver://localhost:1433/Proiect_Petshop;instance=SQLEXPRESS;";
        final String user = "test";
        final String password = "1234";

        System.out.println("Attempting to connect to the database");
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, user, password);
            stmt = conn.createStatement();
            System.out.println("Successfully connected to the database!");
        } catch (Exception e) {
            e.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        }
    }
    */


    private void loadAnimalTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Animal";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Animal_ID = rs.getInt("Animal_ID");
                int Specie_ID = rs.getInt("Specie_ID");
                Date Data_Nastere = rs.getDate("Data_nastere");
                String Pret = rs.getString("Pret");
                String Sex = rs.getString("Sex");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Search an employee
    @FXML
    private void searchHrana(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Hrana hrana = HranaDAO.searchHrana(Search_box.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowHrana(hrana);
        } catch (SQLException e) {
            e.printStackTrace();
            Hrana_txt.setText("Error occurred while getting hrana information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void searchHrana() throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Hrana hrana = HranaDAO.searchHrana(Search_box.getText());
            //Populate Employee on TableView and Display on TextArea
            populateAndShowHrana(hrana);
        } catch (SQLException e) {
            e.printStackTrace();            Hrana_txt.setText("Error occurred while getting hrana information from DB.\n" + e);
            throw e;
        }
    }

    //Search all employees
    @FXML
    private void searchAllHrana(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Hrana> hranaData = HranaDAO.searchAllHrana();
            //Populate Employees on TableView
            populateAllHrana(hranaData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting all hrana information from DB.\n" + e);
            throw e;
        }
    }

    @FXML
    private void searchAllHrana() throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Hrana> hranaData = HranaDAO.searchAllHrana();
            //Populate Employees on TableView
            populateAllHrana(hranaData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting all hrana information from DB.\n" + e);
            throw e;
        }
    }

    //Initializing the controller class.
//This method is automatically called after the fxml file has been loaded.
    @FXML
    public void initializeHrana() {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */
        Hrana_ID_tbl.setCellValueFactory(cellData -> cellData.getValue().hrana_IDProperty().asObject());
        Hrana_Data_expirare_tbl.setCellValueFactory(cellData -> cellData.getValue().data_expirareProperty());
        Hrana_Pret_tbl.setCellValueFactory(cellData -> cellData.getValue().pretProperty());
        Hrana_Gramaj_tbl.setCellValueFactory(cellData -> cellData.getValue().gramajProperty().asObject());
        Hrana_Cod_bare_tbl.setCellValueFactory(cellData -> cellData.getValue().cod_bareProperty());
    }

    //Populate Employee
    @FXML
    private void populateHrana(Hrana hrana) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Hrana> hranaData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        hranaData.add(hrana);
        //Set items to the employeeTable
        Hrana_table.setItems(hranaData);
    }

    //Set Employee information to Text Area
    @FXML
    private void setHranaInfoToTextArea(Hrana hrana) {
        Hrana_txt.setText("Pret: " + hrana.getPret() + "\n" +
                "Cantitate: " + hrana.getGramaj());
    }

    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowHrana(Hrana hrana) throws ClassNotFoundException {
        if (hrana != null) {
            populateHrana(hrana);
            setHranaInfoToTextArea(hrana);
        } else {
            Hrana_txt.setText("This hrana does not exist!\n");
        }
    }

    //Populate Employees for TableView
    @FXML
    private void populateAllHrana(ObservableList<Hrana> hranaData) throws ClassNotFoundException {
        //Set items to the employeeTable
        Hrana_table.setItems(hranaData);
    }

    /*
    //Update employee's email with the email which is written on newEmailText field
    @FXML
    private void updateHrana (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            HranaDAO.updateEmpEmail(empIdText.getText(),newEmailText.getText());
            Hrana_txt.setText("Hrana has been updated for, hrana id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            Hrana_txt.setText("Problem occurred while updating hrana: " + e);
        }
    }

    //Insert an employee to the DB
    @FXML
    private void insertHrana (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            HranaDAO.insertEmp(nameText.getText(),surnameText.getText(),emailText.getText());
            Hrana_txt.setText("Hrana inserted! \n");
        } catch (SQLException e) {
            Hrana_txt.setText("Problem occurred while inserting hrana " + e);
            throw e;
        }
    }


    //Delete an employee with a given employee Id from DB
    @FXML
    private void deleteHrana (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            HranaDAO.deleteHranaWithCod(empIdText.getText());
            Hrana_txt.setText("Hrana deleted! Hrana id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            Hrana_txt.setText("Problem occurred while deleting hrana " + e);
            throw e;
        }
    }
    */

    //Search an employee
    @FXML
    private void searchMagazine(ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
        try {
            //Get Employee information
            Magazin magazin = MagazinDAO.searchMagazin(Integer.parseInt(Search_box1.getText()));
            //Populate Employee on TableView and Display on TextArea
            populateAndShowMagazin(magazin);
        } catch (SQLException e) {
            e.printStackTrace();
            Hrana_txt.setText("Error occurred while getting magazin information from DB.\n" + e);
            throw e;
        }
    }

    //Search all employees
    @FXML
    private void searchAllMagazin(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Magazin> magazinData = MagazinDAO.searchAllMagazin();
            //Populate Employees on TableView
            populateAllMagazin(magazinData);
        } catch (SQLException e) {
            System.out.println("Error occurred while getting all magazin information from DB.\n" + e);
            throw e;
        }
    }

    //Initializing the controller class.
//This method is automatically called after the fxml file has been loaded.
    @FXML
    public void initializeMagazin() {
        /*
        The setCellValueFactory(...) that we set on the table columns are used to determine
        which field inside the Employee objects should be used for the particular column.
        The arrow -> indicates that we're using a Java 8 feature called Lambdas.
        (Another option would be to use a PropertyValueFactory, but this is not type-safe

        We're only using StringProperty values for our table columns in this example.
        When you want to use IntegerProperty or DoubleProperty, the setCellValueFactory(...)
        must have an additional asObject():
        */
        Magazine_ID_tbl.setCellValueFactory(cellData -> cellData.getValue().magazin_IDProperty().asObject());
        Magazine_Judet_tbl.setCellValueFactory(cellData -> cellData.getValue().judetProperty());
        Magazine_Oras_tbl.setCellValueFactory(cellData -> cellData.getValue().orasProperty());
        Magazine_Strada_tbl.setCellValueFactory(cellData -> cellData.getValue().stradaProperty());
        Magazine_Numar_tbl.setCellValueFactory(cellData -> cellData.getValue().numarProperty());
        Magazine_Data_deschidere_tbl.setCellValueFactory(cellData -> cellData.getValue().data_deschidereProperty());
        Magazine_Chirie_luna_tbl.setCellValueFactory(cellData -> cellData.getValue().chirie_lunaProperty());
    }

    //Populate Employee
    @FXML
    private void populateMagazin(Magazin magazin) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Magazin> magazinData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        magazinData.add(magazin);
        //Set items to the employeeTable
        Magazine_table.setItems(magazinData);
    }

    //Set Employee information to Text Area
    @FXML
    private void setMagazinInfoToTextArea(Magazin magazin) {
        Hrana_txt.setText("Judet: " + magazin.getJudet() + "\n" +
                "Oras: " + magazin.getOras());
    }

    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowMagazin(Magazin magazin) throws ClassNotFoundException {
        if (magazin != null) {
            populateMagazin(magazin);
            setMagazinInfoToTextArea(magazin);
        } else {
            Hrana_txt.setText("This magazin does not exist!\n");
        }
    }

    //Populate Employees for TableView
    @FXML
    private void populateAllMagazin(ObservableList<Magazin> magazinData) throws ClassNotFoundException {
        //Set items to the employeeTable
        Magazine_table.setItems(magazinData);
    }

    /*
    //Update employee's email with the email which is written on newEmailText field
    @FXML
    private void updateMagazin (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            MagazinDAO.updateEmpEmail(empIdText.getText(),newEmailText.getText());
            Magazine_txt.setText("Magazin has been updated for, magazin id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            Magazine_txt.setText("Problem occurred while updating magazin: " + e);
        }
    }

    //Insert an employee to the DB
    @FXML
    private void insertMagazin (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            MagazinDAO.insertEmp(nameText.getText(),surnameText.getText(),emailText.getText());
            Magazine_txt.setText("Magazin inserted! \n");
        } catch (SQLException e) {
            Magazine_txt.setText("Problem occurred while inserting magazin " + e);
            throw e;
        }
    }


    //Delete an employee with a given employee Id from DB
    @FXML
    private void deleteMagazin (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            MagazinDAO.deleteHranaWithCod(empIdText.getText());
            Magazine_txt.setText("Magazin deleted! Magazin id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            Magazine_txt.setText("Problem occurred while deleting magazin " + e);
            throw e;
        }
    }
    */

}









































































/*
    private void loadSpecieTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Specie";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Specie_ID = rs.getInt("Specie_ID");
                String Latina = rs.getString("Denumire_latina");
                String Familie = rs.getString("Familie");
                }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadHranaAnimalTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Hrana_Animal";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Animal_ID = rs.getInt("Animal_ID");
                int Hrana_ID = rs.getInt("Hrana_ID");
                String Depozit = rs.getString("Disponabilitate_depozit");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadHranaTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Hrana";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Hrana_ID = rs.getInt("Hrana_ID");
                String Data_Expirare = rs.Calendar.get("Data_expirare");
                String Pret = rs.getString("tyres");
                double Gramaj = rs.getDouble("numgears");
                String Cod_Bare = rs.getString("Cod_bare");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadBonAnimalTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Bon_Animal";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Factura_ID = rs.getInt("Factura_ID");
                int Animal_ID = rs.getInt("Animal_ID");
                int Cantitate = rs.getInt("Cantitate");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private void loadBonHranaTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Bon_Hrana";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Factura_ID = rs.getInt("Factura_ID");
                int Hrana_ID = rs.getInt("Hrana_ID");
                int Cantitate = rs.getInt("Cantitate");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAnimalTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Animal";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Animal_ID = rs.getInt("Animal_ID");
                int Specie_ID = rs.getInt("Specie_ID");
                String Data_Nastere = rs.Calendar.get("Data_nastere");
                String Pret = rs.getString("tyres");
                String seatType = rs.getString("seattype");
                int numGears = rs.getInt("numgears");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAnimalTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Animal";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Animal_ID = rs.getInt("Animal_ID");
                int Specie_ID = rs.getInt("Specie_ID");
                String Data_Nastere = rs.Calendar.get("Data_nastere");
                String Pret = rs.getString("tyres");
                String seatType = rs.getString("seattype");
                int numGears = rs.getInt("numgears");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAnimalTable() {
        System.out.println("Ceva");

        try {
            String sql = "SELECT * FROM Animal";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int Animal_ID = rs.getInt("Animal_ID");
                int Specie_ID = rs.getInt("Specie_ID");
                String Data_Nastere = rs.Calendar.get("Data_nastere");
                String Pret = rs.getString("tyres");
                String seatType = rs.getString("seattype");
                int numGears = rs.getInt("numgears");
            }
            rs.close();
        } catch (SQLException se) {
            se.printStackTrace();
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

 */



