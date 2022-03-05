package com.mylsaber.mybatismultidatasource.controller;

import com.mylsaber.mybatismultidatasource.config.DataSource;
import com.mylsaber.mybatismultidatasource.entity.Student;
import com.mylsaber.mybatismultidatasource.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jfw
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello/{dbId}")
    @DataSource()
    public List<Student> hello(@PathVariable String dbId) {
//        if (Objects.equals(dbId, "2")) {
//            SwitchDataSource.setDataSource("dataSource2");
//        }
        return helloService.listStudent();
    }
}
