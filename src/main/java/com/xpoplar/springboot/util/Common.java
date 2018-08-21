package com.xpoplar.springboot.util;

import org.apache.commons.lang3.StringUtils;
import org.omg.SendingContext.RunTime;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description 通用一些方法
 * @Author ChengXiang
 * @Date 2018/8/18 13:12
 */
public class Common {

    /**
     * 获取uuid(去除"-")
     */
    public static String getUUID(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 经过多次反向代理后的ip
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }
    /**
     * 获取操作系统
     * @return
     */
    public static String getOsName(){
        String os = "";
        os = System.getProperty("os.name");
        return os;
    }



    public static String getMACAddress(){
        String address = "";
        String os = getOsName();
        if (os.startsWith("Windows")){
            try {
                String command = "cmd.exe /c ipconfig /all";
                Process process = Runtime.getRuntime().exec(command);

                InputStream is = process.getInputStream();
                InputStreamReader reader = new InputStreamReader(is,"GBK");

                BufferedReader br = new BufferedReader(reader);
                String line;
                while ((line = br.readLine())!=null){
                    if (line.indexOf("Physical Address")>0 || line.indexOf("物理地址")>0){
                        int index = line.indexOf(":");
                        index+=2;
                        address = line.substring(index);
                        break;
                    }
                }
                br.close();
                return address.trim();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

        }


    return null;


    }
}
