package com.xutao.spitter.persistence.MyBatisDao;

import com.xutao.spitter.domain.Spitter;
import com.xutao.spitter.persistence.SpitterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/16.
 */
@Repository("spitterDao")
public class SpitterDaoImplForMyBatis implements SpitterDao {

    @Autowired
    private MybatisSpitterDao mybatisSpitterDao;

    @Override
    public void addSpitter(Spitter spitter) {
        mybatisSpitterDao.addSpitterTable(EntityTransform.spitterToSpitterTable(spitter));
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        mybatisSpitterDao.saveSpitterTable(EntityTransform.spitterToSpitterTable(spitter));
    }

    @Override
    public Spitter getSpitterById(long id) {

        return EntityTransform.sptterTableToSpitter(mybatisSpitterDao.getSpitterTableById(id));
    }

    @Override
    public Spitter getSpitterByUsername(String username) {

        return EntityTransform.sptterTableToSpitter(mybatisSpitterDao.getSpitterTbaleByUsername(username));
    }

    @Override
    public List<Spitter> findAllSpitters() {
        List<Spitter> list = new ArrayList<Spitter>();
        for (SpitterTable spitterTable: mybatisSpitterDao.findAllSpitterTables()) {
            list.add(EntityTransform.sptterTableToSpitter(spitterTable));
        }
         return list;
    }
}
