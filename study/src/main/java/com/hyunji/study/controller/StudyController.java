package com.hyunji.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudyController {

//    @GetMapping("study")
//    public String study(Model model) {
//        model.addAttribute("key", "화요일");
//        return "study";
//    }

    @GetMapping("test/{id}")
    public String test(@PathVariable int id) {
        System.out.println(id);
        return "study";
    }
}
