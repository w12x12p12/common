package com.hongedu.honghr.honghr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hongedu.honghr.base.dao.BaseDaoImpl;
import com.hongedu.honghr.base.dao.expression.Exp;
import com.hongedu.honghr.honghr.common.constant.DataConstant;
import com.hongedu.honghr.honghr.common.enums.EnumApplyCheckStatus;
import com.hongedu.honghr.honghr.entity.BusinessTripApplyCheck;
import com.hongedu.honghr.honghr.entity.vo.BusinessTripApplyCheckVo;
import com.hongedu.honghr.util.page.Pager;

/**
 * @author el_bp_business_trip_apply_check 表对应业务实现对象 2017/12/07 04:00:57
 */
@Transactional
@Service
public class BusinessTripApplyCheckService {

	@Autowired
	private BaseDaoImpl<BusinessTripApplyCheck> businessTripApplyCheckDao;
	@Autowired
	private BaseDaoImpl<BusinessTripApplyCheckVo> businessTripApplyCheckVoDao;

	/**
	 * 根据主键查询BusinessTripApplyCheck对象
	 * 
	 * @param id
	 * @return
	 */
	public BusinessTripApplyCheck findById(Serializable id) {
		return businessTripApplyCheckDao.findById(BusinessTripApplyCheck.class, id);
	}

	/**
	 * 插入BusinessTripApplyCheck对象
	 * 
	 * @param entity
	 */
	public void save(BusinessTripApplyCheck entity) {
		businessTripApplyCheckDao.save(entity);
	}

	/**
	 * 修改BusinessTripApplyCheck对象
	 * 
	 * @param entity
	 */
	public void update(BusinessTripApplyCheck entity) {
		businessTripApplyCheckDao.update(entity);
	}

	/**
	 * 删除BusinessTripApplyCheck对象
	 * 
	 * @param id
	 */
	public void delete(Serializable id) {
		businessTripApplyCheckDao.delete(BusinessTripApplyCheck.class, id);
	}

	/**
	 * 根据sql查询BusinessTripApplyCheck对象集合
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return BusinessTripApplyCheck对象集合
	 */
	public List<BusinessTripApplyCheck> findListBySql(int currentPage, int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append("select business_trip_apply_check.* from business_trip_apply_check");
		return businessTripApplyCheckDao.findListBySql(BusinessTripApplyCheck.class, sql.toString(), currentPage,
				pageSize);
	}

	/**
	 * 根据sql查询BusinessTripApplyCheck集合数量
	 * 
	 * @return BusinessTripApplyCheck集合数量
	 */
	public int findCountBySql() {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) from business_trip_apply_check");
		return businessTripApplyCheckDao.findCountBySql(sql.toString());
	}

	/**
	 * 根据sql查询BusinessTripApplyCheck分页对象
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return BusinessTripApplyCheck分页对象
	 */
	public Pager<BusinessTripApplyCheck> findPageBySql(int currentPage, int pageSize) {
		int totalRecord = findCountBySql();
		Pager<BusinessTripApplyCheck> pager = new Pager<BusinessTripApplyCheck>(currentPage, pageSize, totalRecord);
		List<BusinessTripApplyCheck> dataList = findListBySql(pager.getFromIndex(), pageSize);
		pager.setDataList(dataList);
		return pager;
	}

	/**
	 * 根据表达式查询BusinessTripApplyCheck对象集合
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return BusinessTripApplyCheck对象集合
	 */
	public List<BusinessTripApplyCheck> findList(int currentPage, int pageSize) {
		List<Exp> expList = new ArrayList<Exp>();
		return businessTripApplyCheckDao.findList(BusinessTripApplyCheck.class, expList, currentPage, pageSize);
	}

	/**
	 * 根据表达式查询BusinessTripApplyCheck集合数量
	 * 
	 * @return BusinessTripApplyCheck集合数量
	 */
	public int findCount() {
		List<Exp> expList = new ArrayList<Exp>();
		return businessTripApplyCheckDao.findCount(BusinessTripApplyCheck.class, expList);
	}

	/**
	 * 根据表达式查询BusinessTripApplyCheck分页对象
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return BusinessTripApplyCheck分页对象
	 */
	public Pager<BusinessTripApplyCheck> findPage(int currentPage, int pageSize) {
		int totalRecord = findCount();
		Pager<BusinessTripApplyCheck> pager = new Pager<BusinessTripApplyCheck>(currentPage, pageSize, totalRecord);
		List<BusinessTripApplyCheck> dataList = findList(pager.getFromIndex(), pageSize);
		pager.setDataList(dataList);
		return pager;
	}

	public List<BusinessTripApplyCheckVo> findBusinessTripApplyCheckVosByApplyId(Integer businessTripApplyId) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"select bc.business_trip_apply_check_id, bc.business_trip_apply_id, bc.check_employee_id, bc.apply_check_time, bc.apply_is_allowed, bc.apply_check_suggest, bc.apply_check_sequence, bc.deleted, ");
		sb.append("e.employee_name checkEmployeeName ");
		sb.append("from business_trip_apply_check bc ");
		sb.append("left join employee e on bc.check_employee_id = e.employee_id ");
		sb.append("where bc.business_trip_apply_id = ? ");
		sb.append("and bc.deleted = ? ");
		sb.append("order by bc.apply_check_sequence asc ");
		List<BusinessTripApplyCheckVo> businessTripApplyCheckVoList = businessTripApplyCheckVoDao.findEntityListBySql(
				BusinessTripApplyCheckVo.class, sb.toString(),
				new Object[] { businessTripApplyId, DataConstant.EXIST });
		setApplyCheckStatusShowByList(businessTripApplyCheckVoList);
		return businessTripApplyCheckVoList;
	}

	private void setApplyCheckStatusShowByList(List<BusinessTripApplyCheckVo> businessTripApplyCheckVoList) {
		for (BusinessTripApplyCheckVo businessTripApplyCheckVo : businessTripApplyCheckVoList) {
			for (EnumApplyCheckStatus enumApplyCheckStatus : EnumApplyCheckStatus.values()) {
				if (enumApplyCheckStatus.getCode().equals(businessTripApplyCheckVo.getApplyIsAllowed())) {
					businessTripApplyCheckVo.setApplyIsAllowedShow(enumApplyCheckStatus.getValue());
					break;
				}
			}
		}
	}
}