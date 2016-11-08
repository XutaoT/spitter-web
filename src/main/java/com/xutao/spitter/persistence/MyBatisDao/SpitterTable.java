package com.xutao.spitter.persistence.MyBatisDao;


/**
 * Created by Tau_Hsu on 2016/10/15.
 */
public class SpitterTable {
       private Long id ;//int(11) AI PK
       private String username;// varchar(25)
       private String password;// varchar(25)
       private String fullname;// varchar(100)
       private String email;// varchar(50)
       private int update_by_email;// tinyint(1)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUpdate_by_email() {
        return update_by_email;
    }

    public void setUpdate_by_email(int update_by_email) {
        this.update_by_email = update_by_email;
    }
}
