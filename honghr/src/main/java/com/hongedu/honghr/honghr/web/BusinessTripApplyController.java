
package com.hongedu.honghr.honghr.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hongedu.honghr.honghr.common.constant.CodeConstant;
import com.hongedu.honghr.honghr.common.constant.DataConstant;
import com.hongedu.honghr.honghr.common.constant.FileConstant;
import com.hongedu.honghr.honghr.common.constant.PageConstant;
import com.hongedu.honghr.honghr.common.constant.SessionConstant;
import com.hongedu.honghr.honghr.common.enums.EnumApplyCheckStatus;
import com.hongedu.honghr.honghr.common.enums.EnumApplyStatus;
import com.hongedu.honghr.honghr.entity.BusinessTripApply;
import com.hongedu.honghr.honghr.entity.BusinessTripApplyCheck;
import com.hongedu.honghr.honghr.entity.Code;
import com.hongedu.honghr.honghr.entity.Department;
import com.hongedu.honghr.honghr.entity.Employee;
import com.hongedu.honghr.honghr.entity.vo.BusinessTripApplyCheckVo;
import com.hongedu.honghr.honghr.entity.vo.BusinessTripApplyVo;
import com.hongedu.honghr.honghr.service.BusinessTripApplyCheckService;
import com.hongedu.honghr.honghr.service.BusinessTripApplyService;
import com.hongedu.honghr.honghr.service.CodeService;
import com.hongedu.honghr.honghr.service.DepartmentService;
import com.hongedu.honghr.honghr.service.EmployeeService;
import com.hongedu.honghr.honghr.service.FileDeleteService;
import com.hongedu.honghr.honghr.service.MailService;
import com.hongedu.honghr.util.download.DownloadUtil;
import com.hongedu.honghr.util.json.JsonResult;
import com.hongedu.honghr.util.page.Pager;
import com.hongedu.honghr.util.upload.UploadUtil;

/**
 * @author el_bp_business_trip_apply 表对应的controller 2017/12/07 04:04:40
 */
@Controller
@RequestMapping("/admin/businessTripApply")
public class BusinessTripApplyController {

	@Autowired
	private BusinessTripApplyCheckService businessTripApplyCheckService;
	@Autowired
	private BusinessTripApplyService businessTripApplyService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CodeService codeService;

	/**
	 * 跳转至填写出差申请页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addBusinessTripApply", method = RequestMethod.GET)
	public String addBusinessTripApply(Model model) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			List<Department> departmentList = departmentService.findDepartmentListByEmployee(employee.getEmployeeId());
			List<Code> applyTypeList = codeService.findCodeById(CodeConstant.BUSINESS_TRIP_APPLY_TYPE_MENU);
			List<Code> provinceList = codeService.findCodeById(CodeConstant.PROVINCE_MENU);
			BusinessTripApplyVo businessTripApplyVo = new BusinessTripApplyVo();
			businessTripApplyVo.setBusinessTripApplyNum(
					businessTripApplyService.getBusinessTripApplyNum(employee.getEmployeeId()));
			businessTripApplyVo.setApplyEmployeeName(employee.getEmployeeName());
			businessTripApplyVo.setApplyDateTime(new Date());
			model.addAttribute("departmentList", departmentList);
			model.addAttribute("applyTypeList", applyTypeList);
			model.addAttribute("provinceList", provinceList);
			model.addAttribute("businessTripApplyVo", businessTripApplyVo);
		}
		return "admin/businessTripApply/addBusinessTripApply";
	}

	/**
	 * 根据省份查询市县
	 * 
	 * @param provinceId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getCitys", method = RequestMethod.GET)
	public String getCitys(Integer provinceId) {
		List<Code> cityList = codeService.findCodeById(provinceId);
		return JSONArray.toJSONString(cityList);
	}

	/**
	 * 查询分配员工的部门
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showDepartmentList", method = RequestMethod.GET)
	public String findAllDepartmentList() {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			List<Department> departmentList = departmentService.findAllDepartmentList(employee.getEmployeeId());
			return JSONArray.toJSONString(departmentList);
		}
		return null;
	}

	/**
	 * 查询部门的员工
	 * 
	 * @param departmentNum
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/showCheckEmployeeList", method = RequestMethod.GET)
	public String findEmployeeListByDepartmentNum(String departmentNum) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			List<Employee> employeeList = employeeService.findEmployeeListByDepartmentNum(departmentNum,
					employee.getEmployeeId());
			return JSONArray.toJSONString(employeeList);
		}
		return null;
	}

	/**
	 * 查询部门的员工
	 * 
	 * @param employeeId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getEmployeeById", method = RequestMethod.GET)
	public String getEmployeeById(Integer employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		return JSONObject.toJSONString(employee);
	}

	/**
	 * 保存出差申请单
	 * 
	 * @param absenceApplyVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addForBusinessTripCheck", method = RequestMethod.POST)
	public String addForBusinessTripCheck(BusinessTripApplyVo businessTripApplyVo) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			businessTripApplyVo.setEmployeeId(employee.getEmployeeId());
			businessTripApplyVo.setCreateEmployeeId(employee.getEmployeeId());
			businessTripApplyVo.setCreateDateTime(new Date());
			businessTripApplyVo.setDeleted(DataConstant.EXIST);
		}
		businessTripApplyVo.setApplyDuration(
				getHours(businessTripApplyVo.getApplyBeginTime(), businessTripApplyVo.getApplyEndTime()));
		businessTripApplyService.insertBusinessTripApplyVo(businessTripApplyVo);
		// 判断申请单是否为提交审批
		if (EnumApplyStatus.WAIT_CHECK.getCode().equals(businessTripApplyVo.getApplyCheckStatus())) {
			List<BusinessTripApplyCheck> businessTripApplyCheckList = businessTripApplyVo.getBusinessTripApplyChecks();
			if (businessTripApplyCheckList != null && !businessTripApplyCheckList.isEmpty()) {
				Integer receiverId = null;
				for (BusinessTripApplyCheck businessTripApplyCheck : businessTripApplyCheckList) {
					// 找到第一个审批人
					if (businessTripApplyCheck.getApplyCheckSequence() != null
							&& businessTripApplyCheck.getApplyCheckSequence().intValue() == 1) {
						receiverId = businessTripApplyCheck.getCheckEmployeeId();
						break;
					}
				}
				// 发邮件提醒审批人进行审批
				MailService mailService = new MailService(employee, receiverId);
				mailService.setBusinessTripApplyService(businessTripApplyService);
				new Thread(mailService).start();
			}
		}
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 查询出差申请列表页面
	 * 
	 * @param currentPage:当前页
	 * @param pageSize:分页数
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/businessTripApplyList", method = RequestMethod.GET)
	public String businessTripApplyList(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			BusinessTripApplyVo search, Model model) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			Pager<BusinessTripApplyVo> page = businessTripApplyService.findPage(search, employee.getEmployeeId(),
					currentPage, pageSize);
			model.addAttribute("page", page);
		}
		model.addAttribute("applyTypeList", codeService.findCodeById(CodeConstant.BUSINESS_TRIP_APPLY_TYPE_MENU));
		return "admin/businessTripApply/businessTripApplyList";
	}

	/**
	 * 查看出差申请单
	 * 
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getBusinessTripApply", method = RequestMethod.GET)
	public String getBusinessTripApply(Integer businessTripApplyId) {
		BusinessTripApplyVo businessTripApplyVo = businessTripApplyService.getBusinessTripApplyVo(businessTripApplyId);
		return JSONObject.toJSONString(businessTripApplyVo);
	}

	/**
	 * 打开编辑休假申请单弹框
	 * 
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/businessTripApplyToEdit", method = RequestMethod.GET)
	public String businessTripApplyToEdit(Integer businessTripApplyId) {
		BusinessTripApplyVo businessTripApplyVo = businessTripApplyService.getBusinessTripApplyVo(businessTripApplyId);
		List<Code> applyTypeList = codeService.findCodeById(CodeConstant.BUSINESS_TRIP_APPLY_TYPE_MENU);
		List<Code> provinceList = codeService.findCodeById(CodeConstant.PROVINCE_MENU);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("businessTripApplyVo", businessTripApplyVo);
		resultMap.put("applyTypeList", applyTypeList);
		resultMap.put("provinceList", provinceList);
		if (StringUtils.isNotEmpty(businessTripApplyVo.getApplyBeginAddress())) {
			List<Code> beginCityList = codeService.findCodeListByValue(businessTripApplyVo.getApplyBeginAddress());
			resultMap.put("beginCityList", beginCityList);
		}
		if (StringUtils.isNotEmpty(businessTripApplyVo.getApplyEndAddress())) {
			List<Code> endCityList = codeService.findCodeListByValue(businessTripApplyVo.getApplyEndAddress());
			resultMap.put("endCityList", endCityList);
		}
		return JSONObject.toJSONString(resultMap);
	}

	/**
	 * 编辑出差申请单
	 * 
	 * @param businessTripApplyVo
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/editForBusinessTripApplyCheck", method = RequestMethod.POST)
	public String editForBusinessTripApplyCheck(BusinessTripApplyVo businessTripApplyVo) {
		businessTripApplyVo.setApplyDuration(
				getHours(businessTripApplyVo.getApplyBeginTime(), businessTripApplyVo.getApplyEndTime()));
		businessTripApplyService.updateBusinessTripApplyVo(businessTripApplyVo);
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 提交审批
	 * 
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/submitApplyCheck", method = RequestMethod.POST)
	public String submitApplyCheck(Integer businessTripApplyId) {
		businessTripApplyService.updateBusinessTripApplyStatus(EnumApplyStatus.WAIT_CHECK.getCode(),
				businessTripApplyId);
		MailService mailService = new MailService(
				(Employee) SecurityUtils.getSubject().getSession().getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY),
				businessTripApplyService.getFirstCheckEmployeeId(businessTripApplyId));
		mailService.setBusinessTripApplyService(businessTripApplyService);
		// 发邮件提醒审批人进行审批
		new Thread(mailService).start();
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 撤回出差申请单
	 * 
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/backApplyCheck", method = RequestMethod.POST)
	public String backApplyCheck(Integer businessTripApplyId) {
		businessTripApplyService.updateBusinessTripApplyStatus(EnumApplyStatus.DRAFT.getCode(), businessTripApplyId);
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 删除出差申请单
	 * 
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteBusinessTripApply/{businessTripApplyId}", method = RequestMethod.DELETE)
	public String deleteBusinessTripApply(@PathVariable("businessTripApplyId") Integer businessTripApplyId) {
		businessTripApplyService.deleteBusinessTripApply(businessTripApplyId);
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 查询待审批出差申请列表页面
	 * 
	 * @param currentPage:当前页
	 * @param pageSize:分页数
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/businessTripApplyListForCheck", method = RequestMethod.GET)
	public String businessTripApplyListForCheck(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			BusinessTripApplyVo search, Model model) throws UnsupportedEncodingException {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			Pager<BusinessTripApplyVo> page = businessTripApplyService.findForCheckPage(search,
					employee.getEmployeeId(), currentPage, pageSize);
			model.addAttribute("page", page);
		}
		model.addAttribute("departmentList", departmentService.findDepartmentList());
		return "admin/businessTripApply/businessTripApplyListForCheck";
	}

	/**
	 * 查看出差申请单审批记录
	 * 
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getBusinessTripApplyProgress", method = RequestMethod.GET)
	public String getBusinessTripApplyProgress(Integer businessTripApplyId) {
		List<BusinessTripApplyCheckVo> businessTripApplyCheckVoList = businessTripApplyCheckService
				.findBusinessTripApplyCheckVosByApplyId(businessTripApplyId);
		return JSONArray.toJSONString(businessTripApplyCheckVoList);
	}

	/**
	 * 同意出差申请单
	 * 
	 * @param applyCheckSuggest
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/agreeBusinessTripApply", method = RequestMethod.POST)
	public String agreeBusinessTripApply(@RequestParam(required = false, defaultValue = "") String applyCheckSuggest,
			Integer businessTripApplyId) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			BusinessTripApplyCheck businessTripApplyCheck = new BusinessTripApplyCheck();
			businessTripApplyCheck.setBusinessTripApplyId(businessTripApplyId);
			businessTripApplyCheck.setCheckEmployeeId(employee.getEmployeeId());
			businessTripApplyCheck.setApplyCheckTime(new Date());
			businessTripApplyCheck.setApplyIsAllowed(EnumApplyCheckStatus.AGREE.getCode());
			businessTripApplyCheck.setApplyCheckSuggest(applyCheckSuggest);
			businessTripApplyService.checkBusinessTripApply(businessTripApplyCheck);
			MailService mailService = new MailService(
					employeeService.getEmployeeByBusinessTripApplyId(businessTripApplyId),
					businessTripApplyService.getNextCheckEmployeeId(businessTripApplyId, employee.getEmployeeId()));
			mailService.setBusinessTripApplyService(businessTripApplyService);
			// 发邮件提醒审批人进行审批
			new Thread(mailService).start();
		}
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 不同意出差申请单
	 * 
	 * @param applyCheckSuggest
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/disAgreeBusinessTripApply", method = RequestMethod.POST)
	public String disAgreeBusinessTripApply(String applyCheckSuggest, Integer businessTripApplyId) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			BusinessTripApplyCheck businessTripApplyCheck = new BusinessTripApplyCheck();
			businessTripApplyCheck.setBusinessTripApplyId(businessTripApplyId);
			businessTripApplyCheck.setCheckEmployeeId(employee.getEmployeeId());
			businessTripApplyCheck.setApplyCheckTime(new Date());
			businessTripApplyCheck.setApplyIsAllowed(EnumApplyCheckStatus.DISAGREE.getCode());
			businessTripApplyCheck.setApplyCheckSuggest(applyCheckSuggest);
			businessTripApplyService.checkBusinessTripApply(businessTripApplyCheck);
		}
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 查询已审批出差申请列表页面
	 * 
	 * @param currentPage:当前页
	 * @param pageSize:分页数
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/businessTripApplyListHasCheck", method = RequestMethod.GET)
	public String businessTripApplyListHasCheck(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			BusinessTripApplyVo search, Model model) throws UnsupportedEncodingException {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			Pager<BusinessTripApplyVo> page = businessTripApplyService.findHasCheckPage(search,
					employee.getEmployeeId(), currentPage, pageSize);
			model.addAttribute("page", page);
		}
		model.addAttribute("departmentList", departmentService.findDepartmentList());
		return "/admin/businessTripApply/businessTripApplyListHasCheck";
	}

	/**
	 * 下载出差报告模板
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "/downloadModalExcel", method = RequestMethod.GET)
	public void downloadModalExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 获取要下载的文件路径
		String realPath = request.getSession().getServletContext().getRealPath(FileConstant.BUSINESS_TRIP_REPORT_MODAL);
		// 获取要下载的文件
		File downloadFile = new File(realPath, "business_trip_report.xlsx");
		if (!downloadFile.exists()) {
			PrintWriter writer = response.getWriter();
			writer.println("<html><script>history.go(-1)</script></html>");
			return;
		}
		DownloadUtil.downloadFile(response, downloadFile);
	}

	/**
	 * 上传出差报告
	 * 
	 * @param request
	 * @param fileList
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadBusinessTripReport", method = RequestMethod.POST)
	public String uploadBusinessTripReport(MultipartFile reportFile, HttpServletRequest request) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// 定义资源的保存路径
		String savePath = FileConstant.BUSINESS_TRIP_REPORT_URL + format.format(new Date()) + "/";
		Map<String, Object> resultMap = UploadUtil.uploadFile(request, reportFile, savePath);
		return JSONObject.toJSONString(resultMap);
	}

	/**
	 * 出差报告入库
	 * 
	 * @param request
	 * @param fileList
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveBusinessTripReport", method = RequestMethod.PUT)
	public String saveBusinessTripReport(BusinessTripApply businessTripApply) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			businessTripApplyService.saveBusinessTripReport(businessTripApply);
		}
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 删除出差报告
	 * 
	 * @param businessTripApplyId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteBusinessTripReport", method = RequestMethod.POST)
	public String deleteBusinessTripReport(BusinessTripApply businessTripApply, HttpServletRequest request) {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			businessTripApplyService.deleteBusinessTripReport(businessTripApply.getBusinessTripApplyId());
			new Thread(new FileDeleteService(businessTripApply.getBusinessTripReportUrl(), request)).start();
		}
		return JsonResult.SUCCESS_CODE;
	}

	/**
	 * 查看出差申请汇总页面
	 * 
	 * @param currentPage:当前页
	 * @param pageSize:分页数
	 * @param model
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = "/businessTripApplyListTotal", method = RequestMethod.GET)
	public String businessTripApplyListTotal(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			BusinessTripApplyVo search, Model model) throws UnsupportedEncodingException {
		Employee employee = (Employee) SecurityUtils.getSubject().getSession()
				.getAttribute(SessionConstant.SESSION_EMPLOYEE_KEY);
		if (employee != null) {
			Pager<BusinessTripApplyVo> page = businessTripApplyService.findAllPage(search, currentPage, pageSize);
			model.addAttribute("page", page);
		}
		model.addAttribute("departmentList", departmentService.findDepartmentList());
		return "admin/businessTripApply/businessTripApplyListTotal";
	}

	private String getHours(Date beginTime, Date endTime) {
		if (beginTime != null && endTime != null) {
			long msec = endTime.getTime() - beginTime.getTime();
			long days = msec / (1000 * 60 * 60 * 24);
			long hours = (msec % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
			DecimalFormat df = new DecimalFormat("######0.0");
			String time = df.format(days + (hours == 0 ? 0 : hours >= 8 ? 1 : hours >= 4 ? 0.5 : 0));
			if (time.contains(".0")) {
				return time.substring(0, time.lastIndexOf("."));
			}
			return time;
		}
		return "";
	}
}