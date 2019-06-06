package com.dieudonne.adminlte.bootrpc.web.consumer.common.shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.dieudonne.adminlte.bootrpc.system.service.ISysRoleMenuService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysUserRoleService;
import com.dieudonne.adminlte.bootrpc.system.service.ISysUserService;
import com.dieudonne.adminlte.model.common.SysUser;

/**
 * 
 * @ClassName: MyRealm
 * @Description:shiro Realm
 * @author: 湖南无为网电子商务有限公司 (Dieudonne)
 * @date: 2018年11月28日 上午9:25:18
 * 
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved.
 *             注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

public class MyRealm extends AuthorizingRealm {

	/**
	 * 用户服务
	 */
	@Autowired
	private ISysUserService userService;
	/**
	 * 用户角色服务
	 */
	@Autowired
	private ISysUserRoleService sysUserRoleService;
	/**
	 * 角色菜单服务
	 */
	@Autowired
	private ISysRoleMenuService sysRoleMenuService;

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken user = (UsernamePasswordToken) token;
		SysUser newUser = new SysUser();
		newUser.setUsername(user.getUsername());
		SysUser sysUser = userService.queryOne(newUser);
		if (sysUser == null) {
			throw new UnknownAccountException();
		}
		if (sysUser.getUserstate() == SysUser._0) {
			throw new LockedAccountException();
		}
		// 用户名，数据库中的密码,reaml名称
		// SimpleAuthenticationInfo info = new
		// SimpleAuthenticationInfo(user.getUsername(),sysUser.getPassword(),getName());
		// 盐值加密
		ByteSource byteSource = ByteSource.Util.bytes(user.getUsername());
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(), byteSource,
				getName());
		return info;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		Set<String> roles = sysUserRoleService.findRolesByUid(sysUser.getId());
		Set<String> permissions = sysRoleMenuService.findMenusByUid(sysUser.getId());
		info.setRoles(roles);
		info.setStringPermissions(permissions);
		return info;
	}

	/**
	 * 密码加密 测试
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// MD5,"原密码","盐",加密次数
		String pwd = new SimpleHash("MD5", "123456", "admin", 1024).toString();
		System.out.println(pwd);

	}
}
