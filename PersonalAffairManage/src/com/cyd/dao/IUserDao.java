package com.cyd.dao;

import java.util.List;

import com.cyd.entity.User;

/**
 * 1.用户管理模块，dao接口设计
 * @author YongDong.Cheng
 *
 */
public interface IUserDao {
	/**
	 * 添加
	 */
	void save(User user);
	
	/**
	 * 更新
	 */
	void update(User user);
	
	/**
	 * 删除
	 */
	void delete(String identicard_id);
	
	/**
	 * 根据主键查询
	 */
	User findByIdenticard_id(String identicard_id);
	
	/**
	 * 查询全部
	 */
	List<User> getAll();
	
	/**
	 * 根据用户名称查询
	 */
	List<User> getAll(String name);
	
}
