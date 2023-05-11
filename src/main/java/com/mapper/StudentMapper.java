package com.mapper;

import com.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface StudentMapper {
    /**
     * 根据name 和 password 查询
     * @param name
     * @param password
     * @return
     */
    @Select("select * from student where name = #{name} and password = #{password}")
    Student select(@Param("name") String name, @Param("password") String password);

    /**
     * 用户名查询
     * @param name
     * @return
     */
    @Select("select * from student where name = #{name}")
    Student selectByName(@Param("name") String name);

    /**
     * 新增
     * @param student
     */
    @Insert("insert into student values(null,#{name},#{password})")
    void add(Student student);
}
