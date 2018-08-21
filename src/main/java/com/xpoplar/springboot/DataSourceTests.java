package com.xpoplar.springboot;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/20 21:20
 */

import cn.hutool.Hutool;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
//import com.alibaba.JSON;
//import com.xiaolyuh.config.DruidDataSourceProperty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
//import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@SpringBootApplication(classes=SpringbootApplication.class)
public class DataSourceTests {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DruidDataSourceProperty druidDataSourceProperty;

    @Test
    public void testDataSource() throws Exception {
        // 获取配置的数据源
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        // 查看配置数据源信息
        System.out.println(dataSource.getClass().getName());
        System.out.println(JSONUtil.toJsonStr(druidDataSourceProperty));
    }

}

