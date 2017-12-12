package com.mengyunzhi.SpringMvcStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
/**
 * @author panjie on 2017/11/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {
    @Autowired TeacherService teacherService;
    @Autowired TeacherRepository teacherRepository; // 教师表
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

}