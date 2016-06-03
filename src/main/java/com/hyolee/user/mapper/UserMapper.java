package com.hyolee.user.mapper;

import com.hyolee.user.domain.QueryVo;
import com.hyolee.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2016/6/2.
 */
@Mapper
public interface UserMapper {

    Integer save(User user);
    void update(User user);
    void delete(Integer id);
    User findById(Integer id);
    List<User> getAll();

    Integer getUserTotal(QueryVo vo);

    List<User> getUserPage(QueryVo vo);
}
