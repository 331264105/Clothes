package com.didu.serviceImpl;

import com.didu.dao.Carouseldao;
import com.didu.domain.Carousel;
import com.didu.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
@Service
@Transactional
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private Carouseldao idao;
    @Override
    public boolean addImage(Carousel image) {
        return (idao.save(image)>0)?true:false;
    }

    @Override
    public List<Carousel> query() {
        return idao.query();
    }

    @Override
    public boolean removeImage(int id) {
        return idao.removeImage(id)>0?true:false;
    }

    @Override
    public Carousel queryI(int id) {
        return idao.queryI(id);
    }

    @Override
    public boolean updateImage(Carousel picture) {
        return idao.updateImage(picture);
    }
}
