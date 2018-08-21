package com.xpoplar.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;

/**
 * @Description     测试SpringBoot
 * @Author ChengXiang
 * @Date 2018/8/16 14:20
 */

//@RestController 注解： 该注解是 @Controller 和 @ResponseBody 注解的合体版
//@RestController

@Controller
public class HelloController {


    private static  final Logger log = LoggerFactory.getLogger(HelloController.class);

//    @Autowired
//    private StudentProperties studentProperties;


    @RequestMapping("/hello")
    public String hello(Model m){
//        return "Hello Spring Boot!";
        log.info("************* info /HelloController/helo  *******");

//        return  studentProperties.getName()+"**"+studentProperties.getAge();

        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
//        m.addAttribute("now", "hello");
        return "hello";


    }
}
