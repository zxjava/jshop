package com.jshop.jshop.dto;

public class Page {

    private Integer page;
    private Integer pageSize;
    private Integer total;

    public Page(Integer page, Integer pageSize, Integer total) {
        this.page = page;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
