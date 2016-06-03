package com.hyolee.user.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyolee.user.utils.JsonDateDeserializer;
import com.hyolee.user.utils.JsonDateSerializer;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/2.
 */
public class User implements Serializable {

    private Integer id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String email;
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @Past
    private Date birthday;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
