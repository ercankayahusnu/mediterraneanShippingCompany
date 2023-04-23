package controller;

import dao.BrandDAO;
import entity.Brand;
import entity.Country;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "brandBean")
@SessionScoped
public class BrandBean implements Serializable {

    private Brand entity;
    private BrandDAO dao;
    private List<Brand> list;
//sayfalama değişkenleri
    private int page = 1;//bulunduğumuz sayfa
    private int pageSize = 4;//kaç tane veri gösterecez    
    private int pageCount;//sayfa sayısı
    private List<Brand> list2;

    public BrandBean() {

    }

    public void clearForm() {
        this.entity = new Brand();
    }

    public void create() {
        this.getDao().BrandDAO(entity);
        this.entity = new Brand();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Brand();
    }

    public void delete(Brand c) {
        this.getDao().delete(c);
        this.entity = new Brand();
    }

    public Brand getEntity() {
        if (this.entity == null) {
            this.entity = new Brand();
        }
        return entity;
    }

    public void setEntity(Brand entity) {
        this.entity = entity;
    }

    public BrandDAO getDao() {
        if (this.dao == null) {
            this.dao = new BrandDAO();
        }
        return dao;
    }

    public void setDao(BrandDAO dao) {
        this.dao = dao;
    }

    public List<Brand> getList() {
        this.list = this.getDao().getCategoryList();
        return list;
    }

    public void setList(List<Brand> list) {
        this.list = list;
    }

    //Kullanıcı sayfalama methotları
    public List<Brand> getList2() {
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
