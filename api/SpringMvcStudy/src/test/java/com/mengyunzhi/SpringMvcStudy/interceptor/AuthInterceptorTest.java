package com.mengyunzhi.SpringMvcStudy.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.mengyunzhi.SpringMvcStudy.controller.ControllerTest;
import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import com.mengyunzhi.SpringMvcStudy.service.TeacherService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.http.Cookie;


public class AuthInterceptorTest extends ControllerTest {
    private final static Logger logger = LoggerFactory.getLogger(AuthInterceptorTest.class.getName());

    @Autowired
    private MockMvc mockMvc;    // 模拟进行REST请求

    @Autowired
    TeacherService teacherService;  // 教师

    @Test
    public void preHandle() throws Exception {
        logger.info("获取当前登录用户，返回401");
        String meUrl = "/Teacher/me";
        this.mockMvc.perform(MockMvcRequestBuilders
                .get(meUrl)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is(401));

        logger.info("用户登录，用户名密码错误，返回401");
        Teacher teacher = teacherService.getOneSavedTeacher();
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(teacher));
        jsonObject.put("password", "abc");
        String jsonString = jsonObject.toJSONString();

        String loginUrl = "/Teacher/login";
        this.mockMvc.perform(MockMvcRequestBuilders
                .post(loginUrl)
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is(401));

        logger.info("用户登录，用户名密码正确，返回200");
        teacher = teacherService.getOneSavedTeacher();
        jsonString = JSONObject.toJSONString(teacher);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .post(loginUrl)
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn();
        Cookie cookie = mvcResult.getResponse().getCookie("SESSION");

        logger.info("获取当前用户，返回200");
        this.mockMvc.perform(MockMvcRequestBuilders
                .get(meUrl)
                .cookie(cookie)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }
}