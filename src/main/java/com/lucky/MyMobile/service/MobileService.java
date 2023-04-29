package com.lucky.MyMobile.service;

import com.lucky.MyMobile.entity.Mobile;

import java.util.List;

public interface MobileService {

    List<Mobile> findAll();

    Mobile findById(int id);

    void save(Mobile mobile);

    void deleteById(int id);
}
