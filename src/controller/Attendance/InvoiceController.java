/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Attendance;

import animatefx.animation.Pulse;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class InvoiceController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private Button printReportCard;
    @FXML
    private Button updateReportCard;
    @FXML
    private JFXTextField clmGradingPeriod;
    @FXML
    private JFXTextField clmGradingPeriod1;
    @FXML
    private JFXTextField clmGradingPeriod2;
    @FXML
    private JFXTextField clmGradingPeriod11;
    @FXML
    private JFXTextField clmGradingPeriod12;
    @FXML
    private JFXTextField clmGradingPeriod3;
    @FXML
    private JFXTextField clmGradingPeriod31;
    @FXML
    private JFXTextField clmGradingPeriod32;
    @FXML
    private JFXTextField clmGradingPeriod311;
    @FXML
    private JFXTextField clmGradingPeriod21;
    @FXML
    private JFXTextField clmGradingPeriod33;
    @FXML
    private JFXTextField clmGradingPeriod331;
    @FXML
    private JFXTextField clmGradingPeriod332;
    @FXML
    private JFXTextField clmGradingPeriod3311;
    @FXML
    private JFXTextField clmGradingPeriod333;
    @FXML
    private JFXTextField clmGradingPeriod3312;
    @FXML
    private JFXTextField clmGradingPeriod3321;
    @FXML
    private JFXTextField clmGradingPeriod33111;
    @FXML
    private JFXTextField clmGradingPeriod3331;
    @FXML
    private JFXTextField clmGradingPeriod33121;
    @FXML
    private JFXTextField clmGradingPeriod33211;
    @FXML
    private JFXTextField clmGradingPeriod331111;
    @FXML
    private JFXTextField clmGradingPeriod3311111;

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
    private void printReportCard(ActionEvent event) {
    }

    @FXML
    private void updateReportCard(ActionEvent event) {
    }
    
}
