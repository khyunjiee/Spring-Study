package com.hyunji.study.controller;

import com.hyunji.study.model.DefaultResponse;
import com.hyunji.study.model.LoginModel;
import com.hyunji.study.service.MemberService;
import com.hyunji.study.utils.ResponseMessage;
import com.hyunji.study.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MemberController {

    private MemberService memberService;

    /*
     * MemberService 생성자 의존성 주입
     * @Param MemberService
     */
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원가입
    @PostMapping("signUp")
    public ResponseEntity signUp(@RequestBody LoginModel loginModel) {
        try {
            return new ResponseEntity(memberService.signUp(loginModel), HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity(DefaultResponse.FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 로그인
    @PostMapping("signIn")
    public ResponseEntity signIn(@RequestBody LoginModel loginModel) {
        try {
            return new ResponseEntity(memberService.signIn(loginModel), HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity(DefaultResponse.FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
