package com.aibibang.app.repository;

import com.aibibang.app.common.base.BaseDao;
import com.aibibang.app.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 角色管理dao接口.
 *
 */
@Mapper
public interface SysRoleDao extends BaseDao<SysRole, Long> {


}