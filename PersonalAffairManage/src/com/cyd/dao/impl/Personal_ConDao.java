package com.cyd.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cyd.dao.IPersonal_ConDao;
import com.cyd.entity.Personal_Con;
import com.cyd.utils.JdbcUtils;

public class Personal_ConDao implements IPersonal_ConDao{
	@Override
	public void save(Personal_Con pc) {
		String sql = "INSERT INTO personal_con(id,pc_create_name,pc_create_identicard_id,pc_object,object_company,object_mobile,object_con,object_job,object_info) VALUES(?,?,?,?,?,?,?,?,?)";
		try {
			//System.out.println(pc);
			JdbcUtils.getQuerrRunner().insert(sql,new BeanHandler<Personal_Con>(Personal_Con.class),pc.getId(),pc.getPc_create_name(),pc.getPc_create_identicard_id(),pc.getPc_object(),pc.getObject_company(),pc.getObject_mobile(),pc.getObject_con(),pc.getObject_job(),pc.getObject_info());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void update(Personal_Con pc) {
		String sql = "update personal_con set pc_create_name=?,pc_create_identicard_id=?,pc_object=?,object_company=?,object_mobile=?,object_con=?,object_job=?,object_info=? where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, pc.getPc_create_name(),pc.getPc_create_identicard_id(),pc.getPc_object(),pc.getObject_company(),pc.getObject_mobile(),pc.getObject_con(),pc.getObject_job(),pc.getObject_info(),pc.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from personal_con where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Personal_Con findById(int id) {
		String sql = "select * from personal_con where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<Personal_Con>(Personal_Con.class),  id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Personal_Con> getAll() {
		String sql = "select * from personal_con";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Personal_Con>(Personal_Con.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Personal_Con> getAll(String pc_create_name) {
		String sql = "select * from personal_con where pc_create_name like ?";
		try {
			return JdbcUtils.getQuerrRunner()
				.query(sql, new BeanListHandler<Personal_Con>(Personal_Con.class),"%" + pc_create_name + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
