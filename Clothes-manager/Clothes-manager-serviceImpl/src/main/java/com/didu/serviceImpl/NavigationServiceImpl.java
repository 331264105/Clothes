package com.didu.serviceImpl;

import com.didu.dao.Carouseldao;
import com.didu.dao.Navigationdao;
import com.didu.domain.Navigation;
import com.didu.service.NavigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
@Service
@Transactional
public class NavigationServiceImpl implements NavigationService {
    @Autowired
    private Navigationdao idao;

    @Override
    public boolean addImage(Navigation navigation) {
        return idao.addImage(navigation)>0?true:false;
    }

    @Override
    public Navigation queryI(int id) {
        return idao.queryI(id);
    }

    @Override
    public boolean updateImage(Navigation picture) {
        return idao.updateImage(picture)>0?true:false;
    }

    @Override
    public List<Navigation> query() {
        return idao.query();
    }
}
