package controller.school;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import db.DBConnection;
import dbController.SchoolController;
import Model.School;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import dbController.StudentController;




public class SchoolInfoController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private JFXTextField clmSchoolAddress;
    @FXML
    private JFXTextField clmClasses;
    @FXML
    private JFXTextField clmSchoolType;
    @FXML
    private JFXTextField clmExamID;
    @FXML
    private JFXTextField clmPostalCode;
    @FXML
    private JFXTextField clmProvince;
    @FXML
    private JFXTextField clmPrincipal;
    @FXML
    private JFXTextField clmEduZone;
    @FXML
    private JFXDatePicker clmEstablished;
    @FXML
    private JFXTextField clmID;
    @FXML
    private JFXTextField clmPrincipalNumber;
    @FXML
    private JFXTextField clmEmail;
    @FXML
    private JFXTextField clmID1;
    @FXML
    private JFXTextField clmID2;
    @FXML
    private JFXTextField clmID3;
    @FXML
    private JFXTextField clmSchoolName;
    @FXML
    private JFXTextField clmTotalStaff;
    @FXML
    private JFXTextField clmTotalStudent;
    @FXML
    private JFXTextField clmLandArea;
    @FXML
    private JFXTextField clmLocation;
    @FXML
    private JFXTextField clmState;
    @FXML
    private JFXTextField clmPoliceArea;
    @FXML
    private JFXTextField clmMunicipal;
    @FXML
    private JFXTextField clmEduDistrict;
    @FXML
    private JFXTextField clmAdminDistrict;
    @FXML
    private JFXTextField clmSchoolID;
    @FXML
    private JFXTextField clmLGA;
    @FXML
    private JFXTextField clmPMB;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            School s = SchoolController.schoolInfo();
            if (s != null) {
                clmSchoolName.setText(s.getSchoolName());
                clmSchoolAddress.setText(s.getSchoolAddress());
                clmClasses.setText(s.getClassAvailable());
                clmSchoolType.setText(s.getSchoolType());
                clmEduZone.setText(s.getEducationalZone());
                clmEduDistrict.setText(s.getEducationalDistrict());
                clmAdminDistrict.setText(s.getAdministrativeDistrict());
                clmMunicipal.setText(s.getMunicipal());
                clmPoliceArea.setText(s.getPoliceArea());
                clmState.setText(s.getTotalStaff());
                clmLocation.setText(s.getLocation());
                clmPMB.setText(s.getPmb());
                clmEstablished.setValue(LocalDate.parse(s.getDateEstablished()));
                clmPostalCode.setText(s.getPostalCode());
                clmSchoolID.setText(s.getSchoolID());
                clmExamID.setText(s.getSchoolExamID());
                clmProvince.setText(s.getProvince());
                clmEmail.setText(s.getEmail());
                clmPrincipal.setText(s.getPrincipalName());
                clmPrincipalNumber.setText(s.getPrincipalNo());
                clmLandArea.setText(s.getTotalLandArea());
                clmTotalStudent.setText(s.getTotalStudent());
                clmTotalStaff.setText(s.getTotalStaff());
                clmLGA.setText(s.getLga());


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("No Information Found..!");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private AnchorPane root;


    void addDetails(ActionEvent event) {            //This Method Button Removed Due to Unwanted

        String SchoolName = clmSchoolName.getText();
        String SchoolAddress = clmSchoolAddress.getText();
        String classAvailable = clmClasses.getText();
        String schoolType = clmSchoolType.getText();
        String educationalZone = clmEduZone.getText();
        String educationalDistrict = clmEduDistrict.getText();
        String adminDistrict = clmAdminDistrict.getText();
        String municipal = clmMunicipal.getText();
        String policeArea = clmPoliceArea.getText();
        String state = clmState.getText();
        String location = clmLocation.getText();
        String pmb = clmPMB.getText();
        String dateEstablished = String.valueOf(clmEstablished.getValue());
        String postalCode = clmPostalCode.getText();
        String schoolID = clmSchoolID.getText();
        String schoolExamID = clmExamID.getText();
        String province = clmProvince.getText();
        String email = clmEmail.getText();
        String principalName = clmPrincipal.getText();
        String principalNo = clmPrincipalNumber.getText();
        String totalLandArea = clmLandArea.getText();
        String totalStudent = clmTotalStudent.getText();
        String totalStaff = clmTotalStaff.getText();
        String lga = clmLGA.getText();


        School sch = new School(SchoolName, SchoolAddress, classAvailable, schoolType, educationalZone, educationalDistrict, adminDistrict,
                municipal, policeArea, state, location, pmb, dateEstablished, postalCode, schoolID,
                schoolExamID, province, email, principalName, principalNo, totalLandArea, totalStudent, totalStaff, lga);
        int i = 0;
        try {
            i = SchoolController.AddDetails(sch);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (i > 0) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("School Information");
            alert.setHeaderText(null);
            alert.setContentText("Updated Successfully");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("School Information");
            alert.setHeaderText(null);
            alert.setContentText("OOPs there is an error in Updating Details..!");
            alert.showAndWait();
        }


    }



    void printDetails(ActionEvent event) {

        try {
            Connection conn = DBConnection.getConnection();
            InputStream report = getClass().getResourceAsStream("/Reports/SchoolInfo.jrxml");
            JasperDesign jd = JRXmlLoader.load(report);
            JRDesignQuery query = new JRDesignQuery();
            query.setText("select * from schoolinfo");
            jd.setQuery(query);
            ReportViewController r = new ReportViewController();
            r.viewReport(jd);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }

    void updateDetails(ActionEvent event) {
        try {
            String SchoolName = clmSchoolName.getText();
            String SchoolAddress = clmSchoolAddress.getText();
            String classAvailable = clmClasses.getText();
            String schoolType = clmSchoolType.getText();
            String educationalZone = clmEduZone.getText();
            String educationalDistrict = clmEduDistrict.getText();
            String adminDistrict = clmAdminDistrict.getText();
            String municipal = clmMunicipal.getText();
            String policeArea = clmPoliceArea.getText();
            String state = clmState.getText();
            String location = clmLocation.getText();
            String pmb = clmPMB.getText();
            String dateEstablished = String.valueOf(clmEstablished.getValue());
            String postalCode = clmPostalCode.getText();
            String schoolID = clmSchoolID.getText();
            String schoolExamID = clmExamID.getText();
            String province = clmProvince.getText();
            String email = clmEmail.getText();
            String principalName = clmPrincipal.getText();
            String principalNo = clmPrincipalNumber.getText();
            String totalLandArea = clmLandArea.getText();
            String totalStudent = clmTotalStudent.getText();
            String totalStaff = clmTotalStaff.getText();
            String lga = clmLGA.getText();

            School sch = new School(SchoolName, SchoolAddress, classAvailable, schoolType, educationalZone, educationalDistrict, adminDistrict,
                    municipal, policeArea, state, location, pmb, dateEstablished, postalCode, schoolID,
            schoolExamID, province, email, principalName, principalNo, totalLandArea, totalStudent, totalStaff, lga);
            int i = SchoolController.updateInfo(sch);

            if (i > 0) {

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("Information Updated Successfully...!");
                alert.showAndWait();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("School Information");
                alert.setHeaderText(null);
                alert.setContentText("OOPs there is an error Updating Details");
                alert.showAndWait();
            }

        }catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(SchoolController.class.getName()).log(Level.SEVERE, null, ex);
    }

    }

    @FXML
    private void btnBackHomeOnAction(ActionEvent event) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("/View/Home.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(home));
    }

    @FXML
    private void btnPrint(ActionEvent event) {
    }

    @FXML
    private void btnUpdate(ActionEvent event) {
    }

    @FXML
    private void btnAdd(ActionEvent event) {
    }
}
