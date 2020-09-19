package com.hyunji.study.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String name;
    private String password;
}