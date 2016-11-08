package com.xutao.spitter.persistence;

import com.xutao.spitter.domain.Spitter;
import com.xutao.spitter.domain.Spittle;

import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/14.
 */
public interface SpittleDao {

    List<Spittle> getRecentSpittle();

    void saveSpittle(Spittle spittle);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    void deleteSpittle(long id);

    Spittle getSpittleById(long id);
}
