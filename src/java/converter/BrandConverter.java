/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.CountryDAO;
import entity.Country;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author husam
 */
@FacesConverter("countryBrand")
public class BrandConverter implements Converter {

    private CountryDAO countryDAO;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Country country = this.getCountryDAO().findbyID(string);//bean den xhtmle 
        return country;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Country c = (Country) t;
        return c.getCountry_id();
    }

    public CountryDAO getCountryDAO() {
        if (countryDAO == null) {
            this.countryDAO = new CountryDAO();
        }
        return countryDAO;
    }

    public void setCountryDAO(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

}
