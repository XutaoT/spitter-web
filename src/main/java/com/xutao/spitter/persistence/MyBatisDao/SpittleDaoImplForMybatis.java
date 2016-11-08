package com.xutao.spitter.persistence.MyBatisDao;

import com.xutao.spitter.domain.Spitter;
import com.xutao.spitter.domain.Spittle;
import com.xutao.spitter.persistence.SpittleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/16.
 */
@Repository("spittleDao")
public class SpittleDaoImplForMybatis implements SpittleDao {

    @Autowired
    private MybatisSpittleDao mybatisSpittleDao;

    @Autowired
    private MybatisSpitterDao mybatisSitterDao;

    @Override
    public List<Spittle> getRecentSpittle() {
        List<Spittle> list = new ArrayList<Spittle>();
        for (SpittleTable spittleTable : mybatisSpittleDao.getRecentSpittle()) {
            Spittle spittle = EntityTransform.spittleTableToSpittle(spittleTable);
            Spitter spittter = EntityTransform.sptterTableToSpitter(mybatisSitterDao.getSpitterTableById(spittleTable.getSpitter_id()));
            spittle.setSpitter(spittter);
            list.add(spittle);
        }
        return list;
    }

    @Override
    public void saveSpittle(Spittle spittle) {
        mybatisSpittleDao.saveSpittleTable(EntityTransform.spittleToSpittleTable(spittle));
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        List<Spittle> list = new ArrayList<Spittle>();
        for (SpittleTable spittleTable
                :mybatisSpittleDao.getSpittleTablesForSpitterTable(EntityTransform.spitterToSpitterTable(spitter))
             ) {
            Spittle spittle = EntityTransform.spittleTableToSpittle(spittleTable);
            spittle.setSpitter(spitter);
            list.add(spittle);
        }
        return list;
    }

    @Override
    public void deleteSpittle(long id) {
        mybatisSpittleDao.deleteSpittleTable(id);
    }

    @Override
    public Spittle getSpittleById(long id) {
        return EntityTransform.spittleTableToSpittle(mybatisSpittleDao.getSpittleTableById(id));
    }
}
