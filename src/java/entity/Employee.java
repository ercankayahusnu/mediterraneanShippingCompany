package entity;

import java.util.Objects;

public class Employee {

    private String employee_id;
    private String employe_name;
    private String date_of_birth;
    private String address;
    private String jop_position;
    private String phone_number;
    private String travel_time;
    private String contract_duration;
    private String wage;

    public Employee() {
    }

    public Employee(String employee_id, String name, String date_of_birth, String address, String jop_position, String phone_number, String travel_time, String contract_duration, String wage) {
        this.employee_id = employee_id;
        this.employe_name = name;
        this.date_of_birth = date_of_birth;
        this.address = address;
        this.jop_position = jop_position;
        this.phone_number = phone_number;
        this.travel_time = travel_time;
        this.contract_duration = contract_duration;
        this.wage = wage;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmploye_name() {
        return employe_name;
    }

    public void setEmploye_name(String name) {
        this.employe_name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJop_position() {
        return jop_position;
    }

    public void setJop_position(String jop_position) {
        this.jop_position = jop_position;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getTravel_time() {
        return travel_time;
    }

    public void setTravel_time(String travel_time) {
        this.travel_time = travel_time;
    }

    public String getContract_duration() {
        return contract_duration;
    }

    public void setContract_duration(String contract_duration) {
        this.contract_duration = contract_duration;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" + "employee_id=" + employee_id + ", name=" + employe_name + ", date_of_birth=" + date_of_birth + ", address=" + address + ", jop_position=" + jop_position + ", phone_number=" + phone_number + ", travel_time=" + travel_time + ", contract_duration=" + contract_duration + ", wage=" + wage + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.employee_id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        return Objects.equals(this.employee_id, other.employee_id);
    }

}
