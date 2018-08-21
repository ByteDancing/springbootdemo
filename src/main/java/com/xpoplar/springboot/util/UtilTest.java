package com.xpoplar.springboot.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/18 13:14
 */
public class UtilTest {

    public static void main(String args[]) {

//        System.out.println(Common.getOsName());
//
//        System.out.println(Common.getMACAddress());
//
//        System.out.println(Common.getUUID());
//
//        System.out.println(MD5.getMD5Str("111111"));

//        HttpServletRequest request = HttpServletRequest.class.
//        System.out.println(Common.getIpAddress());

        String filePath = "D:/";
        RSAUtil.generateKeyPair(filePath);

    }
    }

