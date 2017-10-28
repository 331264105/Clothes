package com.didu.service;

import com.didu.domain.Navigation;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface NavigationService {
    boolean addImage(Navigation navigation);
    Navigation queryI(int id);
    boolean updateImage(Navigation picture);
    List<Navigation> query();
}
