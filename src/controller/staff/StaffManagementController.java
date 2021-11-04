package controller.staff;

import Model.Staff;
import animatefx.animation.Pulse;
import db.TableSchema;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tableModel.StaffTableModel;




public class StaffManagementController implements Initializable {



    @FXML
    private TableView<Staff> tableView;

    @FXML
    private TableColumn<Staff, Integer> clmID;

    @FXML
    private TableColumn<Staff, String> clmStaffName;
    @FXML
    private TableColumn<Staff, String> clmClasses;
    @FXML
    private TableColumn<Staff, String> clmGender;
    @FXML
    private TableColumn<Staff, String> clmDOB;
    @FXML
    private TableColumn<Staff, String> clmHired;
    @FXML
    private TableColumn<Staff, String> clmDepartment;
    @FXML
    private TableColumn<Staff, String> clmPosition;
    @FXML
    private TableColumn<Staff, String> clmDegree;
    @FXML
    private TableColumn<Staff, String> clmSalary;
    @FXML
    private TableColumn<Staff, String> clmContact;
    @FXML
    private TableColumn<Staff, String> clmEmail;
    @FXML
    private TableColumn<Staff, String> clmAddress;
    @FXML
    private TableColumn<Staff, String> clmState;


    ObservableList<Staff> staffList = FXCollections.observableArrayList();
    @FXML
    private Button btnBack;
    @FXML
    private Button btnAddStaff;
    @FXML
    private Button btnPrintStaff;
    @FXML
    private Button moveStaff;
    @FXML
    private TableColumn<?, ?> clmID1;
    @FXML
    private JFXDatePicker date;
    @FXML
    private ComboBox<?> selectClasses;
    @FXML
    private JFXTextField studNo;
    @FXML
    private JFXTextField studName;
    @FXML
    private ComboBox<?> selectTerm;
    @FXML
    private ComboBox<?> loadAttendance;
    @FXML
    private JFXTextField totPresent;
    @FXML
    private JFXTextField totDays;
    @FXML
    private JFXTextField totPresent1;
    @FXML
    private JFXTextField totPresent2;
    @FXML
    private JFXTextField totPresent3;
    @FXML
    private JFXTextField studNo1;
    @FXML
    private TextField EmpNo;
    @FXML
    private Button searchStaff;
    @FXML
    private Button update;
    @FXML
    private Button update2;
    @FXML
    private Button update11;
    @FXML
    private TextField searchVehicle;
    @FXML
    private Button btnSearch;
    @FXML
    private Button btnBack1;

    @FXML
    private void searchStaff(ActionEvent event) {
    }

    @FXML
    private void update(ActionEvent event) {
    }



    public  class SimpleDateFormat{


        public SimpleDateFormat(String s) {
        }

        public void main(String[]args) {
            Date date = new Date();

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {



        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
            ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM staffs");

            while (resultSet.next()) {
                staffList.addAll(new Staff(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("classes"),
                        resultSet.getString("gender"),
                        resultSet.getString("dob"),
                        resultSet.getString("hired"),
                        resultSet.getString("position"),
                        resultSet.getString("department"),
                        resultSet.getString("degree"),
                        resultSet.getString("salary"),
                        resultSet.getString("contact"),
                        resultSet.getString("email"),
                        resultSet.getString("address"),
                        resultSet.getString("state")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }


        clmID.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmStaffName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmClasses.setCellValueFactory(new PropertyValueFactory<>("classes"));
        clmGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        clmDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        clmHired.setCellValueFactory(new PropertyValueFactory<>("hired"));
        clmPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        clmDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        clmDegree.setCellValueFactory(new PropertyValueFactory<>("degree"));
        clmSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        clmEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmState.setCellValueFactory(new PropertyValueFactory<>("state"));


        tableView.setItems(staffList);


    }



    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();
    }

    @FXML
    private void addStaffOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/addStaff.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    private void manageStaffOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/ManageStaffs.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }



    @FXML
    private void printStaffOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/PrintStaffs.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

    }


    @FXML
    private void btnMoveStaff(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Staff/MoveStaff.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }


}
