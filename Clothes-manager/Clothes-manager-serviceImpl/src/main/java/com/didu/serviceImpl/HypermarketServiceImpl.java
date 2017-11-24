package com.didu.serviceImpl;

import com.didu.dao.Hypermarketdao;
import com.didu.domain.Hypermarket;
import com.didu.service.HypermarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service
@Transactional
public class HypermarketServiceImpl implements HypermarketService {
    @Autowired
    private Hypermarketdao hypermarketdao;
    @Override
    public boolean addHypermarket(Hypermarket hypermarket) {
        return hypermarketdao.addHypermarket(hypermarket)>0?true:false;
    }

    @Override
    public Hypermarket queryI(int id) {
        return hypermarketdao.queryI(id);
    }

    @Override
    public boolean removeHypermarket(int id) {
        return hypermarketdao.removeHypermarket(id)>0?true:false;
    }

    @Override
    public boolean updateImage(Hypermarket hypermarket) {
        return hypermarketdao.updateHypermarket(hypermarket)>0?true:false;
    }

    @Override
    public List<Hypermarket> query(String property) {
        return hypermarketdao.query(property);
    }

    @Override
    public boolean updateHerpermarkettwo(Hypermarket hypermarket) {
        return hypermarketdao.updateHerpermarkettwo(hypermarket)>0?true:false;
    }
}
