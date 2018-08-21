package com.xpoplar.springboot.controller;

import com.xpoplar.springboot.mapper.StudentMapper;
import com.xpoplar.springboot.pojo.Student;
import com.xpoplar.springboot.util.Common;
import com.xpoplar.springboot.util.ConfigProperties;
import com.xpoplar.springboot.util.MD5;
import com.xpoplar.springboot.util.RSAUtil;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/16 16:58
 */
@Controller
public class StudentController {

    private static final Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/findAllStudents")
    public String findAllStudnet(Model m){
        log.info("findAllStudents");
        List<Student> students = studentMapper.findAll();
        log.info("**"+students.size()+"**");
        m.addAttribute("students",students);
        return "list";
    }

    /**
     * 用户注册，md5加密
     * @param student
     * @param m
     * @return
     */
    @RequestMapping(value = "/insertStudent",method = RequestMethod.POST)
    public String insert(Student student,Model m){
        try {
//            log.info("register user"+student.getNickname()+"&&"+student.getCreate_Time());
            student.setId(Common.getUUID());
            student.setCreate_Time(new Date());
            student.setLast_Login_Time(new Date());
            student.setStatus((byte)1);
            student.setPswd(MD5.getMD5Str(student.getPswd()));
//            System.out.println(student.toString());
            studentMapper.insertStudent(student);
            List<Student> students = studentMapper.findAll();
            m.addAttribute("students",students);
            return "redirect:welcome";
        } catch (Exception e) {
            return "error404";
        }
    }


    @RequestMapping(value = "/index")
    public String index(Model model){
        return "login" ;
    }


    @RequestMapping("/welcome")
    public void welcome(ModelAndView  model){
        log.info("进入"+"welcome");
        model.setViewName("welcome");

    }

    @RequestMapping("/userLogin")
    public String userLogin(String username,String passwd,Model model){
        log.info("用户登录"+"username:"+username+"&& passwd:"+passwd);
        String privateKey = ConfigProperties.getConfigValueKey("privateKey");
        String password = RSAUtil.decrypt(privateKey,passwd.trim().replaceAll(" ","+"));
        log.info("解密后的密码明文："+password);
        try {
            Student student = studentMapper.CheckLogin(username,MD5.getMD5Str(password));
            log.info(student.toString());
            if (student!=null){
                model.addAttribute("student",student);
              return "welcome";
            }else {
               return "error";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }


    }
}
