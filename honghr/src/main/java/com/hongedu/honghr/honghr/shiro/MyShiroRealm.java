package com.hongedu.honghr.honghr.shiro;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.hongedu.honghr.honghr.common.constant.DataConstant;
import com.hongedu.honghr.honghr.common.constant.SessionConstant;
import com.hongedu.honghr.honghr.entity.Employee;
import com.hongedu.honghr.honghr.service.EmployeeService;

public class MyShiroRealm extends AuthorizingRealm {

	@Autowired
	private EmployeeService employeeService;

	// 认证 登录
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		Employee employee = employeeService.getInfoByUsername(upToken.getUsername());
		if (employee != null && employee.getEmployeeId() != null) {
			Object psdMd5 = new SimpleHash(DataConstant.ENCRYPT_MD5, String.valueOf(upToken.getPassword()),
					String.valueOf(employee.getEmployeeId()), DataConstant.HASH_ITERATION_COUNT);
			if (StringUtils.isNotEmpty(employee.getPassword()) && employee.getPassword().equals(psdMd5.toString())) {
				if (StringUtils.isNotEmpty(employee.getForbided())
						&& DataConstant.ALLOW.equals(employee.getForbided())) {
					Session session = SecurityUtils.getSubject().getSession();
					session.setAttribute(SessionConstant.SESSION_EMPLOYEE_KEY, employee);
					return new SimpleAuthenticationInfo(employee, employee.getPassword(),
							ByteSource.Util.bytes(String.valueOf(employee.getEmployeeId())), getName());
				}
				throw new DisabledAccountException();
			}
			throw new AuthenticationException();
		}
		throw new UnknownAccountException();
	}

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Employee employee = (Employee) principals.getPrimaryPrincipal();
		List<String> roles = new ArrayList<String>();
		roles.add("system" + employee.getEmployeeId());
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		simpleAuthorizationInfo.addStringPermissions(roles);
		return simpleAuthorizationInfo;
	}
}