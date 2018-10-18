package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.entity.Teacher;

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

    /**
     * 用户登录
     * @param teacher
     * @return 成功 true; 失败 false
     */
    boolean login(Teacher teacher);
}
