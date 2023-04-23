
package entity;

public class Company {
    private String company_id;
    private String ship_id;
     private String country_id;
      private String company_name;
    private String company_type;
    private String founder;
    private String year_of_foundation;

    public Company() {
    }

    public Company(String company_id, String ship_id, String country_id, String company_name, String company_type, String founder, String year_of_foundation) {
        this.company_id = company_id;
        this.ship_id = ship_id;
        this.country_id = country_id;
        this.company_name = company_name;
        this.company_type = company_type;
        this.founder = founder;
        this.year_of_foundation = year_of_foundation;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getShip_id() {
        return ship_id;
    }

    public void setShip_id(String ship_id) {
        this.ship_id = ship_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public void setCountry_id(String country_id) {
        this.country_id = country_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getYear_of_foundation() {
        return year_of_foundation;
    }

    public void setYear_of_foundation(String year_of_foundation) {
        this.year_of_foundation = year_of_foundation;
    }
    
    
}
