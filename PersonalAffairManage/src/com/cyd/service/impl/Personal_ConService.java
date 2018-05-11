package com.cyd.service.impl;

import java.util.List;

import com.cyd.dao.IPersonal_ConDao;
import com.cyd.entity.Personal_Con;
import com.cyd.factory.BeanFactory;
import com.cyd.service.IPersonal_ConService;

public class Personal_ConService implements IPersonal_ConService {
	// 工厂创建对象
			private IPersonal_ConDao pcDao = BeanFactory.getInstance("pcDao", IPersonal_ConDao.class);

			@Override
			public void save(Personal_Con pc) {
				try {
					pcDao.save(pc);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			@Override
			public void update(Personal_Con pc) {
				try {
					pcDao.update(pc);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
			}

			@Override
			public void delete(int id) {
				try {
					pcDao.delete(id);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				
			}

			@Override
			public Personal_Con findById(int id) {
				try {
					return pcDao.findById(id);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			@Override
			public List<Personal_Con> getAll() {
				try {
					return pcDao.getAll();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

			@Override
			public List<Personal_Con> getAll(String pc_create_name) {
				try {
					return pcDao.getAll(pc_create_name);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
}
