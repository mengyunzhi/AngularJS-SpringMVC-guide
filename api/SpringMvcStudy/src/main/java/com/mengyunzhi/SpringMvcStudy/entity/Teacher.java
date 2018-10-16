package com.mengyunzhi.SpringMvcStudy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.BaseJsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.KlassJsonView;
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
    @JsonView(TeacherJsonView.class)
    private Long id;

    @JsonView(TeacherJsonView.class)
    private String username;

    @JsonView(BaseJsonView.class)
    private String name;

    @JsonView(TeacherJsonView.class)
    private boolean sex;

    @JsonView(TeacherJsonView.class)
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
}
