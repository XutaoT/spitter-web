package com.xutao.spitter.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Tau_Hsu on 2016/10/6.
 */
public class Spitter {

    private Long id;

    @Size(min = 3, max = 20, message = "Username must be btw 3 and 20 characters long.")//限制长度
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must be alphanumeric with no spaces.")//限制格式
    private String username;

    @Size(min = 6, max = 20, message = "The password must at least 6 characters long.")
    private String password;
    //message属性该消息将会在效验失败的时显示在表单上
    //可以通过BindingResult的getFieldError获取字段的错误
    @Size(min = 3, max = 50, message = "Your full name must be btw 3 and 50 characters long.")
    private String fullName;

    private List<Spittle> spittles;

    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[A-Za-z]{2,4}", message = "Invalid email address.")
    private String email;

    private boolean updateByEmail;

    public static final Spitter FAKE_SPITTER = new Spitter();
    static {
        FAKE_SPITTER.setUsername("Spitter Not Exists, Go Create It.");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setSpittles(List<Spittle> spittles) {
        this.spittles = spittles;
    }

    public List<Spittle> getSpittles() {
        return spittles;
    }

    public void setUpdateByEmail(boolean updateByEmail) {
        this.updateByEmail = updateByEmail;
    }

    public boolean getUpdateByEmail() {
        return updateByEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Spitter)) return false;

        Spitter spitter = (Spitter) o;

        if (getUpdateByEmail() != spitter.getUpdateByEmail()) return false;
        if (getId() != null ? !getId().equals(spitter.getId()) : spitter.getId() != null) return false;
        if (getUsername() != null ? !getUsername().equals(spitter.getUsername()) : spitter.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(spitter.getPassword()) : spitter.getPassword() != null)
            return false;
        if (getFullName() != null ? !getFullName().equals(spitter.getFullName()) : spitter.getFullName() != null)
            return false;
        if (getSpittles() != null ? !getSpittles().equals(spitter.getSpittles()) : spitter.getSpittles() != null)
            return false;
        return getEmail() != null ? getEmail().equals(spitter.getEmail()) : spitter.getEmail() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        result = 31 * result + (getSpittles() != null ? getSpittles().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getUpdateByEmail() ? 1 : 0);
        return result;
    }
}
