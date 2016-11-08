package com.xutao.spitter.persistence.MyBatisDao;


import java.sql.Date;

/**
 * Created by Tau_Hsu on 2016/10/15.
 */
public class SpittleTable {
    private Long id;//int(11) AI PK
    private Long spitter_id;// int(11)
    private String spittleText;// varchar(2000)
    private Date spittleDate;// date

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpitter_id() {
        return spitter_id;
    }

    public void setSpitter_id(Long spitter_id) {
        this.spitter_id = spitter_id;
    }

    public String getSpittleText() {
        return spittleText;
    }

    public void setSpittleText(String spittleText) {
        this.spittleText = spittleText;
    }

    public Date getSpittleDate() {
        return spittleDate;
    }

    public void setSpittleDate(Date spittleDate) {
        this.spittleDate = spittleDate;
    }
}
