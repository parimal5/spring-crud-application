package com.lucky.MyMobile.service;

import com.lucky.MyMobile.dao.MobileRepository;
import com.lucky.MyMobile.entity.Mobile;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MobileServiceImply implements MobileService{

  private MobileRepository mobileRepository;
    @Autowired
    public MobileServiceImply(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    @Override
    public List<Mobile> findAll() {
        return mobileRepository.findAll();
    }

    @Override
    public Mobile findById(int id) {
        Optional<Mobile> result = mobileRepository.findById(id);
        Mobile mobile = null;
        if(result.isPresent())
            mobile = result.get();
        else
            throw new RuntimeException("Did not find the employee id - " + id);
        return mobile;
    }

    @Override
    public void save(Mobile mobile) {
        mobileRepository.save(mobile);
    }

    @Override
    public void deleteById(int id) {
        mobileRepository.deleteById(id);
    }
}
