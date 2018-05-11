package com.cyd.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.cyd.dao.IE_AffairDao;
import com.cyd.entity.E_Affair;
import com.cyd.utils.JdbcUtils;

public class E_AffairDao implements IE_AffairDao {

	@Override
		public void save(E_Affair ea) {
		
			String sql = "INSERT INTO e_affair(id,ea_create_name,ea_create_identicard_id,ea_object,ea_place,ea_content,ea_info) VALUES(?,?,?,?,?,?,?)";
			try {
				//System.out.println(ea);
				JdbcUtils.getQuerrRunner().insert(sql,new BeanHandler<E_Affair>(E_Affair.class),ea.getId(),ea.getEa_create_name(),ea.getEa_create_identicard_id(),ea.getEa_object(),ea.getEa_place(),ea.getEa_content(),ea.getEa_info());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		
	}

	@Override
	public void update(E_Affair ea) {
		String sql = "update e_affair set ea_create_name=?,ea_create_identicard_id=?,ea_object=?,ea_place=?,ea_content=?,ea_info=? where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql,ea.getEa_create_name(),ea.getEa_create_identicard_id(),ea.getEa_object(),ea.getEa_place(),ea.getEa_content(),ea.getEa_info(), ea.getId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from e_affair where id=?";
		try {
			JdbcUtils.getQuerrRunner().update(sql, id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public E_Affair findById(int id) {
		String sql = "select * from e_affair where id=?";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanHandler<E_Affair>(E_Affair.class),  id);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<E_Affair> getAll() {
		String sql = "select * from e_affair";
		try {
			return JdbcUtils.getQuerrRunner().query(sql, new BeanListHandler<E_Affair>(E_Affair.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<E_Affair> getAll(String ea_create_name) {
		String sql = "select * from e_affair where ea_create_name like ?";
		try {
			return JdbcUtils.getQuerrRunner()
				.query(sql, new BeanListHandler<E_Affair>(E_Affair.class),"%" + ea_create_name + "%");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
