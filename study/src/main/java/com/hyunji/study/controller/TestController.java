package com.hyunji.study.controller;

import com.hyunji.study.model.DefaultResponse;
import com.hyunji.study.model.LoginRequest;
import com.hyunji.study.utils.ResponseMessage;
import com.hyunji.study.utils.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("login")
    public ResponseEntity text(@RequestBody LoginRequest loginRequest) {
        return new ResponseEntity(DefaultResponse.res(StatusCode.OK, ResponseMessage.LOGIN_SUCCESS, loginRequest), HttpStatus.OK);
    }
}
