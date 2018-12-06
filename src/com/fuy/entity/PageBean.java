package com.fuy.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 分页的实体类
 */
public class PageBean implements Serializable {
    private Integer pagenum;

    private Integer pagesize;

    private Integer allRecods;

    private Integer startPage;

    private Integer endPage;

    private Integer allPages;

    private Integer startIndex;

    private List<Shop> shops;

    public PageBean()
    {

    }

    public PageBean(int pagenum,int pagesize,int allRecods)
    {
        this.pagenum = pagenum;
        this.pagesize = pagesize;
        this.allRecods = allRecods;
        if (allRecods %pagesize == 0)
        {
            this.allPages = allRecods/pagesize;
        }else
        {
            this.allPages = allRecods/pagesize+1;
        }
        this.startIndex = (pagenum-1)*pagesize;
        this.startPage = 1;
        this.endPage = 5;
        if (allPages<=5)
        {
            this.startPage = 1;
            this.endPage = this.allPages;
        }else
        {
            this.startPage =this.pagenum-2;
            this.endPage = this.pagenum+2;
            if (startPage <= 0)
            {
                this.startPage = 1;
                this.endPage = 5;
            }
            if (endPage>allPages)
            {
                this.startPage = endPage-4;
                this.endPage = this.allPages;
            }
        }
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pagenum=" + pagenum +
                ", pagesize=" + pagesize +
                ", allRecods=" + allRecods +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", allPages=" + allPages +
                ", startIndex=" + startIndex +
                ", shops=" + shops +
                '}';
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public Integer getAllRecods() {
        return allRecods;
    }

    public void setAllRecods(Integer allRecods) {
        this.allRecods = allRecods;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
