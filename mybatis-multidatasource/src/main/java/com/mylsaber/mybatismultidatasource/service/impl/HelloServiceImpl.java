package com.mylsaber.mybatismultidatasource.service.impl;

import com.mylsaber.mybatismultidatasource.dao.HelloMapper;
import com.mylsaber.mybatismultidatasource.entity.Student;
import com.mylsaber.mybatismultidatasource.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jfw
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    private HelloMapper helloMapper;

    @Override
    public List<Student> listStudent() {
        return helloMapper.listStudent();
    }
}
