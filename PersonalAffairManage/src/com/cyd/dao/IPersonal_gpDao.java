package com.cyd.dao;

import java.util.List;


import com.cyd.entity.Personal_gp;

/**
 * 1.个人收支管理模块，dao接口设计
 * @author YongDong.Cheng
 *
 */
public interface IPersonal_gpDao {
	/**
	 * 添加
	 */
	void save(Personal_gp pgp);
	
	/**
	 * 更新
	 */
	void update(Personal_gp pgp);
	
	/**
	 * 删除
	 */
	void delete(int id);
	
	/**
	 * 根据主键查询
	 */
	Personal_gp  findById(int id);
	
	/**
	 * 查询全部
	 */
	List<Personal_gp > getAll();
	
	/**
	 * 根据创建者名称查询
	 */
	List<Personal_gp > getAll(String pgp_create_name);
	
}
