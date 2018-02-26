package com.hongedu.honghr.honghr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hongedu.honghr.base.dao.BaseDaoImpl;
import com.hongedu.honghr.base.dao.expression.Exp;
import com.hongedu.honghr.base.dao.expression.impl.WhereExp;
import com.hongedu.honghr.honghr.entity.Code;
import com.hongedu.honghr.util.page.Pager;

@Transactional
@Service
public class CodeService {

	@Autowired
	private BaseDaoImpl<Code> codeDao;

	public void save(Code entity) {
		codeDao.save(entity);
	}

	public void update(Code entity) {
		codeDao.update(entity);
	}

	@Cacheable(value = "jdbcCache")
	public List<Code> findList(String codeName, int currentPage, int pageSize) {
		List<Exp> expList = new ArrayList<Exp>();
		if (codeName != null) {
			expList.add(new WhereExp(Code.class, "code_name", "like", "%" + codeName + "%"));
		}
		return codeDao.findList(Code.class, expList, currentPage, pageSize);
	}

	public List<Code> findList1() {
		List<Exp> expList = new ArrayList<Exp>();

		expList.add(new WhereExp(Code.class, "code_parent_id", "like", 0));
		return codeDao.findList(Code.class, expList);
	}

	@Cacheable(value = "jdbcCache")
	public int findCount(String codeName) {
		List<Exp> expList = new ArrayList<Exp>();
		if (codeName != null) {
			expList.add(new WhereExp(Code.class, "code_name", "like", "%" + codeName + "%"));
		}
		return codeDao.findCount(Code.class, expList);
	}

	public Pager<Code> findPage(String codeName, int currentPage, int pageSize) {
		int totalRecord = findCount(codeName);
		Pager<Code> pager = new Pager<Code>(currentPage, pageSize, totalRecord);
		List<Code> dataList = findList(codeName, pager.getFromIndex(), pageSize);
		pager.setDataList(dataList);
		return pager;
	}

	public List<Code> findCodeById(Integer menuCode) {
		StringBuilder sb = new StringBuilder();
		sb.append("select code_id, code_name, code_parent_id, code_value ");
		sb.append("from code ");
		sb.append("where code_parent_id = ? ");
		return codeDao.findEntityListBySql(Code.class, sb.toString(), new Object[] { menuCode });
	}

	public List<Code> findCodeListByValue(String codeValue) {
		StringBuilder sb = new StringBuilder();
		sb.append("select c.code_id, c.code_name, c.code_parent_id, c.code_value ");
		sb.append("from code c ");
		sb.append("where c.code_parent_id = ( ");
		sb.append("select cd.code_parent_id ");
		sb.append("from code cd ");
		sb.append("where cd.code_value = ?) ");
		return codeDao.findEntityListBySql(Code.class, sb.toString(), new Object[] { codeValue });
	}

	public Code findByParentId(Integer codeParentId) {
		List<Exp> expList = new ArrayList<Exp>();
		expList.add(new WhereExp(Code.class, "code_id", "=", codeParentId));
		List<Code> list = codeDao.findList(Code.class, expList);
		Code code = new Code();
		for (int i = 0; i < list.size(); i++) {
			code = list.get(i);
		}
		return code;
	}

	public Code findMaxByPid(Integer codeParentId) {
		StringBuffer sql = new StringBuffer();
		sql.append("select Max(c.code_value) ");
		sql.append("from code c");
		sql.append(" where c.code_parent_id = ?");
		Code code = new Code();
		String list = codeDao.getPropertyBySql(sql.toString(), new Object[] { codeParentId });
		code.setCodeValue(list);
		return code;
	}

	public Code findById(Integer codeId) {
		Code code = codeDao.findById(Code.class, codeId);
		return code;
	}
}