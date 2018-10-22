package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.entity.Teacher;

import java.security.SecureRandom;

/**
 * 教师
 *
 * @author panjie on 2017/11/29
 */
public interface TeacherService {
    String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    SecureRandom rnd = new SecureRandom();
    String TEACHER_ID = "teacherId";

    /**
     * 更新实体
     *
     * @param id
     * @param teacher panjie
     */
    void update(Long id, Teacher teacher);

    void delete(Long id);

    /**
     * 用户登录
     *
     * @param teacher
     * @return 成功 true; 失败 false
     */
    boolean login(Teacher teacher);

    /**
     * 获取一个教师
     *
     * @return
     */
    Teacher getOneTeacher();

    /**
     * 获取一个持久化的教师
     *
     * @return
     */
    Teacher getOneSavedTeacher();

    static String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
