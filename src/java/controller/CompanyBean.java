package controller;

import dao.CompanyDAO;
import entity.Company;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "companyBean")
@SessionScoped
public class CompanyBean implements Serializable {

    private Company entity;
    private CompanyDAO dao;
    private List<Company> list;
//sayfalama değişkenleri
    private int page = 1;//bulunduğumuz sayfa
    private int pageSize = 4;//kaç tane veri gösterecez    
    private int pageCount;//sayfa sayısı
     private List<Company> list2;
    public CompanyBean() {
    }
    public void clearForm(){
        this.entity = new Company();
    }

    public void create() {
        this.getDao().CompanyDAO(entity);//gelen Company nesnesini companyDAO sınıfındaki constructor methoduna yollar
        this.entity = new Company();
    }

    public void update() {
        this.getDao().update(entity);//gelen Company nesnesini companyDAO sınıfındaki constructor methoduna yollar
        this.entity = new Company();
    }

    public void delete(Company c) {//gelen Company nesnesini companyDAO sınıfındaki delete methoduna yollar
        this.getDao().delete(c);
        this.entity = new Company();
    }

    public Company getEntity() {
        if (this.entity == null) {
            this.entity = new Company();
        }
        return entity;
    }

    public void setEntity(Company entity) {
        this.entity = entity;
    }

    public CompanyDAO getDao() {
        if (this.dao == null) {
            this.dao = new CompanyDAO();
        }
        return dao;
    }

    public void setDao(CompanyDAO dao) {
        this.dao = dao;
    }

    public List<Company> getList() {
        this.list = this.getDao().getCategoryList();
        return list;
    }

    public void setList(List<Company> list) {
        this.list = list;
    }
    
        public List<Company> getList2() {
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
     //Kullanıcı sayfalama methotları
    
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
