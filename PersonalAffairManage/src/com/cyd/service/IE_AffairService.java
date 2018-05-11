package com.cyd.service;

import java.util.List;

import com.cyd.entity.E_Affair;

public interface IE_AffairService {
	//添加
	void save(E_Affair ea);
	//更新
	void update(E_Affair ea);
	//删除
	void delete(int id);
    //根据主键查询
	E_Affair  findById(int id);
	//查询全部
	List<E_Affair> getAll();
	//根据创建者名字查询
	List<E_Affair> getAll(String ea_create_name);
}
