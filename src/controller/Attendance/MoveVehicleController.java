/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Attendance;

import animatefx.animation.Pulse;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class MoveVehicleController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXButton Back;
    @FXML
    private JFXTextField clmStaffName;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmSalary;
    @FXML
    private JFXTextField clmContact;
    @FXML
    private JFXTextField clmAddress;
    @FXML
    private JFXTextField clmState;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmEmail;
    @FXML
    private JFXComboBox<String> clmGender;
    @FXML
    private JFXTextField clmDegree;
    @FXML
    private JFXDatePicker clmDOB;
    @FXML
    private JFXDatePicker clmHired;
    @FXML
    private JFXTextField clmDepartment;
    @FXML
    private JFXTextField clmPosition;
    @FXML
    private Button move;
    @FXML
    private TextField EmpNo;
    @FXML
    private TextField empName;
    @FXML
    private Button searchStaff;
    @FXML
    private Button searchByName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/attendance.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));

        new Pulse (home).play ();
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
    }

    @FXML
    private void Back(ActionEvent event) {
    }

    @FXML
    private void btnMoveStaff(ActionEvent event) {
    }

    @FXML
    private void searchStaff(ActionEvent event) {
    }

    @FXML
    private void searchByName(ActionEvent event) {
    }
    
}
