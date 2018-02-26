package com.hongedu.honghr.honghr.entity;

import java.io.Serializable;

import com.hongedu.honghr.base.entity.BaseEntity;
import com.hongedu.honghr.base.dao.annotation.Table;

/**
 * @author el_bp_attachment 表对应实体 2017/12/07 04:00:56
 */
@Table(name = "attachment", pk = "attachmentId")
public class Attachment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/***/
	private Integer attachmentId;
	/***/
	private String attachmentName;
	/***/
	private String attachmentDir;
	/***/
	private String attachmentUrl;
	/***/
	private String attachmentSize;
	/***/
	private String attachmentSuffix;
	/***/
	private Integer absenceApplyId;
	/***/
	private String deleted;

	public void setAttachmentId(Integer value) {
		this.attachmentId = value;
	}

	public Integer getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentName(String value) {
		this.attachmentName = value;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentDir(String value) {
		this.attachmentDir = value;
	}

	public String getAttachmentDir() {
		return attachmentDir;
	}

	public void setAttachmentUrl(String value) {
		this.attachmentUrl = value;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentSize(String value) {
		this.attachmentSize = value;
	}

	public String getAttachmentSize() {
		return attachmentSize;
	}

	public void setAttachmentSuffix(String value) {
		this.attachmentSuffix = value;
	}

	public String getAttachmentSuffix() {
		return attachmentSuffix;
	}

	public void setAbsenceApplyId(Integer value) {
		this.absenceApplyId = value;
	}

	public Integer getAbsenceApplyId() {
		return absenceApplyId;
	}

	public void setDeleted(String value) {
		this.deleted = value;
	}

	public String getDeleted() {
		return deleted;
	}
}
