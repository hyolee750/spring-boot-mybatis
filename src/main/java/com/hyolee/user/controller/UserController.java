package com.hyolee.user.controller;

import com.hyolee.user.domain.User;
import com.hyolee.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getUsers();
    }
    @RequestMapping("/index")
    public String hello(){
        return "hello spring boot";
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id")Integer id){
        return userService.findById(id);
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user){
        Integer id = userService.save(user);
        user.setId(id);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id")Integer id){
        userService.delete(id);
        return ResponseEntity.ok("id:"+id + " user has deleted!");
    }

    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(user);
    }
}
