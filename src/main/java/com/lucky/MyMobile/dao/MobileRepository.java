package com.lucky.MyMobile.dao;

import com.lucky.MyMobile.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface MobileRepository extends JpaRepository<Mobile, Integer> {

}
