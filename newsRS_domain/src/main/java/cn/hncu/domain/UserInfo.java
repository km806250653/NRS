package cn.hncu.domain;

import java.io.Serializable;

/**
 * Created by Enzo Cotter on 2019/3/22.
 */
public class UserInfo implements Serializable {
    static final long serialVersionUID = 111L;

    private Integer id;         //唯一标志，无意义
    private String username;    //用户名
    private String password;    //密码
    private String name;        //昵称
    private String email;        //电子邮箱
    private Integer phone_number;    //电话号码
    private String own_page;     //个人主页
    private String isManager;    // "Y为管理员  "N"为非管理员
    private String isActivated;  //"Y为已激活  "N"为未激活
    private String code;   //激活码

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", own_page='" + own_page + '\'' +
                ", isManager='" + isManager + '\'' +
                ", isActivated='" + isActivated + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public String getOwn_page() {
        return own_page;
    }

    public void setOwn_page(String own_page) {
        this.own_page = own_page;
    }

    public String getIsManager() {
        return isManager;
    }

    public void setIsManager(String isManager) {
        this.isManager = isManager;
    }

    public String getIsActivated() {
        return isActivated;
    }

    public void setIsActivated(String isActivated) {
        this.isActivated = isActivated;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
