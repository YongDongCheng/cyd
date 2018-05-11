package com.cyd.service.impl;

import java.util.List;

import com.cyd.dao.IPersonal_gpDao;
import com.cyd.entity.Personal_gp;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IPersonal_gpService;


public class Personal_gpService implements IPersonal_gpService{
	// 工厂创建对象
	   private IPersonal_gpDao pgpDao = BeanFactory.getInstance("pgpDao", IPersonal_gpDao.class);
	
	@Override
	public void save(Personal_gp pgp) {
		try {
			pgpDao.save(pgp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Personal_gp pgp) {
		try {
			pgpDao.update(pgp);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public void delete(int id) {
		try {
			pgpDao.delete(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Personal_gp findById(int id) {
		try {
			return pgpDao.findById(id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Personal_gp> getAll() {
		try {
			return pgpDao.getAll();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Personal_gp> getAll(String pgp_create_name) {
		try {
			return pgpDao.getAll(pgp_create_name);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
