package com.cyd.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cyd.dao.IPersonal_gpDao;

import com.cyd.entity.Personal_gp;
import com.cyd.utils.JdbcUtils;

public class Personal_gpDao implements IPersonal_gpDao {

	@Override
	public void save(Personal_gp pgp) {
		String sql = "INSERT INTO personal_gp(id,pgp_create_name,pgp_create_identicard_id,getmoney,paymoney,pgp_info) VALUES(?,?,?,?,?,?)";
		try {
			//System.out.println(ea);
			JdbcUtils.getQuerrRunner().insert(sql,new BeanHandler<Personal_gp>(Personal_gp.class),pgp.getId(),pgp.getPgp_create_name(),pgp.getPgp_create_identicard_id(),pgp.getGetmoney(),pgp.getPaymoney(),pgp.getPgp_info());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(Personal_gp pgp) {
		String sql = "update personal_gp set pgp_create_name=?,pgp_create_identicard_id=?,getmoney=?,paymoney=?,pgp_info=? where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql,pgp.getPgp_create_name(),pgp.getPgp_create_identicard_id(),pgp.getGetmoney(),pgp.getPaymoney(),pgp.getPgp_info(),pgp.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from personal_gp where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public Personal_gp findById(int id) {
		String sql = "select * from personal_gp where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<Personal_gp>(Personal_gp.class),  id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Personal_gp> getAll() {
		String sql = "select * from personal_gp";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<Personal_gp>(Personal_gp.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Personal_gp> getAll(String pgp_create_name) {
		String sql = "select * from personal_gp where pgp_create_name like ?";
		try {
			return JdbcUtils.getQuerrRunner()
				.query(sql, new BeanListHandler<Personal_gp>(Personal_gp.class),"%" + pgp_create_name + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
