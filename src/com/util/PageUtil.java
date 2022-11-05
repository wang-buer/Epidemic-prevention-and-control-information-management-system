package com.util;

public class PageUtil {
    private int totalCount;//总笔数
    private int pageSize;//每页有多少笔数据
    private int totalPageCount;//总共有多少页数据
    private int currentPageIndex;//当前是第几页
    private int startIndex;//从第几笔开始查询

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalPageCount = (totalCount + this.pageSize-1) / this.pageSize;
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.totalPageCount = (this.totalCount + pageSize -1) /pageSize;
        this.startIndex = this.currentPageIndex * pageSize;
        this.pageSize = pageSize;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public void setCurrentPageIndex(int currentPageIndex) {
        this.startIndex = currentPageIndex * pageSize;
        this.currentPageIndex = currentPageIndex;
    }

    public int getTotalPageCount() {
        return (this.totalCount + this.pageSize-1) / this.pageSize;
    }

    public int getStartIndex() {
        return this.currentPageIndex * pageSize;
    }

    public PageUtil() {
        this(0,5,0);
    }

    public PageUtil(int totalCount, int pageSize, int currentPageIndex) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currentPageIndex = currentPageIndex;
        this.totalPageCount = (this.totalCount + this.pageSize-1) / this.pageSize;
        this.startIndex = this.currentPageIndex * this.pageSize;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", totalPageCount=" + totalPageCount +
                ", currentPageIndex=" + currentPageIndex +
                ", startIndex=" + startIndex +
                '}';
    }

    public static void main(String[] args) {
        //测试分页
        PageUtil pageUtil = new PageUtil(10,3,1);
        System.out.println(pageUtil.toString());
        pageUtil.setTotalCount(20);
        pageUtil.setPageSize(6);
        System.out.println(pageUtil.toString());
    }
}
