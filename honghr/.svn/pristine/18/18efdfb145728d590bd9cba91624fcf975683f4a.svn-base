
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
import com.hongedu.honghr.honghr.entity.ApplyPermission;
import com.hongedu.honghr.honghr.service.ApplyPermissionService;

/**
 * @author el_bp_apply_permission 表对应的controller 2017/12/07 04:04:39
 */
@Controller
@RequestMapping("/admin/applyPermission")
public class ApplyPermissionController {

	@Autowired
	private ApplyPermissionService applyPermissionService;
	
	/**
	 * 查询ApplyPermission表单页面
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/applyPermissionList", method = RequestMethod.GET)
	public String applyPermissionList(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			Model model) {
		Pager<ApplyPermission> page = applyPermissionService.findPage(currentPage, pageSize);
		model.addAttribute("page", page);
		return "admin/applyPermission/applyPermissionList";
	}

	/**
	 * 查询ApplyPermission详情
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findApplyPermission", method = RequestMethod.POST)
	public JsonResult findApplyPermission(@RequestParam(required = true) java.lang.Integer applyPermissionId) {
		try {
			ApplyPermission applyPermission = applyPermissionService.findById(applyPermissionId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", applyPermission);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 编辑ApplyPermission
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editApplyPermission", method = RequestMethod.GET)
	public String editApplyPermission(java.lang.Integer applyPermissionId, Model model) {
		if (applyPermissionId != null) {
			ApplyPermission applyPermission = applyPermissionService.findById(applyPermissionId);
			model.addAttribute("applyPermission", applyPermission);
		}
		return "admin/applyPermission/editApplyPermission";
	}

	/**
	 * 保存ApplyPermission
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveApplyPermission", method = RequestMethod.POST)
	public JsonResult saveApplyPermission(ApplyPermission applyPermission) {
		try {
			if (applyPermission.getApplyPermissionId() == null) {
				applyPermissionService.save(applyPermission);
			} else {
				applyPermissionService.update(applyPermission);
			}
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 删除ApplyPermission
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteApplyPermission", method = RequestMethod.POST)
	public JsonResult deleteApplyPermission(@RequestParam(required = true) java.lang.Integer applyPermissionId) {
		try {
			applyPermissionService.delete(applyPermissionId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
}