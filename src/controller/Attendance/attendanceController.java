/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Attendance;

import Model.Attendance;
import Model.Staff;
import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import controller.ReportViewController;
import db.DBConnection;
import dbController.AttendanceController;
import dbController.StaffController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import static dbController.StaffController.updateOldStaff;
import static dbController.StaffController.updateStaff;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class attendanceController implements Initializable {

    private ComboBox<String> loadClasses;
    @FXML
    private TableView<Attendance> tableView;
    @FXML
    private TableColumn<Attendance, String> clmID1;
    @FXML
    private TableColumn<Attendance, String> clmID;
    @FXML
    private TableColumn<Attendance, String> clmName;


    ObservableList<Attendance> oblist = FXCollections.observableArrayList();

    ObservableList<String> list = FXCollections.observableArrayList("Mechanical Repair", "PanelBeating", "Painting", "PanelBeating & Painting");
    private TableColumn<Attendance, Integer> clmTotalDays;
    @FXML
    private Button btnBack;
    @FXML
    private TextField searchVehicle;
    @FXML
    private TableColumn<Attendance, String> clmVName;
    @FXML
    private TableColumn<Attendance, String> clmMaker;
    @FXML
    private TableColumn<Attendance, String> clmModel;
    @FXML
    private TableColumn<Attendance, String> clmBody;
    @FXML
    private TableColumn<Attendance, String> clmVIN;
    @FXML
    private TableColumn<Attendance, String> clmMileage;
    @FXML
    private TableColumn<Attendance, String> clmCauses;
    @FXML
    private TableColumn<Attendance, String> clmInterior;
    @FXML
    private TableColumn<Attendance, String> clmExterior;
    @FXML
    private TableColumn<Attendance, String> clmDate;
    @FXML
    private Button move;
    @FXML
    private Button print;
    @FXML
    private Button update;
    @FXML
    private TableColumn<Attendance, String> clmRepairType;
    @FXML
    private TableColumn<Attendance, String> clmRemark;
    @FXML
    private Button add;
    @FXML
    private Button print2;
    @FXML
    private Button delete;
    @FXML
    private JFXTextField fieldID;
    @FXML
    private JFXTextField fieldVName;
    @FXML
    private JFXTextField fieldVIN;
    @FXML
    private JFXTextField fieldMileage;
    @FXML
    private JFXTextField fieldBody;
    @FXML
    private JFXTextField fieldInterior;
    @FXML
    private JFXTextField fieldCauses;
    @FXML
    private JFXTextField fieldModel;
    @FXML
    private JFXTextField fieldExterior;
    @FXML
    private JFXTextField fieldName;
    @FXML
    private JFXTextField fieldMaker;
    @FXML
    private JFXDatePicker fieldDate;
    @FXML
    private JFXComboBox<String> fieldType;
    @FXML
    private JFXTextArea fieldRemark;
    @FXML
    private TextField fieldSearch;
    @FXML
    private Button btnSearchVehicle;
    @FXML
    private Button invoice;

    /**
     * Initializes t    @FXML
    private Button move1;
he controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldType.setItems(list);






























        try {
            Connection conn = DBConnection.getDBConnection().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        ResultSet resultSet = null;
        try {
            resultSet = conn.createStatement ().executeQuery ("SELECT * FROM inventory");
        } catch (SQLException e) {
            e.printStackTrace ();
        }

        try {
            while (resultSet.next ()) {
                oblist.addAll (new Attendance (
                        resultSet.getInt ("id"),
                        resultSet.getString ("vname"),
                        resultSet.getString ("name"),
                        resultSet.getString ("maker"),
                        resultSet.getInt ("model"),
                        resultSet.getString ("body"),
                        resultSet.getString ("VIN"),
                        resultSet.getInt ("mileage"),
                        resultSet.getString ("date"),
                        resultSet.getString ("causes"),
                        resultSet.getString ("type"),
                        resultSet.getString ("interior"),
                        resultSet.getString ("exterior"),
                        resultSet.getString ("remark")
                ));


                clmID.setCellValueFactory (new PropertyValueFactory<> ("id"));
                clmVName.setCellValueFactory (new PropertyValueFactory<> ("vname"));
                clmName.setCellValueFactory (new PropertyValueFactory<> ("name"));
                clmMaker.setCellValueFactory (new PropertyValueFactory<> ("maker"));
                clmModel.setCellValueFactory (new PropertyValueFactory<> ("model"));
                clmBody.setCellValueFactory (new PropertyValueFactory<> ("body"));
                clmVIN.setCellValueFactory (new PropertyValueFactory<> ("VIN"));
                clmMileage.setCellValueFactory (new PropertyValueFactory<> ("mileage"));
                clmDate.setCellValueFactory (new PropertyValueFactory<> ("date"));
                clmCauses.setCellValueFactory (new PropertyValueFactory<> ("causes"));
                clmRepairType.setCellValueFactory (new PropertyValueFactory<> ("type"));
                clmInterior.setCellValueFactory (new PropertyValueFactory<> ("interior"));
                clmExterior.setCellValueFactory (new PropertyValueFactory<> ("exterior"));
                clmRemark.setCellValueFactory (new PropertyValueFactory<> ("remark"));

                tableView.setItems (oblist);

            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }






    @FXML
    private void btnMove(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/MoveVehicle.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }

    @FXML
    private void btnPrint(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/PrintInventory.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));

        new Pulse (home).play ();

    }


    @FXML
    private void btnUpdate(ActionEvent event) {

    }


    @FXML
    private void btnAdd(ActionEvent event) {


    }

    @FXML
    private void btnPrint2(ActionEvent event) {


        String id = clmID.getText ();

        InputStream report1 = getClass ().getResourceAsStream ("/Reports/StaffInfo.jrxml");
        InputStream report2 = getClass ().getResourceAsStream ("/Reports/StaffInfoPast.jrxml");

        JRDesignQuery query = new JRDesignQuery ();


        JasperDesign jd = null;
        try {
            jd = JRXmlLoader.load (report1);
        } catch (JRException e) {
            e.printStackTrace ();
        }
        query.setText ("select * from staffs where id = '" + id + "'");
        jd.setQuery (query);
        ReportViewController r1 = new ReportViewController ();
        r1.viewReport (jd);


        JasperDesign jd2 = null;
        try {
            jd2 = JRXmlLoader.load (report2);
        } catch (JRException e) {
            e.printStackTrace ();
        }
        query.setText ("select * from oldstaffs where id = '" + id + "'");
        jd2.setQuery (query);
        ReportViewController r2 = new ReportViewController ();
        r2.viewReport (jd2);

    }

    @FXML
    private void btnDelete(ActionEvent event) {

    }

    @FXML
    private void btnFieldSearch(ActionEvent event) {
        try {

            int id = Integer.parseInt(fieldSearch.getText());
            Attendance s = AttendanceController.searchVehicle (id);
            if (s != null) {
                fieldID.setText(String.valueOf(s.getId()));
                fieldVName.setText(s.getVname ());
                fieldName.setText(s.getName ());
                fieldMaker.setText (s.getMaker ());
                fieldModel.setText (String.valueOf (s.getModel ()));
                fieldBody.setText (s.getBody ());
                fieldVIN.setText(s.getVIN ());
                fieldMileage.setText(String.valueOf (s.getMileage ()));
                fieldDate.setValue (LocalDate.parse (s.getDate ()));
                fieldCauses.setText(s.getCauses ());
                fieldType.setValue (s.getType ());
                fieldInterior.setText(s.getInterior ());
                fieldExterior.setText(s.getExterior ());
                fieldRemark.setText(s.getRemark ());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Staff Search");
                alert.setHeaderText(null);
                alert.setContentText("Staff Not Found");
                alert.showAndWait();

                fieldID.setText(null);
                fieldVName.setText(null);
                fieldName.setText(null);
                fieldMaker.setText (null);
                fieldModel.setText(null);
                fieldBody.setText(null);
                fieldVIN.setText (null);
                fieldMileage.setText (null);
                fieldDate.setValue (null);
                fieldCauses.setText(null);
                fieldType.setValue (null);
                fieldInterior.setText(null);
                fieldExterior.setText(null);
                fieldRemark.setText(null);
                fieldSearch.setText(null);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }


    }

    @FXML
    private void btnSearchVehicle(ActionEvent event) {

        String vname = ((searchVehicle.getText ()));
        Attendance a = null;
        try {

            a = AttendanceController.searchVehicleByName (vname);




        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        if (a != null) {
            clmID.setText(String.valueOf(a.getId()));
            clmVName.setText(a.getVname ());
            clmName.setText(a.getName ());
            clmMaker.setText (a.getMaker ());
            clmModel.setText (String.valueOf (a.getModel ()));
            clmBody.setText (a.getBody ());
            clmVIN.setText(a.getVIN ());
            clmMileage.setText(String.valueOf (a.getMileage ()));
            clmDate.setText  (a.getDate ());
            clmCauses.setText(a.getCauses ());
            clmRepairType.setText (a.getType ());
            clmInterior.setText(a.getInterior ());
            clmExterior.setText(a.getExterior ());
            clmRemark.setText(a.getRemark ());

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vehicle Name not found");
            alert.show();
        }


        int id = Integer.parseInt (((searchVehicle.getText ())));
        Attendance s = null;
        try {
            s = AttendanceController.searchVehicle (id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        if (s != null) {
            clmID.setText(String.valueOf(s.getId()));
            clmVName.setText(s.getVname ());
            clmName.setText(s.getName ());
            clmMaker.setText (s.getMaker ());
            clmModel.setText (String.valueOf (s.getModel ()));
            clmBody.setText (s.getBody ());
            clmVIN.setText(s.getVIN ());
            clmMileage.setText(String.valueOf (s.getMileage ()));
            clmDate.setText  (s.getDate ());
            clmCauses.setText(s.getCauses ());
            clmRepairType.setText (s.getType ());
            clmInterior.setText(s.getInterior ());
            clmExterior.setText(s.getExterior ());
            clmRemark.setText(s.getRemark ());


        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Vehicle ID not found");
            alert.show();
        }

    }

    @FXML
    private void btnInvoice(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/Invoice.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }


}

    
