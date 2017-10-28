package com.didu.service;

import com.didu.domain.Carousel;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface CarouselService {
    boolean addImage(Carousel image);

    List<Carousel> query();

    boolean removeImage(int id);

    Carousel queryI(int id);

    boolean updateImage(Carousel picture);
}
