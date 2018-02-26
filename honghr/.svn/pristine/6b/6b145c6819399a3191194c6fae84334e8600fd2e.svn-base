
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

import com.hongedu.honghr.honghr.entity.Module;
import com.hongedu.honghr.honghr.service.ModuleService;


/**
 * @author  
 * el_sys_module 表对应的controller
 * 2017/12/07 04:04:41
 */
@Controller
@RequestMapping("/admin/module")
public class ModuleController {
	
	@Autowired
	private ModuleService moduleService;
	
	/**
	 * 查询Module详情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/findModule",method=RequestMethod.POST)
	public JsonResult findModule(
			@RequestParam(required=true)java.lang.Integer moduleId) {
		try {
			Module module = moduleService.findById(moduleId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", module);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
	
	/**
	 * 编辑Module
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/editModule",method=RequestMethod.GET)
	public String editModule(
			java.lang.Integer moduleId,
			Model model) {
		if(moduleId != null){
			Module module = moduleService.findById(moduleId);
			model.addAttribute("module", module);
		}
		return "admin/module/editModule";
	}
	
	/**
	 * 保存Module
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveModule",method=RequestMethod.POST)
	public JsonResult saveModule(
			Module module
			) {
		try {
			if(module.getModuleId() == null){
				moduleService.save(module);
			}else{
				moduleService.update(module);
			}
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
	
	/**
	 * 删除Module
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/deleteModule",method=RequestMethod.POST)
	public JsonResult deleteModule(
			@RequestParam(required=true)java.lang.Integer moduleId) {
		try {
			moduleService.delete(moduleId);
		return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
						return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
	
	/**
	 * 查询Module表单页面
	 * @param currentPage 当前页
	 * @param pageSize 分页数
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/moduleList",method=RequestMethod.GET)
	public String moduleList(
			@RequestParam(required=false,defaultValue="1")Integer currentPage,
			@RequestParam(required=false,defaultValue="10")Integer pageSize,
			Model model) {
		Pager<Module> page = moduleService.findPage(currentPage, pageSize);
		model.addAttribute("page", page);
		return "admin/module/moduleList";
	}
}
