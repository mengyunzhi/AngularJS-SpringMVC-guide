package com.mengyunzhi.SpringMvcStudy.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.KlassJsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.TeacherJsonView;

import javax.persistence.*;
import java.util.List;

/**
 * @author panjie on 2017/11/25
 */
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(TeacherJsonView.get.class)
    private Long id;

    @JsonView({
            TeacherJsonView.get.class,
            KlassJsonView.getAll.class
    })
    private String username;

    @JsonView({
            TeacherJsonView.get.class,
            KlassJsonView.getAll.class
    })
    private String name;

    @JsonView(TeacherJsonView.get.class)
    private boolean sex;

    @JsonView(TeacherJsonView.get.class)
    private String email;

    @OneToMany(mappedBy = "teacher")
    @JsonView(TeacherJsonView.getAll.class)
    private List<Klass> klassList;

    public Teacher() {
    }

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
