/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Hercankaya
 */
@Named
@SessionScoped
public class TestBean implements Serializable {

    private String username;
    private String password;

    public TestBean() {
    }

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {

        String v = (String) value;

        if (v.isEmpty()) {

            throw new ValidatorException(new FacesMessage("Şifre boş olamaz "));
        } else if (v.length() < 7) {

            throw new ValidatorException(new FacesMessage("Şifre alanı 8 karakterden az  olamaz "));
        }

        return true;
    }

    public void register() {
        System.out.println("-----------------------REGISTER--------------");
        
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
