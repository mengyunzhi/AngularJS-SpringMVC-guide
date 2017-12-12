package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.repository.Teacher;

/**
 * 教师
 * @author panjie on 2017/11/29
 */
public interface TeacherService {
    /**
     * 更新实体
     * @param id
     * @param teacher
     * panjie
     */
    void update(Long id, Teacher teacher);

    void delete(Long id);
}
