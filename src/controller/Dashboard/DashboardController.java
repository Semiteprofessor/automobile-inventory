/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Dashboard;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Model.Staff;
import animatefx.animation.Pulse;
import db.DBConnection;
import db.TableSchema;
import dbController.AttendanceController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import dbController.StaffController;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane dashboard;
    private PieChart pieChart;
    @FXML
    private Text lblTotalStudents;
    @FXML
    private Text lblTotalStaff;
    private Text lblTotalCLasses;
    private Text lblTotalSubject;
    @FXML
    private LineChart<String, Double> chartView;
    @FXML
    private PieChart PieChart;
    private BarChart<String, Double> BarChart;
    @FXML
    private StackedBarChart<String, Double> StackedBar;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        ObservableList<PieChart.Data>piechartdata;

        piechartdata  = FXCollections.observableArrayList();

        ArrayList<Integer> cell = new ArrayList<Integer> ();
        ArrayList<String> name = new ArrayList<String> ();


        LineChart.Series<String, Double> series = new LineChart.Series<> ();
        StackedBarChart.Series<String, Double> series1 = new StackedBarChart.Series<> ();


        try {


            Connection conn = DBConnection.getDBConnection ().getConnection ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        Connection conn = null;
        try {
            conn = DBConnection.getDBConnection ().getConnection ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SQLException e) {
            e.printStackTrace ();
        }
        ResultSet resultSet = null;

        try {
            resultSet = conn.createStatement ().executeQuery ("SELECT vname, mileage FROM inventory ORDER BY mileage ");


            while (resultSet.next ()) {
                series.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                series1.getData ().add (new XYChart.Data<> (resultSet.getString (1), resultSet.getDouble (2)));
                chartView.getData ().add (series);
                StackedBar.getData ().add (series1);

                piechartdata.add (new PieChart.Data (resultSet.getString (1), resultSet.getInt (2)));
                name.add (resultSet.getString (1));
                cell.add (resultSet.getInt (2));

                PieChart.setData (piechartdata);
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }


        // if((loadGrades != null)&&(loadGender != null)){






        try {
            lblTotalStudents.setText(String.valueOf(AttendanceController.totalInventory ()));
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
        try {
            lblTotalStaff.setText(String.valueOf(StaffController.totalStaff()));
        } catch (SQLException e) {
            e.printStackTrace ();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }



    }



    private void max(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setFullScreenExitHint(" ");
        stage.setFullScreen(true);

    }

    private void min(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setIconified(true);

    }

    private void close(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }


    double x = 0, y = 0;

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();

    }


    @FXML
    private void dragged(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setX(event.getSceneX() - x);
        stage.setY(event.getSceneY() - y);

    }







        private void loadChart()
        {

            PieChart.Data slice1 = new PieChart.Data("Classes", 213);
            PieChart.Data slice2 = new PieChart.Data("Attendance"  , 67);
            PieChart.Data slice3 = new PieChart.Data("Teachers" , 36);

            pieChart.getData().add(slice1);
            pieChart.getData().add(slice2);
            pieChart.getData().add(slice3);

        }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));

        new Pulse (home).play ();

    }






}