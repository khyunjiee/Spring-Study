package com.hyunji.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int userIdx;
    private String name;
    private String part;
}
