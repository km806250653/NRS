package cn.hncu.entity;

import java.util.List;

/**
 * Created by Enzo Cotter on 2019/4/20.
 */
public class PageResult {
    private long total;
    private List rows;

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
