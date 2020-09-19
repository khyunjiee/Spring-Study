package com.hyunji.study.service;

import com.hyunji.study.mapper.UserMapper;
import com.hyunji.study.model.DefaultResponse;
import com.hyunji.study.model.User;
import com.hyunji.study.utils.ResponseMessage;
import com.hyunji.study.utils.StatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 조회
    public DefaultResponse getAllUser() {
        final List<User> userList = userMapper.findAll();
        if (userList.isEmpty()) return DefaultResponse.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        return DefaultResponse.res(StatusCode.OK, ResponseMessage.READ_USER, userList);
    }

    // 아이디로 조회
    public DefaultResponse findUser(final int idx) {
        final User user = userMapper.findByIdx(idx);
        if (user == null) return DefaultResponse.res(StatusCode.NOT_FOUND, ResponseMessage.NOT_FOUND_USER);

        return DefaultResponse.res(StatusCode.OK, ResponseMessage.READ_USER, user);
    }
}
