package com.hongedu.honghr.honghr.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hongedu.honghr.base.dao.BaseDaoImpl;
import com.hongedu.honghr.honghr.common.constant.DataConstant;
import com.hongedu.honghr.honghr.entity.EmployeeAnnualLeave;

@Transactional
@Service
public class EmployeeAnnualLeaveService {

	@Autowired
	private BaseDaoImpl<EmployeeAnnualLeave> employeeAnnualLeaveDao;

	public boolean getIsClearAnnualLeaveHours(Integer employeeId, String yearName) {
		StringBuilder sb = new StringBuilder();
		sb.append("select count(1) ");
		sb.append("from employee_annual_leave ");
		sb.append("where employee_id = ? ");
		sb.append("and year_name = ? ");
		sb.append("and is_clear = ? ");
		Integer number = employeeAnnualLeaveDao.findCountBySql(sb.toString(),
				new Object[] { employeeId, yearName, DataConstant.CLEAR });
		if (number != null) {
			return number.intValue() > 0 && number.intValue() == 1 ? true : false;
		}
		return false;
	}

	public EmployeeAnnualLeave getClearAnnualLeaveHour(Integer employeeId, String yearName) {
		StringBuilder sb = new StringBuilder();
		sb.append("select employee_id, count(1) count, remaining_hour ");
		sb.append("from employee_annual_leave ");
		sb.append("where employee_id = ? ");
		sb.append("and year_name = ? ");
		sb.append("and is_clear = ? ");
		sb.append("group by employee_id");
		EmployeeAnnualLeave employeeAnnualLeave = employeeAnnualLeaveDao.getEntityBySql(EmployeeAnnualLeave.class,
				sb.toString(), new Object[] { employeeId, yearName, DataConstant.CLEAR });
		return employeeAnnualLeave != null && employeeAnnualLeave.getCount() > 0 && employeeAnnualLeave.getCount() == 1
				? employeeAnnualLeave
				: null;
	}

	public List<EmployeeAnnualLeave> getClearAnnualLeaveHoursEmployeeIds(List<Integer> employeeIds, String yearName) {
		List<Object> args = new ArrayList<Object>();
		args.add(yearName);
		args.add(DataConstant.CLEAR);
		StringBuilder sb = new StringBuilder();
		sb.append("select e.employee_id, ");
		sb.append("ea.remaining_hour, count(ea.employee_annual_leave_id) count ");
		sb.append("from employee e ");
		sb.append("left join employee_annual_leave ea ");
		sb.append("on e.employee_id = ea.employee_id ");
		sb.append("and ea.year_name = ? ");
		sb.append("and ea.is_clear = ? ");
		sb.append("where e.employee_id in( ");
		for (int i = 0; i < employeeIds.size(); i++) {
			sb.append("?");
			if (i < employeeIds.size() - 1) {
				sb.append(",");
			}
			args.add(employeeIds.get(i));
		}
		sb.append(")group by e.employee_id ");
		List<EmployeeAnnualLeave> employeeAnnualLeaveList = employeeAnnualLeaveDao
				.findEntityListBySql(EmployeeAnnualLeave.class, sb.toString(), args.toArray(new Object[] {}));
		if (employeeAnnualLeaveList != null && !employeeAnnualLeaveList.isEmpty()) {
			for (Iterator<EmployeeAnnualLeave> iterator = employeeAnnualLeaveList.iterator(); iterator.hasNext();) {
				EmployeeAnnualLeave employeeAnnualLeave = iterator.next();
				if (!(employeeAnnualLeave.getCount() != null && employeeAnnualLeave.getCount().intValue() > 0)) {
					iterator.remove();
				}
			}
		}
		return employeeAnnualLeaveList;
	}

	public void insertClearAnnualLeaveHours(EmployeeAnnualLeave employeeAnnualLeave) {
		StringBuilder sb = new StringBuilder();
		sb.append("insert into employee_annual_leave(employee_id, year_name, remaining_hour, is_clear)values(?,?,?,?)");
		employeeAnnualLeaveDao.insertBySql(sb.toString(),
				new Object[] { employeeAnnualLeave.getEmployeeId(), employeeAnnualLeave.getYearName(),
						employeeAnnualLeave.getRemainingHour(), employeeAnnualLeave.getIsClear() });
	}
}