package com.cyd.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cyd.dao.IUser_ScheduleDao;

import com.cyd.entity.User_Schedule;
import com.cyd.utils.JdbcUtils;

public class User_ScheduleDao implements IUser_ScheduleDao {

	@Override
	public void save(User_Schedule us) {
		String sql = "INSERT INTO user_schedule(id,us_create_name,us_create_identicard_id,us_content,us_place,us_info) VALUES(?,?,?,?,?,?)";
		try {
			JdbcUtils.getQuerrRunner().insert(sql,new BeanHandler<User_Schedule>(User_Schedule.class),us.getId(),us.getUs_create_name(),us.getUs_create_identicard_id(),us.getUs_content(),us.getUs_place(),us.getUs_info());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(User_Schedule us) {
		String sql = "update user_schedule set us_create_name=?,us_create_identicard_id=?,us_content=?,us_place=?,us_info=? where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql,us.getUs_create_name(),us.getUs_create_identicard_id(),us.getUs_content(),us.getUs_place(),us.getUs_info(),us.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from user_schedule where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public User_Schedule findById(int id) {
		String sql = "select * from user_schedule where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<User_Schedule>(User_Schedule.class),  id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User_Schedule> getAll() {
		String sql = "select * from user_schedule";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<User_Schedule>(User_Schedule.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User_Schedule> getAll(String us_create_name) {
		String sql = "select * from user_schedule where us_create_name like ?";
		try {
			return JdbcUtils.getQuerrRunner()
				.query(sql, new BeanListHandler<User_Schedule>(User_Schedule.class),"%" + us_create_name + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
