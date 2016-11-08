package com.xutao.spitter.service;

import com.xutao.spitter.domain.Spitter;
import com.xutao.spitter.domain.Spittle;
import com.xutao.spitter.persistence.SpitterDao;
import com.xutao.spitter.persistence.SpittleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/9.
 */
@Component("spitterService")
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpittleDao spittleDao;

    @Autowired
    private SpitterDao spitterDao;

    @Override
    public List<Spittle> getRecentSpittles(int count) {
        List<Spittle> list = spittleDao.getRecentSpittle();
        return list.subList(0,Math.min(count,list.size()));
    }

    @Override
    public Spitter getSpitter(String usename) {
        return spitterDao.getSpitterByUsername(usename);

    }

    @Override
    public List<Spittle> getSpittlesForSpitter(String username) {
        return spittleDao.getSpittlesForSpitter(spitterDao.getSpitterByUsername(username));
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        spitterDao.addSpitter(spitter);
    }
}
