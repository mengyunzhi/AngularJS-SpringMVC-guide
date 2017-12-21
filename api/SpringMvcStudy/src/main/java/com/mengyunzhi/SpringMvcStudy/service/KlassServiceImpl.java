package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.repository.Klass;
import com.mengyunzhi.SpringMvcStudy.repository.KlassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author panjie on 2017/12/12
 * 班级
 */
@Service
public class KlassServiceImpl implements KlassService {
    @Autowired
    KlassRepository klassRepository;    // 班级

    @Override
    public Klass save(Klass klass) {
        return klassRepository.save(klass);
    }

    @Override
    public Iterable<Klass> getAll() {
        return klassRepository.findAll();
    }

    @Override
    public Klass getById(Long id) {
        return klassRepository.findOne(id);
    }
}
