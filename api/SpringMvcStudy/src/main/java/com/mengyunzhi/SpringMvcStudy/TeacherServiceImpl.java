package com.mengyunzhi.SpringMvcStudy;

import com.mengyunzhi.SpringMvcStudy.repository.Teacher;
import com.mengyunzhi.SpringMvcStudy.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 教师
 * @author panjie on 2017/11/29
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;// 教师仓库
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
}
