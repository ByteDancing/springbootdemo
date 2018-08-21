package com.xpoplar.springboot.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author ChengXiang
 * @Date 2018/8/16 16:54
 */
public class Student implements Serializable {
    private String id;

    private String nickname;

    private String email;

    private String pswd;

    private Date create_Time;

    private Date last_Login_Time;

    private Byte status;

    /*   getter  **  setter*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public Date getCreate_Time() {
        return create_Time;
    }

    public void setCreate_Time(Date create_Time) {
        this.create_Time = create_Time;
    }

    public Date getLast_Login_Time() {
        return last_Login_Time;
    }

    public void setLast_Login_Time(Date last_Login_Time) {
        this.last_Login_Time = last_Login_Time;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", pswd='" + pswd + '\'' +
                ", create_Time=" + create_Time +
                ", last_Login_Time=" + last_Login_Time +
                ", status=" + status +
                '}';
    }
}
