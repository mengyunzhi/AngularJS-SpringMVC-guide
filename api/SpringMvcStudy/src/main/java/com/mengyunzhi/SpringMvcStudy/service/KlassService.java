package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.repository.Klass;

/**
 * @author panjie on 2017/12/12
 * 班级
 */
public interface KlassService {
    Klass save(Klass klass);

    Iterable<Klass> getAll();

    Klass getById(Long id);

    /**
     * 更新
     * @param id 更新实体的iD
     * @param klass 更新的内容
     *              @author panjie
     */
    void updateByIdAndKlass(Long id, Klass klass);
}
