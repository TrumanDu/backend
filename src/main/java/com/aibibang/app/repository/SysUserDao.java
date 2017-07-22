package com.aibibang.app.repository;

import com.aibibang.app.common.base.BaseDao;
import com.aibibang.app.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao extends BaseDao<SysUser, Long> {

	public SysUser findByUsername(String username);
}
