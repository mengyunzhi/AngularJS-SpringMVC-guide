package com.mengyunzhi.SpringMvcStudy.controller;

import com.mengyunzhi.SpringMvcStudy.entity.Klass;
import com.mengyunzhi.SpringMvcStudy.repository.KlassRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author panjie on 2017/12/12
 */
public class KlassControllerTest extends ControllerTest {
    private final static Logger logger = Logger.getLogger(KlassControllerTest.class.getName());
    static final String url = "/Klass/";

    @Autowired
    private MockMvc mockMvc;    // 模拟进行REST请求

    @Autowired
    private KlassRepository klassRepository; // 班级

    @Test
    public void saveTest() throws Exception {
        this.mockMvc
                .perform(post(url)
                        .content("{}")
                        .header("content-type", MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    public void getAll() throws Exception {
        this.mockMvc
                .perform(get(url)
                        .header("content-type", MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void page() throws Exception {
        String pageUrl = url + "page";
        this.mockMvc
                .perform(get(pageUrl)
                        .header("content-type", MediaType.APPLICATION_JSON_UTF8)
                        .param("page", "0")
                        .param("size", "2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").value(0));
    }

    @Test
    public void getByIdTest() throws Exception {
        // 持久化一个实体到数据表
        Klass klass = new Klass();
        // 为这个班级设置一个随机的字符串
        String name = "sdfsdfdfdfsdfsdfsdfdfsdfd";
        klass.setName(name);
        klassRepository.save(klass);

        // 获取这个持久化的实体
        String getUrl = url + klass.getId().toString();

        this.mockMvc
                .perform(get(getUrl)
                        .header("content-type", MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name));

    }

    /**
     * 更新的测试
     *
     * @throws Exception
     */
    @Test
    public void updateTest() throws Exception {
        // 持久化一个实体到数据表
        Klass klass = new Klass();
        klassRepository.save(klass);

        // 发起http请求，来更新这个实体\
        String newName = "123";
        String putUrl = url + klass.getId().toString();
        this.mockMvc
                .perform(MockMvcRequestBuilders.put(putUrl)
                        .header("content-type", MediaType.APPLICATION_JSON_UTF8)
                        .content("{\"name\":\"" + newName + "\"}"))
                .andExpect(status().isOk());

        // 断言更新成功(去数据库里找一个这个实体，并获取name，看是否成功)
        Klass newKlass = klassRepository.findOne(klass.getId());
        assertThat(newKlass.getName()).isEqualTo(newName);
    }

    @Test
    public void deleteTest() throws Exception {
        logger.info("new 一个对象");
        Klass klass = new Klass();
        klassRepository.save(klass);

        String deleteUrl = url + klass.getId().toString();
        logger.info("调用C层的删除方法");
        this.mockMvc
                .perform(MockMvcRequestBuilders.delete(deleteUrl)
                        .header("content-type", MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is(204));

        logger.info("断方删除是否成功");
        Klass newKlass = klassRepository.findOne(klass.getId());
        assertThat(newKlass).isNull();
    }


}