package controller;

import dao.EmployeeDAO;
import entity.Employee;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

    private Employee entity;
    private EmployeeDAO dao;
    private List<Employee> list;
//sayfalama değişkenleri
    private int page = 1;//bulunduğumuz sayfa
    private int pageSize = 4;//kaç tane veri gösterecez    
    private int pageCount;//sayfa sayısı
    private List<Employee> list2;

    public EmployeeBean() {
    }
    public void clearForm(){
        this.entity = new Employee();
    }

    public void create() {
        this.getDao().EmployeeDAO(entity);//gelen Employee nesnesini EmployeeDAO sınıfındaki constructor methoduna yollar
        this.entity = new Employee();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Employee();
    }

    public void delete(Employee c) {//gelen Employee nesnesini EmployeeDAO sınıfındaki delete methoduna yollar
        this.getDao().delete(c);
        this.entity = new Employee();
    }

    public Employee getEntity() {
        if (this.entity == null) {
            this.entity = new Employee();
        }
        return entity;
    }

    public void setEntity(Employee entity) {
        this.entity = entity;
    }

    public EmployeeDAO getDao() {
        if (this.dao == null) {
            this.dao = new EmployeeDAO();
        }
        return dao;
    }

    public void setDao(EmployeeDAO dao) {
        this.dao = dao;
    }

    public List<Employee> getList() {
        this.list = this.getDao().getCategoryList();
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    //Kullanıcı sayfalama methotları
    public List<Employee> getList2() {
        this.list2 = this.getDao().getCategoryList2(page, pageSize);

        //this.list = this.getDao().getCategoryList();
        return list2;
    }

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }

    }

    public void prevois() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }

    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

}
