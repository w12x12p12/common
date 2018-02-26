
package com.hongedu.honghr.honghr.web;

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
import com.hongedu.honghr.honghr.entity.BusinessTripApplyCheck;
import com.hongedu.honghr.honghr.service.BusinessTripApplyCheckService;

/**
 * @author el_bp_business_trip_apply_check 表对应的controller 2017/12/07 04:04:40
 */
@Controller
@RequestMapping("/admin/businessTripApplyCheck")
public class BusinessTripApplyCheckController {

	@Autowired
	private BusinessTripApplyCheckService businessTripApplyCheckService;
	
	/**
	 * 查询BusinessTripApplyCheck表单页面
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/businessTripApplyCheckList", method = RequestMethod.GET)
	public String businessTripApplyCheckList(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			Model model) {
		Pager<BusinessTripApplyCheck> page = businessTripApplyCheckService.findPage(currentPage, pageSize);
		model.addAttribute("page", page);
		return "admin/businessTripApplyCheck/businessTripApplyCheckList";
	}

	/**
	 * 查询BusinessTripApplyCheck详情
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findBusinessTripApplyCheck", method = RequestMethod.POST)
	public JsonResult findBusinessTripApplyCheck(
			@RequestParam(required = true) java.lang.Integer businessTripApplyCheckId) {
		try {
			BusinessTripApplyCheck businessTripApplyCheck = businessTripApplyCheckService
					.findById(businessTripApplyCheckId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", businessTripApplyCheck);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 编辑BusinessTripApplyCheck
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editBusinessTripApplyCheck", method = RequestMethod.GET)
	public String editBusinessTripApplyCheck(java.lang.Integer businessTripApplyCheckId, Model model) {
		if (businessTripApplyCheckId != null) {
			BusinessTripApplyCheck businessTripApplyCheck = businessTripApplyCheckService
					.findById(businessTripApplyCheckId);
			model.addAttribute("businessTripApplyCheck", businessTripApplyCheck);
		}
		return "admin/businessTripApplyCheck/editBusinessTripApplyCheck";
	}

	/**
	 * 保存BusinessTripApplyCheck
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveBusinessTripApplyCheck", method = RequestMethod.POST)
	public JsonResult saveBusinessTripApplyCheck(BusinessTripApplyCheck businessTripApplyCheck) {
		try {
			if (businessTripApplyCheck.getBusinessTripApplyCheckId() == null) {
				businessTripApplyCheckService.save(businessTripApplyCheck);
			} else {
				businessTripApplyCheckService.update(businessTripApplyCheck);
			}
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 删除BusinessTripApplyCheck
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteBusinessTripApplyCheck", method = RequestMethod.POST)
	public JsonResult deleteBusinessTripApplyCheck(
			@RequestParam(required = true) java.lang.Integer businessTripApplyCheckId) {
		try {
			businessTripApplyCheckService.delete(businessTripApplyCheckId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
}