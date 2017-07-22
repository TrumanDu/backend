package com.aibibang.app.repository;

import com.aibibang.app.common.base.BaseDao;
import com.aibibang.app.domain.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 角色菜单dao接口.
 *
 */
@Mapper
public interface SysRoleMenuDao extends BaseDao<SysRoleMenu, Long> {

	/**
	 * 获取角色所有菜单权限
	 * @param roleId
	 * @return
	 */
	public List<Long> findByRoleId(Long roleId);
	
	/**
	 * 删除角色下所有的菜单
	 * @param roleId
	 */
	public void deleteByRoleId(Long roleId);
	
	/**
	 * 获取用户所有的有权限的菜单
	 * @param userId
	 * @return
	 */
	public List<Long> findMenuIdByUserId(Long userId);
}