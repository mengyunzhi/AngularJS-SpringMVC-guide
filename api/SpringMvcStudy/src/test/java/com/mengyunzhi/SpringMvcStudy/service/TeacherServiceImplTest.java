package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import com.mengyunzhi.SpringMvcStudy.repository.TeacherRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author panjie on 2017/11/29
 */
public class TeacherServiceImplTest extends ServiceTest {
    private final static Logger logger = LoggerFactory.getLogger(TeacherServiceImplTest.class.getName());
    @Autowired
    TeacherService teacherService;
    @Autowired
    TeacherRepository teacherRepository; // 教师表
    @Autowired
    HttpSession httpSession;
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

        // 用户名密码正确。断言登录成功，断言成功存入session信息
        testTeacher.setPassword(teacher.getPassword());
        Assertions.assertThat(teacherService.login(testTeacher)).isTrue();
        Assertions.assertThat(testTeacher.getId()).isNotNull();
        Long teacherId = (Long) httpSession.getAttribute(TeacherService.TEACHER_ID);
        Assertions.assertThat(teacherId).isNotNull();
        Assertions.assertThat(teacherId).isNotEqualTo(0L);
        Assertions.assertThat(teacherId).isEqualTo(testTeacher.getId());

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

    @Test
    public void me() throws AuthException {
        logger.info("未登录，抛出异常");
        boolean catchException = false;
        try {
            teacherService.me();
        } catch (AuthException e) {
            catchException = true;
        }
        Assertions.assertThat(catchException).isTrue();


        logger.info("已登录，获取当前登录用户");
        Teacher teacher = teacherService.getOneSavedTeacher();
        teacherService.login(teacher);
        Teacher loginTeacher = teacherService.me();
        Assertions.assertThat(loginTeacher.getId()).isNotNull();
        Assertions.assertThat(loginTeacher.getName()).isNotNull();
    }

    @Test
    public void logout() throws AuthException {
        logger.info("未登录，直接注销，断言异常");
        boolean catchException = false;
        try {
            teacherService.logout();
        } catch (AuthException e) {
            catchException = true;
        }
        Assertions.assertThat(catchException).isTrue();

        logger.info("已登录");
        Teacher teacher = teacherService.getOneSavedTeacher();
        teacherService.login(teacher);

        logger.info("正常获取ME");
        Teacher currentLoginTeacher = teacherService.me();
        Assertions.assertThat(currentLoginTeacher.getId()).isEqualTo(teacher.getId());

        logger.info("注销");
        teacherService.logout();

        logger.info("获取ME异常");
        catchException = false;
        try {
            teacherService.me();
        } catch (AuthException e) {
            catchException = true;
        }
        Assertions.assertThat(catchException).isTrue();

    }
}