package com.mengyunzhi.SpringMvcStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author panjie on 2017/11/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;    // 模拟进行REST请求
    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void getTest() throws Exception {
        // 创建一条数据
        Teacher teacher = new Teacher();
        teacher.setUsername("usrname");
        teacher.setName("name");
        teacher.setEmail("email");
        teacher.setSex(true);
        teacherRepository.save(teacher);

        String url = "/Teacher/" + String.valueOf(teacher.getId());
        this.mockMvc
                .perform(get(url))  // 用get方法来请求这个url
                .andDo(print()) // 请求后，打印请求的返回数据
                .andExpect(status().isOk()); // 断言返回的状态为真
    }

    @Test
    public void updateTest() throws Exception {
        String url = "/Teacher/1";
        this.mockMvc
                .perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content("{}"))  // 用get方法来请求这个url
                .andDo(print()) // 请求后，打印请求的返回数据
                .andExpect(status().isOk()); // 断言返回的状态为真
    }

}