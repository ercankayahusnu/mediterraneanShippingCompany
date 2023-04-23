package dao;

import entity.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class EmployeeDAO extends DBConnection {

    public void EmployeeDAO(Employee c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into employee(employee_id,employee_name,date_of_birth,address,jop_position,phone_number,travel_time,contract_duration,wage) values( '" + c.getEmployee_id() + "', '" + c.getEmploye_name() + "', '" + c.getDate_of_birth() + "','" + c.getAddress() + "', '" + c.getJop_position() + "', '" + c.getPhone_number() + "', '" + c.getTravel_time() + "', '" + c.getContract_duration() + "','" + c.getWage() + "');  ";
            int r = st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Employee findbyID(String id) {

        Employee c = null;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from employee where employee_id='" + id + "' ";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                c = new Employee(rs.getString("employee_id"), rs.getString("employee_name"), rs.getString("date_of_birth"), rs.getString("address"), rs.getString("jop_position"), rs.getString("phone_number"), rs.getString("travel_time"), rs.getString("contract_duration"), rs.getString("wage"));

            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return c;

    }

    public void update(Employee c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update employee set employee_name='" + c.getEmploye_name() + "', date_of_birth='" + c.getDate_of_birth() + "',address='" + c.getAddress() + "',jop_position='" + c.getJop_position() + "', phone_number='" + c.getPhone_number() + "',travel_time='" + c.getPhone_number() + "',contract_duration='" + c.getContract_duration() + "',wage='" + c.getWage() + "' where employee.employee_id='" + c.getEmployee_id() + "';            ";
            int r = st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Employee c) {

        try {
            Statement st = this.getConnection().createStatement();
            String query2 = "delete from employee where employee_id='" + c.getEmployee_id() + "'";
            int r = st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Employee> getCategoryList() {

        List<Employee> EmployeeList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from employee ";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                EmployeeList.add(new Employee(rs.getString("employee_id"), rs.getString("employee_name"), rs.getString("date_of_birth"), rs.getString("address"), rs.getString("jop_position"), rs.getString("phone_number"), rs.getString("travel_time"), rs.getString("contract_duration"), rs.getString("wage")));//Değişkenler Veri tablosundaki sütun iismlerle aynı olacak
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return EmployeeList;
    }

    public List<Employee> getCategoryList2(int page, int pageSize) {

        List<Employee> EmployeeList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from employee order by employee_id asc limit " + pageSize + " offset " + start + " ";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                EmployeeList.add(new Employee(rs.getString("employee_id"), rs.getString("employee_name"), rs.getString("date_of_birth"), rs.getString("address"), rs.getString("jop_position"), rs.getString("phone_number"), rs.getString("travel_time"), rs.getString("contract_duration"), rs.getString("wage")));//Değişkenler Veri tablosundaki sütun iismlerle aynı olacak
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return EmployeeList;
    }

    public int count() {
        int count = 0;

        try {
            //PreparedStatement pst= this.getConnection().prepareStatement("select count(country_id) as country_count from country");
            Statement st = this.getConnection().createStatement();

            String query = "select count(employee_id) as country_count from employee  ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("country_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return count;

    }
}
