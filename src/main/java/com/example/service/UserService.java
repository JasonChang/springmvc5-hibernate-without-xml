package com.example.service;

import com.example.dao.UserDao;
import com.example.model.Authority;
import com.example.model.User;
import com.example.security.JwtUser;
import com.example.security.JwtUserFactory;
import com.example.type.AuthorityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<User> findUserById(long id) {
        return userDao.findById(id);
    }

    public void createUser(User u) {
        User old = userDao.findByUsername(u.getUsername());
        if(old == null){

            Authority auth = new Authority();
            auth.setName(AuthorityName.ROLE_USER);
            List<Authority> aList = new ArrayList<>();
            aList.add(auth);

            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(u.getPassword()));
            newUser.setAuthorities(aList);
            newUser.setEnabled(true);
            newUser.setUsername(u.getUsername());
            newUser.setLastPasswordResetDate(new Date());
            userDao.save(newUser);
        } else {

        }
    }

    public List<JwtUser> findAllUser() {
        List<JwtUser> juList = new ArrayList<>();
        List<User> userList = userDao.findAll();
        userList.forEach(u ->{
            juList.add(JwtUserFactory.create(u));
        });
        return juList;
    }
}
