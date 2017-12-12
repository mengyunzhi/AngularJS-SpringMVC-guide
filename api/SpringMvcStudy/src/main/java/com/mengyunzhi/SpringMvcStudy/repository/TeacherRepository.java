package com.mengyunzhi.SpringMvcStudy.repository;

import org.springframework.data.repository.CrudRepository;

/**
 * @author panjie on 2017/11/25
 * 建立一个访问teacher数据表的接口
 * 指名：
 * 1. 要操作的为Teacher数据
 * 2. Teacher数据表中主键类型是Long
 */
public interface TeacherRepository extends CrudRepository<Teacher, Long>{
}
