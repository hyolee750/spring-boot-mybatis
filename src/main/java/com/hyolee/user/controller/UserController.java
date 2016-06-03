package com.hyolee.user.controller;

import com.hyolee.user.domain.Page;
import com.hyolee.user.domain.QueryVo;
import com.hyolee.user.domain.User;
import com.hyolee.user.exception.ResourceNotFoundException;
import com.hyolee.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取所有的用户列表
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userService.getUsers();
    }

    /**
     * 跳转到首页，显示欢迎信息
     * @return
     */
    @RequestMapping("/index")
    public String hello(){
        return "hello spring boot";
    }

    /**
     * 根据id获取指定用户的信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}",method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable("id")Integer id){
        User user = userService.findById(id);
        if (user == null) {
            throw new ResourceNotFoundException("User with id " + id +" not found");
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    /**
     * 创建一个用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<User> create(@Valid @RequestBody User user){
        Integer id = userService.save(user);
        user.setId(id);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    /**
     * 删除一个用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id")Integer id){
        userService.delete(id);
        return ResponseEntity.ok("id:"+id + " user has deleted!");
    }

    /**
     * 更新一个用户
     * @param user
     * @return
     */
    @RequestMapping(value = "/users/{id}",method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody User user) {
        userService.update(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Page<User> getUserPage(QueryVo vo) {
        return userService.getUserPage(vo);
    }
}
