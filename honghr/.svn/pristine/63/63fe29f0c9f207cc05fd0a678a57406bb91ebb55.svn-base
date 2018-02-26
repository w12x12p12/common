
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
import com.hongedu.honghr.honghr.entity.Attachment;
import com.hongedu.honghr.honghr.service.AttachmentService;

/**
 * @author el_bp_attachment 表对应的controller 2017/12/07 04:04:39
 */
@Controller
@RequestMapping("/admin/attachment")
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;
	
	/**
	 * 查询Attachment表单页面
	 * 
	 * @param currentPage
	 *            当前页
	 * @param pageSize
	 *            分页数
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/attachmentList", method = RequestMethod.GET)
	public String attachmentList(
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_START) Integer currentPage,
			@RequestParam(required = false, defaultValue = PageConstant.DEFAULT_PAGE_SIZE) Integer pageSize,
			Model model) {
		Pager<Attachment> page = attachmentService.findPage(currentPage, pageSize);
		model.addAttribute("page", page);
		return "admin/attachment/attachmentList";
	}

	/**
	 * 查询Attachment详情
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findAttachment", method = RequestMethod.POST)
	public JsonResult findAttachment(@RequestParam(required = true) java.lang.Integer attachmentId) {
		try {
			Attachment attachment = attachmentService.findById(attachmentId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", attachment);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 编辑Attachment
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editAttachment", method = RequestMethod.GET)
	public String editAttachment(java.lang.Integer attachmentId, Model model) {
		if (attachmentId != null) {
			Attachment attachment = attachmentService.findById(attachmentId);
			model.addAttribute("attachment", attachment);
		}
		return "admin/attachment/editAttachment";
	}

	/**
	 * 保存Attachment
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/saveAttachment", method = RequestMethod.POST)
	public JsonResult saveAttachment(Attachment attachment) {
		try {
			if (attachment.getAttachmentId() == null) {
				attachmentService.save(attachment);
			} else {
				attachmentService.update(attachment);
			}
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}

	/**
	 * 删除Attachment
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteAttachment", method = RequestMethod.POST)
	public JsonResult deleteAttachment(@RequestParam(required = true) java.lang.Integer attachmentId) {
		try {
			attachmentService.delete(attachmentId);
			return new JsonResult(JsonResult.SUCCESS_CODE, "", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(JsonResult.FAILE_CODE, "系统异常", null);
		}
	}
}
