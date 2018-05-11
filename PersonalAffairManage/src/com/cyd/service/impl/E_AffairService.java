package com.cyd.service.impl;

import java.util.List;

import com.cyd.dao.IE_AffairDao;
import com.cyd.entity.E_Affair;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IE_AffairService;

public class E_AffairService implements IE_AffairService{
	// 工厂创建对象
				private IE_AffairDao eaDao = BeanFactory.getInstance("eaDao", IE_AffairDao.class);
	@Override
	public void save(E_Affair ea) {
		try {
			eaDao.save(ea);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(E_Affair ea) {
		try {
			eaDao.update(ea);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(int id) {
		try {
			eaDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public E_Affair findById(int id) {
		try {
			return eaDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<E_Affair> getAll() {
		try {
			return eaDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<E_Affair> getAll(String ea_create_name) {
		try {
			return eaDao.getAll(ea_create_name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}

}
