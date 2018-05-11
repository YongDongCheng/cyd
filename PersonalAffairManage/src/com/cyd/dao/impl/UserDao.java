package com.cyd.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cyd.dao.IUserDao;
import com.cyd.entity.User;
import com.cyd.utils.JdbcUtils;

public class UserDao implements IUserDao {

	@Override
	public void save(User user) {
		String sql = "INSERT INTO user(identicard_id,name,age,sex,salary,marry_condition,job,address,phone) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			JdbcUtils.getQuerrRunner().insert(sql,new BeanHandler<User>(User.class),user.getIdenticard_id(),user.getName(),user.getAge(),user.getSex(),user.getSalary(),user.getMarry_condition(),user.getJob(),user.getAddress(),user.getPhone());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(User user) {
		String sql = "update user set name=?,age=?,sex=?,salary=?,marry_condition=?,job=?,address=?,phone=? where identicard_id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql,user.getName(),user.getAge(),user.getSex(),user.getSalary(),user.getMarry_condition(),user.getJob(),user.getAddress(),user.getPhone(),user.getIdenticard_id());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(String identicard_id) {
		
		String sql = "delete from user where identicard_id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, identicard_id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findByIdenticard_id(String identicard_id) {
		
		String sql = "select * from user where identicard_id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<User>(User.class),  identicard_id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
        
	}

	@Override
	public List<User> getAll() {
		
		String sql = "select * from user";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<User>(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getAll(String name) {
		
		String sql = "select * from user where name like ?";
		try {
			return JdbcUtils.getQuerrRunner()
				.query(sql, new BeanListHandler<User>(User.class),"%" + name + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
