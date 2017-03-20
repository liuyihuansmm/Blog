package org.cn.lyh.dto;

/**
 * Created by LYH on 2017-3-20.
 */
public class PageBean {

    private Integer currentPage; //当前页数

    private Integer totalCount;  //总条数

    private Integer perPage = 5; //每页显示多少条

    private Integer totalPage;   //总页数，通过计算得到

    private  Integer dbIndex ;

    private  Integer dbNum;

    public PageBean(){}

    public void count(){
        totalPage = totalCount / perPage;
        if(totalCount%perPage !=0){
            totalPage++;
        }

        if (totalPage ==0){
            totalPage = 1;
        }
        if (currentPage>totalPage){
            currentPage =  totalPage;
        }

        if (currentPage<1){
            currentPage = 1;
        }

        this.dbIndex = (currentPage-1)*perPage;
        this.dbNum = perPage;
    }

    public Integer getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(Integer dbIndex) {
        this.dbIndex = dbIndex;
    }

    public Integer getDbNum() {
        return dbNum;
    }

    public void setDbNum(Integer dbNum) {
        this.dbNum = dbNum;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        count();
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
        //count();
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
        count();
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", perPage=" + perPage +
                ", totalPage=" + totalPage +
                ", dbIndex=" + dbIndex +
                ", dbNum=" + dbNum +
                '}';
    }
}
