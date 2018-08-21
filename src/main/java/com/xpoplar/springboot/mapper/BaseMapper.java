package com.xpoplar.springboot.mapper;

import java.util.List;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/20 11:15
 */
public interface BaseMapper<T> {

    List<T> findAll();

    void insert(T t);

    T findById(String id);


}