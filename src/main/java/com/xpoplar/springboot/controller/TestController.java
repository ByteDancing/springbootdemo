package com.xpoplar.springboot.controller;

import com.xpoplar.springboot.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/18 13:45
 */
@Controller
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/getIpAddress")
    public String getIpAddress(HttpServletRequest request, Model model){
        String ip = Common.getIpAddress(request);
        log.info(" ipaddress : "+ip);
        return "login";
    }
}
