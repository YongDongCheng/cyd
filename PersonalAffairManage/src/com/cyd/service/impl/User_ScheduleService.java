package com.cyd.service.impl;

import java.util.List;


import com.cyd.dao.IUser_ScheduleDao;
import com.cyd.entity.User_Schedule;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IUser_ScheduleService;

public class User_ScheduleService implements IUser_ScheduleService{
	// 工厂创建对象
	private IUser_ScheduleDao usDao = BeanFactory.getInstance("usDao", IUser_ScheduleDao.class);

	@Override
	public void save(User_Schedule us) {
		try {
			usDao.save(us);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(User_Schedule us) {
		try {
			usDao.update(us);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			usDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public User_Schedule findById(int id) {
		try {
			return usDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User_Schedule> getAll() {
		try {
			return usDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User_Schedule> getAll(String us_create_name) {
		try {
			return usDao.getAll(us_create_name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
