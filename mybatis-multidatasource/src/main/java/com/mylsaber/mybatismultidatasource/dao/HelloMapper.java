package com.mylsaber.mybatismultidatasource.dao;

import com.mylsaber.mybatismultidatasource.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jfw
 */
@Mapper
public interface HelloMapper {

    List<Student> listStudent();

}
