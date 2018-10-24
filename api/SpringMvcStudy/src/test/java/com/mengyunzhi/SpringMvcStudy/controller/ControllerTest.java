package com.mengyunzhi.SpringMvcStudy.controller;

import com.alibaba.fastjson.JSONObject;
import com.mengyunzhi.SpringMvcStudy.SpringMvcStudyApplicationTests;
import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import com.mengyunzhi.SpringMvcStudy.service.TeacherService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * @author panjie on 2017/12/30
 */
@AutoConfigureMockMvc
public class ControllerTest extends SpringMvcStudyApplicationTests {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    TeacherService teacherService;
    protected Cookie cookie;

    @Before
    public void before() throws Exception {
        Teacher teacher = teacherService.getOneSavedTeacher();

        // 无此用户名
        String loginUrl = "/Teacher/login";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", teacher.getUsername());
        jsonObject.put("password", teacher.getPassword());
        String jsonString = jsonObject.toJSONString();

        MvcResult mvcResult = this.mockMvc
                .perform(post(loginUrl)
                        .content(jsonString)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();

        this.cookie = mvcResult.getResponse().getCookie("SESSION");
    }


}
