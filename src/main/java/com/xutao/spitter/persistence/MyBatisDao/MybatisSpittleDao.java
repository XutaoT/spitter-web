package com.xutao.spitter.persistence.MyBatisDao;

import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/16.
 */
@MyBatisRepository
public interface MybatisSpittleDao {

    public List<SpittleTable> getRecentSpittle();

    public void saveSpittleTable(SpittleTable spittleTable);

    public List<SpittleTable> getSpittleTablesForSpitterTable(SpitterTable spitterTable);

    public void deleteSpittleTable(long id) ;

    public SpittleTable getSpittleTableById(long id);
}
