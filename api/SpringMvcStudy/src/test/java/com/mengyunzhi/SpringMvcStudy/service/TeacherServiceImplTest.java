package com.mengyunzhi.SpringMvcStudy.service;

import com.alibaba.fastjson.JSONObject;
import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import com.mengyunzhi.SpringMvcStudy.repository.TeacherRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author panjie on 2017/11/29
 */
public class TeacherServiceImplTest extends ServiceTest {
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherRepository teacherRepository; // 教师表
    @Test
    public void updateTest() throws Exception {
        // 新建一个教师张三，并持久化
        Teacher zhangsanTeacher = new Teacher();
        zhangsanTeacher.setName("张三");
        zhangsanTeacher.setUsername("zhangsan");
        zhangsanTeacher.setSex(true);
        zhangsanTeacher.setEmail("zhangsan@yunzhiclub.com");
        teacherRepository.save(zhangsanTeacher);
        Long id = zhangsanTeacher.getId();

        // 新建一个教师李四
        Teacher lisiTeacher = new Teacher();
        lisiTeacher.setName("李四");
        lisiTeacher.setUsername("lisi");
        lisiTeacher.setSex(false);
        lisiTeacher.setEmail("lisi@yunzhiclub.com");

        // 使用李四的信息来更新张三的信息
        teacherService.update(id, lisiTeacher);

        // 断言更新信息成功
        Teacher newTeacher = teacherRepository.findOne(id);
        assertThat(newTeacher.getName()).isEqualTo("李四");
        assertThat(newTeacher.getUsername()).isEqualTo("lisi");
        assertThat(newTeacher.getEmail()).isEqualTo("lisi@yunzhiclub.com");
        assertThat(newTeacher.isSex()).isFalse();
    }

    @Test
    public void deleteTest() {
        // 首先添加一个数据
        Teacher teacher = new Teacher();
        teacherRepository.save(teacher);
        Long id = teacher.getId();

        // 然后再去调用删除方法来删除 这个数据
        teacherService.delete(id);

        // 断言这个删除这个删除成功（查找的时候，查不到了)
        Teacher newTeacher = teacherRepository.findOne(id);
        assertThat(newTeacher).isNull();
    }

    @Test
    public void login() {
        // 实例化一个用户
        Teacher teacher = new Teacher();
        teacher.setUsername("InAbxUsHyQ2dXKbWfueZR6WBfH7ZpLLx");
        teacher.setPassword("LdAUkm37Q5P0oEDLDJtJqKJMJwHaYTmq");
        teacherRepository.save(teacher);

        // 无此用户名
        Teacher testTeacher = new Teacher();
        testTeacher.setUsername("FwypsjUiL0VWSoH3wBgzPqJeii11rX1I");
        Assertions.assertThat(teacherService.login(testTeacher)).isFalse();


        // 密码不正确
        testTeacher.setUsername("InAbxUsHyQ2dXKbWfueZR6WBfH7ZpLLx");
        testTeacher.setPassword("LdAUkm37Q5P0oEDLDJtJqKJMJwHaYTmq12");
        Assertions.assertThat(teacherService.login(testTeacher)).isFalse();

        // 用户名密码正确
        testTeacher.setPassword(teacher.getPassword());
        Assertions.assertThat(teacherService.login(testTeacher)).isTrue();

    }

    @Test
    public void getOneTeacher() {
        Teacher teacher = teacherService.getOneTeacher();
        Assertions.assertThat(teacher.getUsername()).isNotNull();
        Assertions.assertThat(teacher.getPassword()).isNotNull();
        Assertions.assertThat(teacher.getName()).isNotNull();
    }

    @Test
    public void getOneSavedTeacher() {
        Teacher teacher = teacherService.getOneSavedTeacher();
        Assertions.assertThat(teacher.getId()).isNotNull();
        Assertions.assertThat(teacher.getUsername()).isNotNull();
        Assertions.assertThat(teacher.getPassword()).isNotNull();
        Assertions.assertThat(teacher.getName()).isNotNull();
    }

}