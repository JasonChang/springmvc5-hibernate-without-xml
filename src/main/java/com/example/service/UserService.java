package com.example.service;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Optional<User> findUserById(long id) {
        return userDao.findById(id);
    }

    public void createUser(String name) {
        User u = new User();
        u.setName(name);
        userDao.save(u);
    }

    public List<User> findAllUser() {
        return userDao.findAll();
    }
}
