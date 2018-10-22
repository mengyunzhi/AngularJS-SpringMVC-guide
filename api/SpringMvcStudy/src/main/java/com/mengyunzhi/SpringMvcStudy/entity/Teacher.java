package com.mengyunzhi.SpringMvcStudy.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.TeacherJsonView;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author panjie on 2017/11/25
 */
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String name;

    @Column(nullable = false)
    private String password = "yunzhiclub";

    private boolean sex;

    private String email;

    @OneToMany(mappedBy = "teacher")
    @JsonView(TeacherJsonView.class)
    private List<Klass> klassList = new ArrayList<>();

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Klass> getKlassList() {
        return klassList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
