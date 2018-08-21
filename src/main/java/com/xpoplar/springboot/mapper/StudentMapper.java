package com.xpoplar.springboot.mapper;

import com.xpoplar.springboot.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/16 16:56
 */

@Mapper
@Repository
public interface StudentMapper {

    @Select("SELECT * FROM SYS_USER")
    List<Student> findAll();

    @Insert("INSERT INTO SYS_USER(id,nickname, email, pswd, create_time, last_login_time, status) VALUES (#{id},#{nickname},#{email},#{pswd},#{create_Time},#{last_Login_Time},#{status})")
    void insertStudent(Student student);

    @Select("SELECT * FROM SYS_USER WHERE nickname=#{p1} and pswd=#{p2}")
    Student CheckLogin(@Param("p1") String nickname, @Param("p2") String pswd);

}
