package com.aibibang.app.repository;

import com.aibibang.app.common.base.BaseDao;
import com.aibibang.app.domain.SysOrg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysOrgDao extends BaseDao<SysOrg, Long> {

	public List<SysOrg> findForTreeTable(Long parentId);
	
	public void deleteByParentId(Long parentId);
	
	public String getMaxCode(Long parentId);
}
