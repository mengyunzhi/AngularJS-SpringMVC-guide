package com.mengyunzhi.SpringMvcStudy.repository;

import com.mengyunzhi.SpringMvcStudy.entity.Klass;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author panjie on 2017/12/12
 * 班级
 */
public interface KlassRepository extends PagingAndSortingRepository<Klass, Long> {
}
