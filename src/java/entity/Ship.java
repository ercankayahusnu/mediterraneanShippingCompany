package entity;

public class Ship {

    private String ship_id;
    private Employee employee;
    private String ship_name;
    private String dimension;
    private String production_date;
    private String capacity;

    public Ship() {

    }

    public Ship(String ship_id, Employee employee_id, String ship_name, String dimension, String production_date, String capacity) {
        this.ship_id = ship_id;
        this.employee = employee_id;
        this.ship_name = ship_name;
        this.dimension = dimension;
        this.production_date = production_date;
        this.capacity = capacity;
    }

    public String getShip_id() {
        return ship_id;
    }

    public void setShip_id(String ship_id) {
        this.ship_id = ship_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getShip_name() {
        return ship_name;
    }

    public void setShip_name(String ship_name) {
        this.ship_name = ship_name;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

}
