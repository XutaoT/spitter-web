package com.xutao.spitter.persistence.MyBatisDao;

import com.xutao.spitter.domain.Spitter;
import com.xutao.spitter.domain.Spittle;

import java.sql.Date;

/**
 * Created by Tau_Hsu on 2016/10/16.
 */
public class EntityTransform {

    public static Spitter sptterTableToSpitter(SpitterTable spitterTable){
        Spitter spitter = new Spitter();
        spitter.setId(spitterTable.getId());
        spitter.setUsername(spitter.getUsername());
        spitter.setPassword(spitterTable.getPassword());
        spitter.setFullName(spitterTable.getFullname());
        spitter.setEmail(spitterTable.getEmail());
        spitter.setUpdateByEmail(spitterTable.getUpdate_by_email()==1?true:false);
        return spitter;
    }

    public static SpitterTable spitterToSpitterTable(Spitter spitter){
        SpitterTable spitterTable = new SpitterTable();
        spitterTable.setId(spitter.getId());
        spitterTable.setUsername(spitter.getUsername());
        spitterTable.setPassword(spitter.getPassword());
        spitterTable.setFullname(spitter.getFullName());
        spitterTable.setEmail(spitter.getEmail());
        spitterTable.setUpdate_by_email(spitter.getUpdateByEmail()?1:0);
        return spitterTable;
    }

    public static Spittle spittleTableToSpittle(SpittleTable spittleTable){
        Spittle spittle = new Spittle();
        spittle.setId(spittleTable.getId());
        spittle.setText(spittleTable.getSpittleText());
        spittle.setWhen(spittleTable.getSpittleDate());
        return spittle;
    }

    public static SpittleTable spittleToSpittleTable(Spittle spittle){
        SpittleTable spittleTable = new SpittleTable();
        spittleTable.setId(spittle.getId());
        spittleTable.setSpitter_id(spittle.getSpitter().getId());
        spittleTable.setSpittleDate(new Date(spittle.getWhen().getTime()));
        spittleTable.setSpittleText(spittle.getText());
        return spittleTable;
    }
}
