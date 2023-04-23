package controller;

import dao.HarborDAO;
import entity.Harbor;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.io.Serializable;

@Named(value = "harborBean")
@SessionScoped

public class HarborBean implements Serializable {

    private Harbor entity;
    private HarborDAO dao;
    private List<Harbor> list;
//sayfalama değişkenleri
    private int page = 1;//bulunduğumuz sayfa
    private int pageSize = 4;//kaç tane veri gösterecez    
    private int pageCount;//sayfa sayısı
    private List<Harbor> list2;

    public HarborBean() {

    }
    public void clearForm(){
        this.entity = new Harbor();
    }

    public void create() {
        this.getDao().HarborDAO(entity);
        this.entity = new Harbor();
    }

    public void update() {
        this.getDao().update(entity);
        this.entity = new Harbor();
    }

    public void delete(Harbor c) {
        this.getDao().delete(c);
        this.entity = new Harbor();
    }

    public Harbor getEntity() {
        if (this.entity == null) {
            this.entity = new Harbor();
        }
        return entity;
    }

    public void setEntity(Harbor entity) {
        this.entity = entity;
    }

    public HarborDAO getDao() {
        if (this.dao == null) {
            this.dao = new HarborDAO();
        }
        return dao;
    }

    public void setDao(HarborDAO dao) {
        this.dao = dao;
    }

    public List<Harbor> getList() {
        this.list = this.getDao().getCategoryList();
        return list;
    }

    public void setList(List<Harbor> list) {
        this.list = list;
    }
    //Kullanıcı sayfalama methotları

    public List<Harbor> getList2() {
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
