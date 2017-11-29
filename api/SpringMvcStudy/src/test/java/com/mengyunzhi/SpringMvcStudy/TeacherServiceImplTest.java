package com.mengyunzhi.SpringMvcStudy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author panjie on 2017/11/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherServiceImplTest {
    @Autowired TeacherService teacherService;
    @Test
    public void updateTest() throws Exception {
        teacherService.update(1L, new Teacher());
    }

}