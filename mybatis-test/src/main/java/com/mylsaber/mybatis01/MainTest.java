package com.mylsaber.mybatis01;

import com.mylsaber.mybatis01.dao.StudentMapper;
import com.mylsaber.mybatis01.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainTest {
    // 根据 mybatis-config.xml 配置的信息得到 sqlSessionFactory
    String resource = "mybatis-config.xml";
    InputStream inputStream;
    SqlSessionFactory sqlSessionFactory;
    // 然后根据 sqlSessionFactory 得到 session
    SqlSession session;

    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    @After
    public void after() {
        session.close();
    }

    @Test
    public void mybatisXml() {
        // 最后通过 session 的 selectList() 方法调用 sql 语句 listStudent
        List<Student> listStudent = session.selectList("com.mylsaber.mybatis01.dao.StudentMapper.listStudent");
        for (Student student : listStudent) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName() + ",GENDER:" + student.getGender());
        }
    }

    @Test
    public void mybatisXmlDao() {
        final StudentMapper mapper = session.getMapper(StudentMapper.class);
        final List<Student> students = mapper.listStudent();
        for (Student student : students) {
            System.out.println("ID:" + student.getId() + ",NAME:" + student.getName() + ",GENDER:" + student.getGender());
        }
    }
}
