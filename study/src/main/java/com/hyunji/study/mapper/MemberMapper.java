package com.hyunji.study.mapper;

import com.hyunji.study.dto.Member;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member (id, password) VALUES(#{id}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "memberIdx")
    int insertMember(Member member);

    @Select("SELECT * FROM member WHERE id = #{id}")
    Member findById(@Param("id") String id);
}
