package dao;

import entity.Country;
import entity.Harbor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class HarborDAO extends DBConnection {

    private CountryDAO countryDAO;

    public void HarborDAO(Harbor c) {
        try {

            Statement st = this.getConnection().createStatement();

            String query = "insert into harbor (harbor_id, country_id, harbor_name, contract_dates, contract_duration) values('" + c.getHarbor_id() + "','" + c.getCountry().getCountry_id() + "', '" + c.getHarbor_name() + "', '" + c.getContract_dates() + "', '" + c.getContract_duration() + "')";//BURDAKİ İSİSMLER PGADMİNDEKİ  TABLO SÜTUNLARIYLA AYNI OLMAK ZORUNDA c.get******** de classtaki değişkenlelerle atyynı olmak zorunda

            int r = st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Harbor c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update harbor set country_id='" + c.getCountry().getCountry_id() + "',harbor_name='" + c.getHarbor_name() + "',contract_dates='" + c.getContract_dates() + "', contract_duration='" + c.getContract_duration() + "'   where harbor_id='" + c.getHarbor_id() + "' ";
            int r = st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Harbor c) {

        try {
            Statement st = this.getConnection().createStatement();
            String query2 = "delete from harbor where harbor_id='" + c.getHarbor_id() + "'";
            int r = st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Harbor> getCategoryList() {

        List<Harbor> categoryList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from harbor order by harbor_id";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Country c = this.getCountryDAO().findbyID(rs.getString("country_id"));

                categoryList.add(new Harbor(rs.getString("harbor_id"), c, rs.getString("harbor_name"), rs.getString("contract_Dates"), rs.getString("contract_Duration")));///BURDAKİ İSİSMLER PGADMİNDEKİ  TABLO SÜTUNLARIYLA AYNI OLMAK ZORUNDA
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;
    }

    public CountryDAO getCountryDAO() {
        if (this.countryDAO == null) {
            this.countryDAO = new CountryDAO();
        }
        return countryDAO;
    }

    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }
    
    
    
    public List<Harbor> getCategoryList2(int page, int pageSize) {

        List<Harbor> categoryList = new ArrayList<>();
int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from harbor order by harbor_id asc limit " + pageSize + " offset " + start + " ";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Country c = this.getCountryDAO().findbyID(rs.getString("country_id"));

                categoryList.add(new Harbor(rs.getString("harbor_id"), c, rs.getString("harbor_name"), rs.getString("contract_Dates"), rs.getString("contract_Duration")));///BURDAKİ İSİSMLER PGADMİNDEKİ  TABLO SÜTUNLARIYLA AYNI OLMAK ZORUNDA
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

            String query = "select count(harbor_id) as country_count from harbor  ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("country_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return count;

    }

}
