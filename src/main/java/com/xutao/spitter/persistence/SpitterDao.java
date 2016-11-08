package com.xutao.spitter.persistence;

import com.xutao.spitter.domain.Spitter;

import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/13.
 */
public interface SpitterDao {
    void addSpitter(Spitter spitter);

    void saveSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    Spitter getSpitterByUsername(String username);

    List<Spitter> findAllSpitters();
}
