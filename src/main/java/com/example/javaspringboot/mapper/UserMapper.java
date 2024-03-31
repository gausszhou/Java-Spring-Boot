package com.example.javaspringboot.mapper;

import com.example.javaspringboot.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username, password) values (#{username}, #{password})")
    int insert(User user);

    @Delete("delete from user where id=#{id}")
    int delete(int id);

    @Insert("update user set username=#{username}, password=#{password} where id=#{id}")
    int update(User user);

    @Select("select * from user where id=#{id}")
    User findById(int id);

    @Select("select * from user limit 10;")
    List<User> findAll();
}

