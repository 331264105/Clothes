package com.didu.service;

import com.didu.domain.Hypermarket;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */

public interface HypermarketService {
    boolean addHypermarket(Hypermarket hypermarket);
    Hypermarket queryI(int id);
    boolean removeHypermarket(int id);
    boolean updateImage(Hypermarket hypermarket);
    List<Hypermarket> query(String property);
    boolean updateHerpermarkettwo(Hypermarket hypermarket);
}
