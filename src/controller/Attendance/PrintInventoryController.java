/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Attendance;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import Model.Attendance;
import Model.Staff;
import controller.ReportViewController;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import tableModel.StaffTableModel;

/**
 * FXML Controller class
 *
 * @author GeoCodec
 */
public class PrintInventoryController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button printStaff;
    @FXML
    private Button generate;
    @FXML
    private ComboBox<String> Type;
    @FXML
    private TableView<Attendance> tableView;
    @FXML
    private TableColumn<Attendance, String> clmID1;
    @FXML
    private TableColumn<Attendance, Integer> clmID;
    @FXML
    private TableColumn<Attendance, String> clmVName;
    @FXML
    private TableColumn<Attendance, String> clmName;
    @FXML
    private TableColumn<Attendance, String> clmMaker;
    @FXML
    private TableColumn<Attendance, Integer> clmModel;
    @FXML
    private TableColumn<Attendance, String> clmBody;
    @FXML
    private TableColumn<Attendance, String> clmVIN;
    @FXML
    private TableColumn<Attendance, Integer> clmMileage;
    @FXML
    private TableColumn<Attendance, String> clmDate;
    @FXML
    private TableColumn<Attendance, String> clmCauses;
    @FXML
    private TableColumn<Attendance, String> clmRepairType;
    @FXML
    private TableColumn<Attendance, String> clmInterior;
    @FXML
    private TableColumn<Attendance, String> clmExterior;
    @FXML
    private TableColumn<Attendance, String> clmRemark;



    ObservableList<Attendance> Inventory = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Type.getItems().addAll("Current Vehicle", "Left Vehicle");
    }




    @FXML
    void Type(ActionEvent event) {

    }
    //Below code for On key press methods..

    /*@FXML
    void gen(KeyEvent event){
        generate.setOnKeyTyped((e)->{
            if (e.getCode() == KeyCode.G){
                generate();
            }
        });
    }*/

    @FXML
    void generate() {

        try{
            Type.getItems().clear();
            String type = Type.getValue();

            Connection conn = DBConnection.getDBConnection().getConnection();



            if (type == "Current Vehicle") {


                String sql = "select * from inventory";
                ResultSet rs = conn.createStatement().executeQuery(sql);


                while (rs.next ()) {
                    Attendance attendance = new Attendance (
                            rs.getInt ("id"),
                            rs.getString ("vname"),
                            rs.getString ("name"),
                            rs.getString ("maker"),
                            rs.getInt ("model"),
                            rs.getString ("body"),
                            rs.getString ("VIN"),
                            rs.getInt ("mileage"),
                            rs.getString ("date"),
                            rs.getString ("causes"),
                            rs.getString ("type"),
                            rs.getString ("interior"),
                            rs.getString ("exterior"),
                            rs.getString ("remark"));

                    Inventory.add(attendance);
                }
            }
            else if (type == "Left Vehicle"){

                String sql = "select * from leftvehicle";
                ResultSet rs = conn.createStatement().executeQuery(sql);


                while (rs.next ()) {
                    Attendance attendance = new Attendance (
                            rs.getInt ("id"),
                            rs.getString ("vname"),
                            rs.getString ("name"),
                            rs.getString ("maker"),
                            rs.getInt ("model"),
                            rs.getString ("body"),
                            rs.getString ("VIN"),
                            rs.getInt ("mileage"),
                            rs.getString ("date"),
                            rs.getString ("causes"),
                            rs.getString ("type"),
                            rs.getString ("interior"),
                            rs.getString ("exterior"),
                            rs.getString ("remark"));

                    Inventory.add(attendance);
                }
            }
            //Ctrl+D for copy above line
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

            tableView.setItems(Inventory);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }



    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/attendance.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene (home));
    }

    private void printStudents(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Attendance/PrintVehicle.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void printStaff(ActionEvent event) throws SQLException {

        tableView.getItems().clear();
        String type = Type.getValue();

        try {

            Connection conn = DBConnection.getDBConnection().getConnection();

            InputStream report1 = getClass().getResourceAsStream("/Reports/StaffList.jrxml");
            InputStream report2 = getClass().getResourceAsStream("/Reports/StaffListPast.jrxml");

            JRDesignQuery query = new JRDesignQuery();

            /*HashMap<String,Object> Logo = new HashMap<String, Object>();

            URL url = this.getClass().getClassLoader().getResource("Images/dp.png");
            Logo.put("logo", url);*/

            if (type == "Current Staffs"){

                JasperDesign jd = JRXmlLoader.load(report1);
                query.setText("select * from staffs");
                jd.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd);
            }
            else {

                JasperDesign jd2 = JRXmlLoader.load(report2);
                query.setText("select * from oldstaffs");
                jd2.setQuery(query);
                ReportViewController r = new ReportViewController();
                r.viewReport(jd2);
            }
        } catch (JRException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace ();
        }
    }

}