package com.cyd.service;

import java.util.List;

import com.cyd.entity.User;

/**
 * 3. 用户登录模块业务逻辑层，接口设计
 * @author YongDong.Cheng
 *
 */
public interface  IUserService {
	//添加
	void save(User user);
	//更新
	void update(User user);
	//删除
	void delete(String identicard_id);
	//根据主键查询
	User findByIdenticard_id(String identicard_id);
	//查询全部
	List<User> getAll();
	//根据用户名称查询
	List<User> getAll(String name);	
}
