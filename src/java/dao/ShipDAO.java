package dao;

import entity.Employee;
import entity.Ship;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class ShipDAO extends DBConnection {

    private EmployeeDAO emloyedao;

    public void ShipDAO(Ship c) {
        try {

            Statement st = this.getConnection().createStatement();

            String query = "insert into ship (ship_id,employee_id, ship_name, dimension ,production_date,capacity) values('" + c.getShip_id() + "','" + c.getEmployee().getEmployee_id() + "', '" + c.getShip_name() + "', '" + c.getDimension() + "', "
                    + "'" + c.getProduction_date() + "' ,'" + c.getCapacity() + "')";

            int r = st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Ship c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update ship set employee_id='" + c.getEmployee().getEmployee_id() + "',ship_name='" + c.getShip_name() + "' ,dimension='" + c.getDimension() + "',production_date='" + c.getProduction_date() + "', capacity='" + c.getCapacity() + "'where ship_id='" + c.getShip_id() + "' ";
            int r = st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Ship c) {

        try {
            Statement st = this.getConnection().createStatement();
            String query2 = "delete from ship where ship_id='" + c.getShip_id() + "'";
            int r = st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Ship> getCategoryList() {

        List<Ship> categoryList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from ship order by ship_id";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Employee c = this.getEmloyedao().findbyID("employee_id");
                categoryList.add(new Ship(rs.getString("ship_id"), c, rs.getString("ship_name"), rs.getString("dimension"), rs.getString("production_date"), rs.getString("capacity")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;
    }

    public EmployeeDAO getEmloyedao() {
        if (this.emloyedao == null) {
            this.emloyedao = new EmployeeDAO();
        }
        return emloyedao;
    }

    public void setEmloyedao(EmployeeDAO emloyedao) {
        this.emloyedao = emloyedao;
    }

    public List<Ship> getCategoryList2(int page, int pageSize) {

        List<Ship> categoryList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from ship order by ship_id asc limit " + pageSize + " offset " + start + "";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Employee c = this.getEmloyedao().findbyID("employee_id");
                categoryList.add(new Ship(rs.getString("ship_id"), c, rs.getString("ship_name"), rs.getString("dimension"), rs.getString("production_date"), rs.getString("capacity")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;
    }

    public int count() {
        int count = 0;

        try {
            //PreparedStatement pst= this.getConnection().prepareStatement("select count(country_id) as country_count from country");
            Statement st = this.getConnection().createStatement();

            String query = "select count(ship_id) as country_count from ship  ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("country_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return count;

    }

}
