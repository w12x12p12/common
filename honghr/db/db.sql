/*
Navicat MySQL Data Transfer

Source Server         : hongedu
Source Server Version : 50719
Source Host           : 192.168.3.188:3306
Source Database       : honghr

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-02-07 16:50:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for absence_apply
-- ----------------------------
DROP TABLE IF EXISTS `absence_apply`;
CREATE TABLE `absence_apply` (
  `absence_apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `absence_apply_num` varchar(255) DEFAULT NULL,
  `apply_department_num` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `apply_type` varchar(255) DEFAULT NULL,
  `apply_reason` varchar(1000) DEFAULT NULL,
  `apply_begin_time` datetime DEFAULT NULL,
  `apply_end_time` datetime DEFAULT NULL,
  `apply_duration` varchar(255) DEFAULT NULL,
  `apply_date_time` datetime DEFAULT NULL,
  `apply_check_status` varchar(255) DEFAULT NULL,
  `apply_check_progress` varchar(255) DEFAULT NULL,
  `create_employee_id` int(11) DEFAULT NULL,
  `create_date_time` datetime DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`absence_apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8 COMMENT='请假单表';

-- ----------------------------
-- Table structure for absence_apply_check
-- ----------------------------
DROP TABLE IF EXISTS `absence_apply_check`;
CREATE TABLE `absence_apply_check` (
  `absence_apply_check_id` int(11) NOT NULL AUTO_INCREMENT,
  `absence_apply_id` int(11) DEFAULT NULL,
  `check_employee_id` int(11) DEFAULT NULL,
  `apply_check_time` datetime DEFAULT NULL,
  `apply_is_allowed` char(2) DEFAULT NULL,
  `apply_check_suggest` varchar(1000) DEFAULT NULL,
  `apply_check_sequence` int(11) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`absence_apply_check_id`)
) ENGINE=InnoDB AUTO_INCREMENT=193 DEFAULT CHARSET=utf8 COMMENT='请假单审核表';

-- ----------------------------
-- Table structure for apply_permission
-- ----------------------------
DROP TABLE IF EXISTS `apply_permission`;
CREATE TABLE `apply_permission` (
  `apply_permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `check_permission` char(10) DEFAULT NULL,
  `check_level` char(10) DEFAULT NULL,
  `deleted` char(10) DEFAULT NULL,
  PRIMARY KEY (`apply_permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='考勤单据权限表';

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `attachment_id` int(11) NOT NULL AUTO_INCREMENT,
  `attachment_name` varchar(1000) DEFAULT NULL,
  `attachment_dir` varchar(1000) DEFAULT NULL,
  `attachment_url` varchar(1000) DEFAULT NULL,
  `attachment_size` varchar(1000) DEFAULT NULL,
  `attachment_suffix` varchar(50) DEFAULT NULL,
  `absence_apply_id` int(11) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`attachment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='附件表';

-- ----------------------------
-- Table structure for business_trip_apply
-- ----------------------------
DROP TABLE IF EXISTS `business_trip_apply`;
CREATE TABLE `business_trip_apply` (
  `business_trip_apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_trip_apply_num` varchar(255) DEFAULT NULL,
  `apply_department_num` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `apply_type` char(10) DEFAULT NULL,
  `apply_reason` varchar(1000) DEFAULT NULL,
  `apply_begin_time` datetime DEFAULT NULL,
  `apply_end_time` datetime DEFAULT NULL,
  `apply_duration` varchar(1000) DEFAULT NULL,
  `apply_begin_address` varchar(255) DEFAULT NULL,
  `apply_end_address` varchar(255) DEFAULT NULL,
  `apply_date_time` datetime DEFAULT NULL,
  `apply_check_status` char(2) DEFAULT NULL,
  `apply_check_progress` varchar(255) DEFAULT NULL,
  `create_employee_id` int(11) DEFAULT NULL,
  `create_date_time` datetime DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`business_trip_apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='出差单表';

-- ----------------------------
-- Table structure for business_trip_apply_check
-- ----------------------------
DROP TABLE IF EXISTS `business_trip_apply_check`;
CREATE TABLE `business_trip_apply_check` (
  `business_trip_apply_check_id` int(11) NOT NULL AUTO_INCREMENT,
  `business_trip_apply_id` int(11) DEFAULT NULL,
  `check_employee_id` int(11) DEFAULT NULL,
  `apply_check_time` datetime DEFAULT NULL,
  `apply_is_allowed` char(2) DEFAULT NULL,
  `apply_check_suggest` varchar(1000) DEFAULT NULL,
  `apply_check_sequence` int(11) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`business_trip_apply_check_id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='出差单审核表';

-- ----------------------------
-- Table structure for code
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `code_id` int(11) NOT NULL AUTO_INCREMENT,
  `code_name` varchar(1000) DEFAULT NULL,
  `code_parent_id` int(11) DEFAULT NULL,
  `code_value` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3450 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_num` varchar(255) DEFAULT NULL,
  `department_name` varchar(255) DEFAULT NULL,
  `department_introduction` varchar(255) DEFAULT NULL,
  `department_rank` char(2) DEFAULT NULL,
  `department_parent_id` int(11) DEFAULT NULL,
  `referred` char(2) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(1000) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `gender` char(2) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `native_place` varchar(255) DEFAULT NULL,
  `nation` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `idcard` varchar(50) DEFAULT NULL,
  `education` varchar(10) DEFAULT NULL,
  `work_begin_time` date DEFAULT NULL,
  `entry_time` date DEFAULT NULL,
  `forbided` char(2) DEFAULT NULL,
  `referred` char(2) DEFAULT NULL COMMENT '1 被引用 0没被引用',
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=158 DEFAULT CHARSET=utf8 COMMENT='员工表';

-- ----------------------------
-- Table structure for employee_annual_leave
-- ----------------------------
DROP TABLE IF EXISTS `employee_annual_leave`;
CREATE TABLE `employee_annual_leave` (
  `employee_annual_leave_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `year_name` varchar(255) DEFAULT NULL,
  `remaining_hour` varchar(255) DEFAULT NULL,
  `is_clear` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`employee_annual_leave_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employee_position
-- ----------------------------
DROP TABLE IF EXISTS `employee_position`;
CREATE TABLE `employee_position` (
  `employee_position_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `department_num` varchar(255) DEFAULT NULL,
  `position_num` varchar(255) DEFAULT NULL,
  `leader_id` int(11) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`employee_position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COMMENT='员工职位中间表';

-- ----------------------------
-- Table structure for overtime_work_apply
-- ----------------------------
DROP TABLE IF EXISTS `overtime_work_apply`;
CREATE TABLE `overtime_work_apply` (
  `overtime_work_apply_id` int(11) NOT NULL AUTO_INCREMENT,
  `overtime_work_apply_num` varchar(255) DEFAULT NULL,
  `apply_department_num` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `apply_type` varchar(255) DEFAULT NULL,
  `apply_reason` varchar(1000) DEFAULT NULL,
  `apply_work_content` varchar(1000) DEFAULT NULL,
  `apply_begin_time` datetime DEFAULT NULL,
  `apply_end_time` datetime DEFAULT NULL,
  `apply_duration` varchar(1000) DEFAULT NULL,
  `apply_date_time` datetime DEFAULT NULL,
  `apply_check_status` varchar(255) DEFAULT NULL,
  `apply_check_progress` varchar(255) DEFAULT NULL,
  `create_employee_id` int(11) DEFAULT NULL,
  `create_date_time` datetime DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`overtime_work_apply_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='加班单表';

-- ----------------------------
-- Table structure for overtime_work_apply_check
-- ----------------------------
DROP TABLE IF EXISTS `overtime_work_apply_check`;
CREATE TABLE `overtime_work_apply_check` (
  `overtime_work_apply_check_id` int(11) NOT NULL AUTO_INCREMENT,
  `overtime_work_apply_id` int(11) DEFAULT NULL,
  `check_employee_id` int(11) DEFAULT NULL,
  `apply_check_time` datetime DEFAULT NULL,
  `apply_is_allowed` char(2) DEFAULT NULL,
  `apply_check_suggest` varchar(1000) DEFAULT NULL,
  `apply_check_sequence` int(11) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`overtime_work_apply_check_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='加班单审核表';

-- ----------------------------
-- Table structure for position
-- ----------------------------
DROP TABLE IF EXISTS `position`;
CREATE TABLE `position` (
  `position_id` int(11) NOT NULL AUTO_INCREMENT,
  `position_num` int(255) DEFAULT NULL,
  `position_name` varchar(255) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `position_rank` char(10) DEFAULT NULL,
  `position_code` varchar(1000) DEFAULT NULL,
  `position_parent_id` int(11) NOT NULL,
  `referred` char(2) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8 COMMENT='职位表';

-- ----------------------------
-- Table structure for sys_employee_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_employee_role`;
CREATE TABLE `sys_employee_role` (
  `employee_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`employee_role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户角色表';

-- ----------------------------
-- Table structure for sys_module
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_text` varchar(255) DEFAULT NULL,
  `module_permission` varchar(255) DEFAULT NULL,
  `module_sequence` varchar(255) DEFAULT NULL,
  `module_type` varchar(255) DEFAULT NULL,
  `module_parent_id` int(11) DEFAULT NULL,
  `module_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_name` varchar(255) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统权限表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `deleted` char(2) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色表';
