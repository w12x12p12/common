
package com.hongedu.honghr.honghr.web;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hongedu.honghr.util.json.JsonResult;
import com.hongedu.honghr.util.page.Pager;
import com.hongedu.honghr.honghr.common.constant.PageConstant;
import com.hongedu.honghr.honghr.common.constant.SessionConstant;
import com.hongedu.honghr.honghr.entity.Employee;
import com.hongedu.honghr.honghr.entity.OvertimeWorkApplyCheck;
import com.hongedu.honghr.honghr.entity.vo.OvertimeWorkApplyVo;
import com.hongedu.honghr.honghr.service.OvertimeWorkApplyCheckService;
import com.hongedu.honghr.honghr.service.OvertimeWorkApplyService;

/**
 * @author el_bp_overtime_work_apply_check 表对应的controller 2017/12/07 04:04:40
 */
@Controller
@RequestMapping("/admin/overtimeWorkApplyCheck")
public class OvertimeWorkApplyCheckController {

	@Autowired
	private OvertimeWorkApplyCheckService overtimeWorkApplyCheckService;

	@Autowired
	private OvertimeWorkApplyService overtimeWorkApplyService;

	/**
	 * 查询OvertimeWorkApplyCheck详情
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findOvertimeWorkApplyCheck", method = RequestMethod.POST)
	public JsonResult findOvertimeWorkApplyCheck(
			@RequestParam(required = true) java.lang.Integer overtimeWorkApplyCheckId) {
		try {
			OvertimeWorkApplyCheck overtimeWorkApplyCheck = overtimeWorkApplyCheckService
					.findById(overtimeWorkApplyCheckId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", overtimeWorkApplyCheck);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 编辑OvertimeWorkApplyCheck
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editOvertimeWorkApplyCheck", method = RequestMethod.GET)
	public String editOvertimeWorkApplyCheck(java.lang.Integer overtimeWorkApplyCheckId, Model model) {
		if (overtimeWorkApplyCheckId != null) {
			OvertimeWorkApplyCheck overtimeWorkApplyCheck = overtimeWorkApplyCheckService
					.findById(overtimeWorkApplyCheckId);
			model.addAttribute("overtimeWorkApplyCheck", overtimeWorkApplyCheck);
		}
		return "admin/overtimeWorkApplyCheck/editOvertimeWorkApplyCheck";
	}

	/**
	 * 保存OvertimeWorkApplyCheck
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveOvertimeWorkApplyCheck", method = RequestMethod.POST)
	public JsonResult saveOvertimeWorkApplyCheck(OvertimeWorkApplyCheck overtimeWorkApplyCheck) {
		try {
			if (overtimeWorkApplyCheck.getOvertimeWorkApplyCheckId() == null) {
				overtimeWorkApplyCheckService.save(overtimeWorkApplyCheck);
			} else {
				overtimeWorkApplyCheckService.update(overtimeWorkApplyCheck);
			}
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 删除OvertimeWorkApplyCheck
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteOvertimeWorkApplyCheck", method = RequestMethod.POST)
	public JsonResult deleteOvertimeWorkApplyCheck(
			@RequestParam(required = true) java.lang.Integer overtimeWorkApplyCheckId) {
		try {
			overtimeWorkApplyCheckService.delete(overtimeWorkApplyCheckId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 查询OvertimeWorkApplyCheck表单页面
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/overtimeWorkApplyCheckList", method = RequestMethod.GET)
	public String overtimeWorkApplyCheckList(@RequestParam(required = false, defaultValue = "1") Integer currentPage,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize, Model model) {
		Pager<OvertimeWorkApplyCheck> page = overtimeWorkApplyCheckService.findPage(currentPage, pageSize);
		model.addAttribute("page", page);
		return "admin/overtimeWorkApplyCheck/overtimeWorkApplyCheckList";
	}

	@RequestMapping(value = "/overtimeWorkApplyNoCheck", method = RequestMethod.GET)
	public String overtimeWorkApplyNoCheck(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			Model model) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			Pager<OvertimeWorkApplyVo> page = overtimeWorkApplyService.findAllCheckPage(employee.getEmployeeId(),
					currentPage, pageSize);
			model.addAttribute("page", page);
		}
		return "admin/overtimeWorkApply/overtimeWorkApplyCheck";
	}

}
