package com.xpoplar.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/18 12:57
 */
public class MD5 {
    private static final Logger log = LoggerFactory.getLogger(MD5.class);
    /**
     * md5加密
     * @param str
     * @return
     */
    public  static String getMD5Str(String str){
        String encrypeTxt = null;
        MD5Digest md5Digest = new MD5Digest();
        encrypeTxt = md5Digest.md5(str);
        log.info("md5加密后的密文*******"+encrypeTxt);
        return encrypeTxt;
    }
}
