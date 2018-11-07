package com.example.rest;

import com.example.model.User;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("user")
public class UserRest {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    protected ResponseEntity findUserById(@PathVariable Long id) {
        return new ResponseEntity(userService.findUserById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    protected ResponseEntity findAllUser() {
        log.debug("findAllUser");
        return new ResponseEntity(userService.findAllUser(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseBody
    protected ResponseEntity createUser(@RequestBody User u) {
        log.debug("createUser");
        userService.createUser(u);
        return new ResponseEntity( HttpStatus.OK);
    }
}
