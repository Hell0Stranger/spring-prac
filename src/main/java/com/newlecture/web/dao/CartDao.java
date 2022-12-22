package com.newlecture.web.dao;

import com.newlecture.web.entity.Cart;
import org.apache.ibatis.annotations.Mapper;




    @Mapper
    public interface CartDao {

        void add(Cart cart);

        int count(int memberId);
    }

