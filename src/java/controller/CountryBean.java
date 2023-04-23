package controller;

import dao.CountryDAO;
import entity.Country;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "countryBean")
@SessionScoped
public class CountryBean implements Serializable {

    private Country entity;
    private CountryDAO dao;
    private List<Country> list;
    private List<Country> list2;
    //sayfalama değişkenleri
    private int page = 1;//bulunduğumuz sayfa
    private int pageSize = 4;//kaç tane veri gösterecez    
    private int pageCount;//sayfa sayısı

    public CountryBean() {
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public void clearForm(){
        this.entity = new Country();
    }
    public void create() {
        this.getDao().CountryDAO(entity);
        this.entity = new Country();
    }

    public void delete(Country c) {
        this.getDao().delete(c);
        this.entity = new Country();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Country();
    }

    public Country getEntity() {
        if (this.entity == null) {
            this.entity = new Country();
        }
        return entity;
    }

    public CountryDAO getDao() {
        if (this.dao == null) {
            this.dao = new CountryDAO();
        }
        return dao;
    }

    public List<Country> getList() {

        // this.list = this.getDao().findAll(page, pageSize);
        this.list = this.getDao().getCategoryList();
        return list;
    }
     //Kullanıcı sayfalama methotları

    public List<Country> getList2() {
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

    public void setEntity(Country entity) {
        this.entity = entity;
    }

    public void setList(List<Country> list) {
        this.list = list;
    }

    public void setList2(List<Country> list2) {
        this.list2 = list2;
    }

    public void setDao(CountryDAO dao) {
        this.dao = dao;
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
