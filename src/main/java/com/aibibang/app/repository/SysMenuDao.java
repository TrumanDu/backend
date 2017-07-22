package com.aibibang.app.repository;

import com.aibibang.app.common.base.BaseDao;
import com.aibibang.app.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysMenuDao extends BaseDao<SysMenu, Long> {
	
	public List<SysMenu> getByParentId(Long parentId);
	
	public void deleteByParentId(Long parentId);
	
	public List<SysMenu> findForTreeTable(Long parentId);
	
}
