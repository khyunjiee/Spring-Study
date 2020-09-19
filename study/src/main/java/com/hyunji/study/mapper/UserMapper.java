package com.hyunji.study.mapper;

import com.hyunji.study.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

//    @Select("SELECT * FROM user")
    List<User> findAll();

//    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByIdx(@Param("userIdx") int userIdx);

    @Insert("INSERT INTO user(name, part) VALUES (#{name}, #{part})")
    @Options(useGeneratedKeys = true, keyColumn = "userIdx")
    int save(@Param("user") final User user);

}
