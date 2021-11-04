package tableModel;


import javafx.collections.ObservableList;

import java.time.LocalDate;

public class StudentTableModel {

    int id;
    String vname;
    String name;
    String maker;
    int model;
    String body;
    String VIN;
    int mileage;
    String date;
    String causes;
    String type;
    String interior;
    String exterior;
    String remark;


    public StudentTableModel(int id, String vname, String name, String maker, int model, String body, String VIN, int mileage, String date, String causes, String type, String interior, String exterior, String remark) {
        this.id = id;
        this.vname = vname;
        this.name = name;
        this.maker = maker;
        this.model = model;
        this.body = body;
        this.VIN = VIN;
        this.mileage = mileage;
        this.date = date;
        this.causes = causes;
        this.type = type;
        this.interior = interior;
        this.exterior = exterior;
        this.remark = remark;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVname() {
        return this.vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaker() {
        return this.maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getModel() {
        return this.model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getVIN() {
        return this.VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCauses() {
        return this.causes;
    }

    public void setCauses(String causes) {
        this.causes = causes;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInterior() {
        return this.interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getExterior() {
        return this.exterior;
    }

    public void setExterior(String exterior) {
        this.exterior = exterior;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
