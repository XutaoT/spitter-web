package com.xutao.spitter.service;

import com.xutao.spitter.domain.Spitter;
import com.xutao.spitter.domain.Spittle;

import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/6.
 */
public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);
    Spitter getSpitter(String usename);
    List<Spittle> getSpittlesForSpitter(String username);
    void saveSpitter(Spitter spitter);
}
