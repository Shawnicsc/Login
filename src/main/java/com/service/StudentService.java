package com.service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class  StudentService {
    private SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.GetSqlSessionFactory();

    /**
     * 用户名和密码查询
     * @param name
     * @param password
     * @return
     */
    public Student login(String name,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student = mapper.select(name, password);

        sqlSession.close();
        return student;
    }

    public boolean register(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student student1 = mapper.selectByName(student.getName());
        if(student1==null) {
            mapper.add(student);
            sqlSession.commit();
        }
        sqlSession.close();

        return student1 == null;
    }
}
