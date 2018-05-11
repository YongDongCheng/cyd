package com.cyd.service.impl;

import java.util.List;

import com.cyd.dao.IUserDao;
import com.cyd.entity.User;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IUserService;

public class UserService implements IUserService {
	// 工厂创建对象
		private IUserDao userDao = BeanFactory.getInstance("userDao", IUserDao.class);

	@Override
	public void save(User user) {
		try {
			userDao.save(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(User user) {
		try {
			userDao.update(user);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(String identicard_id) {
		try {
			userDao.delete(identicard_id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		
	}

	@Override
	public User findByIdenticard_id(String identicard_id) {
		try {
			return userDao.findByIdenticard_id(identicard_id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getAll() {
		try {
			return userDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getAll(String name) {

		try {
			return userDao.getAll(name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
