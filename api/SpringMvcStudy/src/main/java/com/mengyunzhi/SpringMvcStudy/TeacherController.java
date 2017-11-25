package com.mengyunzhi.SpringMvcStudy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panjie on 2017/11/25
 */
@RestController //声明一个控制器
@RequestMapping("/Teacher") // 声明一个路由地址
public class TeacherController {

    @RequestMapping("/helloWorld") // 声明一个路由地址
    public HelloWorld helloWorld() {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.setName("this is name");
        helloWorld.setValue("this is value");
        return helloWorld;
    }

    static public class HelloWorld {
        private String name;
        private String value;

        public HelloWorld() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
