package com.cyd.service;

import java.util.List;

import com.cyd.entity.Personal_Con;

public interface IPersonal_ConService {
	//添加
	void save(Personal_Con pc);
	//更新
	void update(Personal_Con pc);
	//删除
	void delete(int id);
    //根据主键查询
	Personal_Con findById(int id);
	//查询全部
	List<Personal_Con> getAll();
	//根据创建者名称查询
	List<Personal_Con> getAll(String pc_create_name);
}
