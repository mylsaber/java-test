package com.mylsaber.mybatismultidatasource.controller;

import com.mylsaber.mybatismultidatasource.constant.DataEnum;
import com.mylsaber.mybatismultidatasource.entity.Student;
import com.mylsaber.mybatismultidatasource.service.HelloService;
import com.mylsaber.mybatismultidatasource.utils.SwitchDataSource;
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
    public List<Student> hello(@PathVariable String dbId) {
        SwitchDataSource.setDataSource(DataEnum.getDataSourceName(dbId));
        return helloService.listStudent();
    }
}
