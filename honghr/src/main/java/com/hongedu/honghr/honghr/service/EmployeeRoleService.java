package com.hongedu.honghr.honghr.service;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hongedu.honghr.base.dao.expression.Exp;
import com.hongedu.honghr.honghr.entity.EmployeeRole;
import com.hongedu.honghr.util.page.Pager;

import com.hongedu.honghr.base.dao.BaseDaoImpl;

/**
 * @author  
 * el_sys_employee_role 表对应业务实现对象
 * 2017/12/07 04:00:58
 */
@Transactional
@Service
public class EmployeeRoleService{
	
	@Autowired
	private BaseDaoImpl<EmployeeRole> employeeRoleDao;
	
	/**
	 * 根据主键查询EmployeeRole对象
	 * @param id
	 * @return
	 */
	public EmployeeRole findById (Serializable id){
		EmployeeRole entity = employeeRoleDao.findById(EmployeeRole.class, id);
		return entity;
	}
	
	/**
	 * 插入EmployeeRole对象
	 * @param entity
	 */
	public void save (EmployeeRole entity){
		employeeRoleDao.save(entity);
	}
	
	/**
	 * 修改EmployeeRole对象
	 * @param entity
	 */
	public void update (EmployeeRole entity){
		employeeRoleDao.update(entity);
	}
	
	/**
	 * 删除EmployeeRole对象
	 * @param id
	 */
	public void delete (Serializable id){
		employeeRoleDao.delete(EmployeeRole.class, id);
	}
	
	/**
	 * 根据sql查询EmployeeRole对象集合
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return EmployeeRole对象集合
	 */
	public List<EmployeeRole> findListBySql(int currentPage, int pageSize){
		StringBuffer sql = new StringBuffer();
		sql.append("select EmployeeRole.* from EmployeeRole");
		List<EmployeeRole> list = employeeRoleDao.findListBySql(EmployeeRole.class, sql.toString(), currentPage, pageSize);	
		return list;
	}
	
	/**
	 * 根据sql查询EmployeeRole集合数量
	 * @return EmployeeRole集合数量
	 */
	public int findCountBySql(){
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) from employee_role");
		int count = employeeRoleDao.findCountBySql(sql.toString());	
		return count;
	}
	
	/**
	 * 根据sql查询EmployeeRole分页对象
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return EmployeeRole分页对象
	 */
	public Pager<EmployeeRole> findPageBySql(int currentPage, int pageSize){
		int totalRecord = findCountBySql();	
		Pager<EmployeeRole> pager = new Pager<EmployeeRole>(currentPage, pageSize, totalRecord);
		List<EmployeeRole> dataList = findListBySql(pager.getFromIndex() , pageSize);	
		pager.setDataList(dataList);
		return pager;
	}
	
	/**
	 * 根据表达式查询EmployeeRole对象集合
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return EmployeeRole对象集合
	 */
	public List<EmployeeRole> findList(int currentPage, int pageSize){
		List<Exp> expList = new ArrayList<Exp>();
		List<EmployeeRole> EmployeeRoleList = employeeRoleDao.findList(EmployeeRole.class, expList, currentPage, pageSize);	
		return EmployeeRoleList;
	}
	
	/**
	 * 根据表达式查询EmployeeRole集合数量
	 * @return EmployeeRole集合数量
	 */
	public int findCount(){
		List<Exp> expList = new ArrayList<Exp>();
		int count = employeeRoleDao.findCount(EmployeeRole.class, expList);	
		return count;
	}
	
	/**
	 * 根据表达式查询EmployeeRole分页对象
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return EmployeeRole分页对象
	 */
	public Pager<EmployeeRole> findPage(int currentPage, int pageSize){
		int totalRecord = findCount();	
		Pager<EmployeeRole> pager = new Pager<EmployeeRole>(currentPage, pageSize, totalRecord);
		List<EmployeeRole> dataList = findList(pager.getFromIndex() , pageSize);	
		pager.setDataList(dataList);
		return pager;
	}
}


