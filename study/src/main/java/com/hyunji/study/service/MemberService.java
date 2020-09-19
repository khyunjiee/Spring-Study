package com.hyunji.study.service;

import com.hyunji.study.dto.Member;
import com.hyunji.study.mapper.MemberMapper;
import com.hyunji.study.model.DefaultResponse;
import com.hyunji.study.model.LoginModel;
import com.hyunji.study.utils.ResponseMessage;
import com.hyunji.study.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MemberService {
    private final PasswordEncoder passwordEncoder;
    private final MemberMapper memberMapper;

    public MemberService(PasswordEncoder passwordEncoder, MemberMapper memberMapper) {
        this.passwordEncoder = passwordEncoder;
        this.memberMapper = memberMapper;
    }

    public DefaultResponse signUp(final LoginModel loginModel) {
        try {
            String encodePassword = passwordEncoder.encode(loginModel.getPassword());
            Member member = new Member(loginModel.getId(), encodePassword);

            int memberIdx = memberMapper.insertMember(member);

            return DefaultResponse.res(StatusCode.OK, ResponseMessage.CREATED_USER);
        } catch (Exception e) {
            log.info(e.getMessage());
            return DefaultResponse.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }

    public DefaultResponse signIn(final LoginModel loginModel) {
        try {
            Member member = memberMapper.findById(loginModel.getId());

            boolean matches = passwordEncoder.matches(loginModel.getPassword(), member.getPassword());

            // 로그인 성공
            if (matches) {
                return DefaultResponse.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS);
            }

            return DefaultResponse.res(StatusCode.BAD_REQUEST, ResponseMessage.LOGIN_FAIL);

        } catch (Exception e) {
            log.info(e.getMessage());
            return DefaultResponse.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
