package dao;

import entity.Brand;
import entity.Country;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class BrandDAO extends DBConnection {

    private CountryDAO countryDao;

    public void BrandDAO(Brand c) {
        try {

            Statement st = this.getConnection().createStatement();

            String query = "insert into brand (brand_id, brand_name, contract_dates, contract_duration) values('" + c.getBrand_id() + "','" + c.getBrand_name() + "', '" + c.getContract_Dates() + "', '" + c.getContract_Duration() + "')";

            st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ

            ResultSet rs = st.executeQuery("select max(brand_id) as mid from brand ");
            rs.next();

            String brand_id = rs.getString("mid");

            for (Country co : c.getCountryies()) {
                query = "insert into brand_country (brand_id,country_id) values (" + brand_id + "," + co.getCountry_id() + "";
                st.executeUpdate(query);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void update(Brand c) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "update brand set brand_name='" + c.getBrand_name() + "',contract_dates='" + c.getContract_Dates() + "', contract_duration='" + c.getContract_Duration() + "'   where brand_id='" + c.getBrand_id() + "' ";
            st.executeUpdate(query);  //OLUSTURMA İSLEMLERİ

//            st.executeUpdate("delete from brand_country where brand_id='" + c.getBrand_id() + "' ");
//
//            for (Country co : c.getCountryies()) {
//                query = "insert into brand_country (brand_id,country_id) values (" + c.getBrand_id() + "," + co.getCountry_id() + "";
//                st.executeUpdate(query);
//            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void delete(Brand c) {

        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from brand where brand_id='" + c.getBrand_id() + "'";
            st.executeUpdate(query);
            String query2 = "delete from brand_country  where brand_id='" + c.getBrand_id() + "'";
            st.executeUpdate(query2);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Brand> getCategoryList() {

        List<Brand> categoryList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from brand order by brand_id ";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                categoryList.add(new Brand(rs.getString("brand_id"), this.getBrandCountryies(rs.getString("brand_id")), rs.getString("brand_name"), rs.getString("contract_Dates"), rs.getString("contract_Duration")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;
    }

    public List<Country> getBrandCountryies(String brand_id) {
        List<Country> categoryList = new ArrayList<>();

        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from country where country_id in (select country_id from brand_country where brand_id='" + brand_id + "'); ";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                categoryList.add(new Country(rs.getString("country_id"), rs.getString("country_name")));
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return categoryList;

    }

    public CountryDAO getCountryDao() {
        if (this.countryDao == null) {
            this.countryDao = new CountryDAO();
        }
        return countryDao;
    }

    public void setCountryDao(CountryDAO countryDao) {
        this.countryDao = countryDao;
    }



    public List<Brand> getCategoryList2(int page, int pageSize) {

        List<Brand> categoryList = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();

            String query = "select * from brand order by brand_id asc limit " + pageSize + " offset " + start + " ";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                categoryList.add(new Brand(rs.getString("brand_id"), this.getBrandCountryies(rs.getString("brand_id")), rs.getString("brand_name"), rs.getString("contract_Dates"), rs.getString("contract_Duration")));
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

            String query = "select count(brand_id) as country_count from brand  ";

            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("country_count");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return count;

    }

}
