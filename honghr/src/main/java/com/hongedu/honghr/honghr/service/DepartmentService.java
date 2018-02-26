package com.hongedu.honghr.honghr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hongedu.honghr.base.dao.BaseDaoImpl;
import com.hongedu.honghr.base.dao.expression.Exp;
import com.hongedu.honghr.base.dao.expression.impl.WhereExp;
import com.hongedu.honghr.honghr.common.constant.DataConstant;
import com.hongedu.honghr.honghr.entity.Department;
import com.hongedu.honghr.honghr.entity.vo.DepartmentVo;
import com.hongedu.honghr.util.page.Pager;

/**
 * @author el_bp_department 表对应业务实现对象 2017/12/07 04:00:57
 */
@Transactional
@Service
public class DepartmentService {

	@Autowired
	private BaseDaoImpl<Department> departmentDao;
	@Autowired
	private BaseDaoImpl<DepartmentVo> departmentVoDao;

	/**
	 * 根据主键查询Department对象
	 * 
	 * @param id
	 * @return
	 */
	public Department findById(Serializable id) {
		Department entity = departmentDao.findById(Department.class, id);
		return entity;
	}

	/**
	 * 插入Department对象
	 * 
	 * @param entity
	 */
	public void save(Department entity) {
		departmentDao.save(entity);
	}

	/**
	 * 修改Department对象
	 * 
	 * @param entity
	 */
	public void update(Department entity) {
		departmentDao.update(entity);
	}

	/**
	 * 根据表达式查询Department对象集合
	 * 
	 * @param departmentName
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return Department对象集合
	 */
	public List<Department> findList(String departmentName, int currentPage, int pageSize) {
		List<Exp> expList = new ArrayList<Exp>();
		if (departmentName != null) {
			expList.add(new WhereExp(Department.class, "department_name", "like", "%" + departmentName + "%"));
		}
		expList.add(new WhereExp(Department.class, "deleted", "=", DataConstant.EXIST));
		List<Department> DepartmentList = departmentDao.findList(Department.class, expList, currentPage, pageSize);

		return DepartmentList;
	}

	/**
	 * 根据表达式查询Department集合数量
	 * 
	 * @param departmentName
	 * 
	 * @return Department集合数量
	 */
	public int findCount(String departmentName) {
		List<Exp> expList = new ArrayList<Exp>();
		if (departmentName != null) {
			expList.add(new WhereExp(Department.class, "department_name", "like", "%" + departmentName + "%"));
		}
		expList.add(new WhereExp(Department.class, "deleted", "=", DataConstant.EXIST));
		int count = departmentDao.findCount(Department.class, expList);
		return count;
	}

	/**
	 * 根据表达式查询Department分页对象
	 * @param departmentName
	 * @param currentPage
	 * @param pageSize
	 * @return Department分页对象
	 */
	public Pager<Department> findPage(String departmentName, int currentPage, int pageSize) {
		int totalRecord = findCount(departmentName);
		Pager<Department> pager = new Pager<Department>(currentPage, pageSize, totalRecord);
		List<Department> dataList = findList(departmentName, pager.getFromIndex(), pageSize);
		pager.setDataList(dataList);
		return pager;
	}

	public List<Department> findAllDepartmentList(Integer employeeId) {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct d.department_id, d.department_num, d.department_name ");
		sb.append("from department d ");
		sb.append("join employee_position ep on d.department_num = ep.department_num ");
		sb.append("where ep.employee_id != ? ");
		sb.append("and ep.deleted = ? ");
		sb.append("and d.deleted = ? ");
		return departmentDao.findEntityListBySql(Department.class, sb.toString(),
				new Object[] { employeeId, DataConstant.EXIST, DataConstant.EXIST });
	}

	public List<Department> findDepartmentListByEmployee(Integer employeeId) {
		StringBuilder sb = new StringBuilder();
		sb.append("select distinct d.department_id, d.department_num, d.department_name ");
		sb.append("from department d ");
		sb.append("join employee_position ep on d.department_num = ep.department_num ");
		sb.append("where ep.employee_id = ? ");
		sb.append("and ep.deleted = ? ");
		sb.append("and d.deleted = ? ");
		return departmentDao.findEntityListBySql(Department.class, sb.toString(),
				new Object[] { employeeId, DataConstant.EXIST, DataConstant.EXIST });
	}

	public List<DepartmentVo> findDepartmentListByEmployeeIds(List<Integer> employeeIds) {
		List<Object> args = new ArrayList<Object>();
		StringBuilder sb = new StringBuilder();
		sb.append("select d.department_id, d.department_num, d.department_name, ");
		sb.append("ep.employee_id ");
		sb.append("from department d ");
		sb.append("join employee_position ep on d.department_num = ep.department_num ");
		sb.append("where ep.employee_id in ( ");
		for (int i = 0; i < employeeIds.size(); i++) {
			sb.append("?");
			if (i < employeeIds.size() - 1) {
				sb.append(",");
			}
			args.add(employeeIds.get(i));
		}
		sb.append(")and ep.deleted = ? ");
		sb.append("and d.deleted = ? ");
		args.add(DataConstant.EXIST);
		args.add(DataConstant.EXIST);
		return departmentVoDao.findEntityListBySql(DepartmentVo.class, 
				sb.toString(), args.toArray(new Object[] {}));
	}

	public List<Department> findDepartmentList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select department_id, department_num departmentNum, department_name departmentName ");
		sb.append("from department ");
		sb.append("where deleted = ? ");
		return departmentDao.findEntityListBySql(Department.class, 
				sb.toString(), new Object[] { DataConstant.EXIST });
	}

	/**
	 * 删除部门
	 * 
	 * <p>Title: updateDel</p> 
	 * <p>Description: </p>  
	 * @time 上午11:07:15 
	 * @param department
	 */
	public void updateDel(Department department) {
		department.setDeleted(DataConstant.DELETE);
		departmentDao.update(department);
	}

	/**
	 * 查询部门的父级部门
	 * 
	 * <p>Title: findParentInfo</p> 
	 * <p>Description: </p>  
	 * @time 上午11:07:29 
	 * @param departmentParentId
	 * @return
	 */
	public Department findParentInfo(Integer departmentParentId) {
		List<Exp> expList = new ArrayList<Exp>();
		expList.add(new WhereExp(Department.class, "department_id", "=", departmentParentId));
		expList.add(new WhereExp(Department.class, "deleted", "=", DataConstant.EXIST));
		List<Department> DepartmentList = departmentDao.findList(Department.class, expList);
		Department department = null;
		for (int i = 0; i < DepartmentList.size(); i++) {
			department = DepartmentList.get(i);
		}
		return department;
	}

	/**
	 * 查询departmentParentId下最大的departmentNum
	 * 
	 * <p>Title: findMaxNum</p> 
	 * <p>Description: </p>  
	 * @time 上午11:07:42 
	 * @param departmentParentId
	 * @return
	 */
	public Department findMaxNum(Integer departmentParentId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select Max(d.department_num) ");
		sql.append("from department d");
		sql.append(" where d.department_parent_id = ?");
		Department department = new Department();
		String list = departmentDao.getPropertyBySql(sql.toString(), new Object[] { departmentParentId });
		department.setDepartmentNum(list);
		return department;

	}

	public Department findDepartment(int departmentId) {
		List<Exp> expList = new ArrayList<Exp>();
		expList.add(new WhereExp(Department.class, "department_id", "=", departmentId));
		List<Department> DepartmentList = departmentDao.findList(Department.class, expList);
		Department department = null;
		for (int i = 0; i < DepartmentList.size(); i++) {
			department = DepartmentList.get(i);
		}
		return department;
	}

	/**
	 * 通过departmentNum查询部门
	 * 
	 * <p>Title: findByNUM</p> 
	 * <p>Description: </p>  
	 * @time 上午11:07:57 
	 * @param departmentNum
	 * @return
	 */
	public Department findByNUM(String departmentNum) {
		List<Exp> expList = new ArrayList<Exp>();
		expList.add(new WhereExp(Department.class, "department_num", "=", departmentNum));
		List<Department> DepartmentList = departmentDao.findList(Department.class, expList);
		Department department = null;
		for (int i = 0; i < DepartmentList.size(); i++) {
			department = DepartmentList.get(i);
		}
		return department;
	}
}