package packWork;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;

/**
 * Created by ONUR BASKIRT on 23.02.2016.
 */
public class HranaController {

    @FXML
    private TextField Search_box;
    @FXML
    private TextField Hrana_txt;
    @FXML
    private TableView Hrana_table;
    @FXML
    private TableColumn<Hrana, Integer>  Hrana_ID_tbl;
    @FXML
    private TableColumn<Hrana, Date>  Hrana_Data_expirare_tbl;
    @FXML
    private TableColumn<Hrana, BigDecimal> Hrana_Pret_tbl;
    @FXML
    private TableColumn<Hrana, Double> Hrana_Gramaj_tbl;
    @FXML
    private TableColumn<Hrana, String> Hrana_Cod_bare_tbl;


    //Search an employee
    @FXML
    private void searchHrana (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
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

    //Search all employees
    @FXML
    private void searchAllHrana(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            //Get all Employees information
            ObservableList<Hrana> hranaData = HranaDAO.searchAllHrana();
            //Populate Employees on TableView
            populateAllHrana(hranaData);
        } catch (SQLException e){
            System.out.println("Error occurred while getting all hrana information from DB.\n" + e);
            throw e;
        }
    }

    //Initializing the controller class.
    //This method is automatically called after the fxml file has been loaded.
    @FXML
    public void initialize () {
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
    private void populateHrana (Hrana hrana) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<Hrana> hranaData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        hranaData.add(hrana);
        //Set items to the employeeTable
        Hrana_table.setItems(hranaData);
    }

    //Set Employee information to Text Area
    @FXML
    private void setHranaInfoToTextArea (Hrana hrana) {
        Hrana_txt.setText("First Name: " + hrana.getPret() + "\n" +
                "Last Name: " + hrana.getGramaj());
    }

    //Populate Employee for TableView and Display Employee on TextArea
    @FXML
    private void populateAndShowHrana(Hrana hrana) throws ClassNotFoundException {
        if (hrana != null) {
            populateHrana(hrana);
            setHranaInfoToTextArea(hrana);
        } else {
            Hrana_txt.setText("This employee does not exist!\n");
        }
    }

    //Populate Employees for TableView
    @FXML
    private void populateAllHrana (ObservableList<Hrana> hranaData) throws ClassNotFoundException {
        //Set items to the employeeTable
        Hrana_table.setItems(hranaData);
    }

    /*
    //Update employee's email with the email which is written on newEmailText field
    @FXML
    private void updateEmployeeEmail (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.updateEmpEmail(empIdText.getText(),newEmailText.getText());
            resultArea.setText("Email has been updated for, employee id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while updating email: " + e);
        }
    }

    //Insert an employee to the DB
    @FXML
    private void insertEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.insertEmp(nameText.getText(),surnameText.getText(),emailText.getText());
            resultArea.setText("Employee inserted! \n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while inserting employee " + e);
            throw e;
        }
    }

    //Delete an employee with a given employee Id from DB
    @FXML
    private void deleteEmployee (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            EmployeeDAO.deleteEmpWithId(empIdText.getText());
            resultArea.setText("Employee deleted! Employee id: " + empIdText.getText() + "\n");
        } catch (SQLException e) {
            resultArea.setText("Problem occurred while deleting employee " + e);
            throw e;
        }
    }
    */
}