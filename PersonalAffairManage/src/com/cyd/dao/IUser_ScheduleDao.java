package com.cyd.dao;

import java.util.List;

import com.cyd.entity.User_Schedule;

/**
 * 1.日程安排模块，dao接口设计
 * @author YongDong.Cheng
 *
 */
public interface IUser_ScheduleDao {
	/**
	 * 添加
	 */
	void save(User_Schedule us);
	
	/**
	 * 更新
	 */
	void update(User_Schedule us);
	
	/**
	 * 删除
	 */
	void delete(int id);
	
	/**
	 * 根据主键查询
	 */
	User_Schedule  findById(int id);
	
	/**
	 * 查询全部
	 */
	List<User_Schedule> getAll();
	
	/**
	 * 根据创建者名称查询
	 */
	List<User_Schedule> getAll(String us_create_name);
	
}
