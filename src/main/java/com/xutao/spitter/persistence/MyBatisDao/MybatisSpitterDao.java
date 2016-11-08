package com.xutao.spitter.persistence.MyBatisDao;

import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/16.
 */
@MyBatisRepository
public interface MybatisSpitterDao {

    public void addSpitterTable(SpitterTable  spitterTable);

    public void saveSpitterTable(SpitterTable spitterTable);

    public SpitterTable getSpitterTableById(long id) ;

    public SpitterTable getSpitterTbaleByUsername(String username);

    public List<SpitterTable> findAllSpitterTables();

}
