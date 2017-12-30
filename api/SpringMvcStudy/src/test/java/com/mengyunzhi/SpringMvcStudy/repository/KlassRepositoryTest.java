package com.mengyunzhi.SpringMvcStudy.repository;

import com.mengyunzhi.SpringMvcStudy.SpringMvcStudyApplicationTests;
import com.mengyunzhi.SpringMvcStudy.entity.Klass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @author panjie on 2017/12/12
 */
public class KlassRepositoryTest extends SpringMvcStudyApplicationTests{
    @Autowired KlassRepository klassRepository; // 班级
    @Test
    public void findTest() {
        Iterable<Klass> klasses = klassRepository.findAll();
        assertThat(klasses).isNotNull();
    }

    @Test
    public void findAllTest() {
        PageRequest pageRequest = new PageRequest(0, 2);
        Page<Klass> klasses = klassRepository.findAll(pageRequest);
        assertThat(klasses.getTotalElements()).isGreaterThanOrEqualTo(0);
    }
}