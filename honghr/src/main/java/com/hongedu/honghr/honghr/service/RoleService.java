package com.hongedu.honghr.honghr.service;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hongedu.honghr.base.dao.expression.Exp;
import com.hongedu.honghr.honghr.entity.Role;
import com.hongedu.honghr.util.page.Pager;

import com.hongedu.honghr.base.dao.BaseDaoImpl;

/**
 * @author  
 * el_sys_role 表对应业务实现对象
 * 2017/12/07 04:00:58
 */
@Transactional
@Service
public class RoleService{
	
	@Autowired
	private BaseDaoImpl<Role> roleDao;
	
	/**
	 * 根据主键查询Role对象
	 * @param id
	 * @return
	 */
	public Role findById (Serializable id){
		Role entity = roleDao.findById(Role.class, id);
		return entity;
	}
	
	/**
	 * 插入Role对象
	 * @param entity
	 */
	public void save (Role entity){
		roleDao.save(entity);
	}
	
	/**
	 * 修改Role对象
	 * @param entity
	 */
	public void update (Role entity){
		roleDao.update(entity);
	}
	
	/**
	 * 删除Role对象
	 * @param id
	 */
	public void delete (Serializable id){
		roleDao.delete(Role.class, id);
	}
	
	/**
	 * 根据sql查询Role对象集合
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return Role对象集合
	 */
	public List<Role> findListBySql(int currentPage, int pageSize){
		StringBuffer sql = new StringBuffer();
		sql.append("select Role.* from Role");
		List<Role> list = roleDao.findListBySql(Role.class, sql.toString(), currentPage, pageSize);	
		return list;
	}
	
	/**
	 * 根据sql查询Role集合数量
	 * @return Role集合数量
	 */
	public int findCountBySql(){
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) from sys_role");
		int count = roleDao.findCountBySql(sql.toString());	
		return count;
	}
	
	/**
	 * 根据sql查询Role分页对象
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return Role分页对象
	 */
	public Pager<Role> findPageBySql(int currentPage, int pageSize){
		int totalRecord = findCountBySql();	
		Pager<Role> pager = new Pager<Role>(currentPage, pageSize, totalRecord);
		List<Role> dataList = findListBySql(pager.getFromIndex() , pageSize);	
		pager.setDataList(dataList);
		return pager;
	}
	
	/**
	 * 根据表达式查询Role对象集合
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return Role对象集合
	 */
	public List<Role> findList(int currentPage, int pageSize){
		List<Exp> expList = new ArrayList<Exp>();
		List<Role> RoleList = roleDao.findList(Role.class, expList, currentPage, pageSize);	
		return RoleList;
	}
	
	/**
	 * 根据表达式查询Role集合数量
	 * @return Role集合数量
	 */
	public int findCount(){
		List<Exp> expList = new ArrayList<Exp>();
		int count = roleDao.findCount(Role.class, expList);	
		return count;
	}
	
	/**
	 * 根据表达式查询Role分页对象
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return Role分页对象
	 */
	public Pager<Role> findPage(int currentPage, int pageSize){
		int totalRecord = findCount();	
		Pager<Role> pager = new Pager<Role>(currentPage, pageSize, totalRecord);
		List<Role> dataList = findList(pager.getFromIndex() , pageSize);	
		pager.setDataList(dataList);
		return pager;
	}
}


