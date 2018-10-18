package com.mengyunzhi.SpringMvcStudy.repository;

import com.mengyunzhi.SpringMvcStudy.SpringMvcStudyApplicationTests;
import com.mengyunzhi.SpringMvcStudy.entity.Teacher;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class TeacherRepositoryTest extends SpringMvcStudyApplicationTests {
    private final static Logger logger = LoggerFactory.getLogger(TeacherRepositoryTest.class.getName());

    @Autowired TeacherRepository teacherRepository;

    @Test
    public void findByUsername() {
        logger.debug("实例化一个教师");
        Teacher teacher = new Teacher();
        teacher.setUsername("owpKyaRMPMPMvYM4qKst5poV3LN2AfP4");
        teacher.setPassword("fULN5EyT5ioPrikWVU7mNA89W61flBkF");
        teacherRepository.save(teacher);

        logger.debug("通过用户名查找教师，并断言查找成功");
        Teacher persistTeacher = teacherRepository.findByUsername(teacher.getUsername());
        Assertions.assertThat(persistTeacher).isNotNull();
    }
}