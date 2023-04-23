/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.EmployeeDAO;
import entity.Employee;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author husam
 */
@FacesConverter("employeeShip")
public class ShipConverter implements Converter {

    private EmployeeDAO emloyeedao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        Employee employee = this.getEmloyeedao().findbyID(string);
        return employee;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Employee e = (Employee) t;
        return e.getEmployee_id();

    }

    public EmployeeDAO getEmloyeedao() {
        if (this.emloyeedao == null) {
            this.emloyeedao = new EmployeeDAO();
        }

        return emloyeedao;
    }

    public void setEmloyeedao(EmployeeDAO emloyeedao) {
        this.emloyeedao = emloyeedao;
    }

}
