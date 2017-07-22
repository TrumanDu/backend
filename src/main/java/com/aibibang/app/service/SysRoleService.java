package com.aibibang.app.service;

import com.aibibang.app.common.persistence.Page;
import com.aibibang.app.domain.SysRole;

import java.util.List;

/**
 * 
 * 角色管理service接口
 *
 */
public interface SysRoleService{
	
 	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	分页查询
	 * </pre>
	 * 
	 * @param sysRole
	 * @param page
	 * @return
	 */
	public Page<SysRole> findByPage(SysRole sysRole, Page<SysRole> page);
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	查询
	 * </pre>
	 * 
	 * @param sysRole
	 * @return
	 */
	public List<SysRole> findBySearch(SysRole sysRole);
	
	/**
	 *
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	通过ID查询
	 * </pre>
	 *
	 * @param id
	 * @return
	 */
	public SysRole getById(Long id);
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	新增
	 * </pre>
	 * 
	 * @param sysRole
	 */
	public void add(SysRole sysRole);
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	修改
	 * </pre>
	 * 
	 * @param sysRole
	 */
	public void update(SysRole sysRole);
	
	/**
	 * 
	 * <pre>
	 * 	2016-08-01 22:42 King
	 * 	删除
	 * </pre>
	 * 
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 根据角色id获取所有菜单权限
	 * @param roleId
	 * @return
	 */
	public List<Long> findByRoleId(Long roleId);
}
