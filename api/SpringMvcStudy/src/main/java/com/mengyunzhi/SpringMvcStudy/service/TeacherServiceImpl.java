package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import com.mengyunzhi.SpringMvcStudy.repository.TeacherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * 教师
 * @author panjie on 2017/11/29
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    private final static Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class.getName());

    @Autowired
    TeacherRepository teacherRepository;// 教师仓库
    @Autowired
    HttpSession httpSession;
    /**
     * 更新实体
     * @param id 被更新的实体ID
     * @param newTeacher 要更新的内容
     * panjie
     */
    @Override
    public void update(Long id, Teacher newTeacher) {
        // 获取数据表中已保存的那个实体
        Teacher oldTeacher = teacherRepository.findOne(id);

        // 依次的更新各个字段
        oldTeacher.setName(newTeacher.getName());
        oldTeacher.setUsername(newTeacher.getUsername());
        oldTeacher.setSex(newTeacher.isSex());
        oldTeacher.setEmail(newTeacher.getEmail());

        // 更新数据表
        teacherRepository.save(oldTeacher);
        return;
    }

    @Override
    public void delete(Long id) {
        teacherRepository.delete(id);
    }

    @Override
    public boolean login(Teacher teacher) {
        logger.debug("获取相关用户");
        Teacher persistTeacher = teacherRepository.findByUsername(teacher.getUsername());
        if (persistTeacher == null) {
            return false;
        }

        if (!persistTeacher.getPassword().equals(teacher.getPassword())) {
            return false;
        }

        logger.debug("记录当前用户ID");
        httpSession.setAttribute(TeacherService.TEACHER_ID, persistTeacher.getId());

        logger.debug("写入teacherId");
        teacher.setId(persistTeacher.getId());

        return true;
    }

    @Override
    public Teacher getOneTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("测试名称" + TeacherService.randomString(10));
        teacher.setUsername("teseUsername-" + TeacherService.randomString(20));
        teacher.setPassword("testPassword-" + TeacherService.randomString(10));
        return teacher;
    }

    @Override
    public Teacher getOneSavedTeacher() {
        Teacher teacher = this.getOneTeacher();
        teacherRepository.save(teacher);
        return teacher;
    }
}
