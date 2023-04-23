package entity;

public class Harbor {

    private String harbor_id;
    private Country country;
    private String harbor_name;
    private String contract_dates;
    private String contract_duration;

    public Harbor() {

    }

    public Harbor(String harbor_id, Country country, String harbor_name, String contract_dates, String contract_duration) {
        this.harbor_id = harbor_id;
        this.country = country;
        this.harbor_name = harbor_name;
        this.contract_dates = contract_dates;
        this.contract_duration = contract_duration;
    }

    public String getHarbor_id() {
        return harbor_id;
    }

    public void setHarbor_id(String harbor_id) {
        this.harbor_id = harbor_id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getHarbor_name() {
        return harbor_name;
    }

    public void setHarbor_name(String harbor_name) {
        this.harbor_name = harbor_name;
    }

    public String getContract_dates() {
        return contract_dates;
    }

    public void setContract_dates(String contract_Dates) {
        this.contract_dates = contract_Dates;
    }

    public String getContract_duration() {
        return contract_duration;
    }

    public void setContract_duration(String contract_Duration) {
        this.contract_duration = contract_Duration;
    }

    @Override
    public String toString() {
        return "Harbor{" + "harbor_id=" + harbor_id + ", country=" + country + ", harbor_name=" + harbor_name + ", contract_dates=" + contract_dates + ", contract_duration=" + contract_duration + '}';
    }

}
