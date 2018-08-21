package com.xpoplar.springboot.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description 获取config.properties资源文件中的内容
 * @Author ChengXiang
 * @Date 2018/8/20 15:27
 */
public class ConfigProperties {

    public static Properties properties = null;

    /**
     * 加载静态资源
     */
    static {
        properties = new Properties();
//        String filePath = getFilePath();
        InputStream inputStream = ConfigProperties.class.getResourceAsStream("/config.properties");

        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取资源文件中的配置参数
     * @param key
     * @return
     */
    public static String getConfigValueKey(String key){
        return properties.getProperty(key);
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String args[]){
        String str = "testKey";
       System.out.println( ConfigProperties.getConfigValueKey(str));

    }

}
