package com.example.javaspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javaspringboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperV2 extends BaseMapper<User> {
}
