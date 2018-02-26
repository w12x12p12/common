package com.hongedu.honghr.honghr.service;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hongedu.honghr.base.dao.expression.Exp;
import com.hongedu.honghr.honghr.common.constant.DataConstant;
import com.hongedu.honghr.honghr.entity.Attachment;
import com.hongedu.honghr.util.page.Pager;

import com.hongedu.honghr.base.dao.BaseDaoImpl;

/**
 * @author el_bp_attachment 表对应业务实现对象 2017/12/07 04:00:56
 */
@Transactional
@Service
public class AttachmentService {

	@Autowired
	private BaseDaoImpl<Attachment> attachmentDao;

	/**
	 * 根据主键查询Attachment对象
	 * 
	 * @param id
	 * @return
	 */
	public Attachment findById(Serializable id) {
		return attachmentDao.findById(Attachment.class, id);
	}

	/**
	 * 插入Attachment对象
	 * 
	 * @param entity
	 */
	public void save(Attachment entity) {
		attachmentDao.save(entity);
	}

	/**
	 * 修改Attachment对象
	 * 
	 * @param entity
	 */
	public void update(Attachment entity) {
		attachmentDao.update(entity);
	}

	/**
	 * 删除Attachment对象
	 * 
	 * @param id
	 */
	public void delete(Serializable id) {
		attachmentDao.delete(Attachment.class, id);
	}

	/**
	 * 根据sql查询Attachment对象集合
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return Attachment对象集合
	 */
	public List<Attachment> findListBySql(int currentPage, int pageSize) {
		StringBuffer sql = new StringBuffer();
		sql.append("select attachment.* from attachment");
		return attachmentDao.findListBySql(Attachment.class, sql.toString(), currentPage, pageSize);
	}

	/**
	 * 根据sql查询Attachment集合数量
	 * 
	 * @return Attachment集合数量
	 */
	public int findCountBySql() {
		StringBuffer sql = new StringBuffer();
		sql.append("select count(1) from attachment");
		return attachmentDao.findCountBySql(sql.toString());
	}

	/**
	 * 根据sql查询Attachment分页对象
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return Attachment分页对象
	 */
	public Pager<Attachment> findPageBySql(int currentPage, int pageSize) {
		int totalRecord = findCountBySql();
		Pager<Attachment> pager = new Pager<Attachment>(currentPage, pageSize, totalRecord);
		List<Attachment> dataList = findListBySql(pager.getFromIndex(), pageSize);
		pager.setDataList(dataList);
		return pager;
	}

	/**
	 * 根据表达式查询Attachment对象集合
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return Attachment对象集合
	 */
	public List<Attachment> findList(int currentPage, int pageSize) {
		List<Exp> expList = new ArrayList<Exp>();
		return attachmentDao.findList(Attachment.class, expList, currentPage, pageSize);
	}

	/**
	 * 根据表达式查询Attachment集合数量
	 * 
	 * @return Attachment集合数量
	 */
	public int findCount() {
		List<Exp> expList = new ArrayList<Exp>();
		return attachmentDao.findCount(Attachment.class, expList);
	}

	/**
	 * 根据表达式查询Attachment分页对象
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @return Attachment分页对象
	 */
	public Pager<Attachment> findPage(int currentPage, int pageSize) {
		int totalRecord = findCount();
		Pager<Attachment> pager = new Pager<Attachment>(currentPage, pageSize, totalRecord);
		List<Attachment> dataList = findList(pager.getFromIndex(), pageSize);
		pager.setDataList(dataList);
		return pager;
	}

	public Attachment getAttachmentByAbsenceApplyId(Integer absenceApplyId) {
		StringBuilder sb = new StringBuilder();
		sb.append("select attachment_id, attachment_dir, attachment_url, deleted ");
		sb.append("from attachment ");
		sb.append("where absence_apply_id = ? ");
		sb.append("and deleted = ? ");
		return attachmentDao.getEntityBySql(Attachment.class, sb.toString(),
				new Object[] { absenceApplyId, DataConstant.EXIST });
	}
}