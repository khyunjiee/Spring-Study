package com.hyunji.study.service;

import com.hyunji.study.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {

    // 유저를 담는 List
    private static List<User> users = new ArrayList<>();

    // 유저 인원
    private static int userCount = 3;

    static {
        users.add(new User(1, "A", new Date()));
        users.add(new User(2, "B", new Date()));
        users.add(new User(3, "C", new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }


}
