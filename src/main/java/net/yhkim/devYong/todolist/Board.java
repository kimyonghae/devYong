package net.yhkim.devYong.todolist;

import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by yong on 2018. 6. 30..
 */
public class Board extends Paging{
    private Integer id;
    private String work;
    private boolean procYn;
    private Date createDate;
    private Date lastModifyDate;

    private int procAble;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public boolean getProcYn() {
        return procYn;
    }

    public void setProcYn(boolean procYn) {
        this.procYn = procYn;
    }

    public String getCreateDate() {
        return FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss", TimeZone.getTimeZone("UTC")).format(createDate);
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastModifyDate() {
        return lastModifyDate!=null?FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss", TimeZone.getTimeZone("UTC")).format(lastModifyDate):"";
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public int getProcAble() { return procAble; }

    public void setProcAble(int procAble) { this.procAble = procAble; }


}
