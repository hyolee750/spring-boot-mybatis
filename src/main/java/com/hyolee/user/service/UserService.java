package com.hyolee.user.service;

import com.hyolee.user.domain.Page;
import com.hyolee.user.domain.QueryVo;
import com.hyolee.user.domain.User;
//import com.hyolee.user.mapper.UserMapper;
import com.hyolee.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/2.
 */
@Service
//@Transactional
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getUsers(){
        return userMapper.getAll();
    }

    public User findById(Integer id) {
        return userMapper.findById(id);
    }

    public Integer save(User user) {
        return userMapper.save(user);
    }

    public void delete(Integer id) {
        userMapper.delete(id);
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public Page<User> getUserPage(QueryVo vo){
        Integer total = userMapper.getUserTotal(vo);
        Page<User> page = new Page<User>(vo.getPageNum(),total,vo.getPageSize(),vo.getDisplay());
        vo.setStartIndex(page.getStartIndex());
        List<User> list = userMapper.getUserPage(vo);
        page.setList(list);
        return page;
    }
}
