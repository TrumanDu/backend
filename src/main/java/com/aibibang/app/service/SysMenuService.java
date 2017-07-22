package com.aibibang.app.service;

import com.aibibang.app.domain.SysMenu;

import java.util.List;

public interface SysMenuService {
	
	public List<SysMenu> find(SysMenu menu);
	
	public List<SysMenu> getByParentId(Long parentId);
	
	public SysMenu getById(Long id);
	
	public void add(SysMenu menu);
	
	public void update(SysMenu menu);
	
	public void delete(Long id);
	
	public List<SysMenu> findForTreeTable(Long parentId);
	
}
