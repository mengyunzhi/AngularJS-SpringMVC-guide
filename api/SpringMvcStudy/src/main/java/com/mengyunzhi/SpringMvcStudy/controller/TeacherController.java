package com.mengyunzhi.SpringMvcStudy.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import com.mengyunzhi.SpringMvcStudy.jsonView.TeacherJsonView;
import com.mengyunzhi.SpringMvcStudy.repository.TeacherRepository;
import com.mengyunzhi.SpringMvcStudy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author panjie on 2017/11/25
 */
@RestController //声明一个控制器
@RequestMapping("/Teacher") // 声明一个路由地址
public class TeacherController {
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
}
