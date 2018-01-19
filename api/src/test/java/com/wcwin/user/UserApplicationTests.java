package com.wcwin.user;

import com.wccwin.api.ApiApplication;
import com.wccwin.api.bean.req.Login;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class UserApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","end");
		Login login = new Login();
		login.setPhone("18616918251");
		login.setPwd("aaabbbccc");
		login.setSource("web");

		ValueOperations<String, Login> operations =  redisTemplate.opsForValue();

		operations.set("kation_test", login);

		//redisTemplate.delete("set");

	}

}
