package com.mengyunzhi.SpringMvcStudy.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.SpringMvcStudy.jsonView.TeacherJsonView;

import javax.persistence.*;

/**
 * @author panjie on 2017/12/12
 * 班级
 */
@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(TeacherJsonView.class)
    private String name;

    @ManyToOne
    private Teacher teacher;

    public Klass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
