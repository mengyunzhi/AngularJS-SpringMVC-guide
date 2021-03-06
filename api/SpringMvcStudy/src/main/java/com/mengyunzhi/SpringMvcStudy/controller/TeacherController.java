package com.mengyunzhi.SpringMvcStudy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import com.mengyunzhi.SpringMvcStudy.jsonView.TeacherJsonView;
import com.mengyunzhi.SpringMvcStudy.repository.TeacherRepository;
import com.mengyunzhi.SpringMvcStudy.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author panjie on 2017/11/25
 */
@RestController //声明一个控制器
@RequestMapping("/Teacher") // 声明一个路由地址
public class TeacherController {
    private final static Logger logger = LoggerFactory.getLogger(TeacherController.class.getName());
    @Autowired
    TeacherRepository teacherRepository; // 自动装置一个实例化的TeacherRepository
    @Autowired
    TeacherService teacherService;   // 教师

    // 新增加一个地址为：/Teacher  的GET方法对应的action
    @GetMapping
    @JsonView(TeacherJsonView.class)
    public Iterable<Teacher> getAll() {
        Iterable teachers = teacherRepository.findAll();
        return teachers;
    }

    // 新增一个地址为：/Teacher/ 的post方法
    @PostMapping("/")
    public Teacher save(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
        return teacher;
    }

    @RequestMapping("/helloWorld") // 声明一个路由地址
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("this is name");
        helloWorld.setValue("this is value");
        return helloWorld;
    }

    // 使用{id} 说明，将/Teacher/xxxx 中的xxxx命名为id
    @GetMapping("/{id}")
    @JsonView(TeacherJsonView.class)
    public Teacher get(@PathVariable Long id) {
        Teacher teacher = teacherRepository.findOne(id);
        return teacher;
    }

    // 定义一个put路由来更新数据
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Teacher teacher) {
        teacherService.update(id, teacher);
        return;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }

    static public class HelloWorld {
        private String name;
        private String value;

        public HelloWorld() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    // 用户登录
    @PostMapping("/login")
    public void login(@RequestBody Teacher teacher, HttpServletResponse httpServletResponse) {
        logger.info("用户登录");
        if (teacherService.login(teacher)) {
            logger.info("登录成功");
        } else {
            httpServletResponse.setStatus(401);
            logger.info("登录失败");
        }
    }

    @GetMapping("/me")
    public Teacher me(HttpServletResponse httpServletResponse) {

        Teacher teacher = teacherService.me();
        return teacher;
    }

    @GetMapping("/getCurrentLoginTeacher")
    public Teacher getCurrentLoginTeacher(HttpServletResponse httpServletResponse) {
        return this.me(httpServletResponse);
    }


    @PostMapping("/logout")
    public void logout(HttpServletResponse httpServletResponse) {
        try {
            teacherService.logout();
        } catch (AuthException e) {
            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        }
    }


}
