/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animatefx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class HomeController implements Initializable {

    @FXML
    private AnchorPane homePane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnDashboard(ActionEvent event)throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Dashboard/Dashboard.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Flip (home).play ();
    }

   
 

    @FXML
    private void btnStaff(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/staff/StaffManagement.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new RotateIn (home).play ();
    }




    @FXML
    private void btnAdmin(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Portal/adminPortal/UserAccount.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new ZoomIn (home).play ();
    }

    

    @FXML
    private void btnEvent(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Management/event.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new RotateInUpLeft (home).play ();
    }

    @FXML
    private void btnAttendance(ActionEvent event)  throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/attendance.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new FadeInDown (home).play ();
    }

    @FXML
    private void btnDepartment(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Inventory/inventory.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new SlideInDown (home).play ();
    }
    
}
