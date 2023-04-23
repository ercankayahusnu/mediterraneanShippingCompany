package controller;

import dao.ShipDAO;
import entity.Ship;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "shipBean")
@SessionScoped

public class ShipBean implements Serializable {

    private Ship entity;
    private ShipDAO dao;
    private List<Ship> list;
//sayfalama değişkenleri
    private int page = 1;//bulunduğumuz sayfa
    private int pageSize = 4;//kaç tane veri gösterecez    
    private int pageCount;//sayfa sayısı
    private List<Ship> list2;

    public ShipBean() {

    }
    public void clearForm(){
        this.entity = new Ship();
    }

    public void create() {
        this.getDao().ShipDAO(entity);
        this.entity = new Ship();

    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Ship();
    }

    public void delete(Ship c) {
        this.getDao().delete(c);
        this.entity = new Ship();
    }

    public Ship getEntity() {
        if (this.entity == null) {
            this.entity = new Ship();
        }
        return entity;
    }

    public void setEntity(Ship entity) {
        this.entity = entity;
    }

    public ShipDAO getDao() {
        if (this.dao == null) {
            this.dao = new ShipDAO();
        }
        return dao;
    }

    public void setDao(ShipDAO dao) {
        this.dao = dao;
    }

    public List<Ship> getList() {
        this.list = this.getDao().getCategoryList();
        return list;
    }

    public void setList(List<Ship> list) {
        this.list = list;
    }
    //Kullanıcı sayfalama methotları

    public List<Ship> getList2() {
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
