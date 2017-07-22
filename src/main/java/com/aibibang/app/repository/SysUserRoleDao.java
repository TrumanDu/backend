package com.aibibang.app.repository;

import com.aibibang.app.common.base.BaseDao;
import com.aibibang.app.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 用户角色dao接口.
 *
 */

@Mapper
public interface SysUserRoleDao extends BaseDao<SysUserRole, Long> {

	/**
	 * 查询用户的所有角色
	 * @param userId
	 * @return
	 */
	public List<Long> findByUserId(Long userId);
	
	/**
	 * 删除用户的所有角色
	 * @param userId
	 */
	public void deleteByUserId(Long userId);
}