package com.hongedu.honghr.honghr.service;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hongedu.honghr.base.dao.expression.Exp;
import com.hongedu.honghr.honghr.common.constant.DataConstant;
import com.hongedu.honghr.honghr.common.enums.EnumApplyCheckStatus;
import com.hongedu.honghr.honghr.entity.OvertimeWorkApplyCheck;
import com.hongedu.honghr.honghr.entity.vo.OvertimeWorkApplyCheckVo;
import com.hongedu.honghr.util.page.Pager;
import com.hongedu.honghr.base.dao.BaseDaoImpl;

/**
 * @author  
 * el_bp_overtime_work_apply_check 表对应业务实现对象
 * 2017/12/07 04:00:58
 */
@Transactional
@Service
public class OvertimeWorkApplyCheckService{
	
	@Autowired
	private BaseDaoImpl<OvertimeWorkApplyCheck> overtimeWorkApplyCheckDao;
	
	@Autowired
	private BaseDaoImpl<OvertimeWorkApplyCheckVo> overtimeWorkApplyCheckVoDao;
	
	/**
	 * 根据主键查询OvertimeWorkApplyCheck对象
	 * @param id
	 * @return
	 */
	public OvertimeWorkApplyCheck findById (Serializable id){
		OvertimeWorkApplyCheck entity = overtimeWorkApplyCheckDao.findById(OvertimeWorkApplyCheck.class, id);
		return entity;
	}
	
	/**
	 * 插入OvertimeWorkApplyCheck对象
	 * @param entity
	 */
	public void save (OvertimeWorkApplyCheck entity){
		overtimeWorkApplyCheckDao.save(entity);
	}
	
	/**
	 * 修改OvertimeWorkApplyCheck对象
	 * @param entity
	 */
	public void update (OvertimeWorkApplyCheck entity){
		overtimeWorkApplyCheckDao.update(entity);
	}
	
	/**
	 * 删除OvertimeWorkApplyCheck对象
	 * @param id
	 */
	public void delete (Serializable id){
		overtimeWorkApplyCheckDao.delete(OvertimeWorkApplyCheck.class, id);
	}
	
	/**
	 * 根据sql查询OvertimeWorkApplyCheck对象集合
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return OvertimeWorkApplyCheck对象集合
	 */
	public List<OvertimeWorkApplyCheck> findListBySql(int currentPage, int pageSize){
		StringBuffer sql = new StringBuffer();
		sql.append("select OvertimeWorkApplyCheck.* from OvertimeWorkApplyCheck");
		List<OvertimeWorkApplyCheck> list = overtimeWorkApplyCheckDao.findListBySql(OvertimeWorkApplyCheck.class, sql.toString(), currentPage, pageSize);	
		return list;
	}
	
	/**
	 * 根据sql查询OvertimeWorkApplyCheck集合数量
	 * @return OvertimeWorkApplyCheck集合数量
	 */
	public int findCountBySql(){
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) from overtime_work_apply_check");
		int count = overtimeWorkApplyCheckDao.findCountBySql(sql.toString());	
		return count;
	}
	
	/**
	 * 根据sql查询OvertimeWorkApplyCheck分页对象
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return OvertimeWorkApplyCheck分页对象
	 */
	public Pager<OvertimeWorkApplyCheck> findPageBySql(int currentPage, int pageSize){
		int totalRecord = findCountBySql();	
		Pager<OvertimeWorkApplyCheck> pager = new Pager<OvertimeWorkApplyCheck>(currentPage, pageSize, totalRecord);
		List<OvertimeWorkApplyCheck> dataList = findListBySql(pager.getFromIndex() , pageSize);	
		pager.setDataList(dataList);
		return pager;
	}
	
	/**
	 * 根据表达式查询OvertimeWorkApplyCheck对象集合
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return OvertimeWorkApplyCheck对象集合
	 */
	public List<OvertimeWorkApplyCheck> findList(int currentPage, int pageSize){
		List<Exp> expList = new ArrayList<Exp>();
		List<OvertimeWorkApplyCheck> OvertimeWorkApplyCheckList = overtimeWorkApplyCheckDao.findList(OvertimeWorkApplyCheck.class, expList, currentPage, pageSize);	
		return OvertimeWorkApplyCheckList;
	}
	
	/**
	 * 根据表达式查询OvertimeWorkApplyCheck集合数量
	 * @return OvertimeWorkApplyCheck集合数量
	 */
	public int findCount(){
		List<Exp> expList = new ArrayList<Exp>();
		int count = overtimeWorkApplyCheckDao.findCount(OvertimeWorkApplyCheck.class, expList);	
		return count;
	}
	
	/**
	 * 根据表达式查询OvertimeWorkApplyCheck分页对象
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @return OvertimeWorkApplyCheck分页对象
	 */
	public Pager<OvertimeWorkApplyCheck> findPage(int currentPage, int pageSize){
		int totalRecord = findCount();	
		Pager<OvertimeWorkApplyCheck> pager = new Pager<OvertimeWorkApplyCheck>(currentPage, pageSize, totalRecord);
		List<OvertimeWorkApplyCheck> dataList = findList(pager.getFromIndex() , pageSize);	
		pager.setDataList(dataList);
		return pager;
	}
    
	/**
	 * 查询审批信息
	 * @param overtimeWorkApplyId
	 * @return
	 * @Author wanghui
	 * @Date 2018年1月10日
	 */
	public List<OvertimeWorkApplyCheckVo> findovertimeWorkApplyById(Integer overtimeWorkApplyId) {
		StringBuilder sb = new StringBuilder();
		sb.append("select oc.overtime_work_apply_check_id, oc.overtime_work_apply_id, oc.check_employee_id, oc.apply_check_sequence, oc.deleted, ");
		sb.append("e.employee_name checkEmployeeName ");
		sb.append("from overtime_work_apply_check oc ");
		sb.append("left join employee e on oc.check_employee_id = e.employee_id ");
		sb.append("where oc.overtime_work_apply_id = ? ");
		sb.append("and oc.deleted = ? ");
		sb.append("order by oc.apply_check_sequence asc ");
		return overtimeWorkApplyCheckVoDao.findEntityListBySql(OvertimeWorkApplyCheckVo.class, sb.toString(),
				new Object[] { overtimeWorkApplyId, DataConstant.EXIST });
	}

	public List<OvertimeWorkApplyCheckVo> findOvertimeApplyCheckVosByApplyId(Integer overtimeWorkApplyId) {
		StringBuilder sb = new StringBuilder();
		sb.append("select oc.overtime_work_apply_check_id, oc.overtime_work_apply_id, oc.check_employee_id, oc.apply_check_time, oc.apply_is_allowed, oc.apply_check_suggest, oc.apply_check_sequence, oc.deleted, ");
		sb.append("e.employee_name checkEmployeeName ");
		sb.append("from overtime_work_apply_check oc ");
		sb.append("left join employee e on oc.check_employee_id = e.employee_id ");
		sb.append("where oc.overtime_work_apply_id = ? ");
		sb.append("and oc.deleted = ? ");
		sb.append("order by oc.apply_check_sequence asc ");
		List<OvertimeWorkApplyCheckVo> overtimeApplyCheckVoList = overtimeWorkApplyCheckVoDao.findEntityListBySql(
				OvertimeWorkApplyCheckVo.class, sb.toString(), new Object[] { overtimeWorkApplyId, DataConstant.EXIST });
		setApplyCheckStatusShowByList(overtimeApplyCheckVoList);
		return overtimeApplyCheckVoList;
	}

	private void setApplyCheckStatusShowByList(List<OvertimeWorkApplyCheckVo> overtimeApplyCheckVoList) {
		for (OvertimeWorkApplyCheckVo overtimeWorkApplyCheckVo : overtimeApplyCheckVoList) {
			for (EnumApplyCheckStatus enumApplyCheckStatus : EnumApplyCheckStatus.values()) {
				if (enumApplyCheckStatus.getCode().equals(overtimeWorkApplyCheckVo.getApplyIsAllowed())) {
					overtimeWorkApplyCheckVo.setApplyIsAllowedShow(enumApplyCheckStatus.getValue());
					break;
				}
			}
		}
	}
	
}


