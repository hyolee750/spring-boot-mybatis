package com.hyolee.user;

import com.hyolee.user.domain.User;
//import com.hyolee.user.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootUserApplication.class)
@WebAppConfiguration
public class SpringBootUserApplicationTests {


	@Test
	public void contextLoads() {
	}

}
