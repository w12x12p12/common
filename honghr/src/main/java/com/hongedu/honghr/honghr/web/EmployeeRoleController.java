
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

import com.hongedu.honghr.honghr.entity.EmployeeRole;
import com.hongedu.honghr.honghr.service.EmployeeRoleService;


/**
 * @author  
 * el_sys_employee_role 表对应的controller
 * 2017/12/07 04:04:41
 */
@Controller
@RequestMapping("/admin/employeeRole")
public class EmployeeRoleController {
	
	@Autowired
	private EmployeeRoleService employeeRoleService;
	
	/**
	 * 查询EmployeeRole详情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findEmployeeRole",method=RequestMethod.POST)
	public JsonResult findEmployeeRole(
			@RequestParam(required=true)java.lang.Integer employeeRoleId) {
		try {
			EmployeeRole employeeRole = employeeRoleService.findById(employeeRoleId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", employeeRole);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
	
	/**
	 * 编辑EmployeeRole
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/editEmployeeRole",method=RequestMethod.GET)
	public String editEmployeeRole(
			java.lang.Integer employeeRoleId,
			Model model) {
		if(employeeRoleId != null){
			EmployeeRole employeeRole = employeeRoleService.findById(employeeRoleId);
			model.addAttribute("employeeRole", employeeRole);
		}
		return "admin/employeeRole/editEmployeeRole";
	}
	
	/**
	 * 保存EmployeeRole
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEmployeeRole",method=RequestMethod.POST)
	public JsonResult saveEmployeeRole(
			EmployeeRole employeeRole
			) {
		try {
			if(employeeRole.getEmployeeRoleId() == null){
				employeeRoleService.save(employeeRole);
			}else{
				employeeRoleService.update(employeeRole);
			}
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
	
	/**
	 * 删除EmployeeRole
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteEmployeeRole",method=RequestMethod.POST)
	public JsonResult deleteEmployeeRole(
			@RequestParam(required=true)java.lang.Integer employeeRoleId) {
		try {
			employeeRoleService.delete(employeeRoleId);
		return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
						return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
	
	/**
	 * 查询EmployeeRole表单页面
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/employeeRoleList",method=RequestMethod.GET)
	public String employeeRoleList(
			@RequestParam(required=false,defaultValue="1")Integer currentPage,
			@RequestParam(required=false,defaultValue="10")Integer pageSize,
			Model model) {
		Pager<EmployeeRole> page = employeeRoleService.findPage(currentPage, pageSize);
		model.addAttribute("page", page);
		return "admin/employeeRole/employeeRoleList";
	}
}
