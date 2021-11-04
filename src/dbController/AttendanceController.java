package dbController;


import Model.Attendance;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendanceController {


    public static int AddVehicle(Attendance attendance)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO inventory VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, attendance.getId());
        stm.setObject(2, attendance.getVname ());
        stm.setObject(3, attendance.getName ());
        stm.setObject(4, attendance.getMaker ());
        stm.setObject(5, attendance.getModel ());
        stm.setObject(6, attendance.getBody ());
        stm.setObject(7, attendance.getVIN ());
        stm.setObject(8, attendance.getMileage ());
        stm.setObject(9, attendance.getDate ());
        stm.setObject(10, attendance.getCauses ());
        stm.setObject(11, attendance.getType ());
        stm.setObject(12, attendance.getInterior ());
        stm.setObject(13, attendance.getExterior ());
        stm.setObject(14, attendance.getRemark ());


        return  stm.executeUpdate();
    }



    public static Attendance searchVehicle(Integer id) throws ClassNotFoundException,SQLException {
        String sql = "SELECT * FROM inventory WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Attendance s=new Attendance (rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt (5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getInt (8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14));
            return s;
        }
        return null;
    }


    public static Attendance searchVehicleByName(String name) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM inventory WHERE name LIKE '%"+name+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        // stm.setObject(1, name);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Attendance student = new Attendance (rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt (5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getInt (8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14));
            return student;
        }
        return null;
    }

    public static Attendance searchPastVehicle(Integer id) throws ClassNotFoundException,SQLException {
        String sql = "SELECT * FROM leftvehicle WHERE id = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, id);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Attendance s=new Attendance (rst.getInt(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getInt (5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getInt (8),
                    rst.getString(9),
                    rst.getString(10),
                    rst.getString(11),
                    rst.getString(12),
                    rst.getString(13),
                    rst.getString(14));

            return s;
        }
        return null;
    }

    public static int deleteVehicle(Integer id) throws ClassNotFoundException,SQLException {

        String sql = "DELETE FROM inventory WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return Integer.parseInt (null);
    }

    public static int deleteLeftVehicle(Integer id) throws ClassNotFoundException,SQLException {

        String sql = "DELETE FROM leftvehicle WHERE id ='"+id+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);


        return  stm.executeUpdate();
    }

    public static int moveVehicle(Attendance attendance) throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO leftvehicle VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, attendance.getId());
        stm.setObject(2, attendance.getVname ());
        stm.setObject(3, attendance.getName ());
        stm.setObject(4, attendance.getMaker ());
        stm.setObject(5, attendance.getModel ());
        stm.setObject(6, attendance.getBody ());
        stm.setObject(7, attendance.getVIN ());
        stm.setObject(8, attendance.getMileage ());
        stm.setObject(9, attendance.getDate ());
        stm.setObject(10, attendance.getCauses ());
        stm.setObject(11, attendance.getType ());
        stm.setObject(12, attendance.getInterior ());
        stm.setObject(13, attendance.getExterior ());
        stm.setObject(14, attendance.getRemark ());

        return  stm.executeUpdate();
    }

    public static int updateVehicle(Attendance attendance) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE inventory SET id= ? ,vname= ? ,name= ? ,maker= ? ,model= ? ,body= ? ,VIN=? ,mileage= ? ,date= ? ,causes= ? ,type=? ,interior=? ,exterior=? ,remark=? WHERE id= '" +attendance.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, attendance.getId());
        stm.setObject(2, attendance.getVname ());
        stm.setObject(3, attendance.getName ());
        stm.setObject(4, attendance.getMaker ());
        stm.setObject(5, attendance.getModel ());
        stm.setObject(6, attendance.getBody ());
        stm.setObject(7, attendance.getVIN ());
        stm.setObject(8, attendance.getMileage ());
        stm.setObject(9, attendance.getDate ());
        stm.setObject(10, attendance.getCauses ());
        stm.setObject(11, attendance.getType ());
        stm.setObject(12, attendance.getInterior ());
        stm.setObject(13, attendance.getExterior ());
        stm.setObject(14, attendance.getRemark ());

        return  stm.executeUpdate();
    }

    public static int updateLeftVehicle(Attendance attendance) throws ClassNotFoundException,SQLException {
        String sql = "UPDATE leftvehicle SET id= ? ,vname= ? ,name= ? ,maker= ? ,model= ? ,body= ? ,VIN=? ,mileage= ? ,date= ? ,causes= ? ,type=? ,interior=? ,exterior=? ,remark=? WHERE id= '" +attendance.getId()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, attendance.getId());
        stm.setObject(2, attendance.getVname ());
        stm.setObject(3, attendance.getName ());
        stm.setObject(4, attendance.getMaker ());
        stm.setObject(5, attendance.getModel ());
        stm.setObject(6, attendance.getBody ());
        stm.setObject(7, attendance.getVIN ());
        stm.setObject(8, attendance.getMileage ());
        stm.setObject(9, attendance.getDate ());
        stm.setObject(10, attendance.getCauses ());
        stm.setObject(11, attendance.getType ());
        stm.setObject(12, attendance.getInterior ());
        stm.setObject(13, attendance.getExterior ());
        stm.setObject(14, attendance.getRemark ());

        return  stm.executeUpdate();
    }


    public static int totalInventory() throws SQLException, ClassNotFoundException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = null;
        ResultSet resultSet = null;
        int total = 0;

        try {
            stm = conn.prepareStatement("SELECT COUNT(id) FROM inventory");
            resultSet = stm.executeQuery();

            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }

            resultSet.close();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  total;
    }




}
