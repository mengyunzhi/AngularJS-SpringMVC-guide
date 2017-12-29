package com.mengyunzhi.SpringMvcStudy.service;

import com.mengyunzhi.SpringMvcStudy.repository.Klass;
import com.mengyunzhi.SpringMvcStudy.repository.KlassRepository;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


/**
 * @author panjie on 2017/12/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KlassServiceImplTest {


    private final static Logger logger = Logger.getLogger(KlassServiceImplTest.class.getName());
    @Autowired KlassService klassService;   // 班级
    @Autowired
    KlassRepository klassRepository;    // 班级
    @Test
    public void save() throws Exception {
        logger.info("new一个对象");
        Klass klass = new Klass();

        logger.info("调用保存方法");
        klassService.save(klass);

        logger.info("去数据表中查这个对象");
        Klass newKlass = klassRepository.findOne(klass.getId());

        logger.info("断言查询到的值不是null");
        assertThat(newKlass).isNotNull();
    }

    @Test
    public void getAll() throws Exception {
        logger.info("new一个对象");
        Klass klass = new Klass();

        logger.info("调用保存方法");
        klassService.save(klass);

        List<Klass> klassList = (List<Klass>) klassService.getAll();
        assertThat(klassList.size()).isNotZero();
    }

    @Test
    public void delete() {
        logger.info("new 一个对象");
        Klass klass = new Klass();
        klassRepository.save(klass);

        logger.info("调用M层的删除方法");
        klassService.delete(klass.getId());

        logger.info("断方删除是否成功");
        Klass newKlass = klassRepository.findOne(klass.getId());
        assertThat(newKlass).isNull();
    }
}