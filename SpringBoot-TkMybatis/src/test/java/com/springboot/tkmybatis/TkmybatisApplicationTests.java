package com.springboot.tkmybatis;

import com.springboot.tkmybatis.domain.User;
import com.springboot.tkmybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TkmybatisApplicationTests {

	@Resource
	private UserMapper userMapper;

	@Test
	void contextLoads() {

	}

	@Test
	void insert() {
		User user = new User();
		user.setUsername(null);
//		user.setUsername("user");
//		user.setPassword("123456");
		user.setPassword(null);
		int result = userMapper.insert(user);
		if (result > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}
	}

	@Test
	void insertSelective() {
		User user = new User();
		user.setUsername(null);
//		user.setUsername("user");
//		user.setPassword("123456");
		user.setPassword(null);
		int result = userMapper.insertSelective(user);
		if (result > 0) {
			System.out.println("插入成功");
		} else {
			System.out.println("插入失败");
		}
	}

	@Test
	void delete() {
		User user = new User();
//		user.setUsername("2");
		user.setPassword("2");
		int result = userMapper.delete(user);
		if (result > 0) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

	@Test
	void updateByPrimaryKeySelective() {
		User user = new User();
		user.setId(6);
		user.setUsername("tom");
		user.setPassword("tom");
		int result = userMapper.updateByPrimaryKeySelective(user);
		if (result > 0) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}
	}

	@Test
	void select() {
		User user = new User();
//		user.setId(2);
//		user.setUsername("admin");
		user.setPassword("123456");
		List<User> users = userMapper.select(null);
		System.out.println(users);
	}

	@Test
	void selectAll() {
		List<User> users = userMapper.selectAll();
		System.out.println(users);
	}

	@Test
	void selectOne() {
		User user = new User();
		user.setPassword("admin");
		User user1 = userMapper.selectOne(user);
		System.out.println(user1);
	}

	@Test
	void selectCount() {
		User user = new User();
//		user.setId(1);
		user.setUsername("admin");
//		user.setPassword("123456");
		int result = userMapper.selectCount(user);
		System.out.println(result);
	}

	@Test
	void insertList() {
		User user = new User();
		user.setUsername("test1");
		user.setPassword("test1");
		User user1 = new User();
		user1.setPassword("test2");
		user1.setUsername("test2");
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user1);
		int result = userMapper.insertList(users);
		System.out.println(result);
	}

	@Test
	void insertUseGeneratedKeys() {
		User user = new User();
		user.setUsername("dd");
		user.setPassword("dd");
		int result = userMapper.insertUseGeneratedKeys(user);
		System.out.println(result);
	}

	@Test
	void selectByIds() {
		String id = "1";
		List<User> users = userMapper.selectByIds(id);
		System.out.println(users);
	}

	@Test
	void deleteByIds() {
		String id = "5,6";
		int result = userMapper.deleteByIds(id);
		System.out.println(result);
	}

	@Test
	void selectByCondition() {
		Condition condition = new Condition(User.class);
		Example.Criteria criteria = condition.createCriteria();
		criteria.andLike("username", "%s%");
		List<User> users = userMapper.selectByCondition(condition);
		System.out.println(users);
	}

	@Test
	void selectByExample() {
		Example example = new Example(User.class);
		Example.Criteria criteria = example.createCriteria();
		criteria.andLike("username", "%s%");
		List<User> users = userMapper.selectByExample(example);
		System.out.println(users);
	}

	@Test
	void selectByPrimaryKey() {
		Integer id = 1;
		User user = userMapper.selectByPrimaryKey(id);
		System.out.println(user);
	}
}
